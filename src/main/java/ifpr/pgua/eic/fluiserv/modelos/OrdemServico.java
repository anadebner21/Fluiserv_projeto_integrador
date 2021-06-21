package ifpr.pgua.eic.fluiserv.modelos;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.input.DataFormat;

import java.time.LocalDate;

public class OrdemServico {
    private int cod;
    private String descricaoDoServico;
    private String descricaoAparelho;
    private double valorSubTotal;
    private double valorTotal;
    private double valorMaterial;
    private double valorServico;
    private Cliente cliente;
    private boolean modelo;
    private boolean marca;
    private LocalDate data;

    private ObservableList<Estoque> estoques;
    private ObservableList<Servico> servicos;


    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public OrdemServico(int cod, String descricaoDoServico, String descricaoAparelho, double valorSubTotal, double valorTotal, double valorMaterial, double valorServico, Cliente cliente, boolean modelo, boolean marca, LocalDate data){
        this.cod = cod;
        this.descricaoDoServico = descricaoDoServico;
        this.descricaoAparelho = descricaoAparelho;
        this.valorSubTotal = valorSubTotal;
        this.valorTotal = valorTotal;
        this.valorMaterial = valorMaterial;
        this.valorServico = valorServico;
        this.cliente = cliente;
        this.modelo = modelo;
        this.marca = marca;
        this.data = data;


    }

    public OrdemServico(){
        this.estoques = FXCollections.observableArrayList();
        this.servicos = FXCollections.observableArrayList();
    }

    public void setValorSubTotal(double valorSubTotal) {
        this.valorSubTotal = valorSubTotal;
    }

    public void setValorMaterial(double valorMaterial) {
        this.valorMaterial = valorMaterial;
    }

    public double getValorServico() {
        return valorServico;
    }

    public void setValorServico(double valorServico) {
        this.valorServico = valorServico;
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


    @Override
    public String toString() {
        return "OrdemServico{" +
                "cod=" + cod +
                ", descricaoDoServico='" + descricaoDoServico + '\'' +
                ", descricaoAparelho='" + descricaoAparelho + '\'' +
                ", valorSubTotal=" + valorSubTotal +
                ", valorTotal=" + valorTotal +
                ", valorMaterial=" + valorMaterial +
                ", valorServico=" + valorServico +
                ", cliente=" + cliente +
                ", modelo=" + modelo +
                ", marca=" + marca +
                ", data=" + data +
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
    public boolean add(Servico servico){
        this.servicos.add(servico);

        return true;
    }
    public boolean rmv(Servico servico){
        this.servicos.remove(servico);

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

