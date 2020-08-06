package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 */
public class BLTXT {

    /**
     * Inserir dados em um arquivo txt
     *
     * @param palavra
     * @param caminho
     * @return
     */
    public boolean inserirDados(String palavra, String pCaminho) {
        File fArquivo = null;
        try {
            fArquivo = new File(pCaminho);
            FileWriter fwArquivo = null;

            // Verifica se o arquivo existe
            // Se existir, ele abre par adicionar dados
            // se nao existir, ele cria o arquivo
            if (fArquivo.exists() == true) {
                fwArquivo = new FileWriter(fArquivo, true);
            } else {
                fwArquivo = new FileWriter(fArquivo);
            }
            
            BufferedWriter bw = new BufferedWriter(fwArquivo);

            //escreve o registro no arquivo e pula uma linha com o \n
            bw.write(palavra + "\n");
            
            //fecha o arquivo
            bw.close();
            fwArquivo.close();
            
            JOptionPane.showMessageDialog(null, "Palavra cadastrada com suscesso!");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar palavra!\n" + e,
                    "Menssagem de erro:", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     * Listar dados de um arquivo txt
     * @param pCaminho 
     */
    public ArrayList<String> listarDados(String pCaminho) {
        ArrayList<String> listaDePalavras = new ArrayList<String>();
        Scanner lendoArquivo = null;
        File arquivo = null;
        try {
            // abrindo o arquivo para leitura
            // se o arquivo nao existir será disparada uma exceção
            arquivo = new File(pCaminho);
            lendoArquivo = new Scanner(arquivo);

            // leia o arquivo linha por linha até chegar ao seu fim
            while (lendoArquivo.hasNextLine()) {
//                this.processandoLinha(lendoArquivo.nextLine());
                listaDePalavras.add(lendoArquivo.nextLine());
            }
            
        } catch (FileNotFoundException e) { // tratando quando o arquivo nao existe
            System.err.println("Erro: arquivo nao existe. " + arquivo);
        } finally {
            // fechando o scanner
            try {
                lendoArquivo.close();
            } catch (Exception e) {
            }
        }
        return listaDePalavras;
    }

public void excluir(String linhadelete, String arquivo) throws IOException{  

        System.out.println("Contato a ser deletado:"+linhadelete);  
        try{  
            File inFile = new File(arquivo);  
            if(!inFile.isFile()){  
                System.out.println("O caminho passado não existe!");  
                return;  
            }  
            File tempFile = new File(inFile.getAbsolutePath()+".temp");  
            BufferedReader br = new BufferedReader(new FileReader(arquivo));  
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));  
            String line = null;  
            while((line = br.readLine()) != null){  
                if(!line.trim().equals(linhadelete)){  
                    pw.println(line);  
                    pw.flush();  
                }  
            }  
            pw.close();  
            pw.flush();  
            if(!inFile.delete()){  
                System.out.println("Arquivo não deletado!");  
                return;  
            }  
            if(!tempFile.renameTo(inFile)){  
                System.out.println("Arquivo renomeando!");  
            }  
        }catch (FileNotFoundException arq) {  
            arq.printStackTrace();
        }catch (IOException e) {  
            e.printStackTrace();  
        }  
    }
    
   public void excluirPalavra(String pPalavra){
              
                FileReader fileReader = null;    
                FileWriter fileWriter = null;     
                BufferedReader leitor = null;    
                  
                String nomeDoArquivo = "./src/arquivos/arquivo.txt";  
                String arquivoConferir = "./src/arquivos/arquivoConferir.txt";    
                String line = null;    
                    
                try {    
                        
                    fileReader = new FileReader(new File(nomeDoArquivo));    
                    fileWriter = new FileWriter(new File(arquivoConferir));   
                    leitor = new BufferedReader(fileReader);  
                    line = "";    
                      
                    while ((line = leitor.readLine()) != null) {    
                        if(!line.trim().equals(pPalavra.trim())) {   
                                fileWriter.write(line + "\r\n");   
                            }    
                        } 
                    System.out.println("Registro: "+ pPalavra + "Linha: " + line + " Excluido com sucesso");
                    }catch (IOException e) {    
                    e.printStackTrace();    
                } finally   {    
                    try {    
                        fileWriter.close();  
                        fileReader.close();    
                    } catch (IOException e) {    
                        e.printStackTrace();    
                    }    
                } 
   }
   
}