import java.io.*;

class contador {
	static int numComparacoes = 0;
	static int numMovimentacoes = 0;
};

public class Main {

	private static Serie[] bubblesort(Serie[] serie, int tamanho) {
		for (int i = (tamanho - 1); i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (serie[j].getDuracao().compareTo(serie[j+1].getDuracao()) > 0) {
					Serie temp = serie[j];
					serie[j] = serie[j + 1];
					serie[j + 1] = temp;
				}
			}
		}
		ordenaAlfabeticamente(serie, tamanho);

		return serie;
	}
	
	
	private static void ordenaAlfabeticamente(Serie[] serie, int tam) {
		for (int i = 1; i <= tam; i++) {
			for (int j = i + 1; j <= tam; j++) {
				if (serie[i].getDuracao() == serie[j].getDuracao()) {
					if (serie[i].getNome().compareTo(serie[j].getNome()) > 0) {
						contador.numComparacoes++;
						 bubblesort(serie, tam - 1);
						contador.numMovimentacoes++;
					}
				}
			}
		}
	}

	private static void lerArquivo(int qntLinhas, Serie[] serie) throws Exception {
		ArquivoTextoLeitura leitura;
		leitura = new ArquivoTextoLeitura("/tmp/data.txt");
//		leitura = new ArquivoTextoLeitura("E:/Downloads/data.txt");

		String teste = leitura.ler();
		teste = leitura.ler();

		for (int i = 0; i < qntLinhas; i++) {
			serie[i] = new Serie();
			serie[i].ler(teste);

			teste = leitura.ler();
		}

		leitura.fecharArquivo();
	}

	private static int contadorLinhas() throws Exception {
		ArquivoTextoLeitura contadorLinhas;
		contadorLinhas = new ArquivoTextoLeitura("/tmp/data.txt");
//		contadorLinhas = new ArquivoTextoLeitura("E:/Downloads/data.txt");

		int qntLinhas = 0;
		String linhaArq = contadorLinhas.ler();
		linhaArq = contadorLinhas.ler();

		while (linhaArq != null) {
			qntLinhas++;

			linhaArq = contadorLinhas.ler();
		}

		contadorLinhas.fecharArquivo();
		return qntLinhas;
	}

	public static Serie searchObj(int tamVetor, Serie[] serie, String nomeSerie) {
		Serie serieEncontrada = null;

		for (int i = 0; i < tamVetor; i++) {
			if (nomeSerie.equals(serie[i].getNome())) {
				serieEncontrada = serie[i];
			}
		}

		return serieEncontrada;
	}

	public static void main(String[] args) throws Exception {
		int qntLinhas = contadorLinhas(), tam;
		Serie[] serie = new Serie[qntLinhas];
		Serie[] bubbleSortSerie;
		String entrada;

		lerArquivo(qntLinhas, serie);

		tam = MyIO.readInt();

		bubbleSortSerie = new Serie[tam];

		for (int i = 0; i < tam; i++) {
			entrada = MyIO.readLine();
			bubbleSortSerie[i] = searchObj(qntLinhas, serie, entrada);
		}

		bubbleSortSerie = bubblesort(bubbleSortSerie, tam - 1);

		for (int i = 0; i < tam; i++) {
			bubbleSortSerie[i].imprimir();
		}

		ArquivoTextoEscrita escrita;
		escrita = new ArquivoTextoEscrita("/tmp/783830_bubblesort.txt");
//		escrita = new ArquivoTextoEscrita("E:/Downloads/783830_bubblesort.txt");
		escrita.escrever("783830\t" + System.currentTimeMillis() + "\t" + contador.numComparacoes + "\t"
				+ contador.numMovimentacoes);
		escrita.fecharArquivo();
	}
}

class ArquivoTextoLeitura {
	private BufferedReader entrada;

	ArquivoTextoLeitura(String nomeArquivo) throws Exception {
		try {
			entrada = new BufferedReader(new InputStreamReader(new FileInputStream(nomeArquivo), "UTF-8"));
		} catch (FileNotFoundException excecao) {
			System.out.println("Arquivo nao encontrado");
		}
	}

	public void fecharArquivo() {
		try {
			entrada.close();
		} catch (IOException excecao) {
			System.out.println("Erro no fechamento do arquivo de leitura: " + excecao);
		}
	}

	@SuppressWarnings("finally")
	public String ler() {
		String textoEntrada = null;

		try {
			textoEntrada = entrada.readLine();
		} catch (EOFException excecao) {
			textoEntrada = null;
		} catch (IOException excecao) {
			System.out.println("Erro de leitura: " + excecao);
			textoEntrada = null;
		} finally {
			return textoEntrada;
		}
	}
}

class ArquivoTextoEscrita {
	private BufferedWriter saida;

	ArquivoTextoEscrita(String nomeArquivo) {
		try {
			saida = new BufferedWriter(new FileWriter(nomeArquivo));
		} catch (FileNotFoundException excecao) {
			System.out.println("Arquivo nao encontrado");
		} catch (IOException excecao) {
			System.out.println("Erro na abertura do arquivo de escrita: " + excecao);
		}
	}

	public void fecharArquivo() {
		try {
			saida.close();
		} catch (IOException excecao) {
			System.out.println("Erro no fechamento do arquivo de escrita: " + excecao);
		}
	}

	public void escrever(String textoEntrada) {
		try {
			saida.write(textoEntrada);
			saida.newLine();
		} catch (IOException excecao) {
			System.out.println("Erro de entrada/saida " + excecao);
		}
	}
}

class Serie {
	private String nome;
	private String formato;
	private String duracao;
	private String paisOrigem;
	private String idiomaOrigem;
	private String emissoraTelevisaoOriginal;
	private String DataInicio;
	private int numTemporadas;
	private int numEpisodios;

	public Serie() {
	}

	public Serie(String nome, String formato, String duracao, String paisOrigem, String idiomaOrigem,
			String emissoraTelevisaoOriginal, String dataInicio, int numTemporadas, int numEpisodios) {
		this.nome = nome;
		this.formato = formato;
		this.duracao = duracao;
		this.paisOrigem = paisOrigem;
		this.idiomaOrigem = idiomaOrigem;
		this.emissoraTelevisaoOriginal = emissoraTelevisaoOriginal;
		this.DataInicio = dataInicio;
		this.numTemporadas = numTemporadas;
		this.numEpisodios = numEpisodios;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getPaisOrigem() {
		return paisOrigem;
	}

	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}

	public String getIdiomaOrigem() {
		return idiomaOrigem;
	}

	public void setIdiomaOrigem(String idiomaOrigem) {
		this.idiomaOrigem = idiomaOrigem;
	}

	public String getEmissoraTelevisaoOriginal() {
		return emissoraTelevisaoOriginal;
	}

	public void setEmissoraTelevisaoOriginal(String emissoraTelevisaoOriginal) {
		this.emissoraTelevisaoOriginal = emissoraTelevisaoOriginal;
	}

	public String getDataInicio() {
		return DataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.DataInicio = dataInicio;
	}

	public int getNumTemporadas() {
		return numTemporadas;
	}

	public void setNumTemporadas(int numTemporadas) {
		this.numTemporadas = numTemporadas;
	}

	public int getNumEpisodios() {
		return numEpisodios;
	}

	public void setNumEpisodios(int numEpisodios) {
		this.numEpisodios = numEpisodios;
	}

	public Serie cloneSerie() {
		Serie clone = new Serie();
		clone.nome = this.nome;
		clone.formato = this.formato;
		clone.duracao = this.duracao;
		clone.paisOrigem = this.paisOrigem;
		clone.idiomaOrigem = this.idiomaOrigem;
		clone.emissoraTelevisaoOriginal = this.emissoraTelevisaoOriginal;
		clone.DataInicio = this.DataInicio;
		clone.numTemporadas = this.numTemporadas;
		clone.numEpisodios = this.numEpisodios;

		return clone;
	}

	public void ler(String s) {
		if (s.indexOf(";") > -1) {
			String[] stringArray = s.split(";");

			if (stringArray.length > 0) {
				this.setNome(stringArray[0]);
				this.setFormato(stringArray[1]);
				this.setDuracao(stringArray[2]);
				this.setPaisOrigem(stringArray[3]);
				this.setIdiomaOrigem(stringArray[4]);
				this.setEmissoraTelevisaoOriginal(stringArray[5]);
				this.setDataInicio(stringArray[6]);
				this.setNumTemporadas(Integer.parseInt(stringArray[7]));
				this.setNumEpisodios(Integer.parseInt(stringArray[8]));
			}
		}
	}

	public void imprimir() {
		System.out.println(this.getNome() + " ## " + this.getFormato() + " ## " + this.getDuracao() + " ## "
				+ this.getPaisOrigem() + " ## " + this.getIdiomaOrigem() + " ## " + this.getEmissoraTelevisaoOriginal()
				+ " ## " + this.getDataInicio() + " ## " + this.getNumTemporadas() + " ## " + this.getNumEpisodios());
	}
}