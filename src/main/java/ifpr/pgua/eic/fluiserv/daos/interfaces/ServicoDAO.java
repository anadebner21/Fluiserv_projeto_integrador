package ifpr.pgua.eic.fluiserv.daos.interfaces;

import ifpr.pgua.eic.fluiserv.modelos.Estoque;
import ifpr.pgua.eic.fluiserv.modelos.Servico;

import java.sql.SQLException;
import java.util.List;

public interface ServicoDAO {

    boolean inserir(Servico servico) throws SQLException;

    boolean atualizar(int cod, Servico servico) throws SQLException;

    List<Servico> lista() throws SQLException;

    Servico buscaCod(int cod) throws SQLException;

    boolean delete(Servico servico) throws SQLException;
}
