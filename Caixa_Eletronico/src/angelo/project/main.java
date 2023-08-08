package angelo.project;

public class main {
	public static void main(String[] args) {
		ContaBancaria conta = new ContaBancaria("12345");
		CaixaEletronico caixa = new CaixaEletronico(conta);
		caixa.exibirMenu();
	}
}