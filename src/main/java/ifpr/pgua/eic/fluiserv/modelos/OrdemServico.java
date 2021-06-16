package ifpr.pgua.eic.fluiserv.modelos;


public class OrdemServico {
    private int cod;
    private String descricao;
    private double valorSubTotal;
    private double valorTotal;
    private Servico servico;
    private Estoque estoque;
    private Cliente cliente;
    private boolean modelo;
    private boolean marca;



    public OrdemServico(int cod, String descricao, double valorSubTotal, double valorTotal, Servico servico, Estoque estoque, Cliente cliente, boolean modelo, boolean marca){
        this.cod = cod;
        this.descricao = descricao;
        this.valorSubTotal = valorSubTotal;
        this.valorTotal = valorTotal;
        this.servico = servico;
        this.estoque = estoque;
        this.cliente = cliente;
        this.modelo = modelo;
        this.marca = marca;


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

    public void setValorSubTotal(double valorSubTotal) {
        this.valorSubTotal = valorSubTotal;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isModelo() {
        return modelo;
    }

    public void setModelo(boolean modelo) {
        this.modelo = modelo;
    }

    public boolean isMarca() {
        return marca;
    }

    public void setMarca(boolean marca) {
        this.marca = marca;
    }

    public double getValorSubTotal() {
        return servico.getValor() + estoque.getValor();
    }

    public Servico getServico() {
        return servico;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    @Override
    public String toString() {
        return "OrdemServico{" +
                "cod=" + cod +
                ", descricao='" + descricao + '\'' +
                ", valorSubTotal=" + valorSubTotal +
                ", valorTotal=" + valorTotal +
                ", servico=" + servico +
                ", estoque=" + estoque +
                ", cliente=" + cliente +
                ", modelo=" + modelo +
                ", marca=" + marca +
                '}';
    }


}
