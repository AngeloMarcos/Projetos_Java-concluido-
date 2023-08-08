package angelo.project;

public class ContaBancaria {
	private String numeroConta;
	private double saldo;
	
	//criando construtor do objeto
	public ContaBancaria (String numeroConta) {
		this.numeroConta = numeroConta;
		this.saldo = 0.0;
	}
	public String getNumeroConta() {
		return  numeroConta;
		
	}
	public double getSaldo() {
		return saldo;
	}
	
	public void depositar(double valor) {
		saldo += valor;
	}
	public void sacar (double valor) {
		if (valor <= saldo) {
			saldo -= valor;
		}else {
			System.out.println("Saldo insuficiente!");
		}
		
	}
}
