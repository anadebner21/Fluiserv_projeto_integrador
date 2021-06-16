package ifpr.pgua.eic.fluiserv.repositories.interfaces;

import ifpr.pgua.eic.fluiserv.modelos.OrdemServico;
import javafx.collections.ObservableList;

public interface OrdemServicoRepository {

    boolean add(OrdemServico ordemServico);
    ObservableList<OrdemServico> lista();

}
