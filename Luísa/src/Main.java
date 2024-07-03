/*
5. Fa�a uma fun��o recursiva que calcula o valor de S da s�rie a seguir para n > 0:
		S = 1/1! + 1/2! + 1/3! + ...+1 /N!
		double serie (int n)
	Fa�a um programa que leia um n�mero, acione a fun��o e exiba o resultado gerado.
 */

public class Main {
	public static void main(String[] args) {
		// vari�vel que guarda o valor que a fun��o retornar
		double resultado = 0.0;

		// n�mero que ser� enviado para a fun��o
		int numero = MyIO.readInt();

		// fun��o sendo chamada com o n�mero sendo passado por parametro e guardando o
		// retorno numa vari�vel
		resultado = serie(numero);

		// exibindo o resultado na tela
		MyIO.println("Resultado final:  " + resultado);
	}

	// fun��o que calcula o fatorial
	public static double serie(double numero) {
		double soma = 0.0;
		// se o n�mero de entrada for igual a 0, retorna 1 (pois chegamos ao final) e sai da fun��o
		if (numero == 0) {
			return 1;
			// caso contr�rio, calcula o fatorial
		} else {
			// calcula o fatorial de 1! at� N!, enquanto soma e � dividido por 1
			soma += 1 / (numero * serie(numero - 1));
		}
		
		// retorna o valor calculado acima
		return soma;
	}
}