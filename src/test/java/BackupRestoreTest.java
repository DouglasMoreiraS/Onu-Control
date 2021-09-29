
import br.com.planet.dao.EquipamentoDAO;
import br.com.planet.dao.ManutencaoDAO;
import br.com.planet.dao.ModeloDAO;
import br.com.planet.model.bean.Equipamento;
import br.com.planet.model.bean.Manutencao;
import br.com.planet.model.bean.Modelo;
import br.com.planet.util.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.apache.poi.ss.usermodel.Row;

public class BackupRestoreTest {

    //@Test
    public void backup() {

        FileOutputStream fileOut = null;
        try {
            String data = Utils.getAtualDate();
            data = data.replaceAll("/", "-");
            data = data.replaceAll(" ", "-");
            data = data.replaceAll(":", "-");

            fileOut = new FileOutputStream("C:\\Users\\PC_PLANET\\Documents\\GitHub\\OnuControl2.0\\target\\backup" + data + ".xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook();

            XSSFSheet sheetModelo;
            XSSFSheet sheetEquip;
            XSSFSheet sheetRegistro;

            sheetModelo = workbook.createSheet("modelos");
            sheetEquip = workbook.createSheet("equipamentos");
            sheetRegistro = workbook.createSheet("Registros");

            List<Modelo> modelos = new ModeloDAO().listar();
            List<Equipamento> equips = new EquipamentoDAO().listar();
            List<Manutencao> registros = new ManutencaoDAO().listar();

            for (Modelo m : modelos) {
                Row row = sheetModelo.createRow(sheetModelo.getPhysicalNumberOfRows());

                Cell cellId = row.createCell(0);
                Cell cellNome = row.createCell(1);

                cellId.setCellValue(m.getId());
                cellNome.setCellValue(m.getNome());
            }

            for (Equipamento e : equips) {
                Row row = sheetEquip.createRow(sheetEquip.getPhysicalNumberOfRows());

                Cell cellId = row.createCell(0);
                Cell cellModelo = row.createCell(1);
                Cell cellFirmware = row.createCell(2);
                Cell cellPatrimonio = row.createCell(3);
                Cell cellStatus = row.createCell(4);

                cellId.setCellValue(e.getSn());
                cellModelo.setCellValue(e.getModelo().getId());
                cellFirmware.setCellValue(e.getFirmware());
                cellPatrimonio.setCellValue(e.getPatrimonio());

                if (e.isStatus()) {
                    cellStatus.setCellValue(1);
                } else {
                    cellStatus.setCellValue(0);
                }
            }

            for (Manutencao m : registros) {
                Row row = sheetRegistro.createRow(sheetRegistro.getPhysicalNumberOfRows());

                Cell cellId = row.createCell(0);
                Cell cellData = row.createCell(1);
                Cell cellEquip = row.createCell(2);
                Cell cellObs = row.createCell(3);
                Cell cellPon = row.createCell(4);

                cellId.setCellValue(m.getId());
                cellData.setCellValue(m.getData());
                cellEquip.setCellValue(m.getEquipamento().getSn());
                cellObs.setCellValue(m.getObservacao());
                cellPon.setCellValue(m.getPon());

            }

            workbook.write(fileOut);
            workbook.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(BackupRestoreTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BackupRestoreTest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileOut.close();
            } catch (IOException ex) {
                Logger.getLogger(BackupRestoreTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Test
    public void restore() {

        FileInputStream arquivo = null;
        try {
            String path = "C:\\Users\\PC_PLANET\\Documents\\GitHub\\OnuControl2.0\\target\\backup29-09-2021-11-24-20.xlsx";
            arquivo = new FileInputStream(new File(path));
            XSSFWorkbook workbook = new XSSFWorkbook(arquivo);

            XSSFSheet sheetModelo = workbook.getSheet("modelos");
            XSSFSheet sheetEquip = workbook.getSheet("equipamentos");
            XSSFSheet sheetRegistros = workbook.getSheet("registros");

            List<Modelo> modeloList = new ArrayList<>();
            List<Equipamento> equipList = new ArrayList<>();
            List<Manutencao> registrosList = new ArrayList<>();

            Iterator<Row> rowIterator = sheetModelo.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                Modelo m = new Modelo();

                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();

                    switch (cell.getColumnIndex()) {
                        case 0 ->
                            m.setId((int) cell.getNumericCellValue());
                        case 1 ->
                            m.setNome(cell.getStringCellValue());
                    }

                }
                modeloList.add(m);
            }

            rowIterator = sheetEquip.rowIterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                Equipamento e = new Equipamento();

                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();

                    switch (cell.getColumnIndex()) {

                        case 0 ->
                            e.setSn(cell.getStringCellValue());

                        case 1 -> {
                            int id = (int) cell.getNumericCellValue();

                            for (Modelo m : modeloList) {
                                if (m.getId() == id) {
                                    e.setModelo(m);
                                    break;
                                }
                            }
                        }

                        case 2 -> {
                            e.setFirmware(cell.getStringCellValue());
                        }

                        case 3 -> {
                            e.setPatrimonio(cell.getStringCellValue());
                        }

                        case 4 -> {
                            int status = (int) (cell.getNumericCellValue());

                            if (status == 0) {
                                e.setStatus(false);
                            } else {
                                e.setStatus(true);
                            }

                        }
                    }

                }
                equipList.add(e);
            }

            rowIterator = sheetRegistros.rowIterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                Manutencao m = new Manutencao();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    switch (cell.getColumnIndex()) {
                        case 0 ->
                            m.setId((int) cell.getNumericCellValue());

                        case 1 ->
                            m.setData(cell.getStringCellValue());

                        case 2 -> {
                            String sn = cell.getStringCellValue();

                            for (Equipamento e : equipList) {
                                if (e.getSn().equals(sn)) {
                                    m.setEquipamento(e);
                                    break;
                                }
                            }
                        }

                        case 4 ->
                            m.setObservacao(cell.getStringCellValue());

                        case 5 ->
                            m.setPon(cell.getStringCellValue());
                    }
                }
                registrosList.add(m);
            }

            int count = 1;
            System.out.println("MODELOS: " + modeloList.size());
            System.out.println("Qt | id | Nome");
            for (Modelo m : modeloList) {
                System.out.println(count + "- " + m.getId() + " " + m.getNome());
                count++;
            }

            count = 1;
            System.out.println("\n******************\n");
            System.out.println("Equipamentos: " + equipList.size());
            System.out.println("Qt | Sn | Modelo | Firmware | Patrimonio | Status");
            for (Equipamento m : equipList) {
                System.out.println(count + "- " + m.getSn() + " " + m.getModelo().getNome() + " " + m.getFirmware() + " " + m.getPatrimonio() + " " + m.isStatus());
                count++;
            }
            count = 1;
            System.out.println("\n******************\n");
            System.out.println("Registros: " + registrosList.size());
            System.out.println("Qt | Id | Data | Equipamento | Obs | Pon");
            for (Manutencao m : registrosList) {
                System.out.println(count + "- " + m.getId() + " " + m.getData() + " " + m.getEquipamento().getModelo().getNome() + " " + m.getObservacao() + " " + m.getPon());
                count++;
            }

            System.out.println("MODELOS: " + modeloList.size());
            System.out.println("Equipamentos: " + equipList.size());
            System.out.println("Registros: " + registrosList.size());

            arquivo.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(BackupRestoreTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BackupRestoreTest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                arquivo.close();
            } catch (IOException ex) {
                Logger.getLogger(BackupRestoreTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
