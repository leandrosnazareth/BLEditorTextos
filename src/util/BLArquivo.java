/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BLArquivo {
    
    File f;
    FileWriter fw;
    BufferedWriter bw;
    
    public BLArquivo() throws IOException{
        f = new File("ListaPalavras.xml");
        fw = new FileWriter(f);
        bw = new BufferedWriter(fw);
    }
    
    public void escreverTexto(String pTexto) throws IOException{
            //INSERE UMA NOVA LINHA
            bw.write(pTexto);
            bw.newLine();
            bw.flush();
    }
    
    public boolean fecharArquivo() throws IOException{
        bw.close();
        return true;
    }

}
