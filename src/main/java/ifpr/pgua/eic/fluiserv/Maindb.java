package ifpr.pgua.eic.fluiserv;

import ifpr.pgua.eic.fluiserv.db.Database;

import java.sql.SQLException;

public class Maindb {
    public static void main(String[] args) throws SQLException {

        Database db = new Database();

        db.conecta();
    }
}
