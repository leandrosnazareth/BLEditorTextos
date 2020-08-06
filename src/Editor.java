import java.io.*; //importa pra poder usar File, FileReader e FileWriter 
import javax.swing.JFileChooser; //Importa componente pra janela de escolha de arquio
import javax.swing.JFrame; //Janela Principal
import javax.swing.JOptionPane; //Painel

/**
   Classe Principal do 
   Editor de Texto Simples 
*/
public class Editor extends JFrame {
	private javax.swing.JPanel jContentPane = null;
	private javax.swing.JPanel jPanel = null;
	private javax.swing.JButton jButton = null;
	private javax.swing.JButton jButton1 = null;
	private javax.swing.JButton jButton2 = null;
	private javax.swing.JScrollPane jScrollPane = null;
	private javax.swing.JTextArea jTextArea = null;
	private javax.swing.JFileChooser jFileChooser = null; //  @jve:visual-info  decl-index=0 visual-constraint="582,36"
	private boolean hasChanged = false; //Indica se o texto foi alterado
	private static final String title = "Editor de Texto Simples"; //Titulo da janela

	/**
	 * Construtor Default
	 */
	public Editor() {
		super(); //chama super de JFrame
		initialize(); //Inicializa o Objeto
	}
   
	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new javax.swing.JPanel();
			jContentPane.setLayout(new java.awt.BorderLayout());
			jContentPane.add(getJPanel(), java.awt.BorderLayout.SOUTH);
			jContentPane.add(getJScrollPane(), java.awt.BorderLayout.CENTER);
			jContentPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
		}
		return jContentPane;
	}

	/**
	 * Inícializa a classe
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setContentPane(getJContentPane());
		this.setSize(480, 284); //Tamanho da janela
		this.setTitle(title);
		this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE); //Isso é pra não fechar
      //pois preciso de um evento que trate o fechamento ao sair    
		this.addWindowListener(new java.awt.event.WindowAdapter() { //Listener pra tratar o fechamento
			public void windowClosing(java.awt.event.WindowEvent e) {
				doExit(); 
			}
		});

	}

	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private javax.swing.JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new javax.swing.JPanel();
			jPanel.add(getJButton(), null);
			jPanel.add(getJButton1(), null);
			jPanel.add(getJButton2(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jButton
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton() {
		if (jButton == null) {
			jButton = new javax.swing.JButton();
			jButton.setText("Abrir arquivo");
			jButton.addActionListener(new java.awt.event.ActionListener() { //Listener pra carregar arquivo no clique do botão
				public void actionPerformed(java.awt.event.ActionEvent e) { 
					loadFile();
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jButton1
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new javax.swing.JButton();
			jButton1.setText("Salvar arquivo");
			jButton1.addActionListener(new java.awt.event.ActionListener() { //Listener pra salvar arquivo no clique do botão
				public void actionPerformed(java.awt.event.ActionEvent e) {
					saveFile();
				}
			});
		}
		return jButton1;
	}

	/**
	 * This method initializes jButton2
	 * 
	 * @return javax.swing.JButton
	 */
	private javax.swing.JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new javax.swing.JButton();
			jButton2.setText("Sair");
			jButton2.addActionListener(new java.awt.event.ActionListener() { //Listener pra fechar programa no clique do botão
				public void actionPerformed(java.awt.event.ActionEvent e) {
					doExit();
				}
			});
		}
		return jButton2;
	}

	/**
	 * This method initializes jScrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private javax.swing.JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new javax.swing.JScrollPane();
			jScrollPane.setViewportView(getJTextArea());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTextArea
	 * 
	 * @return javax.swing.JTextArea
	 */
	private javax.swing.JTextArea getJTextArea() {
		if (jTextArea == null) {
			jTextArea = new javax.swing.JTextArea();
			jTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyTyped(java.awt.event.KeyEvent e) { //Detecta modificação e seta tbm
					if (!hasChanged) {
						setTitle(title + " *");
						hasChanged = true;
					}
				}
			});
		}
		return jTextArea;
	}

	/**
	 * This method initializes jFileChooser
	 * 
	 * @return javax.swing.JFileChooser
	 */
	private javax.swing.JFileChooser getJFileChooser() {
		if (jFileChooser == null) {
			jFileChooser = new javax.swing.JFileChooser();
			jFileChooser.setMultiSelectionEnabled(false);
		}
		return jFileChooser;
	}

   //função que carrega o texto
	private void loadFile() {
		int state = getJFileChooser().showOpenDialog(this); //chama janela pra selecionar arquivo
		if (state == JFileChooser.APPROVE_OPTION) { //verifica o status
			File f = getJFileChooser().getSelectedFile(); //pega o file selecionado na janela
			try { //Tenta ler o arquivo para o controle de texto
				FileReader fr = new FileReader(f); //cria o FileReader com o file previamente selecionado
            String temp = ""; //String temporaria
            //Vai lendo um caractere por vez e concatenando em temp.
            //A função read retorna um inteiro pois pode vir -1 significando o fim do arquivo
            //E um char não permite negativos
            //a função read pode gerar IOException
            int i = fr.read(); 
            while (i!=-1) {
               temp+=((char)i); 
               i = fr.read();
            } 
            fr.close(); //fecha arquivo
            getJTextArea().setText(temp); //atribui temp ao controle
				setTitle(title); //seta o titulo pra remover o * se houver
				hasChanged = false; //Não alterado
			} catch (FileNotFoundException e) { //Não encontrou arquivo
				e.printStackTrace();
			} catch (IOException e) { //Algum erro na leitura
				e.printStackTrace();
			}
		}
	}

   //função que salva
	private void saveFile() {
		int state = getJFileChooser().showSaveDialog(this); //Abre dialogo pra selecionar
		if (state == JFileChooser.APPROVE_OPTION) { //se selecionou
			File f = getJFileChooser().getSelectedFile(); //pega file
			try {
            //tenta salvar      
				FileWriter fw = new FileWriter(f);
            //pega o texto do TextArea e envia pra stream no arquivo
            //A função write escreve uma string para o arquivo. Existem outras opções
            //a função write pode gerar IOException
            fw.write(getJTextArea().getText());
            fw.close();//fecha arquivo
				setTitle(title); //seta o titulo pra remover o * se houver
				hasChanged = false; //marca como não alterado
			} catch (FileNotFoundException e) { //Não encontrou o arquivo
				e.printStackTrace();
			} catch (IOException e) { //Algum outro erro de io, não conseguiu gravar pois não tem permissão por exemplo
				e.printStackTrace();
			}
		}
	}

   //Na saida verifica se quer salvar
	private void doExit() {
		if (hasChanged) {
			int state = JOptionPane.showConfirmDialog(this,
					"O Arquivo foi moficado. Quer salva antes de sair?");
			if (state == JOptionPane.YES_OPTION) {
				saveFile();
			} else if (state == JOptionPane.CANCEL_OPTION) {
				return;
			}
		}
		System.exit(0); //Sae fora =)
	}
   
   //Função Princial, apenas cria classe e mostra, depois os Listener adicionados em Editor fazem o resto 
   public static void main(String[] args) {
      javax.swing.SwingUtilities.invokeLater(new Runnable() { //Adiciona o código run abaixo a thread que maipula os eventos graficos
            public void run() {
                Editor e = new Editor(); //Cria objeto
                e.setVisible(true); //Mostra
            }
        });
      
   }
   
   
} //  @jve:visual-info  decl-index=0 visual-constraint="20,27"
