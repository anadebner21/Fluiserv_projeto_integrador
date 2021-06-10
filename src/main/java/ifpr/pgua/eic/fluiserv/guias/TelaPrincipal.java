package ifpr.pgua.eic.fluiserv.guias;

import ifpr.pgua.eic.fluiserv.Main;
import ifpr.pgua.eic.fluiserv.modelos.Cliente;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.ClienteRepository;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class TelaPrincipal {
    @FXML
    ListView<Cliente> ltwClientes;

    private ClienteRepository clienteRepository;

    public TelaPrincipal(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    public void cadastrarCliente(){
        Main.mudaCena(Main.ADICIONARCLIENTE, (aClass)-> new CadastrarClientes(clienteRepository));
    }

    public void verClientes(){
        Main.mudaCena(Main.VERCLIENTE, (aClass)-> new VerClientes(clienteRepository));
    }


}

