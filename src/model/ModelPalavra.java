/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Leandro
 */
public class ModelPalavra {
    
    
    private String descricao;
    
    public ModelPalavra(){}
    
    /**
     * Construtor para cadastrar palavra
     * @param pCodigo
     * @param pDescricao 
     */
    public ModelPalavra(int pCodigo, String pDescricao){
        this.descricao = pDescricao;
    }
    public ModelPalavra(String pDescricao){
        this.descricao = pDescricao;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
