package ifpr.pgua.eic.fluiserv.repositories.interfaces;

import ifpr.pgua.eic.fluiserv.modelos.Estoque;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface EstoqueRepository {
    boolean add(Estoque estoque) throws SQLException;
    boolean editar(int cod, Estoque estoque) throws SQLException;

    ObservableList<Estoque> lista() throws SQLException;
}
