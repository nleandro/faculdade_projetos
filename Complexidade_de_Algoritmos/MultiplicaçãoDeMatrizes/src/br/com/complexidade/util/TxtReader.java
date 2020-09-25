package br.com.complexidade.util;

import br.com.complexidade.model.Dimensao;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;

public class TxtReader {

    public static ObservableList<Dimensao> lerArquivo() {
        try {
            // Parte que vai ler o arquivo, sendo permitido somente do tipo .txt.
            ObservableList<Dimensao> ds = ds = FXCollections.observableArrayList();
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Arquivo TXT", "*.txt"));
            File f = fc.showOpenDialog(null);
            BufferedReader br = new BufferedReader(new FileReader(f));

            // Essa parte será lido o arquivo e colocando numa string conteúdo e
            // depois será lido a mesma string. Na leitura, quando encontrar um
            // 'x' será feito uma separação em duas strings, uma antes do 'x' e 
            // outra depois, fazendo esse processo até ler toda a string conteúdo.
            String conteudo = br.readLine();
            String[] valores = conteudo.split("x");

            // Se tiver menos ou igual a 3 dimensões não é aceito.
            if (valores.length <= 3) {
                throw new Exception();
            } else {
                // Vai adicionar todas as dimensões que existem do arquivo e 
                // colocar dentro de um ObservableList, permitindo a exibição  
                // tableView.
                for (int i = 0; i < valores.length; i++) {
                    Dimensao d = new Dimensao("d" + i, Integer.parseInt(valores[i]));
                    ds.add(d);
                }

                return ds;
            }
        } catch (Exception e) {
            System.out.println("Erro");
        }
        return null;
    }

}
