package ifpr.pgua.eic.fluiserv.daos;

import ifpr.pgua.eic.fluiserv.daos.interfaces.EstoqueDAO;
import ifpr.pgua.eic.fluiserv.modelos.Cliente;
import ifpr.pgua.eic.fluiserv.modelos.Estoque;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCEstoqueDAO implements EstoqueDAO {

    private static final String INSERT = "INSERT INTO estoque(nome, descricao, quantidade, valor) VALUES (?,?,?,?)";
    private static final String LISTA = "SELECT * FROM estoque";
    private static final String UPDATE = "UPDATE estoque set nome=?, descricao=?, quantidade=?, valor=? where cod=?";


    @Override
    public boolean inserir(Estoque estoque) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto_integrador", "root", "");

        PreparedStatement preparedStatement = conn.prepareStatement(INSERT);

        preparedStatement.setString(1, estoque.getNome());
        preparedStatement.setString(2, estoque.getDescricao());
        preparedStatement.setInt(3, estoque.getQuantidade());
        preparedStatement.setDouble(4, estoque.getValor());

        int ret = preparedStatement.executeUpdate();

        preparedStatement.close();
        conn.close();

        return ret == 1;
    }

    @Override
    public boolean atualizar(int cod,Estoque estoque) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto_integrador", "root", "");

        PreparedStatement preparedStatement = conn.prepareStatement(UPDATE);


        preparedStatement.setString(1, estoque.getNome());
        preparedStatement.setString(2, estoque.getDescricao());
        preparedStatement.setInt(3, estoque.getQuantidade());
        preparedStatement.setDouble(4, estoque.getValor());
        preparedStatement.setInt(5,cod);



        int ret = preparedStatement.executeUpdate();

        preparedStatement.close();
        conn.close();
        return ret == 1;

    }

    @Override
    public List<Estoque> lista() throws SQLException {
        ArrayList<Estoque> lista = new ArrayList<>();

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto_integrador", "root", "");



        PreparedStatement pstmt = conn.prepareStatement(LISTA);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            int cod = rs.getInt("cod");
            String nome = rs.getString("nome");
            String descricao = rs.getString("descricao");
            int quantidade = rs.getInt("quantidade");
            double valor = rs.getDouble("valor");


            Estoque estoque = new Estoque(cod,nome, descricao, quantidade,  valor);

            lista.add(estoque);
        }


        rs.close();
        pstmt.close();
        conn.close();

        return lista;

    }

    @Override
    public Estoque buscaCod(int cod) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(Estoque estoque) throws SQLException {
        return false;
    }
}
