package mc322.lab03;

/**
 * Classe para chamada da função main
 * @author João Victor E. Matoso
 * @see AquarioLombriga
 * @see Animacao
 */
public class AppLab03 {
	
	public static void main(String[] args) {
		
		Animacao animacao = new Animacao("080403MCMVM");
		System.out.println(animacao.apresenta());
		
		while(animacao.passo())
			System.out.println(animacao.apresenta());
	}
}