package ifpr.pgua.eic.fluiserv.repositories;

import ifpr.pgua.eic.fluiserv.modelos.Cliente;

import java.util.ArrayList;

public class ClienteRepository implements ifpr.pgua.eic.fluiserv.interfaces.ClienteRepository {

    private ArrayList<Cliente> clientes;

    public ClienteRepository() {
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
