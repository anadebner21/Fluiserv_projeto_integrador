package ifpr.pgua.eic.fluiserv.guias;

import ifpr.pgua.eic.fluiserv.Main;
import ifpr.pgua.eic.fluiserv.modelos.Cliente;
import ifpr.pgua.eic.fluiserv.repositories.ClienteRepositoryImpl;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.ClienteRepository;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;



public class VerClientes {

        private ClienteRepository clienteRepository;

        @FXML
        ListView<Cliente> ltwClientes;

        public VerClientes(ClienteRepository clienteRepository){

            this.clienteRepository = clienteRepository;

        }
        @FXML
        private void initialize() {

            ltwClientes.setCellFactory(new Callback <ListView<Cliente>, ListCell<Cliente>>() {
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
            ltwClientes.setItems(clienteRepository.lista());
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
        private void cancelar(){
            Main.mudaCena(Main.PRINCIPAL,(aClass)-> new TelaPrincipal(clienteRepository));
        }

    }


    /*public  boolean editar(int cpf_cnpj, Cliente cliente){
        for(Cliente c:clientes){
           if(c.getCpf_cnpj() == cpf_cnpj){
               c.setNome(cliente.getNome());
               c.setTelefone(cliente.getTelefone());
               c.setEmail(cliente.getEmail());
               c.setEndereco(cliente.getEndereco());
               c.setCidade(cliente.getCidade());

               return  true;
           }
        }
       return false;*/

/*@FXML
        public void editar(MouseEvent evento){


            if(evento.getClickCount() == 2){
                Cliente cliente = ltwClientes.getSelectionModel().getSelectedItem();
                if(cliente != null) {
                    Main.mudaCena(Main.ADICIONARCLIENTE, (aClass) -> new CadastrarClientes(clienteRepository, cliente));
                }
            }
        }*/