package ifpr.pgua.eic.fluiserv.repositories;



import ifpr.pgua.eic.fluiserv.daos.interfaces.ServicoDAO;
import ifpr.pgua.eic.fluiserv.modelos.Servico;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.ServicoRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class ServicoRepositoryimpl implements ServicoRepository {

    ObservableList<Servico> servicos;
    private ServicoDAO servicoDAO;

    public ServicoRepositoryimpl(ServicoDAO servicoDAO) {

        servicos = FXCollections.observableArrayList();
        this.servicoDAO = servicoDAO;
    }

    @Override
    public boolean add(Servico servico) throws SQLException {
            servicoDAO.inserir(servico);
            return true;
    }

    @Override
    public boolean editar(int cod,Servico servico) throws SQLException{
        return servicoDAO.atualizar(cod, servico);
    }

    public ObservableList<Servico> lista() throws SQLException{

        servicos.clear();
        servicos.addAll(servicoDAO.lista());

        return FXCollections.unmodifiableObservableList(servicos);
    }
}
