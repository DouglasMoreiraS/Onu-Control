package br.com.planet.model.tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import br.com.planet.model.bean.Equipamento;
import br.com.planet.model.bean.Manutencao;

public class RemoteAcessTableModel extends AbstractTableModel{

    private String colunas[] = {"Data"};
    private List<Manutencao> equipamento;
    private final int COLUNA_DATA = 0;

    public RemoteAcessTableModel(List<Manutencao> equipamento) {
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
    
        Manutencao m = this.equipamento.get(rowIndex);
        
        switch (columnIndex){
            case COLUNA_DATA ->{
                return m.getData();
            }
            
        }
       return null;
    }
        
    public Object getObjectSelected(int rowIndex){
        return equipamento.get(rowIndex);
    }
    
}
