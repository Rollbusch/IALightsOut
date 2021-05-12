/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturas;

import ialightsout.Tabuleiro;

/**
 *
 * @author Rollbusch
 */
public interface EstadosAbertos {
    
    public void push(Tabuleiro tabuleiro);
    public Tabuleiro pop();
    public int size();
    
}
