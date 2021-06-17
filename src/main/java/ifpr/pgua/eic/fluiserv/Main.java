package ifpr.pgua.eic.fluiserv;


import ifpr.pgua.eic.fluiserv.guias.CadastrarClientes;
import ifpr.pgua.eic.fluiserv.guias.TelaPrincipal;
import ifpr.pgua.eic.fluiserv.repositories.EstoqueRepositoryimpl;
import ifpr.pgua.eic.fluiserv.repositories.OrdemServicoRepositoryImpl;
import ifpr.pgua.eic.fluiserv.repositories.ServicoRepositoryimpl;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.ClienteRepository;
import ifpr.pgua.eic.fluiserv.repositories.ClienteRepositoryImpl;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.EstoqueRepository;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.OrdemServicoRepository;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.ServicoRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;


public class Main extends Application {

    public static final String PRINCIPAL = "/fxml/telaPrincipal.fxml";
    public static final String ADICIONARCLIENTE = "/fxml/cadastrarClientes.fxml";
    public static final String VERCLIENTE = "/fxml/verClientes.fxml";
    public static final String ADICIONARESTOQUE = "/fxml/estoque.fxml";
    public static  final String VERESTOQUE = "/fxml/verEstoque.fxml";
    public static final  String SERVICO = "/fxml/servico.fxml";
    public static final String ORDEMSERVICO = "/fxml/cadastrarOrdemServico.fxml";
    public static final String VERORDEMSERVICO = "/fxml/verOrdemServico.fxml";


    private static  ClienteRepository clienteRepository;
    private  static EstoqueRepository estoqueRepository;
    private static ServicoRepository servicoRepository;
    private static OrdemServicoRepository ordemServicoRepository;


    public static StackPane base;


    public static void main(String[] args) {


        Application.launch(args);
    }


    @Override
    public void init() throws Exception {
        super.init();


        clienteRepository = new ClienteRepositoryImpl();
        estoqueRepository = new EstoqueRepositoryimpl();
        servicoRepository = new ServicoRepositoryimpl();
        ordemServicoRepository = new OrdemServicoRepositoryImpl();


    }

    @Override
    public void start(Stage stage) throws Exception {

        base = new StackPane();

        stage.setScene(new Scene(base, Region.USE_PREF_SIZE, Region.USE_PREF_SIZE));
        stage.setTitle("FLUISERV CLIMATIZAÇÃO");

        mudaCena(Main.PRINCIPAL, telaPrincipalCallback());


        stage.show();

    }


    @Override
    public void stop() throws Exception {
        super.stop();

    }


    public static void mudaCena(String fxml, Callback controllerFactory) {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource(fxml));
            loader.setControllerFactory(controllerFactory);

            Parent novoRoot = loader.load();


            if (base.getChildren().stream().count()>0){
                base.getChildren().remove(0);
            }
            base.getChildren().add(novoRoot);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static  void voltaTelaPrincipal(){
        mudaCena(Main.PRINCIPAL, telaPrincipalCallback());
    }

    private static  Callback telaPrincipalCallback() {
        return  (aClass)-> new TelaPrincipal(clienteRepository, estoqueRepository, servicoRepository, ordemServicoRepository);
    }

}