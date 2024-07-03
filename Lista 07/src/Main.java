class Flutuante {
	private float valor;

	public Flutuante() {
		valor = 0;
	}

	public Flutuante(float i) {
		valor = i;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public void imprimir() {
		System.out.println("Valor: " + this.valor);
	}
}

class Celula {
	private Flutuante item;
	private Celula proximo;

	public Celula(Flutuante novo) {
		item = novo;
		proximo = null;
	}

	public Celula() {

		item = new Flutuante();
		proximo = null;
	}

	public Flutuante getItem() {
		return item;
	}

	public void setItem(Flutuante item) {
		this.item = item;
	}

	public Celula getProximo() {
		return proximo;
	}

	public void setProximo(Celula proximo) {
		this.proximo = proximo;
	}
}

class Pilha {
	private Celula fundo;
	private Celula topo;

	public Pilha() {

		Celula sentinela;

		sentinela = new Celula();
		fundo = sentinela;
		topo = sentinela;
	}

	public boolean pilhaVazia() {
		boolean resp;

		if (topo == fundo)
			resp = true;
		else
			resp = false;

		return resp;
	}

	public void empilhar(Flutuante novo) {
		Celula novaCelula;

		novaCelula = new Celula(novo);
		novaCelula.setProximo(topo);
		topo = novaCelula;
	}

	public Flutuante desempilhar() throws Exception {
		Celula desempilhado;

		if (!pilhaVazia()) {
			desempilhado = topo;
			topo = topo.getProximo();
			desempilhado.setProximo(null);
			return (desempilhado.getItem());
		} else
			throw new Exception("Nao foi possivel desempilhar: a pilha esta vazia!");
	}
}

class Main {
	public static void main(String[] args) {
		Pilha minhaPilha;
		Flutuante novo;

		String saida = new String(), entrada = new String();

		minhaPilha = new Pilha();

		while (!entrada.equals("FIM")) {
			entrada = MyIO.readLine();

			for (int i = 0; i < entrada.length(); i++) {
				char caractere = entrada.charAt(i);
				switch (caractere) {
				case '+':
					novo = new Flutuante(caractere);
					try {
						minhaPilha.empilhar(novo);
					} catch (Exception erro) {
						System.out.println(erro.getMessage());
					}
					break;
				case '-':
					novo = new Flutuante(caractere);
					try {
						minhaPilha.empilhar(novo);
					} catch (Exception erro) {
						System.out.println(erro.getMessage());
					}
					break;

				case '/':
					novo = new Flutuante(caractere);
					try {
						minhaPilha.empilhar(novo);
					} catch (Exception erro) {
						System.out.println(erro.getMessage());
					}
					break;
				case '*':
					novo = new Flutuante(caractere);
					try {
						minhaPilha.empilhar(novo);
					} catch (Exception erro) {
						System.out.println(erro.getMessage());
					}
					break;

				case ')':
					novo = new Flutuante(caractere);
					try {
						minhaPilha.empilhar(novo);
					} catch (Exception erro) {
						System.out.println(erro.getMessage());
					}
					break;

				default:
					if (caractere != '(') {
						saida = saida + caractere;
						break;
					}
				}
			}
			while (!minhaPilha.pilhaVazia()) {
				try {
					saida = saida + minhaPilha.desempilhar().getValor();
				} catch (Exception erro) {
					System.out.println(erro.getMessage());
				}
			}
			System.out.println(saida);
			saida = "";
		}
	}
}
