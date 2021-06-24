package ifpr.pgua.eic.fluiserv.guias;

import ifpr.pgua.eic.fluiserv.Main;
import ifpr.pgua.eic.fluiserv.modelos.Cliente;
import ifpr.pgua.eic.fluiserv.modelos.Servico;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.ServicoRepository;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.sql.SQLException;

public class CadastrarServico {

    @FXML
    private Button btAdicionar;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfValor;

    @FXML
    private TextArea dadosServico;


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

        try {
            ltwServico.setItems(servicoRepository.lista());

        }catch (SQLException e){
            Alert alert = new Alert(Alert.AlertType.ERROR,e.getMessage());
            alert.showAndWait();
        }

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
                Main.mudaCena(Main.SERVICO, (aClass) -> new CadastrarServico(servicoRepository, servico));
            }

        }
    }


    @FXML
    public void adicionar() {
        String nome = tfNome.getText();
        double valor = Double.valueOf(tfValor.getText());
        if(nome.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Nome inválido!!");
            alert.showAndWait();
            return;
        }

        int cod = 0;
        Servico servico = new Servico(cod, nome, valor);

        try{
            if (servicoOriginal != null){
                servicoRepository.editar(servicoOriginal.getCod(), servico);
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"Dados do serviço alterado!!");
                alert.showAndWait();
            }else{
                servicoRepository.add(servico);
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"SERVIÇO CADASTRADO!!");
                alert.showAndWait();


            }
        }catch (SQLException e){
            Alert alert = new Alert(Alert.AlertType.ERROR,e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void atualizaDadosServico() {

        Servico s = (Servico) ltwServico.getSelectionModel().getSelectedItem();

        if (s != null) {
            String str = "";
            str += "Código  " + s.getCod() + "\n";
            str += "NOME: " + s.getNome() + "\n";
            str += "VALOR: " + s.getValor() + "\n";



            dadosServico.clear();
            dadosServico.setText(str);
        }
    }




    @FXML
    private void cancelar(){
        Main.voltaTelaPrincipal();

    }



}
