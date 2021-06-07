package ifpr.pgua.eic.fluiserv.guias;

import javafx.scene.control.Alert;

public class Base {

    protected void mostraMensagem(Alert.AlertType icone, String mensagem){
        Alert alert = new Alert(icone,mensagem);
        alert.showAndWait();
    }

}
