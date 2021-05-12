/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturas;

import ialightsout.Tabuleiro;
import java.util.Stack;

/**
 *
 * @author Rollbusch
 */
public class Pilha implements EstadosAbertos {
    
    private Stack<Tabuleiro> elementos = new Stack<>();

    @Override
    public void push(Tabuleiro tabuleiro) {
        this.elementos.push(tabuleiro);
    }

    @Override
    public Tabuleiro pop() {
        return this.elementos.pop();
    }

    @Override
    public int size() {
        return this.elementos.size();
    }
    
}
