package modelo;

import java.util.ArrayList;
import java.util.List;

public class Campo {
//	  criando linhas e colunas
	private final int linha;
	private final int coluna;
//		criando variavel booleana para campo com minas ou vazios
	private boolean aberto = false;
	private boolean minado = false;
	
//	criando array list
	private List<Campo> vizinhos = new ArrayList<>(); 
	
//	criando construtor campo
	Campo(int linha, int coluna){
		this.linha = linha;
		this.coluna = coluna;
	}
//	criando método vizinho 
	boolean adicionarVizinho(Campo vizinho) {
		boolean linhaDiferente = linha != vizinho.linha;
		boolean colunaDiferente = coluna != vizinho.coluna;
		boolean diagonal = linhaDiferente && colunaDiferente;
		
		int deltaLinha = Math.abs(linha - vizinho.linha);
		int deltaColuna = Math.abs(coluna - vizinho.coluna);
		int deltaGeral = deltaColuna + deltaLinha;
		
		
		if (deltaGeral == 1 && !diagonal) {
			vizinhos.add(vizinho);
			return true;
		}else if (deltaGeral == 2 && diagonal) {
			vizinhos.add(vizinho);
			rerturn true;
		}else {
			return false;
		}
		
	}
	
	
}
