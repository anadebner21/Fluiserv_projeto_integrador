package ifpr.pgua.eic.fluiserv.guias;

import ifpr.pgua.eic.fluiserv.Main;
import ifpr.pgua.eic.fluiserv.modelos.Cliente;
import ifpr.pgua.eic.fluiserv.repositories.ClienteRepositoryImpl;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.ClienteRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.List;

public class CadastrarClientes {

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
    private TextField tfCidade;


    private ClienteRepository clienteRepository;


    public CadastrarClientes(ClienteRepository clienteRepository) {

        this.clienteRepository = clienteRepository;
    }

    @FXML
    public void adicionar() {
        String nome = tfNome.getText();
        String cpf_cnpj = tfCpf.getText();
        String email = tfEmail.getText();
        String telefone = tfTelefone.getText();
        String endereco = tfEndereco.getText();
        String cidade = tfCidade.getText();

        if(nome.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Nome inválido!!");
            alert.showAndWait();
            return;
        }

        if(cpf_cnpj.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR,"CPF ou CNPJ inválida!!");
            alert.showAndWait();
            return;
        }

        if(email.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Email inválido!!");
            alert.showAndWait();
            return;
        }
        if(telefone.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Telefone inválido!!");
            alert.showAndWait();
            return;
        }
        if(endereco.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Endereço inválido!!");
            alert.showAndWait();
            return;
        }
        if(cidade.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Cidade inválida!!");
            alert.showAndWait();
            return;
        }

        Cliente cliente = new Cliente(cpf_cnpj, nome, email, telefone, endereco, cidade);


        if(clienteRepository.add(cliente)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"CLIENTE CADASTRADO!!");
            alert.showAndWait();
            atualizaClientes();

        }


        Main.mudaCena(Main.PRINCIPAL,(aClass)-> new TelaPrincipal(clienteRepository));

    }
    public void atualizaClientes(){

        }
    @FXML
    private void cancelar(){
        Main.mudaCena(Main.PRINCIPAL,(aClass)-> new TelaPrincipal(clienteRepository));
    }

}

