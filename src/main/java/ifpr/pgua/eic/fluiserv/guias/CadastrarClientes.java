package ifpr.pgua.eic.fluiserv.guias;

import ifpr.pgua.eic.fluiserv.Main;
import ifpr.pgua.eic.fluiserv.modelos.Cliente;
import ifpr.pgua.eic.fluiserv.repositories.ClienteRepositoryImpl;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.ClienteRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
        int cpf_cnpj = Integer.valueOf(tfCpf.getText());
        String email = tfEmail.getText();
        int telefone = Integer.valueOf(tfTelefone.getText());
        String endereco = tfEndereco.getText();
        String cidade = tfCidade.getText();

        try {
            cpf_cnpj = Integer.valueOf(tfCpf.getText());
        } catch (NumberFormatException e) {
            if (cpf_cnpj < 11) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Número do CPF ou CNPJ inválido...");
                alert.showAndWait();
                return;
            }
        }
        if (nome.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Nome inválido!!");
            alert.showAndWait();
            return;
        }

        if (email.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Email inválido!!");
            alert.showAndWait();
            return;
        }

        if (endereco.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Endereço inválido!!");
            alert.showAndWait();
            return;
        }

        Cliente cliente = new Cliente(cpf_cnpj, nome, email, telefone, endereco, cidade);

        clienteRepository.add(cliente);

        Main.mudaCena(Main.PRINCIPAL, (aClass) -> new TelaPrincipal(clienteRepository));
    }
    @FXML
    private void cancelar(){
        Main.mudaCena(Main.PRINCIPAL,(aClass)-> new TelaPrincipal(clienteRepository));
    }

}

