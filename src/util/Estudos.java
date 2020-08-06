/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author IPSEMG
 */
/*
 Este exemplo mostra como ordenar as colunas
 de uma JTable clicando nos títulos das
 colunas desejadas. Necessário Java SE 6 ou superior.
*/

import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;

public class Estudos extends JFrame{
  int linha, coluna;
  
  public Estudos(){
    super("JTable");
		
    TableModel modelo = createTableModel();
    JTable tabela = new JTable(modelo);
    tabela.setPreferredScrollableViewportSize(new 
         Dimension(350, 100));
    
    // Instala o TableRowSorter.
    TableRowSorter<TableModel> sorter;
    sorter = new TableRowSorter<TableModel>(modelo);
    tabela.setRowSorter(sorter);	

    Container c = getContentPane();
    c.setLayout(new FlowLayout());
	
    JScrollPane scrollPane = new JScrollPane(tabela);
    c.add(scrollPane);
    	
    setSize(400, 300);
    setVisible(true);
  }

  TableModel createTableModel(){
    DefaultTableModel model = new DefaultTableModel(5, 2);
    String[] colunas = {"Cidades","Estados"};
    model.setColumnIdentifiers(colunas);
    String[] cidades = {"Goiânia", "Cuiabá", "Brasília",
                        "Barra do Garças", "Fortaleza"};
    String[] estados = {"GO", "MT", "DF", "MT", "CE"};

    int nrows = model.getRowCount();
    int ncols = model.getColumnCount();

    for(int i = 0; i < nrows; i++){
      model.setValueAt(cidades[i], i, 0);
      model.setValueAt(estados[i], i, 1);
    }

    return model;
  } 
	
  public static void main(String args[]){
    Estudos app = new Estudos();
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}
