/********************************************************
 * * Autor: Igor Martins * Data: 16/03/2022 * https://github.com/igormartins4 *
 * Algoritmos e Estruturas de Dados 2 * *
 ********************************************************/

public class Main {
	public static void main(String[] args) {
		//ex01();
		ex02();
	}

	/*
	 * 1) Fa�a um programa, em Java, para corrigir provas de m�ltipla escolha. Cada
	 * prova tem oito quest�es e cada quest�o vale um ponto. O primeiro conjunto de
	 * dados a ser lido � o gabarito da prova. Os outros dados s�o os n�meros dos
	 * alunos e suas respectivas respostas �s quest�es da prova. Existem dez alunos
	 * matriculados. Calcule e mostre:
	 * 
	 * a) o n�mero e a nota de cada aluno; 
	 * b) a porcentagem de aprova��o, sabendo-se que a nota m�nima 
	 * necess�ria para aprova��o � cinco.
	 */

	public static void ex01() {
		String[] gabarito = new String[8];
		int[] numero = new int[10];
		int[] nota = new int[10];
		String resposta;
		double aprovacao = 0;

		MyIO.println("---- Gabarito da prova ----");

		for (int i = 0; i < 8; i++) {
			gabarito[i] = MyIO.readString("Resposta da " + (i + 1) + "� quest�o: ");
		}

		MyIO.println("");
		MyIO.println("---- Alunos ----");
		for (int i = 0; i < 10; i++) {

			MyIO.println("");
			MyIO.println("---- Gabarito " + (i + 1) + "� aluno ----");
			numero[i] = MyIO.readInt("Digite o n�mero do " + (i + 1) + "� aluno: ");

			for (int j = 0; j < 8; j++) {
				resposta = MyIO.readString("Resposta da " + (j + 1) + "� quest�o do " + (i + 1) + "� aluno: ");
				if (resposta.equals(gabarito[j])) {
					nota[i] += 1;
				}
			}
		}

		for (int i = 0; i < 10; i++) {
			MyIO.println("");
			MyIO.println("Aluno " + (i + 1) + ":");
			MyIO.println("N�mero: " + numero[i] + ", Nota: " + nota[i]);

			if (nota[i] >= 5) {
				aprovacao++;
			}
		}

		aprovacao = (aprovacao * 100) / 10;
		MyIO.println("");
		MyIO.println("Porcentagem de aprova��o: " + aprovacao + "%");

		MyIO.println("");
	}

	/*
	 * 2) Fa�a um programa, em Java, que preencha uma matriz de ordem 3 x 4 (3
	 * linhas e 4 colunas) com n�meros inteiros e positivos; calcule e mostre:
	 * 
	 * a) o maior elemento da matriz e sua posi��o (linha e coluna); 
	 * b) o menor elemento da matriz e sua posi��o (linha e coluna).
	 */

	public static void ex02() {
		int[][] matriz = new int[3][4];
		
		int maior = 0;
		int posMaiorI = 0;
		int posMaiorJ = 0;
		
		int menor = 0;
		int posMenorI = 0;
		int posMenorJ = 0;

		for (int i = 0; i < 3; i++) {
			MyIO.println("");
			for (int j = 0; j < 4; j++) {
				matriz[i][j] = MyIO.readInt("Digite um n�mero para preencher a matriz: ");
				maior = matriz[i][j];
				menor = matriz[i][j];
			}
		}
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				if (menor > matriz[i][j]) {
					menor = matriz[i][j];
					posMenorI = i;
					posMenorJ = j;
				}

				if (maior < matriz[i][j]) {
					maior = matriz[i][j];
					posMaiorI = i;
					posMaiorJ = j;
				}
			}
		}
		
		MyIO.println("");

		MyIO.println("Maior elemento: " + maior + ", posi��o " + posMaiorI + "x" + posMaiorJ);
		MyIO.println("Menor elemento: " + menor + ", posi��o " + posMenorI + "x" + posMenorJ);
	}
}
