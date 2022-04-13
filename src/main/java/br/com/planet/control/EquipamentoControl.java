package br.com.planet.control;

import br.com.planet.dao.EquipamentoDAO;
import br.com.planet.dao.ManutencaoDAO;
import br.com.planet.dao.ModeloDAO;
import br.com.planet.excel.ExportToExcel;
import br.com.planet.exception.DeleteViolationException;
import br.com.planet.exception.PatrimonioViolationException;
import br.com.planet.exception.SerialNumberViolationException;
import br.com.planet.model.bean.Equipamento;
import br.com.planet.model.bean.Modelo;
import br.com.planet.model.tablemodel.EquipamentoTableModel;
import br.com.planet.model.tablemodel.ManutencaoTableModel;
import br.com.planet.util.GraficoEquipamentos;
import br.com.planet.view.crud.EditarEquipamentoView;
import br.com.planet.view.crud.HistoricoView;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.table.TableModel;
import javax.xml.bind.ValidationException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class EquipamentoControl {

    private List<Equipamento> equipamentos;
    private List<Modelo> modelos;

    private Equipamento equipamentoSelecionado;

    private EquipamentoDAO eqDao;
    private ModeloDAO mDao;

    private EditarEquipamentoView viewEdita;

    private Modelo modelo;

    public EquipamentoControl() {
        eqDao = new EquipamentoDAO();
        mDao = new ModeloDAO();

        equipamentos = eqDao.listar();
        modelos = mDao.listar();

        equipamentoSelecionado = new Equipamento();
    }

    public EquipamentoTableModel getTableModel() {
        return new EquipamentoTableModel(equipamentos);
    }

    public void buscar(String[] busca, int status) {
        equipamentos = eqDao.buscaEspecifica(busca, status);
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
        equipamentoSelecionado = equipamentos.get(selectedRow);
    }

    public Equipamento getEquipamentoSelecionado() {
        return equipamentoSelecionado;
    }

    public void salvar(int key) throws PatrimonioViolationException, SerialNumberViolationException {
        if (key == 0) {
            if (eqDao.buscar(equipamentoSelecionado.getSn()) != null) {
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
        this.equipamentos.clear();
        this.equipamentos.addAll(eqDao.listar());
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
        GraficoEquipamentos grafico = new GraficoEquipamentos(equipamentos);

        switch (titulo) {
            case "status" -> {
                retorno = ChartFactory.createPieChart(titulo, grafico.graficoStatus(), false, true, false);
            }

            case "patrimonio" -> {
                retorno = ChartFactory.createPieChart(titulo, grafico.graficoPatrimonio(), false, true, false);
            }

            case "firmware" -> {
                retorno = ChartFactory.createPieChart(titulo, grafico.graficoFirmware(), false, true, false);
            }

            case "contagem" -> {
                retorno = ChartFactory.createPieChart(titulo, grafico.graficoContagem(), true, true, true);
            }

            default -> {
                DefaultCategoryDataset barDataSet = new DefaultCategoryDataset();

                Collections.sort(equipamentos);

                modelos.forEach(s -> {
                    int quantidade = 0;

                    for (Equipamento e : equipamentos) {
                        if (e.getModelo().getNome().equals(s)) {
                            quantidade++;
                        }
                    }

                    if (quantidade > 0) {
                        barDataSet.setValue(quantidade, "Equipamentos", s.getNome());
                        //   pieDataSet.setValue(s + "(" + quantidade + ")", quantidade);
                    }

                });
                retorno = ChartFactory.createBarChart("Ranking Equipamentos", "Equipamentos", "Quantidade", barDataSet, PlotOrientation.HORIZONTAL, true, false, false);
            }
        }
        return retorno;
    }

    public List<Modelo> getModelos() {
        return modelos;
    }

    public void salvarModelo(String m) throws Exception {
        modelo = new Modelo();
        modelo.setNome(m);
        Modelo.salvar(modelo);
    }

    public void exportarExcel(String path, int rows[]) throws ValidationException, Exception {
        List<Equipamento> export = new ArrayList();
        for (int i : rows) {
            export.add(equipamentos.get(i));
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

    public TableModel getHistoricoTableModel() {
        return new ManutencaoTableModel(new ManutencaoDAO().listarPorEquipamento(equipamentoSelecionado));
    }

    public void setModelo(int index) {
        if (index >= 0){
            equipamentoSelecionado.setModelo(modelos.get(index));
        }
    }
}
