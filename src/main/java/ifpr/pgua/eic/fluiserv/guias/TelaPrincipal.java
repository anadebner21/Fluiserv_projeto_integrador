package ifpr.pgua.eic.fluiserv.guias;

import ifpr.pgua.eic.fluiserv.Main;
import ifpr.pgua.eic.fluiserv.modelos.Cliente;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.ClienteRepository;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class TelaPrincipal {

    @FXML
    private Button btCadastraCliente;

    @FXML
    private Button btVerClientes;

    @FXML
    private Button btCadastraMaterial;

    @FXML
    private Button btVerMateriais;

    private ClienteRepository clienteRepository;

    public TelaPrincipal(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    public void cadastrarCliente(){
        Main.mudaCena(Main.ADICIONARCLIENTE, (aClass)-> new CadastrarClientes(clienteRepository));
    }


}

