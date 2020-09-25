package br.edu.fip.compiladores.analisadorlexico_minijava;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestaAnalisadorLexico {

    public static void main(String[] args) throws IOException {
        String rootPath = Paths.get("").toAbsolutePath().toString();
        String subPath = "/src/br/edu/fip/compiladores/analisadorlexico_minijava/";
        String name = "teste2.txt";
        
        Path path = Paths.get(rootPath, subPath, name);
        String teste = new String(Files.readAllBytes(path));
        
        AnalisadorLexico lexical = new AnalisadorLexico(new StringReader(teste));
        lexical.yylex();
    }

}
