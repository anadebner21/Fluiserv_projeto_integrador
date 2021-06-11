package ifpr.pgua.eic.fluiserv.guias;

import ifpr.pgua.eic.fluiserv.Main;
import ifpr.pgua.eic.fluiserv.modelos.Cliente;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.ClienteRepository;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.EstoqueRepository;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class TelaPrincipal {
    @FXML

    private ClienteRepository clienteRepository;
    private  EstoqueRepository estoqueRepository;

    public TelaPrincipal(ClienteRepository clienteRepository, EstoqueRepository estoqueRepository) {
        this.clienteRepository = clienteRepository;
        this.estoqueRepository = estoqueRepository;
    }


    public void cadastrarCliente(){
        Main.mudaCena(Main.ADICIONARCLIENTE, (aClass)-> new CadastrarClientes(clienteRepository));
    }

    public void verClientes(){

        Main.mudaCena(Main.VERCLIENTE, (aClass)-> new VerClientes(clienteRepository));
    }
    public void  cadastrarEstoque(){
        Main.mudaCena(Main.ADICIONARESTOQUE, (aClass)-> new CadastraEstoque(estoqueRepository));
    }
    public void  verEstoque(){
        Main.mudaCena(Main.VERESTOQUE, (aClass)-> new VerEstoque(estoqueRepository));
    }

}

