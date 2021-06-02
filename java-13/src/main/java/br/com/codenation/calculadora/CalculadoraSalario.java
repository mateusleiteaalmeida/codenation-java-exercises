package br.com.codenation.calculadora;


public class CalculadoraSalario {

	private double salarioBase;

	public long calcularSalarioLiquido(double salarioBase) {
		//Use o Math.round apenas no final do método para arredondar o valor final.
		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-

		if (salarioBase < 1039) {
			return 0;
		} else {
			this.salarioBase = salarioBase;
			double salarioDescInss = calcularInss(this.salarioBase);
			double salarioDescIrrf = calcularIrrf(salarioDescInss);
			return Math.round(salarioDescIrrf);
		}
	}
	
	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
	private double calcularInss(double salario) {
		double inss = 0;
		if (salario <= 1500) {
			inss = salario * 0.08;
		} else if (salario > 1500 && salario <= 4000) {
			inss = salario * 0.09;
		} else {
			inss = salario * 0.11;
		}
		return salario - inss;
	}

	private double calcularIrrf(double salario) {
		double irrf = 0;
		if (salario > 3000 && salario <= 6000) {
			irrf = salario * 0.075;
		} else if (salario > 6000) {
			irrf = salario * 0.15;
		}
		return salario - irrf;
	}

}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/