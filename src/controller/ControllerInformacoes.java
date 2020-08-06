/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.ModelInformacoes;

/**
 *
 * @author IPSEMG
 */
public class ControllerInformacoes {

    public void retornarInfo(String retornarInfo) {
        ModelInformacoes modelInfo = new ModelInformacoes();
        modelInfo.retornarInfo(retornarInfo);
    }
    
}
