package mc322.lab03;

/**
 * Classe que define uma lombriga em um aquário
 * @author João Victor E. Matoso
 */
public class AquarioLombriga {
	/** Tamanho atual da lombriga */
	int tamLombriga;
	
	/** Tamanho do aquário */
	int tamAquario;
	
	/** Posição atual da lombriga no aquário */
	int posLombriga;
	
	/** Direção da lombriga no aquário: 'd' -> direita, 'e' -> esquerda */
	char direcaoCabeca;
	
	/**
	 * Inicializa novo objeto AquarioLombriga
	 * @param tamanhoAquario Tamanho do aquário
	 * @param tamanhoLombriga Tamanho da lombriga
	 * @param posicaoLombriga Posição da lombriga dentro do aquário (primeira posição: 1)
	 */
	AquarioLombriga(int tamanhoAquario, int tamanhoLombriga, int posicaoLombriga) {
		/* Verifica se a lombriga cabe no aquário */
		if (tamanhoLombriga > tamanhoAquario)
			tamanhoAquario = tamanhoLombriga;
		
		/* Verifica se a lombriga cabe na posição */
		if(posicaoLombriga + tamanhoLombriga -1 > tamanhoAquario)
			posicaoLombriga = 1;
		
		/* Inicialização dos atributos do objeto */
		this.tamAquario = tamanhoAquario;
		this.tamLombriga = tamanhoLombriga;
		this.posLombriga = posicaoLombriga;
		this.direcaoCabeca = 'd';	// Lombriga sempre começa virada para direita
	}
	
	/**
	 * Inverte a posição da lombriga dentro do aquário
	 */
	void virar() {
		if(this.direcaoCabeca == 'd')
			this.direcaoCabeca = 'e';
		else
			this.direcaoCabeca = 'd';
	}
	
	/**
	 * Move a lombriga uma casa na direção da cabeça. Se não houver espaço, a lombriga vira
	 */
	void mover() {
		/* Caso da cabeça virada para esquerda */
		if(this.direcaoCabeca == 'e') {
			if(this.posLombriga > 1)
				this.posLombriga--;
			else
				this.virar();
		}
		
		/* Caso da cabeça virada para direita */
		else {
			if(this.posLombriga + this.tamLombriga - 1 < this.tamAquario)
				this.posLombriga++;
			else
				this.virar();
		}
	}
	
	/**
	 * Cresce a lombriga uma casa na direção da cauda. Se não houver espaço, não cresce
	 */
	void crescer() {
		/* Caso da cabeça virada para direita */
		if(this.direcaoCabeca == 'd') {
			if(this.posLombriga > 1) {
				this.tamLombriga++;
				this.posLombriga--;
			}
		}
		
		/* Caso da cabeça virada para esquerda */
		else {
			if(this.posLombriga + this.tamLombriga - 1 < this.tamAquario)
				this.tamLombriga++;
		}
	}
	
	/**
	 * Cria representação em string do estado atual da lombriga no aquário
	 * @return string com a representação atual da animação
	 */
	String apresenta() {
		char[] s = new char[this.tamAquario];
		
		// Gera parte esquerda do aquário, se houver
		for(int i = 0; i < this.posLombriga-1; i++)
			s[i] = '#';
		
		// Gera lombriga
		for(int i = this.posLombriga-1; i < this.posLombriga + this.tamLombriga -1; i++)
			s[i] = '@';
		
		// Gera parte direita do aquário, se houver
		for(int i = this.posLombriga + this.tamLombriga -1; i < this.tamAquario; i++)
			s[i] = '#';
		
		// Coloca a cabeça da lombriga na posição correta
		if(this.direcaoCabeca == 'e')
			s[this.posLombriga-1] = '0';
		else
			s[this.posLombriga+this.tamLombriga-2] = '0';
		
		return new String(s);
	}
}
