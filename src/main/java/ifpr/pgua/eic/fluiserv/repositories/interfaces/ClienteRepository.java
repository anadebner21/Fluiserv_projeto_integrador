package ifpr.pgua.eic.fluiserv.repositories.interfaces;

import ifpr.pgua.eic.fluiserv.modelos.Cliente;
import javafx.collections.ObservableList;

public interface ClienteRepository {


    public boolean add(Cliente cliente);
    public ObservableList<Cliente> lista();


}
