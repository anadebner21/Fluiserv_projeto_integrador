package ifpr.pgua.eic.fluiserv.repositories;
import ifpr.pgua.eic.fluiserv.modelos.Estoque;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.EstoqueRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EstoqueRepositoryimpl implements EstoqueRepository {
        private ObservableList<Estoque> estoques;

        private void aleatorio(){

            estoques.add(new Estoque("tubulação", "3/4", 2, 25 ));
            estoques.add(new Estoque("tubulação1", "3/4", 2, 50 ));
            estoques.add(new Estoque("tubulação2", "3/4", 2, 75 ));
            estoques.add(new Estoque("tubulação3", "3/4", 2, 100 ));

        }

        public EstoqueRepositoryimpl(){

            estoques = FXCollections.observableArrayList();
            aleatorio();
        }
        public boolean add(Estoque estoque){
                estoques.add(new Estoque(estoques.size(), estoque.getNome(), estoque.getDescricao(), estoque.getQuantidade(), Double.valueOf(estoque.getValor())));

                return true;
        }

     @Override
    public boolean editar(int cod, Estoque estoque){

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

    public ObservableList<Estoque> lista(){

        return FXCollections.unmodifiableObservableList(estoques);
    }


}
