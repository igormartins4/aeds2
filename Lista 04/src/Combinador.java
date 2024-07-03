public class Combinador {

	public static void main(String[] args) {
		String linha = null, palavra1 = null, palavra2 = null, palavraCombinada = null;

		int tamPalavra1 = 0, tamPalavra2 = 0, cont = 0, contVet1 = 0, contVet2 = 0;

		linha = MyIO.readLine();

		char[] vet1 = new char[linha.length()];
		char[] vet2 = new char[linha.length()];
		char[] vetFinal = new char[linha.length()];

		while (linha.compareTo("FIM") != 0) {

			while (linha.charAt(cont) != ' ') {
				cont++;
				palavra1 = linha.substring(0, cont);
			}

			palavra2 = linha.substring(cont, linha.length());
			cont = 0;

			tamPalavra1 = palavra1.length();
			tamPalavra2 = palavra2.length();

			for (int i = 0; i < tamPalavra1; i++) {
				vet1[i] = palavra1.charAt(i);
			}

			for (int i = 0; i < tamPalavra2; i++) {
				vet2[i] = palavra2.charAt(i);
			}

			for (int i = 0; i < linha.length(); i++) {
				if (i % 2 == 0) {
					vetFinal[i] = vet1[contVet1];
					contVet1++;
				} else {
					vetFinal[i] = vet2[contVet2];
					contVet2++;
				}
			}

			palavraCombinada = String.valueOf(vetFinal);

			MyIO.println(palavraCombinada);

			linha = MyIO.readLine();
		}
	}
}
