package ifpr.pgua.eic.fluiserv.guias;

import ifpr.pgua.eic.fluiserv.Main;
import ifpr.pgua.eic.fluiserv.modelos.Cliente;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.ClienteRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.sql.SQLException;


public class VerClientes {

    private ClienteRepository clienteRepository;

    @FXML
    ListView<Cliente> ltwClientes;

    @FXML
    private TextArea dadosClientes;


    public VerClientes(ClienteRepository clienteRepository) {

        this.clienteRepository = clienteRepository;

    }

    @FXML
    private void initialize() {

        ltwClientes.setCellFactory(new Callback<ListView<Cliente>, ListCell<Cliente>>() {
            @Override
            public ListCell<Cliente> call(ListView<Cliente> clienteListView) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(Cliente cliente, boolean b) {
                        super.updateItem(cliente, b);

                        if (cliente != null) {
                            setText(cliente.getNome());
                        } else {
                            setText("");
                        }

                    }
                };
            }
        });

        try {
            ltwClientes.setItems(clienteRepository.lista());

        }catch (SQLException e){
            Alert alert = new Alert(Alert.AlertType.ERROR,e.getMessage());
            alert.showAndWait();
        }

    }


    @FXML
    public void editarClientes(MouseEvent evt) {
        if (evt.getClickCount() == 2) {

            Cliente cliente = ltwClientes.getSelectionModel().getSelectedItem();
            if (cliente != null) {
                Main.mudaCena(Main.ADICIONARCLIENTE, (aClass) -> new CadastrarClientes(clienteRepository, cliente));
            }

        }
    }


    @FXML
    private void cancelar() {
        Main.voltaTelaPrincipal();
    }

    @FXML
    private void atualizaDadosClientes() {

        Cliente c = (Cliente) ltwClientes.getSelectionModel().getSelectedItem();

        if (c != null) {
            String str = "";
            str += "CPF/CNPJ:  " + c.getCpf_cnpj() + "\n";
            str += "NOME: " + c.getNome() + "\n";
            str += "EMAIL: " + c.getEmail() + "\n";
            str += "ENDEREÇO: " + c.getEndereco() + "\n";
            str += "CIDADE: " + c.getCidade() + "\n";


            dadosClientes.clear();
            dadosClientes.setText(str);
        }
    }
}

