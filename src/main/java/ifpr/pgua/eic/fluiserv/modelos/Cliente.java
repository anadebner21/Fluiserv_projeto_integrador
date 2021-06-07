package ifpr.pgua.eic.fluiserv.modelos;

public class Cliente {

    private int cpf_cnpj;
    private String nome;
    private String email;
    private String endereco;
    private int cidade;


    public Cliente(int cpf_cnpj, String nome, String email, String endereco, int cidade){
        this.cpf_cnpj = cpf_cnpj;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.cidade = cidade;
    }


    public int getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(int cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getCidade() {
        return cidade;
    }

    public void setCidade(int cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cpf_cnpj=" + cpf_cnpj +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                ", cidade=" + cidade +
                '}';
    }
}
