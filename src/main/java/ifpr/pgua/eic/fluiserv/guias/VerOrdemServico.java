package ifpr.pgua.eic.fluiserv.guias;

import ifpr.pgua.eic.fluiserv.Main;
import ifpr.pgua.eic.fluiserv.modelos.OrdemServico;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.ClienteRepository;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.EstoqueRepository;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.OrdemServicoRepository;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.ServicoRepository;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class VerOrdemServico {


    @FXML
    ListView<OrdemServico> ltwOrdemServico;

    @FXML
    private TextArea dadosOrdem;

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
                Main.mudaCena(Main.VERORDEMSERVICO, (aClass) -> new CadastrarOrdemServico(ordemServicoRepository, clienteRepository, servicoRepository, estoqueRepository, null));
            }

        }
    }

    @FXML
    private void atualizaDadosOrdem() {

        OrdemServico o = (OrdemServico) ltwOrdemServico.getSelectionModel().getSelectedItem();

        if (o != null) {
            String str = "";
            str += "CÓDIGO DA ORDEM:  " + o.getCod() + "\n";
            str += "DESCRIÇÃO DO SERVIÇO:  " + o.getDescricaoDoServico() + "\n";
            str += "DESCRIÇÃO DO APARELHO:  " + o.getDescricaoAparelho() + "\n";
            str += "VALOR SUBTOTAL: " + o.getValorServico() + o.getValorMaterial() + "\n";
            str += "CLIENTE: " + o.getCliente() + "\n";
            str += "MODELO DO APARELHO: " + (o.isModelo()? "ACJ":"SPLIT")+ (o.isModelo()? "PISO-TETO":"CASSETE")+"\n";
            str += "MARCA DO APARELHO: " + (o.isMarca()? "LG":"SPRINGER")+ (o.isMarca()? "ELGIN" : "CONSUL")+ (o.isMarca()? "ELECTROLUX":"KOMECO")+"\n";
            str += "DATA: " + o.getData() + "\n";




            dadosOrdem.clear();
            dadosOrdem.setText(str);
        }
    }



    @FXML
    private void cancelar(){

        Main.voltaTelaPrincipal();
    }

}
