package ifpr.pgua.eic.fluiserv.repositories;



import ifpr.pgua.eic.fluiserv.modelos.Servico;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.ServicoRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ServicoRepositoryimpl implements ServicoRepository {

    ObservableList<Servico> servicos;

    public ServicoRepositoryimpl() {

        servicos = FXCollections.observableArrayList();
    }

    @Override
    public boolean add(Servico servico) {
        servicos.add(new Servico(servico.getCod(), servico.getNome(), servico.getValor()));

        return true;
    }

    @Override
    public boolean editar(int cod,Servico servico) {
        for(Servico s: servicos){
            if(s.getCod() == cod){
                s.setNome(servico.getNome());
                s.setValor(servico.getValor());

                return  true;
            }
        }
        return false;
    }

    public ObservableList<Servico> lista(){

        return FXCollections.unmodifiableObservableList(servicos);
    }
}
