public class Conta{

    private int numero;
    private double saldo = 0;

    public double getSaldo(){
        return saldo;
    }

    public int getNumero(){
        return numero;
    }

    public void saque(int valor){
        if(this.saldo >= valor){
            this.saldo -= valor;
        }
    }

}