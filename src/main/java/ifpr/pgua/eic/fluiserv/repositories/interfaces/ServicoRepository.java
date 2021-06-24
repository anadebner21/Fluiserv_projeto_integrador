package ifpr.pgua.eic.fluiserv.repositories.interfaces;

import ifpr.pgua.eic.fluiserv.guias.CadastrarServico;
import ifpr.pgua.eic.fluiserv.modelos.Servico;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface ServicoRepository {
    boolean add(Servico servico) throws SQLException;
    boolean editar(int cod, Servico servico) throws SQLException;
    ObservableList<Servico> lista() throws SQLException;

}
