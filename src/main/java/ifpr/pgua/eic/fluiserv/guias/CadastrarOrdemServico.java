package ifpr.pgua.eic.fluiserv.guias;

import ifpr.pgua.eic.fluiserv.Main;
import ifpr.pgua.eic.fluiserv.modelos.Cliente;
import ifpr.pgua.eic.fluiserv.modelos.Estoque;
import ifpr.pgua.eic.fluiserv.modelos.OrdemServico;
import ifpr.pgua.eic.fluiserv.modelos.Servico;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.ClienteRepository;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.EstoqueRepository;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.OrdemServicoRepository;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.ServicoRepository;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.DataFormat;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Callback;

public class CadastrarOrdemServico {

    @FXML
    private ListView<Servico> ltwServico;

    @FXML
    private ListView<Cliente> ltwClientes;

    @FXML
    private TextField tfDescricaoServico;

    @FXML
    private RadioButton rbAcj;

    @FXML
    private RadioButton rbSplit;

    @FXML
    private RadioButton rbPisoTeto;

    @FXML
    private RadioButton rbCassete;

    @FXML
    private RadioButton rbPortatil;

    @FXML
    private RadioButton rbLG;

    @FXML
    private RadioButton rbSpringer;

    @FXML
    private RadioButton rbElgin;

    @FXML
    private RadioButton rbConsul;

    @FXML
    private RadioButton rbElectrolux;

    @FXML
    private RadioButton rbKomeco;

    @FXML
    private RadioButton rbOutra;

    @FXML
    private TextField tfDesAparelho;

    @FXML
    private ListView<Estoque> ltwEstoque;

    @FXML
    private Text tXTValorMaterial;

    @FXML
    private TextField tfData;

    @FXML
    private RadioButton rbSim;

    @FXML
    private RadioButton rbNao;

    @FXML
    private TextField tfSubtotal;

    @FXML
    private TextField tfTotal;

    @FXML
    private Text txtValorServico;

    private OrdemServico ordemServico;

    private ClienteRepository clienteRepository;
    private OrdemServicoRepository ordemServicoRepository;
    private ServicoRepository servicoRepository;
    private EstoqueRepository estoqueRepository;


    public CadastrarOrdemServico(OrdemServicoRepository ordemServicoRepository, ClienteRepository clienteRepository, ServicoRepository servicoRepository, EstoqueRepository estoqueRepository) {
        this.clienteRepository = clienteRepository;
        this.ordemServicoRepository = ordemServicoRepository;
        this.servicoRepository = servicoRepository;
        this.estoqueRepository = estoqueRepository;
        System.out.println("Aqui1");



    }

    @FXML
    private void initialize() {

        ltwClientes.setCellFactory(clienteListView -> new ListCell<>() {
            @Override
            protected void updateItem(Cliente cliente, boolean b) {
                super.updateItem(cliente, b);

                if (cliente != null) {
                    setText(cliente.getNome());
                } else {
                    setText("");
                }
            }
        });
        ltwClientes.setItems(clienteRepository.lista());


        ltwEstoque.setCellFactory(estoqueListView -> new ListCell<>(){
            @Override
            protected void updateItem(Estoque estoque, boolean b) {
                super.updateItem(estoque, b);

                if(estoque != null){
                    setText(estoque.getNome());
                }else{
                    setText("");
                }
            }
        });

        ltwEstoque.setItems(estoqueRepository.lista());

    }
    @FXML
    private void processaMaterial(MouseEvent evt){
        Estoque estoque = ltwEstoque.getSelectionModel().getSelectedItem();
        System.out.println("Aqui");

        if(evt.getClickCount() == 1 && evt.getButton() == MouseButton.PRIMARY){

            if(estoque != null){
                ordemServico.adiciona(estoque);
            }
        }else if(evt.getButton() == MouseButton.SECONDARY){
            if(estoque != null){
                ordemServico.remove(estoque);
            }
        }
        ltwEstoque.refresh();
        ltwEstoque.getSelectionModel().clearSelection();
        tXTValorMaterial.setText("R$ "+ordemServico.getValorMaterial());
    }

    @FXML
    private void add(){
        String descricaoDoServico = tfDescricaoServico.getText();
        String descricaoAparelho = tfDesAparelho.getText();
        double valorSubTotal = Double.valueOf(tfSubtotal.getText());
        double valorTotal = Double.valueOf(tfTotal.getText());
        double valorMaterial = Double.valueOf(tXTValorMaterial.getText());
        double valorServico = Double.valueOf(txtValorServico.getText());
        boolean modelo = rbAcj.isSelected();
        boolean marca = rbLG.isSelected();
        Cliente cliente = ltwClientes.getSelectionModel().getSelectedItem();
        Servico servico = ltwServico.getSelectionModel().getSelectedItem();
        Estoque estoque = ltwEstoque.getSelectionModel().getSelectedItem();
        DataFormat data = DataFormat.lookupMimeType(tfData.getText());


        OrdemServico ordemServico = new OrdemServico(-1, descricaoDoServico, descricaoAparelho, -1, valorTotal, valorMaterial, valorServico, servico, estoque, cliente, modelo, marca, data);

        ordemServicoRepository.add(ordemServico);

        Main.voltaTelaPrincipal();

    }

    @FXML
    private void cancelar(){
        Main.voltaTelaPrincipal();
    }
}
