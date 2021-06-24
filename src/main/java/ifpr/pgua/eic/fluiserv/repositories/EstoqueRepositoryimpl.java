package ifpr.pgua.eic.fluiserv.repositories;
import ifpr.pgua.eic.fluiserv.daos.interfaces.EstoqueDAO;
import ifpr.pgua.eic.fluiserv.modelos.Estoque;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.EstoqueRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public class EstoqueRepositoryimpl implements EstoqueRepository {
        private ObservableList<Estoque> estoques;
        private EstoqueDAO estoqueDAO;



        public EstoqueRepositoryimpl(EstoqueDAO estoqueDAO){

            estoques = FXCollections.observableArrayList();
            this.estoqueDAO = estoqueDAO;

        }
        public boolean add(Estoque estoque) throws SQLException{
                estoqueDAO.inserir(estoque);
                return true;
        }

     @Override
    public boolean editar(int cod, Estoque estoque) throws SQLException {

            Estoque antigo = estoques.stream().filter((e-> e.getCod() == cod)).findFirst().get();

            if(antigo != null){

                antigo.setNome(estoque.getNome());
                antigo.setDescricao(estoque.getDescricao());
                antigo.setQuantidade(estoque.getQuantidade());
                antigo.setValor(estoque.getValor());

                return  true;
            }

        return false;
    }

    public ObservableList<Estoque> lista() throws SQLException{
        estoques.clear();
        estoques.addAll(estoqueDAO.lista());

        return FXCollections.unmodifiableObservableList(estoques);
    }


}
