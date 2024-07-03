class Caractere {

	private int valor;

	public Caractere() {
		valor = 0;
	}

	public Caractere(char i) {
		valor = i;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(char valor) {
		this.valor = valor;
	}
}

class Celula {

	private Caractere item;
	private Celula proximo;

	public Celula(Caractere novo) {
		item = novo;
		proximo = null;
	}

	public Celula() {

		item = new Caractere();
		proximo = null;
	}

	public Caractere getItem() {
		return item;
	}

	public void setItem(Caractere item) {
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

	public void empilhar(Caractere novo) {

		Celula novaCelula;

		novaCelula = new Celula(novo);
		novaCelula.setProximo(topo);
		topo = novaCelula;
	}

	public Caractere desempilhar() throws Exception {

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
		Caractere novo;
		Caractere desempilhado;

		minhaPilha = new Pilha();

		String entrada = "ok";
		boolean correto = true;
		char retirado = 0;

		while (!entrada.equals("FIM")) {
			entrada = MyIO.readLine();

			for (int i = 0; i < entrada.length(); i++) {
				char caractere = entrada.charAt(i);

				if (caractere == '[' || caractere == '(') {
					novo = new Caractere(caractere);
					try {
						minhaPilha.empilhar(novo);
					} catch (Exception erro) {
						i = entrada.length();
						break;
					}
				} else if (caractere == ']' || caractere == ')') {
					try {
						desempilhado = minhaPilha.desempilhar();
						retirado = (char) desempilhado.getValor();
					} catch (Exception erro) {
						i = entrada.length();
						break;
					}

					if (caractere == ')' && retirado != '(') {
						correto = false;
						i = entrada.length();
						break;
					}
					if (caractere == ']' && retirado != '[') {
						correto = false;
						i = entrada.length();
						break;
					}
					if (correto == false)
						MyIO.println("incorreto");
					else
						MyIO.println("correto");
				}
			}
		}
	}
}