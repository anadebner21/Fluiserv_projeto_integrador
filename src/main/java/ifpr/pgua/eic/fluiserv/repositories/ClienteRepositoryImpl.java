package ifpr.pgua.eic.fluiserv.repositories;

import ifpr.pgua.eic.fluiserv.repositories.interfaces.ClienteRepository;
import ifpr.pgua.eic.fluiserv.modelos.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class ClienteRepositoryImpl implements ClienteRepository {

    private ObservableList<Cliente> clientes;


    public ClienteRepositoryImpl() {

        clientes = FXCollections.observableArrayList();
    }

    public boolean add(Cliente cliente) {
        clientes.add(cliente);
        return true;
    }
    public ObservableList<Cliente> lista(){

        return FXCollections.unmodifiableObservableList(clientes);
    }


}
