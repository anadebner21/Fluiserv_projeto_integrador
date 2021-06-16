package ifpr.pgua.eic.fluiserv.guias;

import ifpr.pgua.eic.fluiserv.Main;
import ifpr.pgua.eic.fluiserv.modelos.Estoque;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.EstoqueRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CadastraEstoque {

    @FXML
    private TextField tfProduto;

    @FXML
    private TextField tfDescricao;

    @FXML
    private TextField tfQuantidade;

    @FXML
    private TextField tfValor;

    @FXML
    private Button btAdicionar;

    private final EstoqueRepository estoqueRepository;
    private final Estoque estoqueOriginal;



    public CadastraEstoque(EstoqueRepository estoqueRepository, Estoque estoque){
        this.estoqueRepository = estoqueRepository;
        this.estoqueOriginal = estoque;
    }


    public CadastraEstoque(EstoqueRepository estoqueRepository){
        this(estoqueRepository, null);

    }


    @FXML
    private void initialize(){
        if(estoqueOriginal != null){
            tfProduto.setText(tfProduto.getText());
            tfDescricao.setText(tfDescricao.getText());
            tfQuantidade.setText(String.valueOf(tfQuantidade.getText()));
            tfValor.setText(String.valueOf(tfValor.getText()));


            btAdicionar.setText("Alterar");
        }
    }

    @FXML
    public void adicionar() {
        String nome = tfProduto.getText();
        String descricao = tfDescricao.getText();
        int quantidade = quantidade = Integer.parseInt(tfQuantidade.getText());
        double valor = -1;

    try {
        Double.valueOf(tfValor.getText());
    }catch (NumberFormatException e){
        Alert alert = new Alert(Alert.AlertType.ERROR,"Valor inválido!!");
        alert.showAndWait();
        return;
    }
        if(quantidade <= 0){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Quantidade não reconhecida!!");
            alert.showAndWait();
            return;
        }

        if(nome.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Nome vazio!!");
            alert.showAndWait();
            return;
        }

        if(descricao.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Descrição vazia!!");
            alert.showAndWait();
            return;
        }


        Estoque estoque = new Estoque(nome, descricao, quantidade, -1);



        if (estoqueOriginal != null){
            estoqueRepository.editar(estoqueOriginal.getCod(), estoque);
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Dados do produto alterado!!");
            alert.showAndWait();
        }else{
            estoqueRepository.add(estoque);
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"PRODUTO CADASTRADO!!");
            alert.showAndWait();


        }

        Main.voltaTelaPrincipal();

    }
    @FXML
    private void cancelar(){

        Main.voltaTelaPrincipal();
    }




}