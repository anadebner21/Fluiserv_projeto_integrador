package ifpr.pgua.eic.fluiserv.guias;

import ifpr.pgua.eic.fluiserv.Main;
import ifpr.pgua.eic.fluiserv.modelos.Estoque;
import ifpr.pgua.eic.fluiserv.modelos.OrdemServico;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.ClienteRepository;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.EstoqueRepository;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.OrdemServicoRepository;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.ServicoRepository;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class VerOrdemServico {


    @FXML
    ListView<OrdemServico> ltwOrdemServico;

    private OrdemServicoRepository ordemServicoRepository;
    private ClienteRepository clienteRepository;
    private ServicoRepository servicoRepository;
    private EstoqueRepository estoqueRepository;

    public VerOrdemServico(OrdemServicoRepository ordemServicoRepository) {

        this.ordemServicoRepository = ordemServicoRepository;
    }
    @FXML
    private void initialize() {

        ltwOrdemServico.setCellFactory(new Callback<ListView<OrdemServico>, ListCell<OrdemServico>>() {

            @Override
            public ListCell<OrdemServico> call(ListView<OrdemServico> ordemServicoListView) {
                return new ListCell<>(){

                    @Override
                    protected void updateItem(OrdemServico ordemServico, boolean b) {
                        super.updateItem(ordemServico, b);

                        if (ordemServico != null) {
                            setText(ordemServico.getDescricaoDoServico());
                        } else {
                            setText("");
                        }

                    }
                };
            }
        });


        ltwOrdemServico.setItems(ordemServicoRepository.lista());

    }
    @FXML
    public void editarOrdemServico(MouseEvent evt) {
        if (evt.getClickCount() == 2) {

            OrdemServico ordemServico = ltwOrdemServico.getSelectionModel().getSelectedItem();
            if (ordemServico != null) {
                Main.mudaCena(Main.VERORDEMSERVICO, (aClass) -> new CadastrarOrdemServico(ordemServicoRepository, clienteRepository, servicoRepository, estoqueRepository));
            }

        }
    }



    @FXML
    private void cancelar(){

        Main.voltaTelaPrincipal();
    }

}
