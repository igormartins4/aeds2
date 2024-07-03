/*
5. Faça uma função recursiva que calcula o valor de S da série a seguir para n > 0:
		S = 1/1! + 1/2! + 1/3! + ...+1 /N!
		double serie (int n)
	Faça um programa que leia um número, acione a função e exiba o resultado gerado.
 */

public class Main {
	public static void main(String[] args) {
		// variável que guarda o valor que a função retornar
		double resultado = 0.0;

		// número que será enviado para a função
		int numero = MyIO.readInt();

		// função sendo chamada com o número sendo passado por parametro e guardando o
		// retorno numa variável
		resultado = serie(numero);

		// exibindo o resultado na tela
		MyIO.println("Resultado final:  " + resultado);
	}

	// função que calcula o fatorial
	public static double serie(double numero) {
		double soma = 0.0;
		// se o número de entrada for igual a 0, retorna 1 (pois chegamos ao final) e sai da função
		if (numero == 0) {
			return 1;
			// caso contrário, calcula o fatorial
		} else {
			// calcula o fatorial de 1! até N!, enquanto soma e é dividido por 1
			soma += 1 / (numero * serie(numero - 1));
		}
		
		// retorna o valor calculado acima
		return soma;
	}
}