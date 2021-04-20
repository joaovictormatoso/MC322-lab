package mc322.lab04;

/**
 * @author João Victor Matoso
 */
public class AppRestaUm {

	public static void main(String[] args) {
		executaJogo("moves.csv");
	}

	/** Executa jogo a partir de jogadas gravadas em um arquivo .CSV
	 * @param file Caminho do arquivo com jogadas
	 * @return String[] Vetor com o estado do tabuleiro após cada jogada
	 */
	public static String[] executaJogo(String file) {
		// Le e extrai jogadas do arquivo CSV
		CSVReader csv = new CSVReader();
		csv.setDataSource(file);
		String commands[] = csv.requestCommands();
		
		// Comeca um novo jogo
		RestaUm jogo = new RestaUm();
		
		// String para armazenar resultados intermediarios
		String[] saida = new String[commands.length+1];
		
		// Estado inicial do tabuleiro
		saida[0] = jogo.getTabuleiro();
		
		System.out.println("Tabuleiro inicial:");
		jogo.imprimirTabuleiro();
		
		// Roda lista de comandos
		for(int i = 1; i < commands.length+1;i++) {
			String origem = commands[i-1].toLowerCase().split(":")[0];
			String destino = commands[i-1].toLowerCase().split(":")[1];
			
			jogo.efetuarJogada(origem, destino);
			saida[i] = jogo.getTabuleiro();
			
			System.out.println("Source: " + origem);
			System.out.println("Target: " + destino);
			jogo.imprimirTabuleiro();
		}
		
		return saida;
	}
}
