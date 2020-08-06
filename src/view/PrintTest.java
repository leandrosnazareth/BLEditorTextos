/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author leand_000
 */

// The PrintText application expands on the
// PrintExample application in that it images
// text on to the single page printed.
import java.awt.Font; 
import java.awt.Graphics; 
import java.awt.Graphics2D; 
import java.awt.print.PageFormat; 
import java.awt.print.Pageable; 
import java.awt.print.Printable; 
import java.awt.print.PrinterException; 
import java.awt.print.PrinterJob; 

import javax.swing.JTextArea; 
import javax.swing.RepaintManager; 

public class PrintTest { 

public static void main(String[] args) { 
PrintClass pc = new PrintClass(); 
pc.print(); 
} 

public static class PrintClass extends Object implements Printable, 
Pageable { 

private PrinterJob printerJob; 
private PageFormat pageFormat; 
private JTextArea textPane; 

/** 
*	Default constructor. 
*/ 

public PrintClass() { 
super(); 

textPane = new JTextArea(); 
textPane.setText("iiiiiiiiii1iiiiiiiiii2iiiiiiiiii3iiiiiiiiii4iiiiiiiiii5iiiiiiiiii6iiiiiiiiii7iiiiiiiiii8iiiiiiiiii9iiiiiiiiii10iiiiiiiiii11iiiiiiiiii12iiiiiiiiii13iiiiiiiiii14iiiiiiiiii15iiiiiiiiii16iiiiiiiiii17iiiiiiiiii18iiiiiiiiii19iiiiiiiiii20");
textPane.setFont(new Font("Tahoma", Font.PLAIN, 12)); 
textPane.setLineWrap(true); 
textPane.setWrapStyleWord(true); 
} 

//	Implements Pageable.getNumberOfPages 

public int getNumberOfPages() { 
return 1; 
} 

//	Implements Pageable.getPageFormat 

public PageFormat getPageFormat(int pageIndex) throws 
IndexOutOfBoundsException { 
return pageFormat; 
} 

//	Implements Pageable.getPrintable 

public Printable getPrintable(int pageIndex) throws 
IndexOutOfBoundsException { 
return this; 
} 

//	Implements Printable.print(Graphics, PageFormat, int) 

public int print(Graphics g, PageFormat pageFormat, int pageIndex) { 

final Graphics2D g2 = (Graphics2D)g; 

RepaintManager currentManager = 
RepaintManager.currentManager(textPane); 

currentManager.setDoubleBufferingEnabled(false); 

g2.translate(pageFormat.getImageableX(), 
pageFormat.getImageableY()); 

textPane.setSize((int)pageFormat.getImageableWidth(), 
(int)pageFormat.getImageableHeight()); 
textPane.print(g); 

currentManager.setDoubleBufferingEnabled(true); 

return Printable.PAGE_EXISTS; 

} 

/** 
*	Prints the contents of the window. 
*/ 

public void print() { 
printerJob = PrinterJob.getPrinterJob(); 
pageFormat = printerJob.defaultPage(); 

printerJob.setPageable(this); 

try { 
printerJob.print(); 
} catch (PrinterException ignored) { 

} 
} 
} 
} 