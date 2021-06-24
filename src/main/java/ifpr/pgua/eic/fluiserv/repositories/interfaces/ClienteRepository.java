package ifpr.pgua.eic.fluiserv.repositories.interfaces;

import ifpr.pgua.eic.fluiserv.modelos.Cliente;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface ClienteRepository {


    boolean add(Cliente cliente) throws SQLException;
    boolean editar(String cpf_cnpj, Cliente clienteOriginal) throws SQLException;
    ObservableList<Cliente> lista() throws SQLException;


}
/* boolean editar(int cpf_cnpj, Cliente cliente);*/