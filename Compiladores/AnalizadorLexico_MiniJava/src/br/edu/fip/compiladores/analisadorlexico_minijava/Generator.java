package br.edu.fip.compiladores.analisadorlexico_minijava;

import java.io.File;
import java.nio.file.Paths;

public class Generator {
    
    public static void main(String[] args) {
        String rootPath = Paths.get("").toAbsolutePath().toString();
        String subPath = "/src/br/edu/fip/compiladores/analisadorlexico_minijava/";
        
        String file = rootPath + subPath + "language.lex";
        
        File souceCode = new File(file);
        
        jflex.Main.generate(souceCode);
    }
    
}
