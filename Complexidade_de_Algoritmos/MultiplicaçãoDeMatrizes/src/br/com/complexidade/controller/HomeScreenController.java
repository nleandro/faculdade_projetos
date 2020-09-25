package br.com.complexidade.controller;

import br.com.complexidade.model.Dimensao;
import br.com.complexidade.util.TxtReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class HomeScreenController implements Initializable {

    @FXML
    private TableView tabelaDimensao;
    @FXML
    private TableColumn<Dimensao, String> dimensaoCol;
    @FXML
    private TableColumn<Dimensao, Integer> valorCol;
    @FXML
    private Label ordemParenteses;
    @FXML
    private Label custoMultiplicacao;
    @FXML
    private Button btnMatrizM;
    @FXML
    private Button btnMatrizC;

    ObservableList<Dimensao> d;
    private int n;
    private int[][] m;
    private int[][] c;
    private char matriz = 'A';
    private String ordemMatriz;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dimensaoCol.setCellValueFactory(new PropertyValueFactory<>("d"));
        valorCol.setCellValueFactory(new PropertyValueFactory<>("valor"));

        btnMatrizM.setDisable(true);
        btnMatrizC.setDisable(true);

        ordemParenteses.setVisible(false);
        custoMultiplicacao.setVisible(false);
    }

    @FXML
    private void calcularMatriz() {        
        // Pegar o ObservableList da leitura do .txt.
        d = TxtReader.lerArquivo();

        // Atribuir todos os valores na TableView.
        tabelaDimensao.setItems(d);

        // Quantidade de dimensões.
        n = d.size();
        // Matriz de multiplicação.
        m = new int[n][n];
        // Matriz de escolha.
        c = new int[n][n];

        // Parte que irá atribuir 0 quando o 'i' e o 'j' forem iguais, ou seja,
        // quando for M(i, i).
        for (int i = 1; i < n; i++) {
            m[i][i] = 0;
        }

        // Essa parte vai calcular os valores de cada M, sendo feito para os M(i, i+n).
        for (int l = 2; l < n; l++) {
            for (int i = 1; i < n - l + 1; i++) {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int r = m[i][k] + m[k + 1][j] + d.get(i - 1).getValor() * d.get(k).getValor() * d.get(j).getValor();
                    if (r < m[i][j]) {
                        m[i][j] = r;
                        c[i][j] = k;
                    }
                }
            }
        }

        // Simples método que vai criar uma string com a melhor ordem de parênteses.
        matriz = 'A';
        ordemMatriz = "";
        printMatriz(1, n - 1, n, c);

        custoMultiplicacao.setText("Custo mínimo de multiplicação: " + Integer.toString(m[1][n - 1]));
        ordemParenteses.setText("Melhor ordem de parênteses: " + ordemMatriz);

        btnMatrizM.setDisable(false);
        btnMatrizC.setDisable(false);

        ordemParenteses.setVisible(true);
        custoMultiplicacao.setVisible(true);
    }

    private void printMatriz(int i, int j, int n, int[][] c) {
        if (i == j) {
            ordemMatriz += matriz++;
            return;
        }

        ordemMatriz += "(";

        printMatriz(i, c[i][j], n, c);

        ordemMatriz += "*";

        printMatriz(c[i][j] + 1, j, n, c);

        ordemMatriz += ")";
    }

    @FXML
    private void matrizM() {
        // Esse método vai carregar a página de matrizes passando a matriz de multiplicação.
        if (m != null) {
            try {
                FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/br/com/complexidade/screen/MatrizScreen.fxml"));
                fXMLLoader.setControllerFactory(cf -> {
                    return new MatrizScreenController(m, true);
                });
                Parent root = fXMLLoader.load();

                Stage stage = new Stage();
                stage.setTitle("Tabela de Multiplicação");
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                System.out.println("Erro " + e.getMessage());
            }
        }
    }

    @FXML
    private void matrizC() {
        // Esse método vai carregar a página de matrizes passando a matriz de escolha.
        if (c != null) {
            try {
                FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/br/com/complexidade/screen/MatrizScreen.fxml"));
                fXMLLoader.setControllerFactory(cf -> {
                    return new MatrizScreenController(c, false);
                });
                Parent root = fXMLLoader.load();

                Stage stage = new Stage();
                stage.setTitle("Tabela de Escolha");
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                System.out.println("Erro " + e.getMessage());
            }
        }
    }
}
