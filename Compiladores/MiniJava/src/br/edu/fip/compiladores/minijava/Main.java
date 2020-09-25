/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.fip.compiladores.minijava;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

/**
 *
 * @author Nellson
 */
public class Main {
    
    public static void main(String[] args) throws IOException {
        String rootPath = Paths.get("").toAbsolutePath().toString();
        String subPath = "/src/br/edu/fip/compiladores/minijava/";
        
        String code = rootPath + subPath + "Program.txt";
        
        try {
            Parser p = new Parser(new AnalisadorLexico(new FileReader(code)));
            Object result = p.parse().value;
            
            System.out.println("Compilação concluida com sucesso...");
        } catch (Exception e) {
            System.out.println("Falha ao compilar...");
        }
    }
    
}
