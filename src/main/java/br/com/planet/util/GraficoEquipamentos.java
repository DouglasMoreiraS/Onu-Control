package br.com.planet.util;

import br.com.planet.model.bean.Equipamento;
import java.util.ArrayList;
import java.util.List;
import org.jfree.data.general.DefaultPieDataset;

public class GraficoEquipamentos {

    List<Equipamento> lista;

    public GraficoEquipamentos(List<Equipamento> lista) {
        this.lista = lista;
    }

    public DefaultPieDataset graficoFirmware() {
        DefaultPieDataset pieDataSet = new DefaultPieDataset();
        List<String> firmwares = new ArrayList<>();

        for (Equipamento e : lista) {
            String firmwareAtual = e.getFirmware();

            if (!firmwares.contains(firmwareAtual)) {
                firmwares.add(firmwareAtual);

                int contador = 0;
                for (int i = 0; i < lista.size(); i++) {

                    if (lista.get(i).getFirmware().equals(firmwareAtual)) {
                        contador++;
                    }
                }
                pieDataSet.setValue(firmwareAtual + "\n( " + contador + " )", contador);
            }
        }
        return pieDataSet;
    }

    public DefaultPieDataset graficoStatus() {

        DefaultPieDataset pieDataSet = new DefaultPieDataset();

        int contadorPar = 0;
        int contadorImpar = 0;

        for (Equipamento e : lista) {
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

    public DefaultPieDataset graficoPatrimonio() {
        DefaultPieDataset pieDataSet = new DefaultPieDataset();

        int contadorPar = 0;
        int contadorImpar = 0;

        for (Equipamento e : lista) {
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

    public DefaultPieDataset graficoContagem() {
        DefaultPieDataset pieDataSet = new DefaultPieDataset();
        List<String> equip = new ArrayList<>();

        for (Equipamento e : lista) {
            String equipAtual = e.getModelo().getNome();

            if (!equip.contains(equipAtual)) {
                
                equip.add(equipAtual);

                int contador = 0;
                for (int i = 0; i < lista.size(); i++) {
                    if (lista.get(i).getModelo().getNome().equals(equipAtual)) {
                        contador++;
                    }
                }

                pieDataSet.setValue(equipAtual, contador);
            }
        }
        return pieDataSet;
    }

}
