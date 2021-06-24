package ifpr.pgua.eic.fluiserv.daos;

import ifpr.pgua.eic.fluiserv.daos.interfaces.ClienteDAO;
import ifpr.pgua.eic.fluiserv.modelos.Cliente;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCClienteDAO implements ClienteDAO {

    private static final String INSERT = "INSERT INTO cliente(cpf_cnpj, nome, email, telefone, endereco, cidade) VALUES (?,?,?,?,?,?)";
    private static final String LISTA = "SELECT * FROM cliente";


    @Override
    public boolean inserir(Cliente cliente) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto_integrador", "root", "");

          PreparedStatement preparedStatement = conn.prepareStatement(INSERT);

        preparedStatement.setString(1, cliente.getCpf_cnpj());
        preparedStatement.setString(2, cliente.getNome());
        preparedStatement.setString(3, cliente.getEmail());
        preparedStatement.setString(4, cliente.getTelefone());
        preparedStatement.setString(5, cliente.getEndereco());
        preparedStatement.setString(6, cliente.getCidade());

        int ret = preparedStatement.executeUpdate();

        preparedStatement.close();
        conn.close();

        return ret == 1;
    }

    @Override
    public boolean atualizar(Cliente cliente) throws SQLException {
        return false;
    }

    @Override
    public List<Cliente> lista() throws SQLException {
        ArrayList<Cliente> lista = new ArrayList<>();

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto_integrador", "root", "");


        PreparedStatement preparedStatement = conn.prepareStatement(LISTA);



        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {

            String cpf_cnpj = rs.getString("cpf_cnpj");
            String nome = rs.getString("nome");
            String email = rs.getString("email");
            String telefone = rs.getString("telefone");
            String endereco = rs.getString("endereco");
            String cidade = rs.getString("cidade");



            Cliente cliente = new Cliente(cpf_cnpj,nome,email,telefone,endereco,cidade);

            lista.add(cliente);
        }


            rs.close();
            preparedStatement.close();
            conn.close();

        return lista;
    }

    @Override
    public Cliente buscaCod(int cpf_cnpj) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(Cliente cliente) throws SQLException {
        return false;
    }

}
