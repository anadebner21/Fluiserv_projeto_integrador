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
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CadastrarOrdemServico {

    @FXML
    private ListView<Servico> ltwServico;

    @FXML
    private ListView<Cliente> ltwClientes;

    @FXML
    private TextField tfDescricaoServico;

    @FXML
    private ToggleGroup groupModelo;

    @FXML
    private ToggleGroup groupMarca;
    @FXML
    private TextField tfDesAparelho;

    @FXML
    private ListView<Estoque> ltwEstoque;

    @FXML
    private Text txtValorMaterial;

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
    private OrdemServico ordemServicoOriginal;



    public CadastrarOrdemServico(OrdemServicoRepository ordemServicoRepository, ClienteRepository clienteRepository, ServicoRepository servicoRepository, EstoqueRepository estoqueRepository, OrdemServico ordemServicoOriginal) {
        this.clienteRepository = clienteRepository;
        this.ordemServicoRepository = ordemServicoRepository;
        this.servicoRepository = servicoRepository;
        this.estoqueRepository = estoqueRepository;
        this.ordemServicoOriginal = ordemServicoOriginal;

        ordemServico = new OrdemServico();


    }
    public CadastrarOrdemServico(OrdemServicoRepository ordemServicoRepository, ClienteRepository clienteRepository, EstoqueRepository estoqueRepository, ServicoRepository servicoRepository){
        this(ordemServicoRepository, clienteRepository, servicoRepository, estoqueRepository, null);
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


        try {
            ltwClientes.setItems(clienteRepository.lista());
        }catch (SQLException e){
            Alert alert = new Alert(Alert.AlertType.ERROR,e.getMessage());
            alert.showAndWait();
        }


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
        try {
            ltwEstoque.setItems(estoqueRepository.lista());

        }catch (SQLException e){
            Alert alert = new Alert(Alert.AlertType.ERROR,e.getMessage());
            alert.showAndWait();
        }


        ltwServico.setCellFactory(servicoListView -> new ListCell<>(){
            @Override
                protected void updateItem(Servico servico, boolean b){
                    super.updateItem(servico, b);
                    if(servico != null){
                        setText(servico.getNome());
                    }else {
                        setText("");
                    }
            }
        });

        try {
            ltwServico.setItems(servicoRepository.lista());

        }catch (SQLException e){
            Alert alert = new Alert(Alert.AlertType.ERROR,e.getMessage());
            alert.showAndWait();
        }

    }

    @FXML
    private void processaServico(MouseEvent event){
        Servico servico = ltwServico.getSelectionModel().getSelectedItem();

        if(event.getClickCount() == 1 && event.getButton() == MouseButton.PRIMARY){

            if(servico != null){
                ordemServico.add(servico);
            }
            else if(event.getButton() == MouseButton.SECONDARY){
                if(servico != null){
                    ordemServico.rmv(servico);
                }
            }
            ltwServico.refresh();
            ltwServico.getSelectionModel().clearSelection();
            txtValorServico.setText("R$ " +ordemServico.getValorServico());
        }
    }
    @FXML
    private void processaMaterial(MouseEvent evt){
        Estoque estoque = ltwEstoque.getSelectionModel().getSelectedItem();


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
        txtValorMaterial.setText("R$ "+ordemServico.getValorMaterial());
    }


    @FXML
    private void add(){
        String descricaoDoServico = tfDescricaoServico.getText();
        String descricaoAparelho = tfDesAparelho.getText();
        double valorSubTotal = Double.valueOf(tfSubtotal.getText());
        double valorTotal = Double.valueOf(tfTotal.getText());
        double valorMaterial = Double.valueOf(txtValorMaterial.getText().replace("R$ ", ""));
        double valorServico = Double.valueOf(txtValorServico.getText().replace("R$ ", ""));
        String modelo = ((RadioButton)groupModelo.getSelectedToggle()).getText();
        String marca = ((RadioButton)groupMarca.getSelectedToggle()).getText();
        Cliente cliente = ltwClientes.getSelectionModel().getSelectedItem();

        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            LocalDate data = LocalDate.from(formater.parse(tfData.getText()));
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Data inválida!!!");
            alert.showAndWait();
            return;

        }
        this.ordemServico.setDescricaoDoServico(descricaoDoServico);
        this.ordemServico.setDescricaoAparelho(descricaoAparelho);
        this.ordemServico.setValorSubTotal(valorSubTotal);
        this.ordemServico.setValorTotal(valorTotal);
        this.ordemServico.setValorMaterial(valorMaterial);
        this.ordemServico.setValorServico(valorServico);
        this.ordemServico.setModelo(modelo);
        this.ordemServico.setMarca(marca);
        this.ordemServico.setCliente(cliente);


        if (ordemServicoOriginal != null){
            ordemServicoRepository.editar(ordemServicoOriginal.getCod(), ordemServico);
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Dados da ordem de serviço alterado!!");
            alert.showAndWait();
        }else{
            ordemServicoRepository.add(ordemServico);
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"ORDEM DE SERVIÇO CADASTRADA!!");
            alert.showAndWait();


        }


        Main.voltaTelaPrincipal();

    }

    @FXML
    private void cancelar(){
        Main.voltaTelaPrincipal();
    }
}
