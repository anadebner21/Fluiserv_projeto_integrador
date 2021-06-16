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
import javafx.scene.text.Text;
import javafx.util.Callback;

public class CadastrarOrdemServico {

    @FXML
    private ListView<Servico> ltwServico;

    @FXML
    private ListView<Cliente> ltwClientes;

    @FXML
    private TextField tfDescricao;

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
    private Text tXTValor;

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

    private ClienteRepository clienteRepository;
    private OrdemServicoRepository ordemServicoRepository;
    private ServicoRepository servicoRepository;
    private EstoqueRepository estoqueRepository;


    public CadastrarOrdemServico(OrdemServicoRepository ordemServicoRepository, ClienteRepository clienteRepository, ServicoRepository servicoRepository, EstoqueRepository estoqueRepository) {
        this.clienteRepository = clienteRepository;
        this.ordemServicoRepository = ordemServicoRepository;
        this.servicoRepository = servicoRepository;
        this.estoqueRepository = estoqueRepository;


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

        ltwServico.setCellFactory(new Callback<ListView<Servico>, ListCell<Servico>>() {
            @Override
            public ListCell<Servico> call(ListView<Servico> servicoListView) {
                return new ListCell<>(){
                    @Override
                    protected void updateItem(Servico servico, boolean b) {
                        super.updateItem(servico, b);

                        if(servico != null){
                            setText(servico.getNome());
                        }else{
                            setText("");
                        }

                    }
                };
            }
        });

        ltwServico.setItems(servicoRepository.lista());

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
    private void add(){
        String descricao = tfDescricao.getText();
        double valorSubTotal = Double.valueOf(tfSubtotal.getText());
        double valorTotal = Double.valueOf(tfTotal.getText());
        boolean modelo = rbAcj.isSelected();
        boolean marca = rbLG.isSelected();
        Cliente cliente = ltwClientes.getSelectionModel().getSelectedItem();
        Servico servico = ltwServico.getSelectionModel().getSelectedItem();
        Estoque estoque = ltwEstoque.getSelectionModel().getSelectedItem();

        OrdemServico ordemServico = new OrdemServico(-1, descricao, -1, -1, servico, estoque, cliente, modelo, marca);

        ordemServicoRepository.add(ordemServico);

        Main.voltaTelaPrincipal();

    }

    @FXML
    private void cancelar(){
        Main.voltaTelaPrincipal();
    }
}
