package ialightsout;

import dao.InputInstance;
import estruturas.Fila;

public class IALightsOut {

    public static void main(String[] args)  {
        
        // Pega a instancia e constroi o tabuleiro dele
        InputInstance ii = new InputInstance("DIRETORIO DA INSTANCIA");

        if (ii.tabuleiro != null) {
            Tabuleiro tab = new Tabuleiro(ii.getTabuleiro(), ii.getSize());
            int tabSize = ii.getSize();
            
            int[][] objetivo = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

            Tabuleiro obj = new Tabuleiro(objetivo, tabSize);

            Solver solver = new Solver(tab, obj, new Fila(), tabSize);
            solver.jogar();
        }
    }
}
