package ifpr.pgua.eic.fluiserv;


import ifpr.pgua.eic.fluiserv.guias.Tela_Principal;
import ifpr.pgua.eic.fluiserv.interfaces.ClienteRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

import java.sql.SQLException;


public class Main extends Application {

    public static final String Tela_Principal = "/fxml/Tela_Principal.fxml";
    public static final String Adicionar_Clientes = "/fxml/Adicionar_Cliente.fxml";


    private static ClienteRepository clienteRepository;



    private static StackPane base;


    public static void main(String[] args) {


        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        base = new StackPane();


        stage.setScene(new Scene(base, Region.USE_PREF_SIZE, Region.USE_PREF_SIZE));
        stage.setTitle("FLUISEV CLIMATIZAÇÃO...");


        mudaCena(Main.Tela_Principal, principalCallback());


        //stage.setResizable(false);
        //stage.initStyle(StageStyle.UNDECORATED);
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

            //ja existe alguma coisa sendo mostrada, entao remover
            if (base.getChildren().stream().count() > 0) {
                base.getChildren().remove(0);
            }
            base.getChildren().add(novoRoot);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void voltaPrincipal() {
        mudaCena(Main.Tela_Principal, principalCallback());
    }

    private static Callback principalCallback() {
        return (aClass) -> new Tela_Principal();
    }

}
