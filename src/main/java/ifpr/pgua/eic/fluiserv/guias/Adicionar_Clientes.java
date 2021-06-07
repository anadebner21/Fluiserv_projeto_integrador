package ifpr.pgua.eic.fluiserv.guias;

import ifpr.pgua.eic.fluiserv.Main;
import ifpr.pgua.eic.fluiserv.modelos.Cliente;
import ifpr.pgua.eic.fluiserv.repositories.ClienteRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class Adicionar_Clientes extends Base {
    private final ClienteRepository clienteRepository;
    private final Cliente clienteOriginal;
    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfCpf;

    @FXML
    private TextField tfTelefone;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfEndereco;

    @FXML
    private Button btAdicionar;

    @FXML
    private Button btCancela;


    public Adicionar_Clientes(ClienteRepository clienteRepository, Cliente cliente) {
        this.clienteRepository = clienteRepository;
        this.clienteOriginal = cliente;
    }


    public Adicionar_Clientes(ClienteRepository clienteRepository) {

        this(clienteRepository, null);
    }

    @FXML
    private void initialize(){

        if(clienteOriginal != null){
            tfNome.setText(clienteOriginal.getNome());
            tfEmail.setText(String.valueOf(clienteOriginal.getEmail()));

            btAdicionar.setText("Alterar");

        }

    }



    @FXML
    private void adicionar(){
        String nome = tfNome.getText();
        String telefone = tfTelefone.getText();
        String email = tfEmail.getText();
        String endereco = tfEndereco.getText();
        int cpf_cnpj = Integer.valueOf(tfCpf.getText());

        if(nome.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Nome inválido!!");
            alert.showAndWait();
            return;
        }

        if(email.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Email inválido!!");
            alert.showAndWait();
            return;
        }
        if(telefone.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Endereço inválido!!");
            alert.showAndWait();
            return;
        }




        Cliente cliente = new Cliente(cpf_cnpj, nome, email, endereco, clienteOriginal.getCidade());

        Main.voltaPrincipal();


    }

    @FXML
    private void cancelar(){
        Main.voltaPrincipal();
    }
}







