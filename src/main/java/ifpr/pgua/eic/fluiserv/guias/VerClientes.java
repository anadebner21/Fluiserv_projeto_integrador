package ifpr.pgua.eic.fluiserv.guias;

import ifpr.pgua.eic.fluiserv.Main;
import ifpr.pgua.eic.fluiserv.modelos.Cliente;
import ifpr.pgua.eic.fluiserv.repositories.ClienteRepositoryImpl;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.ClienteRepository;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
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
                public ListCell<Cliente> call(ListView<Cliente> ingredienteListView) {
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
        private void cancelar(){
            Main.mudaCena(Main.PRINCIPAL,(aClass)-> new TelaPrincipal(clienteRepository));
        }

    }