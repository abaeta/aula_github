import java.util.ArrayList;
import java.util.Scanner;

public class Banco {
    private ArrayList<Cliente> clientes;

    //returns -1 if not found the client or returns the index of the clientes array if found
    public int findCliente(int cpf)
    {
        for (int i = 0; i < clientes.size(); i++)
        {
            if (clientes.get(i).getCpf() == cpf)
            {
                return i;
            }
        }

        return -1;
    }

    public void cadastrarCliente()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println(" ==== Cadastrar Cliente ==== \n");
        System.out.print("Digite seu nome: ");
		String nome = sc.nextLine();
        int cpf;

        do
        {
            System.out.print("Digite seu CPF: ");
            cpf = sc.nextInt();
        }
        while(findCliente(cpf) != -1);

        clientes.add(new Cliente(nome, cpf));

        System.out.println("Cliente cadastrado com sucesso!");

        sc.close();
    }
}
