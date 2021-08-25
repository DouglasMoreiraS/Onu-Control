package br.com.planet.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import br.com.planet.model.bean.Equipamento;
import br.com.planet.model.bean.Manutencao;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import br.com.planet.util.Utils;

public class ExportToExcel {

    private List<Equipamento> equipamentoList;

    private String path;

    public boolean ExportToHuawei(List<Manutencao> m, String path) throws Exception {

        try {

            FileOutputStream fileOut = new FileOutputStream(path +"//"+ "teste" + ".xlsx");

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet();

            for (Manutencao e : m) {
                Row row = sheet.createRow(sheet.getPhysicalNumberOfRows());

                Cell cellSN = row.createCell(0);
                Cell cellObs = row.createCell(1);
                cellSN.setCellValue(e.getEquipamento().getSn());
                cellObs.setCellValue(e.getObservacao());

            }

            workbook.write(fileOut);
            workbook.close();
            return true;
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado");
            ex.printStackTrace();
            throw new Exception("Arquivo não encontrado");
        } catch (IOException ex) {
            System.out.println("Erro ao salvar");
            throw new Exception("Erro ao salvar");
        }
    }
}
