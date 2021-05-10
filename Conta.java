public class Conta
{
    private int cpf;
    private int numero;
    private double saldo = 0;

    public Conta(int cpf, int numero)
    {
        this.cpf = cpf;
        this.numero = numero;
        saldo = 0;
    }

    public double getSaldo(){
        return saldo;
    }

    public int getNumero(){
        return numero;
    }

    public int getCpf()
    {
        return cpf;
    }

    public void setCpf(int cpf)
    {
        this.cpf = cpf;
    } 

    public boolean saque(double valor){
        if(this.saldo >= valor && valor > 0){
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public void deposito(double valor){
        this.saldo += valor;
    }

}