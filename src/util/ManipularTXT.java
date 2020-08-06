/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author IPSEMG
 */
 
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
 
/**
 * Exemplo de como fazer a leitura e a escrita em arquivos TXT com Java
 * Para a leitura é feito uso da classe Scanner
 *
 * @author Emerson Ribeiro de Mello
 */
public class ManipularTXT {
 
    /* atributos */
    private String nomeDoArquivo;
 
    /* construtor */
    public ManipularTXT(String nomeArquivo) {
        this.nomeDoArquivo = nomeArquivo;
    }
 
    /* métodos */
    public boolean inserirDados(String registro) {
        File fArquivo = null;
        try {
            fArquivo = new File(this.nomeDoArquivo);
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
            bw.write(registro + "\n");
 
 
            
            //fecha o arquivo
            bw.close();
            fwArquivo.close();
 
            System.out.println("Registro adicionado com sucesso...");
            return true;
        } catch (Exception e) {
            System.err.println("Erro ao inserir linhas no arquivo: " + fArquivo);
            return false;
        }
    }
 
    public void listarDados() {
        Scanner lendoArquivo = null;
        File arquivo = null;
        try {
            // abrindo o arquivo para leitura
            // se o arquivo nao existir será disparada uma exceção
            arquivo = new File(this.nomeDoArquivo);
            lendoArquivo = new Scanner(arquivo);
 
            // leia o arquivo linha por linha até chegar ao seu fim
            while (lendoArquivo.hasNextLine()) {
                this.processandoLinha(lendoArquivo.nextLine());
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
    }
 
    private void processandoLinha(String linha) {
        // toda linha do arquivo segue o formato:
        // nome:telefone
        if (linha != null) {
            // separando os campos através do delimitador ':'
            String[] campos = linha.split(":");
 
            System.out.print("Nome: " + campos[0].trim());
            System.out.println("\tFone: " + campos[1].trim());
            System.out.println("--------------------------------------\n");
        }
    }
 
    public void menu() {
        // passando para o objeto da classe Scanner o dispositivo de entrada padrão
        // que é o teclado
        Scanner teclado = new Scanner(System.in);
        int op = 0;
        do {
            System.out.println("..:: Trabalhando com Arquivos Texto ::..");
            System.out.println("1 - Inserir linha");
            System.out.println("2 - Listar todo arquivo");
            System.out.println("3 - Sair");
            System.out.print("Entre com uma opcao: ");
            op = teclado.nextInt();
 
            switch (op) {
                case 1:
                    teclado.nextLine();
                    String nome;
                    String telefone;
                    System.out.println("Entre com os dados:");
                    System.out.print("Nome: ");
                    nome = teclado.nextLine();
                    System.out.print("Fone: ");
                    telefone = teclado.nextLine();
                    this.inserirDados(nome + ":" + telefone);
                    break;
                case 2:
                    this.listarDados();
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
 
        } while (op != 3);
    }
 
    public static void main(String[] args) {
 
        ManipularTXT p = new ManipularTXT("agenda-poo.txt");
 
        p.menu();
    }
}