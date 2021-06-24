package ifpr.pgua.eic.fluiserv.daos.interfaces;
import ifpr.pgua.eic.fluiserv.modelos.Estoque;

import java.sql.SQLException;
import java.util.List;

public interface EstoqueDAO {

    boolean inserir(Estoque estoque) throws SQLException;

    boolean atualizar(Estoque estoque) throws SQLException;

    List<Estoque> lista() throws SQLException;

    Estoque buscaCod(int cod) throws SQLException;

    boolean delete(Estoque estoque) throws SQLException;
}
