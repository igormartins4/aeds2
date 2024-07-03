/********************************************************
 * Autor: Igor Martins								    * 
 * Data: 22/03/2022								    	*
 * https://github.com/igormartins4 						*
 * Algoritmos e Estruturas de Dados 2 					*
 ********************************************************/

public class Main {

	public static int calculaMaiusculo(String texto) {
		
		int totalMaiusculos = 0;
		
		if (texto.isEmpty()) {
	        return 0;
	    }
		
		int c = 0;
		char primeiro = texto.charAt(0);
		
	    if (primeiro >= 'A' && primeiro <= 'Z') {
//			System.out.println(c);
	    	c = 1;
		}

	    return c + calculaMaiusculo(texto.substring(1));
	}

	public static void main(String[] args) {
		int total;
		String entrada = MyIO.readLine();

		while (!entrada.equals("FIM")) {
			total = calculaMaiusculo(entrada);
//			entrada = MyIO.readLine();

			System.out.println(total);

			entrada = MyIO.readLine();
		}
	}

}