package ifpr.pgua.eic.fluiserv.modelos;

public class Servico {
    private int cod;
    private String nome;
    private double valor;


    public Servico(int cod, String nome, double valor){
        this.cod = cod;
        this.nome = nome;
        this.valor = valor;
    }

    public int getCod() {
        return cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "CadastrarServico{" +
                "cod=" + cod +
                ", nome='" + nome + '\'' +
                ", valor=" + valor +
                '}';
    }

}
