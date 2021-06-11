package ifpr.pgua.eic.fluiserv.repositories;

import ifpr.pgua.eic.fluiserv.repositories.interfaces.ClienteRepository;
import ifpr.pgua.eic.fluiserv.modelos.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


    public class ClienteRepositoryImpl implements ClienteRepository {

    private ObservableList<Cliente> clientes;


    public ClienteRepositoryImpl() {

        clientes = FXCollections.observableArrayList();
    }

    public boolean add(Cliente cliente) {

        clientes.add(new Cliente(cliente.getCpf_cnpj(), cliente.getNome(), cliente.getTelefone(), cliente.getEmail(), cliente.getEndereco(), cliente.getCidade()));

        return true;
    }

    public boolean editar(String cpf_cnpj, Cliente cliente){
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


    public ObservableList<Cliente> lista(){

        return FXCollections.unmodifiableObservableList(clientes);
    }


}
