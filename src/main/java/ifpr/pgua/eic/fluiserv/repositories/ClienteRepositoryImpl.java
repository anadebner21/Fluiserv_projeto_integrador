package ifpr.pgua.eic.fluiserv.repositories;

import ifpr.pgua.eic.fluiserv.interfaces.ClienteRepository;
import ifpr.pgua.eic.fluiserv.modelos.Cliente;

import java.util.ArrayList;

public class ClienteRepositoryImpl implements ClienteRepository {

    private ArrayList<Cliente> clientes;

    public ClienteRepositoryImpl() {

        clientes = new ArrayList<>();
    }

    public boolean add(Cliente cliente) {
        clientes.add(cliente);
        return true;
    }

    public boolean editar(int cpf_cnpj, Cliente cliente) {
        return true;
    }
}
