package br.com.planet.util;

import br.com.planet.model.bean.Equipamento;
import java.util.ArrayList;
import java.util.List;
import org.jfree.data.general.DefaultPieDataset;

public class GraficoEquipamentos {

    public DefaultPieDataset graficoFirmware(List<Equipamento> eqList) {
        DefaultPieDataset pieDataSet = new DefaultPieDataset();
        List<String> firmwares = new ArrayList<>();

        for (Equipamento e : eqList) {
            String firmwareAtual = e.getFirmware();

            if (!firmwares.contains(firmwareAtual)) {
                firmwares.add(firmwareAtual);

                int contador = 0;
                for (int i = 0; i < eqList.size(); i++) {

                    if (eqList.get(i).getFirmware().equals(firmwareAtual)) {
                        contador++;
                    }
                }
                pieDataSet.setValue(firmwareAtual + "\n( " + contador + " )", contador);
            }
        }
        return pieDataSet;
    }

    public DefaultPieDataset graficoStatus(List<Equipamento> eqList) {

        DefaultPieDataset pieDataSet = new DefaultPieDataset();

        int contadorPar = 0;
        int contadorImpar = 0;

        for (Equipamento e : eqList) {
            if (e.isStatus()) {
                contadorPar++;
            } else {
                contadorImpar++;
            }
        }
        pieDataSet.setValue("Ativos\n( " + contadorPar + " )", contadorPar);
        pieDataSet.setValue("Desativados\n( " + contadorImpar + " )", contadorImpar);

        return pieDataSet;

    }

    public DefaultPieDataset graficoPatrimonio(List<Equipamento> eqList) {
        DefaultPieDataset pieDataSet = new DefaultPieDataset();

        int contadorPar = 0;
        int contadorImpar = 0;

        for (Equipamento e : eqList) {
            if (e.getPatrimonio() != null) {

                if (e.getPatrimonio().equals("")) {
                    contadorImpar++;
                } else {
                    contadorPar++;
                }
            } else {
                contadorImpar++;
            }
        }
        pieDataSet.setValue("Patrimonio Cadastrado\n( " + contadorPar + " )", contadorPar);
        pieDataSet.setValue("Sem Patrimonio\n( " + contadorImpar + " )", contadorImpar);

        return pieDataSet;
    }

    public DefaultPieDataset graficoContagem(List<Equipamento> equipamentoList) {
        DefaultPieDataset p = new DefaultPieDataset();
        p.setValue("Equipamentos\n(" + equipamentoList.size() + ")", equipamentoList.size());
        return p;
    }

}
