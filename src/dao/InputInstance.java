/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Rollbusch
 */
public class InputInstance {
    
    public int[][] tabuleiro;
    public int size;

    public InputInstance(String arquivo) {
        this.pegarTabuleiro(arquivo);
    }
    
    private void pegarTabuleiro (String arquivo) {
        try {
            File file = new File(arquivo);
            Scanner scanner = new Scanner(file);
            ArrayList<Integer> lista = new ArrayList<Integer>();

            while (scanner.hasNext()) {
                lista.add(Integer.parseInt(scanner.next()));
            }
            
            this.size = lista.get(0);
            lista.remove(0);
            this.criarTabuleiro(lista);
        } catch (FileNotFoundException ex) {
            System.out.println("Erro ao procurar o arquivo. Mais informações abaixo: ");
            System.out.println(ex.getMessage());
        }
    }
    
    private void criarTabuleiro (ArrayList lista) {
        int[][] tab = new int[this.size][this.size];
        int index = 0;
        
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j< this.size; j++) {
                tab[i][j] = (int)lista.get(index);
                index++;
            }
        }
        this.tabuleiro = tab;
    }

    public int[][] getTabuleiro() {
        return tabuleiro;
    }

    public int getSize() {
        return size;
    }
    
    @Override
    public String toString() {
        return "InputInstance{" + "tabuleiro=" + tabuleiro + '}';
    }
    
    
    
}
