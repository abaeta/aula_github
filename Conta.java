public class Conta{

    private int numero;
    private double saldo = 0;

    public double getSaldo(){
        return saldo;
    }

    public int getNumero(){
        return numero;
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