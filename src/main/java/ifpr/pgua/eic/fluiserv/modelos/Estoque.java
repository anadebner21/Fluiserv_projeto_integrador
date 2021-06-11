package ifpr.pgua.eic.fluiserv.modelos;

public class Estoque {
        private int cod;
        private String nome;
        private String descricao;
        private int quantidade;
        private float valor;


        public  Estoque(int cod,String nome, String descricao, int quantidade, float valor){
            this.cod = cod;
            this.descricao = descricao;
            this.quantidade = quantidade;
            this.valor = valor;

        }

    public Estoque(String nome, String descricao, int quantidade, float valor) {
        this(-1,nome,descricao,quantidade,valor);
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "cod=" + cod +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", quantidade=" + quantidade +
                ", valor=" + valor +
                '}';
    }
}
