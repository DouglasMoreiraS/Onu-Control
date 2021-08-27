package br.com.planet.control;

import br.com.planet.dao.EquipamentoDAO;
import br.com.planet.exception.DeleteViolationException;
import br.com.planet.exception.PatrimonioViolationException;
import br.com.planet.exception.SerialNumberViolationException;
import br.com.planet.model.bean.Equipamento;
import br.com.planet.model.bean.Modelo;
import br.com.planet.model.tablemodel.EquipamentoTableModel;
import br.com.planet.util.GraficoEquipamentos;
import br.com.planet.view.crud.EditarEquipamentoView;
import br.com.planet.view.crud.HistoricoView;
import java.awt.Frame;
import java.util.List;
import org.jfree.data.general.DefaultPieDataset;

public class EquipamentoControl {

    private List<Equipamento> equipamentoList;
    private Equipamento equipamentoSelecionado;
    private EquipamentoDAO dao;

    private EditarEquipamentoView viewEdita;

    private Modelo modelo;
    
    public EquipamentoControl() {
        dao = new EquipamentoDAO();
        equipamentoList = dao.listar();
        equipamentoSelecionado = new Equipamento();

    }

    public EquipamentoTableModel getTableModel() {
        return new EquipamentoTableModel(equipamentoList);
    }

    public void buscar(String[] busca, int status) {
        equipamentoList = dao.buscaEspecifica(busca, status);
    }

    public void editar(Frame parent) {
        viewEdita = new EditarEquipamentoView(null, true, this, 1);
        viewEdita.setVisible(true);

    }

    public void criar(Frame parent) {
        viewEdita = new EditarEquipamentoView(null, true, this, 0);
        viewEdita.setVisible(true);
    }

    public void setEquipamentoSelecionado(int selectedRow) {
        equipamentoSelecionado = equipamentoList.get(selectedRow);
    }

    public Equipamento getEquipamentoSelecionado() {
        return equipamentoSelecionado;
    }

    public void salvar(int key) throws PatrimonioViolationException, SerialNumberViolationException {
        if (key == 0) {
            if (dao.buscar(equipamentoSelecionado.getSn()) != null) {
                throw new SerialNumberViolationException("Patrimonio já cadastrado");
            }
            Equipamento.salvar(equipamentoSelecionado);
        } else if (key == 1) {
            Equipamento.editar(equipamentoSelecionado);
        }

        equipamentoSelecionado = new Equipamento();

        this.atualizarLista();
    }

    private void atualizarLista() {
        this.equipamentoList.clear();
        this.equipamentoList.addAll(dao.listar());
    }

    public void historico(Frame parent) {
        new HistoricoView(parent, true, equipamentoSelecionado.getModelo().getNome(),"", "", equipamentoSelecionado.getSn(), false).setVisible(true);
    }

    public boolean deletar() {
        try {
            Equipamento.deletar(equipamentoSelecionado);
            return true;
        } catch (DeleteViolationException e) {
            return false;
        }
    }

    public DefaultPieDataset getGrafico(String tipo) {
        
        switch (tipo){
            case "status" ->{
                return new GraficoEquipamentos().graficoStatus(equipamentoList);
            }
            
            case "patrimonio" ->{
                return new GraficoEquipamentos().graficoPatrimonio(equipamentoList);
            }
            
            case "firmware" ->{
                return new GraficoEquipamentos().graficoFirmware(equipamentoList);
            }
            default ->{
                return new GraficoEquipamentos().graficoContagem(equipamentoList);
            }
        }
        
        
    }

    public String[] getModelos() {
        String [] retorno;
        
        List <Modelo> m = Modelo.getListaDeModelos();
        
        retorno = new String [m.size()];
        
        for (int i=0;i<m.size();i++){
            retorno[i] = m.get(i).getNome();
        }
        return retorno;
    }

    public void salvarModelo(String m) throws Exception{
        modelo = new Modelo();
        modelo.setNome(m);
        Modelo.salvar(modelo);
    }

}
