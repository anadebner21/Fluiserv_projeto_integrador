package ifpr.pgua.eic.fluiserv.guias;

import ifpr.pgua.eic.fluiserv.Main;
import ifpr.pgua.eic.fluiserv.modelos.Estoque;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.EstoqueRepository;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class VerEstoque {

    @FXML
    ListView<Estoque> ltwEstoque;

    private EstoqueRepository estoqueRepository;

    public VerEstoque(EstoqueRepository estoqueRepository){

        this.estoqueRepository = estoqueRepository;

    }
    @FXML
    private void initialize() {

        ltwEstoque.setCellFactory(new Callback<ListView<Estoque>, ListCell<Estoque>>() {

            @Override
            public ListCell<Estoque> call(ListView<Estoque> estoqueListView) {
                return new ListCell<>(){

                        @Override
                        protected void updateItem(Estoque estoque, boolean b) {
                            super.updateItem(estoque, b);

                            if (estoque != null) {
                                setText(estoque.getNome());
                            } else {
                                setText("");
                            }

                        }
                    };
                }
            });


        ltwEstoque.setItems(estoqueRepository.lista());

    }




    @FXML
    public void editarEstoque(MouseEvent evt) {
        if (evt.getClickCount() == 2) {

            Estoque estoque = ltwEstoque.getSelectionModel().getSelectedItem();
            if (estoque != null) {
                Main.mudaCena(Main.ADICIONARESTOQUE, (aClass) -> new CadastraEstoque(estoqueRepository, estoque));
            }

        }
    }



    @FXML
    private void cancelar(){

        Main.voltaTelaPrincipal();
    }

}
