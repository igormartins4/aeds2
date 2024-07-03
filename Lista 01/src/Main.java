/********************************************************
*                                                       *
*   Autor: Igor Martins                                 *
*   Data: 26/02/2022                                    *
*   https://github.com/igormartins4                     *
*   Algoritmos e Estruturas de Dados 2                  *
*                                                       *
********************************************************/

public class Main {
	public static void main(String[] args) {
		ex01( );
		ex02();
		ex03();
	}

	/*
	 * 1) Uma empresa pretende ajustar os salários de seus funcionários conforme a
	 * tabela a seguir:
	 * 
	 * Salário Percentual de Aumento 
	 * Até R$ 1200,00 		->	10% 
	 * Acima de R$ 1200,00	->	5%
	 * 
	 * Faça um programa, em Java, que receba o salário atual do funcionário; calcule
	 * e mostre o aumento que esse funcionário receberá e seu novo salário.
	 */

	public static void ex01() {
		double salario = MyIO.readDouble("Digite o salário atual: ");
		double novoSalario = 0.0;
		double aumento = 0.0;

		if (salario <= 1200) {
			novoSalario = salario + (salario * 0.1);
			aumento = novoSalario - salario;
		} else {
			novoSalario = salario + (salario * 0.05);
			aumento = novoSalario - salario;
		}

		MyIO.println("Aumento do novo salário: R$ " + aumento);
		MyIO.println("Novo salário: R$ " + novoSalario);
		
		MyIO.println("");
	}

	/*
	 * 2) Faça um programa, em Java, que receba como entrada três notas de um aluno
	 * (digite valores entre 0 e 10), calcule e mostre a média aritmética e a
	 * mensagem constante na tabela a seguir:
	 * 
	 * Média Aritmética Mensagem 
	 * De 0,0 a abaixo de 4,0 	->	Reprovado
	 * De 4,0 a abaixo de 6,0	->	Exame Especial
	 * De 6,0 a 10,0			->	Aprovado
	 */

	public static void ex02() {
		float notaUm = MyIO.readFloat("Digite a primeira nota do aluno: ");
		float notaDois = MyIO.readFloat("Digite a segunda nota do aluno: ");
		float notaTres = MyIO.readFloat("Digite a terceira nota do aluno: ");

		double media = (notaUm + notaDois + notaTres) / 3;

		MyIO.println("Média aritmética do aluno: " + media);

		if (media < 4.0) {
			MyIO.println("Reprovado");
		} else if (media >= 4.0 && media < 6.0) {
			MyIO.println("Exame Especial");
		} else if (media > 6.0) {
			MyIO.println("Aprovado");
		}
		
		MyIO.println("");
	}

	/*
	 * 3) Faça um programa, em Java, que simule um radar na Av. Cristiano Machado.
	 * Esse radar deve receber a velocidade de cinco veículos, calcular e exibir a
	 * quantidade de veículos com velocidade acima de 60 km/h. O radar também deve
	 * informar o total arrecadado com multas, considerando que o valor de cada
	 * multa é de R$150,00 e que veículos com velocidade superior a 60 km/h serão
	 * multados.
	 */

	public static void ex03() {
		int velocUm = MyIO.readInt("Digite a velocidade do 1º veículo: ");
		int velocDois = MyIO.readInt("Digite a velocidade do 2º veículo: ");
		int velocTres = MyIO.readInt("Digite a velocidade do 3º veículo: ");
		int velocQuatro = MyIO.readInt("Digite a velocidade do 4º veículo: ");
		int velocCinco = MyIO.readInt("Digite a velocidade do 5º veículo: ");

		double totalMultas = 0.0;

		if (velocUm > 60) {
			MyIO.println("Veículo 1 multado por exceder 60km/h: " + velocUm + "km/h");
			totalMultas += 150;
		}
		if (velocDois > 60) {
			MyIO.println("Veículo 2 multado por exceder 60km/h: " + velocDois + "km/h");
			totalMultas += 150;
		}
		if (velocTres > 60) {
			MyIO.println("Veículo 3 multado por exceder 60km/h: " + velocTres + "km/h");
			totalMultas += 150;
		}
		if (velocQuatro > 60) {
			MyIO.println("Veículo 4 multado por exceder 60km/h: " + velocQuatro + "km/h");
			totalMultas += 150;
		}
		if (velocCinco > 60) {
			MyIO.println("Veículo 5 multado por exceder 60km/h: " + velocCinco + "km/h");
			totalMultas += 150;
		}
		
		MyIO.println("Total de veículos multados: " + totalMultas/150);
		MyIO.println("Total arrecadado com as multas: R$ " + totalMultas);
	}
}
