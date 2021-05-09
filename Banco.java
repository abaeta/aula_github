import java.util.ArrayList;
import java.util.Scanner;

public class Banco {
    private ArrayList<Conta> contas = new ArrayList<Conta>();
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
  
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

    public int findConta(int numero){
        for(int i = 0; i < contas.size(); i++){
            if(contas.get(i).getNumero() == numero)
                return i;
        }
        return -1;
    }

    public void visualizarSaldo(){
        Scanner sc = new Scanner(System.in);
        System.out.println(" ==== Visulizar saldo ==== \n");
        
        int index;
        do
        {
            System.out.print("Digite seu numero da conta: ");
            int numero = sc.nextInt();
            index = findConta(numero);
        }
        while(index == -1);
        
        System.out.println("Saldo: " + contas.get(index).getSaldo());

        sc.close();
    }

    public void saque(){
        
        int index;
        double valor;

        Scanner sc = new Scanner(System.in);

        System.out.println("Entre com o valor do saque");
        valor = sc.nextDouble();
       
        do
        {
            System.out.print("Digite seu numero da conta: ");
            int numero = sc.nextInt();
            index = findConta(numero);
        }
        while(index == -1);
        
        contas.get(index).saque(valor);
        sc.close()
    }
}

