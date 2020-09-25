package br.com.complexidade.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class MatrizScreenController implements Initializable {

    // Essa variável vai dizer se a matriz que será feita é de multiplicação ou
    // de escolha.
    private final boolean isMatrizM;
    private int[][] matriz;
    @FXML
    private GridPane gdMatriz;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int gridSize = gdMatriz.getColumnConstraints().size();

        // Parte que será definido a quantidade de colunas e linhas de acordo 
        // com a quantidade de dimensões.
        while (gridSize != matriz.length) {
            gdMatriz.getColumnConstraints().add(new ColumnConstraints(70));
            gdMatriz.getRowConstraints().add(new RowConstraints(30));
            gridSize = gridSize + 1;
        }

        // Simples for para adicionar os índices de cada linha.
        for (int i = 0; i < gridSize - 1; i++) {
            Label label = new Label(Integer.toString(i + 1));
            label.setFont(Font.font("System", FontWeight.BOLD, 12));
            GridPane.setHalignment(label, HPos.CENTER);
            gdMatriz.add(label, i, 0);
        }
        
        // Simples for para adicionar os índices de cada coluna.
        for (int i = 0; i < gridSize - 1; i++) {
            Label label = new Label(Integer.toString(i + 1));
            label.setFont(Font.font("System", FontWeight.BOLD, 12));
            GridPane.setHalignment(label, HPos.CENTER);
            gdMatriz.add(label, gridSize - 1, i + 1);
        }

        // Adicionar os valores das matrizes no GridPane, onde será exibido na
        // interface.
        for (int i = 1; i < matriz.length; i++) {
            for (int j = 1; j < matriz.length; j++) {
                if (isMatrizM) {
                    if (i <= j) {
                        Label label = new Label();
                        label.setText(Integer.toString(matriz[i][j]));
                        GridPane.setHalignment(label, HPos.CENTER);
                        gdMatriz.add(label, j - 1, i);
                    }
                // Se a matriz passada é de escolha, o if vai ignorar os i == j.
                } else {
                    if (i < j) {
                        Label label = new Label();
                        label.setText(Integer.toString(matriz[i][j]));
                        GridPane.setHalignment(label, HPos.CENTER);
                        gdMatriz.add(label, j - 1, i);
                    }
                }
            }
        }
    }

    public MatrizScreenController(int[][] matriz, boolean isMatrizM) {
        this.matriz = matriz;
        this.isMatrizM = isMatrizM;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public int[][] getMmatriz() {
        return matriz;
    }
}
