package ifpr.pgua.eic.fluiserv.repositories;

import ifpr.pgua.eic.fluiserv.modelos.Cliente;
import ifpr.pgua.eic.fluiserv.modelos.Estoque;
import ifpr.pgua.eic.fluiserv.modelos.OrdemServico;
import ifpr.pgua.eic.fluiserv.modelos.Servico;
import ifpr.pgua.eic.fluiserv.repositories.interfaces.OrdemServicoRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OrdemServicoRepositoryImpl implements OrdemServicoRepository {

    private ObservableList<OrdemServico> ordemServicos;
    private ObservableList<Servico> servicos;
    private ObservableList<Cliente> clientes;
    private ObservableList<Estoque> estoques;


    public OrdemServicoRepositoryImpl() {
        ordemServicos = FXCollections.observableArrayList();
        servicos = FXCollections.observableArrayList();
        clientes = FXCollections.observableArrayList();
        estoques = FXCollections.observableArrayList();


    }


    @Override
    public boolean add(OrdemServico ordemServico) {

        ordemServicos.add(ordemServico);

        return true;
    }

    @Override
    public boolean editar(int cod, OrdemServico ordemServico) {
        for(OrdemServico o:ordemServicos){
            if(o.getCod() == cod){
                o.setDescricaoDoServico(ordemServico.getDescricaoDoServico());
                o.setDescricaoAparelho(ordemServico.getDescricaoAparelho());
                o.setValorTotal(ordemServico.getValorTotal());
                o.setValorServico(ordemServico.getValorServico());
                o.setValorMaterial(ordemServico.getValorMaterial());
                o.setMarca(ordemServico.isMarca());
                o.setModelo(ordemServico.isModelo());
                o.setCliente(ordemServico.getCliente());
                o.setData(ordemServico.getData());


                return  true;
            }
        }
        return false;
    }





    @Override
    public ObservableList<OrdemServico> lista() {
        return FXCollections.unmodifiableObservableList(ordemServicos);

    }
}
