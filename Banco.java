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

        //sc.close();
    }

    public void abrirConta()
    {
        System.out.println("=== Cadastrar Conta ===");
        Scanner sc = new Scanner(System.in);

        int cpf, conta;

        do
        {
            System.out.println("Digite o numero de seu CPF: ");
            cpf = sc.nextInt();
        }
        while(findCliente(cpf) == -1);
        
        do
        {
            System.out.println("Digite o numero da conta: ");
            conta = sc.nextInt();
        }
        while(findConta(conta) != -1);

        contas.add(new Conta(cpf, conta));

        System.out.println("Conta cadastrada com sucesso!");
    }

    public void removerConta()
    {
        System.out.println("=== Excluir Conta ===");
        Scanner sc = new Scanner(System.in);

        int conta;

        do
        {
            System.out.println("Digite o numero da conta: ");
            conta = sc.nextInt();
        }
        while(findConta(conta) == -1);

        contas.remove(findConta(conta));

        System.out.println("Conta removida com sucesso!");
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

        //sc.close();
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
        //sc.close();
    }

    public void deposito(){
        
        int index;
        double valor;

        Scanner sc = new Scanner(System.in);

        System.out.println("Entre com o valor do deposito");
        valor = sc.nextDouble();

        if(valor > 0){

            do
            {
                System.out.print("Digite seu numero da conta");
                int numero = sc.nextInt();
                index = findConta(numero);
            }
            while(index == -1);
        
            contas.get(index).deposito(valor);
        }
        else {
            System.out.println("Valor de deposito invalido");
        }
        
        //sc.close();
    }

    public void transferencia(){
        
        int index_origem, index_destino;
        double valor;

        Scanner sc = new Scanner(System.in);

        System.out.println("Entre com o valor de transferência");
        valor = sc.nextDouble();

        if(valor > 0){

            do
            {
                System.out.print("Digite o numero da conta de origem");
                int numero = sc.nextInt();
                index_origem = findConta(numero);
            }
            while(index_origem == -1);

            do
            {
                System.out.print("Digite o numero da conta de destino");
                int numero = sc.nextInt();
                index_destino = findConta(numero);
            }
            while(index_destino == -1);

            if(contas.get(index_origem).saque(valor)){
                contas.get(index_destino).deposito(valor);
            }
        }
        else {
            System.out.println("Valor de transferência inválido");
        }
    }
}

