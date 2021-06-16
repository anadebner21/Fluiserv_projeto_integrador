package ifpr.pgua.eic.fluiserv.guias;

import ifpr.pgua.eic.fluiserv.Main;
import ifpr.pgua.eic.fluiserv.modelos.Servico;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.ServicoRepository;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class CadastrarServico {

    @FXML
    private Button btAdicionar;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfValor;

    private ServicoRepository servicoRepository;
    private Servico servicoOriginal;

    @FXML
    ListView<Servico> ltwServico;


    public CadastrarServico(ServicoRepository servicoRepository, Servico servico){
        this.servicoRepository = servicoRepository;
        this.servicoOriginal = servico;
    }


    public CadastrarServico(ServicoRepository servicoRepository) {

        this(servicoRepository, null);
    }

    @FXML
    private void initialize(){

        ltwServico.setCellFactory(new Callback <ListView<Servico>, ListCell<Servico>>() {
            @Override
            public ListCell<Servico> call(ListView<Servico> servicoListView) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(Servico servico, boolean b) {
                        super.updateItem(servico, b);

                        if (servico != null) {
                            setText(servico.getNome());
                        } else {
                            setText("");
                        }

                    }
                };
            }
        });
        ltwServico.setItems(servicoRepository.lista());

        if(servicoOriginal != null) {

            tfNome.setText(servicoOriginal.getNome());
            tfValor.setText(String.valueOf(Double.valueOf(servicoOriginal.getValor())));

            btAdicionar.setText("Alterar");
        }



        }
    @FXML
    public void editarServico(MouseEvent evt) {
        if (evt.getClickCount() == 2) {

            Servico servico = ltwServico.getSelectionModel().getSelectedItem();
            if (servico != null) {
                Main.mudaCena(Main.SERVICO, (aClass) -> new CadastrarServico(servicoRepository));
            }

        }
    }


    @FXML
    public void adicionar() {
        String nome = tfNome.getText();
        double valor = -1;

        try {
            Double.valueOf(tfValor.getText());
        }catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Valor inválido!!");
            alert.showAndWait();
            return;
        }
        if(nome.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Nome inválido!!");
            alert.showAndWait();
            return;
        }


        Servico servico = new Servico(nome, valor);


        if (servicoOriginal != null){
            servicoRepository.editar(servicoOriginal.getCod(), servico);
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"Dados do cliente alterado!!");
            alert.showAndWait();
        }else{
            servicoRepository.add(servico);
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"SERVIÇO CADASTRADO!!");
            alert.showAndWait();


        }
    }

    @FXML
    private void cancelar(){
        Main.voltaTelaPrincipal();

    }



}
