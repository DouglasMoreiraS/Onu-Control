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

public class ExportToExcel {

    private List<Equipamento> equipamentoList;

    private String path;

    public boolean exportManutencao(List<Manutencao> m, String path) throws Exception {

        try {

            FileOutputStream fileOut = new FileOutputStream(path +"//"+ "export(" + m.size() +")" + ".xlsx");

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet();

            for (Manutencao e : m) {
                Row row = sheet.createRow(sheet.getPhysicalNumberOfRows());

                Cell cellData = row.createCell(0);
                Cell cellModelo = row.createCell(1);
                Cell cellSn = row.createCell(2);
                Cell cellObs = row.createCell(3);
                Cell cellPon = row.createCell(4);

                cellData.setCellValue(e.getData());
                cellModelo.setCellValue(e.getEquipamento().getModelo().getNome());
                cellSn.setCellValue(e.getEquipamento().getSn());
                cellObs.setCellValue(e.getObservacao());
                cellPon.setCellValue(e.getPon());

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
    
    public boolean exportEquipamento(List<Equipamento> m, String path) throws Exception {

        try {

            FileOutputStream fileOut = new FileOutputStream(path +"//"+ "export(" + m.size() +")" + ".xlsx");

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet();

            for (Equipamento e : m) {
                Row row = sheet.createRow(sheet.getPhysicalNumberOfRows());

                Cell cellModelo = row.createCell(0);
                Cell cellPatrimonio = row.createCell(1);
                Cell cellSn = row.createCell(2);
                Cell cellFirmware = row.createCell(3);
                Cell cellStatus = row.createCell(4);

                cellModelo.setCellValue(e.getModelo().getNome());
                cellPatrimonio.setCellValue(e.getPatrimonio());
                cellSn.setCellValue(e.getSn());
                cellFirmware.setCellValue(e.getFirmware());
                cellStatus.setCellValue(e.isStatus());

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
