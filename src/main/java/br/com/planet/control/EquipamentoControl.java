package br.com.planet.control;

import br.com.planet.dao.EquipamentoDAO;
import br.com.planet.excel.ExportToExcel;
import br.com.planet.exception.DeleteViolationException;
import br.com.planet.exception.PatrimonioViolationException;
import br.com.planet.exception.SerialNumberViolationException;
import br.com.planet.model.bean.Equipamento;
import br.com.planet.model.bean.Manutencao;
import br.com.planet.model.bean.Modelo;
import br.com.planet.model.tablemodel.EquipamentoTableModel;
import br.com.planet.util.GraficoEquipamentos;
import br.com.planet.view.crud.EditarEquipamentoView;
import br.com.planet.view.crud.HistoricoView;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.ValidationException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

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
        new HistoricoView(parent, true, equipamentoSelecionado.getModelo().getNome(), "", "", equipamentoSelecionado.getSn(), false).setVisible(true);
    }

    public boolean deletar() throws DeleteViolationException {
        try {
            Equipamento.deletar(equipamentoSelecionado);
            return true;
        } catch (DeleteViolationException e) {
            throw e;
        }
    }

    public JFreeChart getGrafico(String titulo) {

        JFreeChart retorno;

        switch (titulo) {
            case "status" -> {
                retorno = ChartFactory.createPieChart(titulo, new GraficoEquipamentos().graficoStatus(equipamentoList), false, true, false);
            }

            case "patrimonio" -> {
                retorno = ChartFactory.createPieChart(titulo, new GraficoEquipamentos().graficoPatrimonio(equipamentoList), false, true, false);
            }

            case "firmware" -> {
                retorno = ChartFactory.createPieChart(titulo, new GraficoEquipamentos().graficoFirmware(equipamentoList), false, true, false);

            }
            case "contagem" -> {
                retorno = ChartFactory.createPieChart(titulo, new GraficoEquipamentos().graficoContagem(equipamentoList), false, true, false);
            }

            default -> {
                DefaultCategoryDataset barDataSet = new DefaultCategoryDataset();
                
                Collections.sort(equipamentoList);
                
                for (String s : this.getModelos()) {

                    int quantidade = 0;

                    for (Equipamento e : equipamentoList) {
                        if (e.getModelo().getNome().equals(s)) {
                            quantidade++;
                        }
                    }
                    if (quantidade > 0) {
                        barDataSet.setValue(quantidade, "Equipamentos", s);
                        //   pieDataSet.setValue(s + "(" + quantidade + ")", quantidade);
                    }
                }
                retorno = ChartFactory.createBarChart("Ranking Equipamentos", "Equipamentos", "Quantidade", barDataSet, PlotOrientation.HORIZONTAL, true, false, false);
            }
        }
        return retorno;
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

    public void salvarModelo(String m) throws Exception {
        modelo = new Modelo();
        modelo.setNome(m);
        Modelo.salvar(modelo);
    }

    public void exportarExcel(String path, int rows[]) throws ValidationException, Exception {
        List<Equipamento> export = new ArrayList();
        for (int i : rows) {
            export.add(equipamentoList.get(i));
        }

        if (export.isEmpty()) {
            throw new ValidationException("Não há registros selecionados");
        }

        ExportToExcel excel = new ExportToExcel();
        try {
            excel.exportEquipamento(export, path);
        } catch (Exception ex) {
            throw ex;
        }
    }
}
