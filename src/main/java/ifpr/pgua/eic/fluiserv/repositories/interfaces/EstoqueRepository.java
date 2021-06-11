package ifpr.pgua.eic.fluiserv.repositories.interfaces;

import ifpr.pgua.eic.fluiserv.modelos.Estoque;
import javafx.collections.ObservableList;

public interface EstoqueRepository {
    boolean add(Estoque estoque);
    boolean editar(int cod, Estoque estoque);

    ObservableList<Estoque> lista();
}
