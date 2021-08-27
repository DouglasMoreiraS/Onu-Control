package br.com.planet.control;

import br.com.planet.dao.ModeloDAO;
import br.com.planet.model.bean.Modelo;
import br.com.planet.model.tablemodel.ModeloTableModel;
import br.com.planet.view.crud.EquipamentoView;
import java.awt.Frame;
import java.util.List;

public class ModeloControl {

    private List<Modelo> modeloList;
    private Modelo modeloSelecionado;
    private ModeloDAO dao;

    public ModeloControl() {

        dao = new ModeloDAO();
        modeloList = dao.listar();
        modeloSelecionado = new Modelo();
    }

    public ModeloTableModel getTableModel() {
        return new ModeloTableModel(modeloList);
    }

    public void buscar(String busca) {
        modeloList = dao.buscaEspecifica(busca);
    }

    public void setModeloSelecionado(int selectedRow) {
        modeloSelecionado = modeloList.get(selectedRow);
    }

    public Modelo getModeloSelecionado() {
        return modeloSelecionado;
    }

    public void salvar() throws Exception {
        if (modeloSelecionado.getNome() != null) {
            Modelo.salvar(modeloSelecionado);
        }
        modeloSelecionado = new Modelo();
        
        this.atualizarLista();
    }
    
    public void equipamentoList(Frame parent){
        new EquipamentoView (parent, true, modeloSelecionado.getNome());
    }
    
    public boolean deletar(){
        return true;
    }
    
    private void atualizarLista(){
        this.modeloList.clear();
        this.modeloList.addAll(dao.listar());
    }
    
}
        