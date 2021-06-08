package ifpr.pgua.eic.fluiserv;


import ifpr.pgua.eic.fluiserv.guias.TelaPrincipal;
import ifpr.pgua.eic.fluiserv.interfaces.ClienteRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.security.cert.PolicyNode;


public class Main extends Application {

    public static final String PRINCIPAL = "/fxml/telaPrincipal.fxml";
    public static final String ADICIONARCLIENTE = "/fxml/adicionarClientes.fxml";
    private static PolicyNode base;


    private ClienteRepository clienteRepository;

    public static void main(String[] args) {


        Application.launch(args);
    }


    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource(PRINCIPAL));
        loader.setControllerFactory((aClass -> new TelaPrincipal()));

        Parent root = loader.load();

        Scene scene = new Scene(root, 400, 600);

        stage.setScene(scene);
        stage.setTitle("FLUISERV CLIMATIZAÇÃO");
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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}