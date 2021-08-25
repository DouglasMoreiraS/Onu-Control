package br.com.planet.control;

import br.com.planet.dao.EquipamentoDAO;
import br.com.planet.dao.ManutencaoDAO;
import br.com.planet.dao.ModeloDAO;
import br.com.planet.excel.ExportToExcel;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.ValidationException;
import br.com.planet.model.bean.Equipamento;
import br.com.planet.model.bean.Manutencao;
import br.com.planet.model.tablemodel.ManutencaoTableModel;
import br.com.planet.view.ExportaHistoricoExcelView;

public final class ExportaHistoricoExcelControl {

    List<Manutencao> mList;
    ManutencaoDAO dao;
    ManutencaoTableModel tableModel;
    ExportaHistoricoExcelView view;
    ExportToExcel excel;
    String[] equipamentos;

    public ExportaHistoricoExcelControl(Frame parent) {
        dao = new ManutencaoDAO();
        mList = dao.listar();
        tableModel = new ManutencaoTableModel(mList);
        view = new ExportaHistoricoExcelView(parent, true, this);
        view.getTblLista().setModel(tableModel);
        comboBoxNames();
        view.setVisible(true);
    }

    public void listarPorEquipamento() {
        String nome = view.getCbEquipamentos().getItemAt(view.getCbEquipamentos().getSelectedIndex());
        System.out.println(nome);
        EquipamentoDAO dao2 = new EquipamentoDAO();

        if (nome == "Todos") {
            mList.clear();
            mList = dao.listar();
        } else {
            List<Equipamento> eList = dao2.buscarPorModelo(new ModeloDAO().buscar(nome));
            mList.clear();
            for (Equipamento ee : eList) {
                mList.addAll(dao.listarPorEquipamento(ee));
            }
            }
        atualizaTableModel();
    }

    public void comboBoxNames() {
        view.getCbEquipamentos().addItem("Todos");
        equipamentos = new Equipamento().getAllEquipaments();
        for (String s : equipamentos) {
            view.getCbEquipamentos().addItem(s);
        }
    }

    public void atualizaTableModel() {
        tableModel = new ManutencaoTableModel(mList);
        view.getTblLista().setModel(tableModel);
    }

    public void exportaExcel(String path) throws ValidationException, Exception {
        List<Manutencao> export = new ArrayList();
        for (int i : view.getTblLista().getSelectedRows()) {
            export.add(mList.get(i));
        }

        if (export.isEmpty()) {
            throw new ValidationException("Nada foi selecionado");
        }

        excel = new ExportToExcel();
        excel.ExportToHuawei(export, path);
    }

}
