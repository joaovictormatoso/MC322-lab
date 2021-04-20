package mc322.lab04;

/**
 * @author João Victor Matoso
 */
public class Tabuleiro {
	private Peca[][] tabuleiro;
	
	/**
	 * Inicializa tabuleiro com peças na posição inicial
	 */
	Tabuleiro(){
		tabuleiro = new Peca[7][7];
		
		// Cria as peças para o tabuleiro
		for(int c = 0; c < 7; c++)
			for(int l = 0; l < 7; l++)
				if(posicaoEhValida(c,l))
					tabuleiro[c][l] = new Peca();
		
		// Retira peça do centro do tabuleiro
		tabuleiro[3][3].setVisibilidade(false);
		
		// Inicializa vizinhos das peças
		for(int c = 0; c < 7; c++) {
			for(int l = 0; l < 7; l++) {
				if(posicaoEhValida(c,l)) {
					if(posicaoEhValida(c,l+1))
						tabuleiro[c][l].setVizinho('c', tabuleiro[c][l+1]);
					
					if(posicaoEhValida(c,l-1))
						tabuleiro[c][l].setVizinho('b', tabuleiro[c][l-1]);
					
					if(posicaoEhValida(c-1,l))
						tabuleiro[c][l].setVizinho('e', tabuleiro[c-1][l]);
					
					if(posicaoEhValida(c+1,l))
						tabuleiro[c][l].setVizinho('d', tabuleiro[c+1][l]);
				}
			}
		}
	}
	
	/** Retorna peça no indices indicados */
	public Peca getPeca(int coluna, int linha) {
		return tabuleiro[coluna][linha];
	}
	
	/** Gera string com estado atual do tabuleiro */
	public String toString() {
		String t = "";
		
		for(int l = 6; l>= 0; l--) {
			for(int c = 0; c < 7; c++) {
				if(posicaoEhValida(c,l))
					t += tabuleiro[c][l].toString();
				else
					t += " ";
			}
			t += '\n';
		}
		
		return t;
	}
	
	/**
	 * Verifica se posição c,l do tabuleiro faz parte do tabuleiro
	 * @param c Colunas do tabuleiro (0=a,1=b,2=c,...,6=g)
	 * @param l Linhas do tabuleiro (0=1,1=2,2=3,...,6=7)
	 * @return
	 * True -> Se faz parte
	 * False -> Não faz parte
	 */	
	private Boolean posicaoEhValida(int c, int l) {
		Boolean estaDentroMatriz = c >= 0 && c < 7 && l >= 0 && l < 7;
		Boolean naoEstaNosCantos = (c >= 2 && c <= 4) || (l >= 2 && l <= 4);
		return  estaDentroMatriz && naoEstaNosCantos ;
	}
}
