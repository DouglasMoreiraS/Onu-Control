package ViewTest;

import br.com.planet.dao.EquipamentoDAO;
import br.com.planet.dao.ModeloDAO;
import br.com.planet.model.bean.Equipamento;
import java.util.List;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.Test;

public class GraficoTeste extends JFrame {

    public GraficoTeste() {
        super("Grafico Teste");

        DefaultPieDataset pieDataSet = new DefaultPieDataset();
        
        for (String s : Equipamento.getAllEquipaments())
            pieDataSet.setValue(s, new EquipamentoDAO().buscarPorModelo(new ModeloDAO().buscar(s)).size());
        

        JFreeChart grafico = ChartFactory.createPieChart("Titulo", pieDataSet, true, true, false);

        this.add(new ChartPanel(grafico));

        this.pack();
    }

    @Test
    public void teste() {
        new GraficoTeste().setVisible(true);
        while (true){}
    }

}
