/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemploproperties;

import br.com.praticas.exemploproperties.util.MensagensUtil;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author ALUNO
 */
public class ExemploProperties {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic 

        String op, op2 = "";
        Scanner input = new Scanner(System.in);
        
        do {

            System.out.println(MensagensUtil.getMensagem(MensagensUtil.MENU_PRINCIPAL_TITULO));
            System.out.println(MensagensUtil.getMensagem(MensagensUtil.MENU_PRINCIPAL_CADASTRAR));
            System.out.println(MensagensUtil.getMensagem(MensagensUtil.MENU_PRINCIPAL_BUSCAR));
            System.out.println(MensagensUtil.getMensagem(MensagensUtil.MENU_PRINCIPAL_IDIOMA));

            op = input.nextLine();
            
            if(op.equals("3")){
                
                System.out.println("MUDAR IDIOMA");
                System.out.println("1 - PT / 2 - EN");
                
                op2 = input.nextLine();
                
                if(op2.equals("1")){
                    MensagensUtil.setLocale(MensagensUtil.LOCALE_PT_BR);
                }
                else{
                     MensagensUtil.setLocale(MensagensUtil.LOCALE_EN_US);
                }
            }
            
        } while (!op.equals("0"));

    }

}
