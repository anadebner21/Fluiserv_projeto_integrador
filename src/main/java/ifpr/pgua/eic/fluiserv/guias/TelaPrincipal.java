package ifpr.pgua.eic.fluiserv.guias;

import ifpr.pgua.eic.fluiserv.Main;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.ClienteRepository;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.EstoqueRepository;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.OrdemServicoRepository;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.ServicoRepository;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class TelaPrincipal {
    @FXML

    private ClienteRepository clienteRepository;
    private  EstoqueRepository estoqueRepository;
    private ServicoRepository servicoRepository;
    private OrdemServicoRepository ordemServicoRepository;

    public TelaPrincipal(ClienteRepository clienteRepository, EstoqueRepository estoqueRepository, ServicoRepository servicoRepository, OrdemServicoRepository ordemServicoRepository) {
        this.clienteRepository = clienteRepository;
        this.estoqueRepository = estoqueRepository;
        this.servicoRepository = servicoRepository;
        this.ordemServicoRepository = ordemServicoRepository;
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

    public void cadastarServico(){
        Main.mudaCena(Main.SERVICO, (aClass)-> new CadastrarServico(servicoRepository));
    }

    public void  verEstoque(){

        Main.mudaCena(Main.VERESTOQUE, (aClass)-> new VerEstoque(estoqueRepository));
    }
    public void cadastrarOrdemServico(){
        Main.mudaCena(Main.ORDEMSERVICO, (aClass)-> new CadastrarOrdemServico(ordemServicoRepository, clienteRepository, servicoRepository, estoqueRepository, null));
    }
    public void verOrdemServico(){
        Main.mudaCena(Main.VERORDEMSERVICO, (aClass)-> new VerOrdemServico(ordemServicoRepository));
    }

}

