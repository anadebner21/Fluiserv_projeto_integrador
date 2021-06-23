package ifpr.pgua.eic.fluiserv.db;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    public void conecta() throws SQLException {

        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto_integrador", "root", "");
            System.out.println("Conectou...");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
