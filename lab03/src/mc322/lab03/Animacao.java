package mc322.lab03;

/**
 * Classe para animação de lombrigas em aquários
 * @author João Victor E. Matoso
 * @see AquarioLombriga
 */
public class Animacao {
	/** Armazena o estado e executar as tarefas da animação */
	AquarioLombriga aquarioLombriga;

	/** lista de movimentos a serem executados */
	String movimentos;
	
	/** Contador do passo atual da animação */
	int passoAtual;
	
	/**
	 * Inicializa um novo objeto Animação a partir das informações passadas pela String s.
	 * @param s
	 * String com as informoções da animação
	 */
	Animacao(String s){
		/* Extrai dados de tamanho e posição dos 6 primeiros caracteres da string s */
		int tamanhoAquario = Integer.parseInt(s.substring(0,2));
		int tamanhoLombriga = Integer.parseInt(s.substring(2,4));
		int posicaoLombriga = Integer.parseInt(s.substring(4,6));;
		
		/* Cria um objeto AquarioLombriga a partir dos dados extraidos */
		this.aquarioLombriga = new AquarioLombriga(tamanhoAquario, tamanhoLombriga, posicaoLombriga);
		
		/* Extrai lista de movimentos da string e inicializa passoAtual */
		this.movimentos = s.substring(6);
		this.passoAtual=0;
	}
	
	/**
	 * Cria representação em string do estado atual da lombriga no aquário
	 * @return string com a representação atual da animação
	 */
	String apresenta() {
		return this.aquarioLombriga.apresenta();
	}
	
	/**
	 * Realiza o próximo passo da simulação
	 * @return
	 * true se executou a animação, false se não ha mais movimentos
	 */
	Boolean passo() {
		/* Verifica se animação chegou ao fim */
		if(this.passoAtual >= this.movimentos.length())
			return false;
		
		/* Obtem proximo movimento da lista e o executa */
		char m = this.movimentos.charAt(passoAtual);
		passoAtual++;
		
		switch(m) {
			case 'M':
				this.aquarioLombriga.mover();
				break;
			case 'C':
				this.aquarioLombriga.crescer();
				break;
			case 'V':
				this.aquarioLombriga.virar();
				break;
		}
		
		return true;
	}
	
}
