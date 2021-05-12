package ialightsout;

import java.util.ArrayList;
import java.util.List;
import estruturas.EstadosAbertos;
import java.awt.Point;
 
public class Solver {
    
    private List<Tabuleiro> estadosFechados;
    private EstadosAbertos estadosAbertos;
    private final Tabuleiro OBJETIVO;
    private boolean achouObjetivo = false;
    private Tabuleiro tabuleiroFinal;
    private int tabSize;

    public Solver(Tabuleiro tabuleiro, Tabuleiro objetivo, EstadosAbertos estrutura, int size) {
        this.estadosFechados = new ArrayList<>();
        this.estadosAbertos = estrutura;
        this.estadosAbertos.push(tabuleiro);
        this.OBJETIVO = objetivo;
        this.tabSize = size;
    }
   
    public void jogar () {        
        System.out.println("----- JOGANDO -----");
        while (!this.isAchouObjetivo()) {
            Tabuleiro tab = this.estadosAbertos.pop();
            this.estadosFechados.add(tab);
            this.gerarFilhos(tab);
            System.out.println("Estados fechados: " + this.estadosFechados.size());
            System.out.println("Estados abertos: " + this.estadosAbertos.size());
        } 
        System.out.println("##### TABULEIRO RESOLVIDO #####");
        this.tutorial();
    }
    
    private void gerarFilhos (Tabuleiro tab) {
        tab.mostrarTabuleiro();
        if (tab.equals(this.OBJETIVO)) {
            this.setAchouObjetivo(true);
            this.tabuleiroFinal = tab;
        }
        
        for (int i = 0; i < this.tabSize; i++) {
            for (int j = 0; j < this.tabSize; j++) {
                Tabuleiro tabPai = new Tabuleiro(tab.copy(), this.tabSize);
                Tabuleiro tabFilho = this.mudarVizinho(i, j, tabPai);
                tabFilho.getPaiCaminho(tab);
                tabFilho.addCaminho(new Point(i, j));
                if (!tabFilho.equals(tabPai)) this.estadosAbertos.push(tabFilho);
            }
        }
    }

    public boolean isAchouObjetivo() {
        return achouObjetivo;
    }

    public void setAchouObjetivo(boolean isObjetivo) {
        this.achouObjetivo = isObjetivo;
    }
    
    
    private Tabuleiro mudarVizinho (int i, int j, Tabuleiro tabPai) {
        Tabuleiro tab = new Tabuleiro(tabPai.copy(), this.tabSize);
        
        // Get the number which will be manipulated
        int num = tab.getNum(i, j);
        tab.setNum(i, j, mudarNumero(num));

        // Getting his neighbour 
        int ngbour1 = tab.getNum(i - 1, j);
        if (ngbour1 != -1) tab.setNum(i - 1, j, mudarNumero(ngbour1));

        int ngbour2 = tab.getNum(i + 1, j);
        if (ngbour2 != -1) tab.setNum(i + 1, j, mudarNumero(ngbour2));

        int ngbour3 = tab.getNum(i, j - 1);
        if (ngbour3 != -1) tab.setNum(i, j - 1, mudarNumero(ngbour3));

        int ngbour4 = tab.getNum(i, j + 1);
        if (ngbour4 != -1) tab.setNum(i, j + 1, mudarNumero(ngbour4));
        
        return tab;
    }
    
    protected int mudarNumero (int aNum) {
        int num = aNum;
        if (num == 0) num = 1;
        else if (num == 1) num = 0;
        return num;
    }
    
    public void tutorial () {
        System.out.println("SERÃO NECESSÁRIAS " + this.tabuleiroFinal.caminhoSize() + " JOGADAS.");
        int i = 1;
        
        int[][] novoTabuleiro = OBJETIVO.copy();
        Tabuleiro tabTutorial = new Tabuleiro(novoTabuleiro, this.tabSize);
        tabTutorial.getPaiCaminho(this.tabuleiroFinal);
        
        for (Object coordenada : this.tabuleiroFinal.getCaminho()) {
            tabTutorial.setNum(((Point)coordenada).x, ((Point)coordenada).y, i);
            i++;
        }
        tabTutorial.mostrarTabuleiro();
        tabTutorial.mostrarCaminho();
    }  
    
}
