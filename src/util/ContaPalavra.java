/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.DataInputStream;

/**
 *
 * @author Leandro
 */
    public class ContaPalavra{  
        
        /**
         * Retorna quantidade de palavras em uma frase
         * @param pFrase
         * @return 
         */
       public int retornaTotalPalavra(String pFrase){  
            int quantidade = 0;  
            DataInputStream dado;  
              
            try  
              {  

               
              for (int i = 0; i < pFrase.length(); i++)  
               {  
                 if (pFrase.charAt(i) == ' ')  
                    {   
                      quantidade += 1;  
                        
                    }  
                 if (pFrase.charAt(i) == '.')  
                    {  
                       quantidade += 1;  
                        
                      break;  
                    }                 
                 else  
                   {  
                      continue;  
                   }      
                }  
               System.out.println("Numero de palavras: " + quantidade);  
              }  
             catch (Exception a)  
              {  
                System.out.println("erro");  
              }  
           return quantidade;
          }  
       
       /**
        * Retorna quantidade de letras de uma frase
        * @param pFrase
        * @return 
        */
        public int retornaQuantidadeDeLetras(String pFrase) {
            int quantidade = 0;
            quantidade = pFrase.length();
            return quantidade;
        }
    }  