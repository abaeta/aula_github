public class Cliente {
    private String nome;
    private int cpf;

    public Cliente(String nome, int cpf)
    {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getNome()
    {
        return nome;
    }

    public void setCpf(int cpf)
    {
        this.cpf = cpf;
    }

    public int getCpf()
    {
        return cpf;
    }
}
