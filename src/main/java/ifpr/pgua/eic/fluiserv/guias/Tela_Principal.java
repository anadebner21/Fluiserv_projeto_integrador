package ifpr.pgua.eic.fluiserv.guias;

import ifpr.pgua.eic.fluiserv.Main;
import ifpr.pgua.eic.fluiserv.modelos.Cliente;
import ifpr.pgua.eic.fluiserv.repositories.ClienteRepository;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.format.DateTimeFormatter;

public class Tela_Principal extends Base {
    
    @FXML
    private Button tfCadastraClientes;

    private ClienteRepository clienteRepository;



    public Tela_Principal(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;

    }

    
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");

    public Tela_Principal() {
        
    }

    @FXML
    private void mudaCena(ActionEvent evt) {

        String texto = ((Button)evt.getSource()).getText();

        java.awt.Label txtIdentificacaoTela = null;
        txtIdentificacaoTela.setText(texto);

        Main.mudaCena(Main.Adicionar_Clientes,(aClass)->new Adicionar_Clientes(clienteRepository));


    }

    @FXML
    private void cadastrarCliente(Cliente cliente){
        Main.mudaCena(Main.Adicionar_Clientes,(aClass) -> new Adicionar_Clientes(clienteRepository));
    }

    @FXML
    private void sair(){
        Platform.exit();
    }
}
