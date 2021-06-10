package ifpr.pgua.eic.fluiserv.repositories.interfaces;

import ifpr.pgua.eic.fluiserv.modelos.Cliente;
import javafx.collections.ObservableList;

public interface ClienteRepository {


    boolean add(Cliente cliente);
    boolean editar(String cpf_cnpj, Cliente clienteAntigo);
    ObservableList<Cliente> lista();


}
/* boolean editar(int cpf_cnpj, Cliente cliente);*/