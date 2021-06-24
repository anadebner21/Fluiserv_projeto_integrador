package ifpr.pgua.eic.fluiserv.daos.interfaces;

import ifpr.pgua.eic.fluiserv.modelos.Cliente;

import java.sql.SQLException;
import java.util.List;

public interface ClienteDAO {

    boolean inserir(Cliente cliente) throws SQLException;

    boolean atualizar(String cpf_cnpj, Cliente cliente) throws SQLException;

    List<Cliente> lista() throws SQLException;

    Cliente buscaCod(int cpf_cnpj) throws SQLException;

    boolean delete(Cliente cliente) throws SQLException;


}
