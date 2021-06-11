package ifpr.pgua.eic.fluiserv.repositories.interfaces;

import ifpr.pgua.eic.fluiserv.guias.CadastrarServico;
import ifpr.pgua.eic.fluiserv.modelos.Servico;
import javafx.collections.ObservableList;

public interface ServicoRepository {
    boolean add(Servico servico);
    boolean editar(int cod, Servico servico);
    ObservableList<Servico> lista();

}
