package angelo.project;

import java.util.Scanner;

public class CaixaEletronico {
	private ContaBancaria conta;
	
	public CaixaEletronico(ContaBancaria conta) {
		this.conta = conta;
	}
	public void exibirMenu() {
		Scanner scanner = new Scanner(System.in);
		int opcao;
		
		do {
			System.out.println("==============");
			System.out.println("CAIXA ELETRONICO DO ANGELO");
			System.out.println("==============");
			System.out.println("Escolha uma das opções abaixo:");
			System.out.println("1. Consultar saldo");
			System.out.println("2. fazer depósito");
			System.out.println("3. Fazer saque");
			System.out.println("0. Sair");
			System.out.println("==============");
			opcao = scanner.nextInt();
			 
			switch (opcao) {
			case 1:
				consultarSaldo();
				break;
			case 2:
				fazerDeposito();
				break;
			case 3:
				fazerSaque();
				break;
			case 0:
				System.out.println("Saindooooo...");
				break;
			default:

				System.out.println("Opção Invalida!");
				break;
			}
		}while (opcao != 0);
		scanner.close();
	}
	private void consultarSaldo() {
		System.out.println("Seu saldo é de: R$" + conta.getSaldo());
	}
	private void fazerDeposito() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o valor a ser depositado: R$");
		double valor = scanner.nextDouble();
		conta.depositar(valor);
		System.out.println("Depósito Realizado com sucesso!");
	}
	private void fazerSaque() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o valor a ser sacado: R$");
		double valor = scanner.nextDouble();
		conta.sacar(valor);
	}
}











