package br.com.planet.model.tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import br.com.planet.model.bean.Manutencao;

/**
 *
 * @author PC_PLANET
 */
public class ExportManutencaoTableModel extends AbstractTableModel{
    
    private String colunas[] = {"Selecione", "Data", "Modelo", "Serial Number", "Observação", "Pon Status"};
    private List<Manutencao> man;
    private final int COLUNA_DATA = 1;
    private final int COLUNA_MODELO = 2;
    private final int COLUNA_SN = 3;
    private final int COLUNA_OBS = 4;
    private final int COLUNA_PON = 5;

    public ExportManutencaoTableModel(List<Manutencao> man) {
        this.man = man;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int ColumnIndex){
        return false;
    }
    
    @Override
    public int getRowCount() {
         return man.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int indice){
        return colunas[indice];
    }
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Manutencao m = this.man.get(rowIndex);
        switch (columnIndex){
            case COLUNA_DATA -> {
                return m.getData();
            }
            case COLUNA_MODELO -> {
                return m.getEquipamento().getModelo();
            }
            case COLUNA_SN -> {
                return m.getEquipamento().getSn();
            }
            
            case COLUNA_OBS ->{
                return m.getObservacao();
            }
            
            case COLUNA_PON ->{
                return m.getPon();
            }
        }
        return null;
    }
    
}
