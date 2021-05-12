package ialightsout;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tabuleiro {
    
    private int[][] tabuleiro;
    private int size;
    private List<Point> caminho;
    
    public Tabuleiro(int[][] tabuleiro, int size) {
        this.caminho = new ArrayList<Point>();
        this.tabuleiro = tabuleiro;
        this.size = size;
    }

    public int[][] getTabuleiro() {
        return tabuleiro;
    }

    public List getCaminho() {
        return this.caminho;
    }
    
    public int caminhoSize () {
        return this.caminho.size();
    }
    
    public void getPaiCaminho (Tabuleiro tabPai) {
        List<Point> novoCaminho = new ArrayList<>();
        List<Point> atualCaminho = this.getCaminho();
        
        for (Object coordenada : tabPai.getCaminho()) {
            novoCaminho.add((Point)coordenada);
        }
        
        for (Object coordenada : atualCaminho) {
            novoCaminho.add((Point)coordenada);
        }
        
        this.caminho = novoCaminho;
    }
    
    public void addCaminho(Point coordenada) {
        this.caminho.add(coordenada);
    }
    

    public int getNum(int i, int j) {
        int num;
        try {
            num = this.tabuleiro[i][j];
            return num;
        } catch (Exception e) {
            return -1;
        }
    }

    public int getSize() {
        return size;
    }
    
    public void setNum(int i, int j, int num) {
        try {
            this.tabuleiro[i][j] = num;
        } catch (Exception e) {
            System.out.println("Posição não existe.");
        }
    }
    
    public int[][] copy () {
        int [][] tabCopy = new int[tabuleiro.length][];
        for(int i = 0; i < tabuleiro.length; i++)
            tabCopy[i] = tabuleiro[i].clone();
        return tabCopy;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Arrays.deepHashCode(this.tabuleiro);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tabuleiro other = (Tabuleiro) obj;
        if (!Arrays.deepEquals(this.tabuleiro, other.tabuleiro)) {
            return false;
        }
        return true;
    }

    public void mostrarTabuleiro() {
        if (size == 3) {
            System.out.println("##### TABULEIRO #####");
            System.out.println(this.tabuleiro[0][0] + " " + this.tabuleiro[0][1] + " " + this.tabuleiro[0][2]);
            System.out.println(this.tabuleiro[1][0] + " " + this.tabuleiro[1][1] + " " + this.tabuleiro[1][2]);
            System.out.println(this.tabuleiro[2][0] + " " + this.tabuleiro[2][1] + " " + this.tabuleiro[2][2]);
        }
        if (size == 4) {
            System.out.println("##### TABULEIRO #####");
            System.out.println(this.tabuleiro[0][0] + " " + this.tabuleiro[0][1] + " " + this.tabuleiro[0][2] + " " + this.tabuleiro[0][3]);
            System.out.println(this.tabuleiro[1][0] + " " + this.tabuleiro[1][1] + " " + this.tabuleiro[1][2] + " " + this.tabuleiro[1][3]);
            System.out.println(this.tabuleiro[2][0] + " " + this.tabuleiro[2][1] + " " + this.tabuleiro[2][2] + " " + this.tabuleiro[2][3]);
            System.out.println(this.tabuleiro[3][0] + " " + this.tabuleiro[3][1] + " " + this.tabuleiro[3][2] + " " + this.tabuleiro[3][3]);
        }
    }

    public void mostrarCaminho() {
        System.out.print("Coordenadas para chegar ao objetivo: ");
        for (Point coord : this.caminho) {
            System.out.print("(" + coord.x + ", " + coord.y + ") ");
        }
    }
    
    
    
}
