package ifpr.pgua.eic.fluiserv;

import ifpr.pgua.eic.fluiserv.db.Database;
import ifpr.pgua.eic.fluiserv.modelos.Cliente;

import java.sql.SQLException;
import java.util.List;

public class Maindb {
    public static void main(String[] args) throws SQLException {

        Database db = new Database();

        db.conecta();
    }

}
