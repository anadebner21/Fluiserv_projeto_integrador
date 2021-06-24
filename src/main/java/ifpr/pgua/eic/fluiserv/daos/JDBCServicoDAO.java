package ifpr.pgua.eic.fluiserv.daos;

import ifpr.pgua.eic.fluiserv.daos.interfaces.ServicoDAO;
import ifpr.pgua.eic.fluiserv.modelos.Estoque;
import ifpr.pgua.eic.fluiserv.modelos.Servico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCServicoDAO implements ServicoDAO {
    private static final String INSERT = "INSERT INTO servico(nome, valor) VALUES (?,?)";
    private static final String LISTA = "SELECT * FROM servico";
    private static final String UPDATE = "UPDATE servico set nome=?, valor=? where cod=?";


    @Override
    public boolean inserir(Servico servico) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto_integrador", "root", "");

        PreparedStatement preparedStatement = conn.prepareStatement(INSERT);

        preparedStatement.setString(1, servico.getNome());
        preparedStatement.setDouble(2, servico.getValor());

        int ret = preparedStatement.executeUpdate();

        preparedStatement.close();
        conn.close();

        return ret == 1;
    }

    @Override
    public boolean atualizar(int cod, Servico servico) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto_integrador", "root", "");

        PreparedStatement preparedStatement = conn.prepareStatement(UPDATE);


        preparedStatement.setString(1, servico.getNome());
        preparedStatement.setDouble(2, servico.getValor());
        preparedStatement.setInt(3,cod);



        int ret = preparedStatement.executeUpdate();

        preparedStatement.close();
        conn.close();
        return ret == 1;

    }

    @Override
    public List<Servico> lista() throws SQLException {
        ArrayList<Servico> lista = new ArrayList<>();

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto_integrador", "root", "");



        PreparedStatement pstmt = conn.prepareStatement(LISTA);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            int cod = rs.getInt("cod");
            String nome = rs.getString("nome");
            double valor = rs.getDouble("valor");


            Servico servico = new Servico(cod,nome, valor);

            lista.add(servico);
        }


        rs.close();
        pstmt.close();
        conn.close();

        return lista;

    }

    @Override
    public Servico buscaCod(int cod) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(Servico servico) throws SQLException {
        return false;
    }
}
