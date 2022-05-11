package br.com.planet.model.tablemodel;

import br.com.planet.dao.ManutencaoDAO;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import br.com.planet.model.bean.Equipamento;

public class EquipamentoTableModel extends AbstractTableModel {

    private String colunas[] = {"Modelo", "Patrimonio", "Serial Number", "Firmware", "Status", "Registros"};
    private List<Equipamento> equipamento;
    private final int COLUNA_MODELO = 0;
    private final int COLUNA_PATRIMONIO = 1;
    private final int COLUNA_SN = 2;
    private final int COLUNA_FIRMWARE = 3;
    private final int COLUNA_STATUS = 4;
    private final int COLUNA_REGISTROS = 5;

    public EquipamentoTableModel(List<Equipamento> equipamento) {
        this.equipamento = equipamento;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int ColumnIndex) {
        return false;
    }

    @Override
    public int getRowCount() {
        return equipamento.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int indice) {
        return colunas[indice];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Equipamento m = this.equipamento.get(rowIndex);
        switch (columnIndex) {

            case COLUNA_MODELO -> {
                return m.getModelo().getNome();
            }
            case COLUNA_FIRMWARE -> {
                return m.getFirmware();
            }
            case COLUNA_PATRIMONIO -> {
                String p = "";
                if (!m.getPatrimonio().isEmpty()) {
                    p = "p";
                } 
                return p + m.getPatrimonio();
            }
            case COLUNA_SN -> {
                return m.getSn();
            }

            case COLUNA_STATUS -> {
                if (m.isStatus()) {
                    return "Ativo";
                } else {
                    return "Desativado";
                }
            }

            case COLUNA_REGISTROS -> {
                return new ManutencaoDAO().listarPorEquipamento(m).size();
            }
        }
        return null;
    }

    public Object getObjectSelected(int rowIndex) {
        return equipamento.get(rowIndex);
    }

}
