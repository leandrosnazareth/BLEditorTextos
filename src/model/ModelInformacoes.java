/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author IPSEMG
 */
public class ModelInformacoes {
    
    private String informacao;

    /**
     * @return the informacao
     */
    public String getInformacao() {
        return informacao;
    }

    /**
     * @param informacao the informacao to set
     */
    public void setInformacao(String informacao) {
        this.informacao = informacao;
    }

    public void retornarInfo(String retornarInfo) {
        setInformacao(retornarInfo);
    }
    
}
