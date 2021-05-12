/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturas;

import ialightsout.Tabuleiro;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Rollbusch
 */
public class Fila implements EstadosAbertos {
    
    Queue<Tabuleiro> elementos = new LinkedList();

    @Override
    public void push(Tabuleiro tabuleiro) {
        elementos.add(tabuleiro);
    }

    @Override
    public Tabuleiro pop() {
        return elementos.poll();
    }

    @Override
    public int size() {
        return elementos.size();
    }
    
}
