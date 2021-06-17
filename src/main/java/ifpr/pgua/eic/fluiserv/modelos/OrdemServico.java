package ifpr.pgua.eic.fluiserv.modelos;


import javafx.collections.ObservableList;
import javafx.scene.input.DataFormat;

public class OrdemServico {
    private int cod;
    private String descricaoDoServico;
    private String descricaoAparelho;
    private double valorSubTotal;
    private double valorTotal;
    private double valorMaterial;
    private double valorServico;
    private Servico servico;
    private Estoque estoque;
    private Cliente cliente;
    private boolean modelo;
    private boolean marca;
    private DataFormat data;

    private ObservableList<Estoque> estoques;
    private ObservableList<Servico> servicos;



    public OrdemServico(int cod, String descricaoDoServico, String descricaoAparelho, double valorSubTotal, double valorTotal, double valorMaterial,double valorServico, Servico servico, Estoque estoque, Cliente cliente, boolean modelo, boolean marca, DataFormat data){
        this.cod = cod;
        this.descricaoDoServico = descricaoDoServico;
        this.descricaoAparelho = descricaoAparelho;
        this.valorSubTotal = valorSubTotal;
        this.valorTotal = valorTotal;
        this.valorMaterial = valorMaterial;
        this.valorServico = valorServico;
        this.servico = servico;
        this.estoque = estoque;
        this.cliente = cliente;
        this.modelo = modelo;
        this.marca = marca;
        this.data = data;


    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDescricaoDoServico() {
        return descricaoDoServico;
    }

    public void setDescricaoDoServico(String descricaoDoServico) {
        this.descricaoDoServico = descricaoDoServico;
    }

    public String getDescricaoAparelho() {
        return descricaoAparelho;
    }

    public void setDescricaoAparelho(String descricaoAparelho) {
        this.descricaoAparelho = descricaoAparelho;
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
                ", descricaoDoServico='" + descricaoDoServico + '\'' +
                ", descricaoAparelho='" + descricaoAparelho + '\'' +
                ", valorSubTotal=" + valorSubTotal +
                ", valorTotal=" + valorTotal +
                ", servico=" + servico +
                ", estoque=" + estoque +
                ", cliente=" + cliente +
                ", modelo=" + modelo +
                ", marca=" + marca +
                '}';
    }

    public boolean adiciona(Estoque estoque) {
       this.estoques.add(estoque);

       return true;
    }

    public boolean remove(Estoque estoque) {
        this.estoques.remove(estoque);
        return true;
    }

    public double getValorMaterial() {

            this.valorMaterial = 0.0;

            for(Estoque e:estoques){
                this.valorMaterial += e.getValor();
            }

            return this.valorMaterial;

    }
}

