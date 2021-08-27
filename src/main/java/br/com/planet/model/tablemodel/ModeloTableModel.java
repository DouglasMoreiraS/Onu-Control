package br.com.planet.model.tablemodel;

import br.com.planet.dao.EquipamentoDAO;
import br.com.planet.model.bean.Modelo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTableModel extends AbstractTableModel{

    private String colunas[] = {"Nome", "Cadastrados"}; 
    
    private List<Modelo> modelos;
    
    private final int COLUNA_NOME = 0;
    private final int COLUNA_CADASTRADOS = 1;
    
    public ModeloTableModel(List<Modelo> modelos){
        this.modelos = modelos;
    }
    
    @Override
    public int getRowCount() {
        return modelos.size();
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
        Modelo m = this.modelos.get(rowIndex);
        
        switch (columnIndex){
            case COLUNA_NOME ->{
                return m.getNome();
            }
            
            case COLUNA_CADASTRADOS -> {
                return new EquipamentoDAO().buscarPorModelo(m).size();
            }
        }
        return null;
    }
    
}
