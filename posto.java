import java.util.Scanner;
import java.text.DecimalFormat;

public class posto {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");

        while (true) {

            double valorAdicional;
            double valorTotal;
            double valorTroco;
            double valorPago;
            double valorAlcool;
            double valorGasolina;
            double litros;
            char repetirAtendimento = 'n';
	    String tipoCombustivel;

            System.out.println("Boas-Vindas!!");

            System.out.println("Qual o valor do Álcool?");

            while (true) {
                if (scanner.hasNextDouble()) {
                    valorAlcool = scanner.nextDouble();
                    break;
                } else {
                    System.out.println("Entrada inválida, use apenas números!");
                    scanner.next();
                }
            }

            while (valorAlcool < 1 || valorAlcool > 10) {
                System.out.println("Valor inválido, insira um verdadeiro!");
                valorAlcool = scanner.nextDouble();
            }

            System.out.println("Qual o valor da Gasolina?");

            while (true) {
                if (scanner.hasNextDouble()) {
                    valorGasolina = scanner.nextDouble();
                    break;
                } else {
                    System.out.println("Entrada inválida, use apenas números!");
                    scanner.next();
                }
            }

            while (valorGasolina < 1 || valorGasolina > 10) {
                System.out.println("Valor inválido, insira um verdadeiro!");
                valorGasolina = scanner.nextDouble();
            }

            double razao = valorAlcool / valorGasolina;

            System.out.println("Quantos litros você irá abastecer?");

            while (true) {
                if (scanner.hasNextDouble()) {
                    litros = scanner.nextDouble();
                    break;
                } else {
                    System.out.println("Entrada inválida, use apenas números!");
                    scanner.next();
                }
            }

            while (litros < 1 || litros > 60) {
                System.out.println("Quantidade máxima/mínima da bomba atingida!!");
                System.out.println("Insira outra quantidade entre 1L e 60L");

                while (true) {
                    if (scanner.hasNextDouble()) {
                        litros = scanner.nextDouble();
                        break;
                    } else {
                        System.out.println("Entrada inválida, use apenas números!");
                        scanner.next();
                    }
                }
            }

            if (razao < 0.7) {
                tipoCombustivel = "Álcool";
                valorTotal = litros * valorAlcool;
            } else {
                tipoCombustivel = "Gasolina";
                valorTotal = litros * valorGasolina;
            }

	    System.out.println("Abasteça com " + tipoCombustivel);

            valorTotal = Math.round(valorTotal * 100.0) / 100.0;
            System.out.println("O valor total foi: R$" + df.format(valorTotal) + "!!");

            System.out.println("Qual o valor que foi pago pelo cliente?");

            while (true) {
                if (scanner.hasNextDouble()) {
                    valorPago = scanner.nextDouble();
                    break;
                } else {
                    System.out.println("Entrada inválida, use apenas números!");
                    scanner.next();
                }
            }

            valorPago = Math.round(valorPago * 100.0) / 100.0;

            while (valorPago < valorTotal) {
                System.out.println("O valor pago é menor que o total!!");

                double falta = valorTotal - valorPago;
                falta = Math.round(falta * 100.0) / 100.0;

                System.out.println("Resta pagar: R$" + df.format(falta));
                System.out.println("Qual valor o cliente pagou a mais?");

            while (true) {
                if (scanner.hasNextDouble()) {
                    valorAdicional = scanner.nextDouble();
                    break;
                } else {
                    System.out.println("Entrada inválida, use apenas números!");
                    scanner.next();
                }
            }
                valorPago += valorAdicional;
            }

            valorTroco = valorPago - valorTotal;
            valorTroco = Math.round(valorTroco * 100.00) / 100.00;

            if (valorTroco > 0) {
                System.out.println("O seu troco é: R$" + df.format(valorTroco));
            } else {
                System.out.println("Valor pago com sucesso!!");
            }

            System.out.println("Você deseja atender outro cliente?(s/n)");
            repetirAtendimento = scanner.next().charAt(0);

            if (repetirAtendimento != 's' && repetirAtendimento != 'S') {
                System.out.println("Finalizando atendimento...");
                break;
            }
        }
        scanner.close();
    }
}