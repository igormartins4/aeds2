import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

class contador {
	static int numComparacoes = 0;
	static int numMovimentacoes = 0;
};

public class Main {
	
	// 1.a chamada do método mergesort: esq: 0; dir: array.length - 1
	private static Serie[] mergesort(Serie[] serie, int esq, int dir) {
		if (esq < dir) {
	        	int meio = (esq + dir) / 2;
	         	mergesort(serie, esq, meio);
	         	mergesort(serie, meio + 1, dir);
	         	intercalar(serie, esq, meio, dir);
	      	}
		
		ordenaAlfabeticamente(serie, dir);
		return serie;
	}

	private static void intercalar(Serie[] serie, int esq, int meio, int dir) {

		int n1, n2, i, j, k;

	      	//Definir tamanho dos dois subarrays
	      	n1 = meio - esq + 1;
	      	n2 = dir - meio;

	      	Serie[] a1 = new Serie[n1];
	      	Serie[] a2 = new Serie[n2];

	      	//Inicializar primeiro subarray
	      	for (i = 0; i < n1; i++) {
	        	a1[i] = serie[esq + i];
	      	}

	      	//Inicializar segundo subarray
	      	for (j = 0; j < n2; j++) {
	        	a2[j] = serie[meio + j + 1];
	      	}

		//Intercalação propriamente dita
	      	for (i = j = 0, k = esq; (i < n1 && j < n2); k++) {
	        	if (a1[i].getIdiomaOrigem().compareTo(a2[j].getIdiomaOrigem()) < 0 || a1[i].getIdiomaOrigem().compareTo(a2[j].getIdiomaOrigem()) == 0)
	        		serie[k] = a1[i++];
			else
				serie[k] = a2[j++];
	      	}
		
		if (i == n1)
			for (; k <= dir; k++) {
				serie[k] = a2[j++];
		    	}
		else
		    	for (; k <= dir; k++) {
		    		serie[k] = a1[i++];
		    	}
	}
	
	
	private static void ordenaAlfabeticamente(Serie[] serie, int tam) {
		for (int i = 1; i <= tam; i++) {
			for (int j = i + 1; j <= tam; j++) {
				if (serie[i].getDuracao() == serie[j].getDuracao()) {
					if (serie[i].getNome().compareTo(serie[j].getNome()) > 0) {
						contador.numComparacoes++;
						mergesort(serie, i, j);
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
		Serie[] mergeSortSerie;
		String entrada;

		lerArquivo(qntLinhas, serie);

		tam = MyIO.readInt();

		mergeSortSerie = new Serie[tam];

		for (int i = 0; i < tam; i++) {
			entrada = MyIO.readLine();
			mergeSortSerie[i] = searchObj(qntLinhas, serie, entrada);
		}

		mergeSortSerie = mergesort(mergeSortSerie,  0, tam - 1);

		for (int i = 0; i < tam; i++) {
			mergeSortSerie[i].imprimir();
		}

		ArquivoTextoEscrita escrita;
		escrita = new ArquivoTextoEscrita("/tmp/783830_mergesort.txt");
//		escrita = new ArquivoTextoEscrita("E:/Downloads/783830_mergesort.txt");
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