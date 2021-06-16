package ifpr.pgua.eic.fluiserv.repositories;

import ifpr.pgua.eic.fluiserv.modelos.OrdemServico;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.OrdemServicoRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OrdemServicoRepositoryImpl implements OrdemServicoRepository {

    private ObservableList<OrdemServico> ordemServicos;


    public OrdemServicoRepositoryImpl() {
        ordemServicos = FXCollections.observableArrayList();

    }


    @Override
    public boolean add(OrdemServico ordemServico) {

        ordemServicos.add(ordemServico);

        return true;
    }

    @Override
    public ObservableList<OrdemServico> lista() {
        return FXCollections.unmodifiableObservableList(ordemServicos);

    }
}
