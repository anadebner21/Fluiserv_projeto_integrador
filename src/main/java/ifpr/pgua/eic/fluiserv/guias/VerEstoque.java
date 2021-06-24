package ifpr.pgua.eic.fluiserv.guias;

import ifpr.pgua.eic.fluiserv.Main;
import ifpr.pgua.eic.fluiserv.modelos.Cliente;
import ifpr.pgua.eic.fluiserv.modelos.Estoque;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.EstoqueRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.sql.SQLException;

public class VerEstoque {

    @FXML
    ListView<Estoque> ltwEstoque;

    @FXML
    private TextArea dadosEstoque;

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

            try {
                ltwEstoque.setItems(estoqueRepository.lista());

            }catch (SQLException e){
                Alert alert = new Alert(Alert.AlertType.ERROR,e.getMessage());
                alert.showAndWait();
            }

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
    private void atualizaDadosEstoque() {

        Estoque e = (Estoque) ltwEstoque.getSelectionModel().getSelectedItem();

        if (e != null) {
            String str = "";
            str += "CÓDIGO DO PRODUTO: " + e.getCod() + "\n";
            str += "NOME: " + e.getNome() + "\n";
            str += "DESCRIÇÃO " + e.getDescricao() + "\n";
            str += "QUANTIDADE: " + e.getQuantidade() + "\n";
            str += "VALOR: " + e.getValor() + "\n";


            dadosEstoque.clear();
            dadosEstoque.setText(str);
        }
    }





    @FXML
    private void cancelar(){

        Main.voltaTelaPrincipal();
    }

}
