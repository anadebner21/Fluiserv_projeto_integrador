package ifpr.pgua.eic.fluiserv.repositories;

import ifpr.pgua.eic.fluiserv.daos.interfaces.ClienteDAO;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.ClienteRepository;
import ifpr.pgua.eic.fluiserv.modelos.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;


public class ClienteRepositoryImpl implements ClienteRepository {

    private ObservableList<Cliente> clientes;
    private ClienteDAO clienteDAO;


    public ClienteRepositoryImpl(ClienteDAO clienteDAO) {

        clientes = FXCollections.observableArrayList();
        this.clienteDAO = clienteDAO;
    }

    public boolean add(Cliente cliente) throws SQLException {

        return clienteDAO.inserir(cliente);


    }

    public boolean editar(String cpf_cnpj, Cliente cliente) throws SQLException{
        for(Cliente c:clientes){
            if(c.getCpf_cnpj() == cpf_cnpj){
                c.setNome(cliente.getNome());
                c.setTelefone(cliente.getTelefone());
                c.setEmail(cliente.getEmail());
                c.setEndereco(cliente.getEndereco());
                c.setCidade(cliente.getCidade());

                return  true;
            }
        }
        return false;
    }


    public ObservableList<Cliente> lista() throws SQLException{
        clientes.clear();
        clientes.addAll(clienteDAO.lista());

        return FXCollections.unmodifiableObservableList(clientes);
    }


}
