package br.com.planet.control;

import br.com.planet.dao.ManutencaoDAO;
import br.com.planet.excel.ExportToExcel;
import br.com.planet.model.bean.Manutencao;
import br.com.planet.model.bean.Modelo;
import br.com.planet.model.tablemodel.ManutencaoTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.TableModel;
import javax.xml.bind.ValidationException;

public class HistoricoControl {

    private List<Manutencao> historicoList;
    private Manutencao historicoSelecionado;
    private ManutencaoDAO dao;

    public HistoricoControl() {
        dao = new ManutencaoDAO();
        historicoList = dao.listar();
        historicoSelecionado = new Manutencao();
    }

    public void buscar(String[] busca, int filtro) {
        historicoList = dao.buscaEspecifica(busca, filtro);
    }

    public void setHistoricoSelecionado(int selectedRow) {
        historicoSelecionado = historicoList.get(selectedRow);
    }

    public Manutencao getHistoricoSelecionado() {
        return historicoSelecionado;
    }

    public void setHistoricoSelecionado(Manutencao historicoSelecionado) {
        this.historicoSelecionado = historicoSelecionado;
    }

    public TableModel getTableModel() {
        return new ManutencaoTableModel(historicoList);
    }

    private void atualizarLista() {
        this.historicoList.clear();
        this.historicoList.addAll(dao.listar());
    }

    public void exportarExcel(String path, int rows[]) throws ValidationException, Exception {
        List<Manutencao> export = new ArrayList();
        for (int i : rows) {
            export.add(historicoList.get(i));
        }

        if (export.isEmpty()) {
            throw new ValidationException("Não há registros selecionados");
        }

        ExportToExcel excel = new ExportToExcel();
        try {
            excel.Export(export, path);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public String[] getModelos() {
        String[] retorno;

        List<Modelo> m = Modelo.getListaDeModelos();

        retorno = new String[m.size()];

        for (int i = 0; i < m.size(); i++) {
            retorno[i] = m.get(i).getNome();
        }
        return retorno;
    }

}
