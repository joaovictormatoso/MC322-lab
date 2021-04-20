package mc322.lab04;

/**
 * @author João Victor Matoso
 */
public class RestaUm {
	// Tabuleiro para o jogo
	private Tabuleiro tabuleiro;
		
	RestaUm() {
		tabuleiro = new Tabuleiro();
	}
	
	/** Efetua jogada a partir da posição origem para posição destino
	 * @param origem String com posição inicial da peça
	 * @param destino String com posição final após jogada
	 */
	public void efetuarJogada(String origem, String destino) {
		// Verifica se strings estão na formatação adequada
		if(!isValidPositionString(origem) || !isValidPositionString(destino))
			return;
		
		// Extrai indices da matriz
		int cOrigem = getColumnIndex(origem);
		int lOrigem = getLineIndex(origem);
		int cDestino = getColumnIndex(destino);
		int lDestino = getLineIndex(destino);
		
		// Identifica direção da jogada e a executa
		if(cOrigem == cDestino) {
			if(lOrigem < lDestino)
				tabuleiro.getPeca(cOrigem, lOrigem).mover('c');
			else if (lOrigem > lDestino)
				tabuleiro.getPeca(cOrigem, lOrigem).mover('b');
		}
		else if(lOrigem == lDestino) {
			if(cOrigem < cDestino)
				tabuleiro.getPeca(cOrigem, lOrigem).mover('d');
			else if (cOrigem > cDestino)
				tabuleiro.getPeca(cOrigem, lOrigem).mover('e');
		}
	}
	
	/** Retorna string com estado atual do tabuleiro */
	public String getTabuleiro() {
		return tabuleiro.toString();
	}
	
	/** Extrai indice da coluna dado uma string de posição
	 * @param cmd String com posição
	 */
	private int getColumnIndex(String pos) {
		switch(pos.charAt(0)) {
		case 'a':
			return 0;
		case 'b':
			return 1;
		case 'c':
			return 2;
		case 'd':
			return 3;
		case 'e':
			return 4;
		case 'f':
			return 5;
		case 'g':
			return 6;
		}
		return -1;
	}
	
	/** Extrai indice da linha dado uma string de posição
	 * @param  String com posição
	 */
	private int getLineIndex(String pos) {
		return -1+(int)Character.getNumericValue(pos.charAt(1));
	}
	
	/** Função para verificar se string contem dois char, uma letra entre a-g e um numero entre 1-7*/
	private Boolean isValidPositionString(String cmd) {
		return cmd.matches("^[a-g][1-7]$");
	}
	
	/** Imprime tabuleiro na saída padrão com coordenadas */
	public void imprimirTabuleiro() {
		String[] tab = getTabuleiro().split("\n");
		System.out.println("7 " + tab[0]);
		System.out.println("6 " + tab[1]);
		System.out.println("5 " + tab[2]);
		System.out.println("4 " + tab[3]);
		System.out.println("3 " + tab[4]);
		System.out.println("2 " + tab[5]);
		System.out.println("1 " + tab[6]);
		System.out.println("  abcdefg\n");
	}
}
