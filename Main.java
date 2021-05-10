import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int op = 0;
		Banco banco = new Banco();

		do
		{
			Menu mainMenu =  new Menu("Menu Principal", Arrays.asList("Cadastrar Cliente", "Abrir Conta", "Remover Conta" , "Realizar Saque", "Realizar Depósito", "Visualizar Saldo", "Realizar Transferência"));
			op = mainMenu.getSelection();

			if (op == 1)
			{
				banco.cadastrarCliente();
			}
			else if (op == 2)
			{
				//TODO cadastrar conta
			}
			else if (op == 3)
			{
				//TODO remover conta
			}
			else if (op == 4)
			{
				banco.saque();
			}
			else if (op == 5)
			{
				banco.deposito();
			}
			else if (op == 6)
			{
				banco.visualizarSaldo();
			}
			else if(op == 7)
			{
				banco.transferencia();
			}
		}
		while (op != 0);

		System.out.println("Fim");
	}

}
