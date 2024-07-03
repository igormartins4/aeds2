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
	 * 1) Faça um programa, em Java, para corrigir provas de múltipla escolha. Cada
	 * prova tem oito questões e cada questão vale um ponto. O primeiro conjunto de
	 * dados a ser lido é o gabarito da prova. Os outros dados são os números dos
	 * alunos e suas respectivas respostas às questões da prova. Existem dez alunos
	 * matriculados. Calcule e mostre:
	 * 
	 * a) o número e a nota de cada aluno; 
	 * b) a porcentagem de aprovação, sabendo-se que a nota mínima 
	 * necessária para aprovação é cinco.
	 */

	public static void ex01() {
		String[] gabarito = new String[8];
		int[] numero = new int[10];
		int[] nota = new int[10];
		String resposta;
		double aprovacao = 0;

		MyIO.println("---- Gabarito da prova ----");

		for (int i = 0; i < 8; i++) {
			gabarito[i] = MyIO.readString("Resposta da " + (i + 1) + "º questão: ");
		}

		MyIO.println("");
		MyIO.println("---- Alunos ----");
		for (int i = 0; i < 10; i++) {

			MyIO.println("");
			MyIO.println("---- Gabarito " + (i + 1) + "º aluno ----");
			numero[i] = MyIO.readInt("Digite o número do " + (i + 1) + "º aluno: ");

			for (int j = 0; j < 8; j++) {
				resposta = MyIO.readString("Resposta da " + (j + 1) + "º questão do " + (i + 1) + "º aluno: ");
				if (resposta.equals(gabarito[j])) {
					nota[i] += 1;
				}
			}
		}

		for (int i = 0; i < 10; i++) {
			MyIO.println("");
			MyIO.println("Aluno " + (i + 1) + ":");
			MyIO.println("Número: " + numero[i] + ", Nota: " + nota[i]);

			if (nota[i] >= 5) {
				aprovacao++;
			}
		}

		aprovacao = (aprovacao * 100) / 10;
		MyIO.println("");
		MyIO.println("Porcentagem de aprovação: " + aprovacao + "%");

		MyIO.println("");
	}

	/*
	 * 2) Faça um programa, em Java, que preencha uma matriz de ordem 3 x 4 (3
	 * linhas e 4 colunas) com números inteiros e positivos; calcule e mostre:
	 * 
	 * a) o maior elemento da matriz e sua posição (linha e coluna); 
	 * b) o menor elemento da matriz e sua posição (linha e coluna).
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
				matriz[i][j] = MyIO.readInt("Digite um número para preencher a matriz: ");
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

		MyIO.println("Maior elemento: " + maior + ", posição " + posMaiorI + "x" + posMaiorJ);
		MyIO.println("Menor elemento: " + menor + ", posição " + posMenorI + "x" + posMenorJ);
	}
}
