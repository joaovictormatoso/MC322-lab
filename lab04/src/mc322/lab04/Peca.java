package mc322.lab04;

/**
 * @author João Victor Matoso
 */
public class Peca {
	/** Guarda estado da peça, se foi capturada ou não. */
	private Boolean visivel;
	
	/** Vetor para guardar os quatro vizinhos da peça */
	private Peca[] vizinhos;
	
	Peca() {
		this.visivel = true;
		vizinhos = new Peca[4];
	}

	/** Define visibilidade da peça */
	public void setVisibilidade(boolean v) {
		visivel = v;
	}

	/** Define vizinho em uma direção
	 * @param direcao 'c' -> cima, 'b' -> baixo, 'e' -> esquerda, 'd' -> direita
	 * @param vizinho Ponteiro para peça vizinha
	 */
	public void setVizinho(char direcao, Peca vizinho) {
		vizinhos[direcaoToIndex(direcao)] = vizinho;
	}

	/** Verifica se peça está visível */
	public Boolean isVisivel() {
		return visivel;
	}
	
	public String toString() {
		if(visivel)
			return "P";
		else
			return "-";
	}

	/** Mover peça capturando vizinho
	 * @param direcao 'c' -> cima, 'b' -> baixo, 'e' -> esquerda, 'd' -> direita
	 * @return true se foi possível mover, false senão
	 */
	public Boolean mover(char direcao) {
		// Verifica se a peça está presente no tabuleiro
		if(this.isVisivel()) {
			
			// Verifica se vizinho na direção desejada está presente
			if(vizinhos[direcaoToIndex(direcao)].isVisivel() == true) {
				
				// Verifica se existe uma casa disponível atrás do vizinho
				if(vizinhos[direcaoToIndex(direcao)].vizinhos[direcaoToIndex(direcao)].isVisivel() == false) {
					this.setVisibilidade(false);
					vizinhos[direcaoToIndex(direcao)].setVisibilidade(false);
					vizinhos[direcaoToIndex(direcao)].vizinhos[direcaoToIndex(direcao)].setVisibilidade(true);
					return true;
				}
			}
		}
		return false;
	}
	
	/** Mapeamento da direção para index do vetor vizinhos
	 * @param direcao 'c' -> cima, 'b' -> baixo, 'e' -> esquerda, 'd' -> direita
	 */
	private int direcaoToIndex(char direcao) {
		switch(direcao) {
		case 'c':
			return 0;
		case 'b':
			return 1;
		case 'e':
			return 2;
		case 'd':
			return 3;
		}
		return -1;
	}
}
