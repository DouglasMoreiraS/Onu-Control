package br.com.planet.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import br.com.planet.model.bean.Equipamento;
import br.com.planet.model.bean.Manutencao;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import br.com.planet.controlers.Controle;
import br.com.planet.util.Utils;

public class DataBase {

    private static final String PATH2 = "C:\\Users\\PC_PLANET\\Documents\\GitHub\\OnuControl\\OnuControl\\src\\main\\java\\resources\\dba.xlsx";
    private static final String PATH = "C:\\Users\\PC_PLANET\\Desktop\\backup.xlsx";

    private static DataBase instancia = new DataBase();

    private DataBase() {

    }

    public void create() {

    }

    public static DataBase getInstance() {
        return instancia;
    }
/*
    public List<Equipamento> getListEquipamentos() {
        List<Equipamento> lista = new ArrayList<>();

        try {
            FileInputStream arquivo = new FileInputStream(new File(PATH));

            XSSFWorkbook workbook = new XSSFWorkbook(arquivo);

            for (int i = 0; i < 3; i++) {

                XSSFSheet sheet = workbook.getSheetAt(i);

                Iterator<Row> rowIterator = sheet.iterator();

                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();

                    Equipamento m = new Equipamento();

                    switch (i) {
                        case 0:
                            m.setTipo(Controle.ONU_TYPE);
                        case 1:
                            m.setTipo(Controle.ONT_TYPE);
                        case 2:
                            m.setTipo(Controle.ROUTER_TYPE);
                    }

                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();

                        switch (cell.getColumnIndex()) {

                            case 1 ->
                                m.setModelo(cell.getStringCellValue());

                            case 2 ->
                                m.setSn(cell.getStringCellValue());
                            case 7 ->
                                m.setFirmware(cell.getStringCellValue());
                        }
                    }

                    if (!lista.isEmpty()) {
                        int key = 0;

                        for (Equipamento e : lista) {
                            if (e.getSn().equals(m.getSn())) {
                                key = 1;
                                break;
                            }
                        }

                        if (key == 0) {
                            lista.add(m);
                        }
                    } else {
                        lista.add(m);
                    }
                    arquivo.close();
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo Excel não encontrado!");
        } catch (IOException ex) {
            System.out.println("Erro ao abrir arquivo");
        }
        return lista;

    }

    public List<Equipamento> getListEquipamentos(String busca) {
        List<Equipamento> lista = new ArrayList<>();

        try {
            FileInputStream arquivo = new FileInputStream(new File(PATH));

            XSSFWorkbook workbook = new XSSFWorkbook(arquivo);

            for (int i = 0; i < 3; i++) {

                XSSFSheet sheet = workbook.getSheetAt(i);

                Iterator<Row> rowIterator = sheet.iterator();

                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();

                    Equipamento m = new Equipamento();

                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();

                        switch (cell.getColumnIndex()) {

                            case 1 ->
                                m.setModelo(cell.getStringCellValue());

                            case 2 ->
                                m.setSn(cell.getStringCellValue());

                        }
                    }

                    int key = 0;

                    for (Equipamento e : lista) {
                        if (e.getSn().equals(m.getSn())) {
                            key = 1;
                            break;
                        }
                    }
                    if (key == 0) {
                        if ((m.getSn()).toLowerCase().contains((busca.toLowerCase())) || (m.getModelo().toLowerCase()).contains((busca.toLowerCase()))) {
                            lista.add(m);
                        }
                    }

                    arquivo.close();
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo Excel não encontrado!");
        } catch (IOException ex) {
            System.out.println("Erro ao abrir arquivo");
        }
        return lista;

    }

    public List<Manutencao> getList() {
        List<Manutencao> lista = new ArrayList<>();

        try {
            FileInputStream arquivo = new FileInputStream(new File(PATH));

            XSSFWorkbook workbook = new XSSFWorkbook(arquivo);

            for (int i = 0; i < 3; i++) {

                XSSFSheet sheet = workbook.getSheetAt(i);

                Iterator<Row> rowIterator = sheet.iterator();

                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();

                    Manutencao m = new Manutencao();
                    lista.add(m);

                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();

                        switch (cell.getColumnIndex()) {
                            case 0:
                                m.setData(cell.getStringCellValue());
                                break;

                            case 1:
                                m.getEquipamento().setModelo(cell.getStringCellValue());
                                break;

                            case 2:
                                m.getEquipamento().setSn(cell.getStringCellValue());
                                break;

                            case 3:
                                m.setObservacao(cell.getStringCellValue());
                                break;
                        }
                    }
                    arquivo.close();
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo Excel não encontrado!");
        } catch (IOException ex) {
            System.out.println("Erro ao abrir arquivo");
        }
        return lista;
    }

    public List<Manutencao> getList(Equipamento e) {
        List<Manutencao> lista = new ArrayList<>();

        try {
            FileInputStream arquivo = new FileInputStream(new File(PATH));

            XSSFWorkbook workbook = new XSSFWorkbook(arquivo);

            for (int i = 0; i < 3; i++) {

                XSSFSheet sheet = workbook.getSheetAt(i);

                Iterator<Row> rowIterator = sheet.iterator();

                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();

                    Manutencao m = new Manutencao();

                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();

                        switch (cell.getColumnIndex()) {
                            case 0:
                                m.setData(cell.getStringCellValue());

                            case 1:
                                m.getEquipamento().setModelo(cell.getStringCellValue());

                            case 2:
                                m.getEquipamento().setSn(cell.getStringCellValue());

                            case 3:
                                m.setObservacao(cell.getStringCellValue());
                                System.out.println(m.getObservacao());
                        }

                    }

                    if ((m.getEquipamento().getSn().toLowerCase()).contains((e.getSn().toLowerCase()))) {
                        lista.add(m);
                    }

                    arquivo.close();
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo Excel não encontrado!");
        } catch (IOException ex) {
            System.out.println("Erro ao abrir arquivo");
        }
        return lista;
    }

    public List<Manutencao> getList(String busca) {
        List<Manutencao> lista = new ArrayList<>();

        try {
            FileInputStream arquivo = new FileInputStream(new File(PATH));

            XSSFWorkbook workbook = new XSSFWorkbook(arquivo);

            for (int i = 0; i < 3; i++) {

                XSSFSheet sheet = workbook.getSheetAt(i);

                Iterator<Row> rowIterator = sheet.iterator();

                while (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();

                    Manutencao m = new Manutencao();

                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();

                        switch (cell.getColumnIndex()) {
                            case 0:
                                m.setData(cell.getStringCellValue());

                            case 1:
                                m.getEquipamento().setModelo(cell.getStringCellValue());

                            case 2:
                                m.getEquipamento().setSn(cell.getStringCellValue());

                            case 3:
                                m.setObservacao(cell.getStringCellValue());
                        }

                    }
                    if ((m.getEquipamento().getSn().toLowerCase()).contains((busca.toLowerCase()))) {
                        lista.add(m);
                    }
                    arquivo.close();
                }
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo Excel não encontrado!");
        } catch (IOException ex) {
            System.out.println("Erro ao abrir arquivo");
        }
        return lista;
    }

    public void editar(Manutencao m, int tipo) {

        try {
            FileInputStream arquivo = new FileInputStream(new File(PATH));

            XSSFWorkbook workbook = new XSSFWorkbook(arquivo);

            XSSFSheet sheet = workbook.getSheetAt(tipo);

            for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {

                Row row = sheet.getRow(i);
                Cell cellSn = row.getCell(2);
                if (cellSn.getStringCellValue().equals(m.getEquipamento().getSn())) {

                    Cell cellObs = row.createCell(3);
                    Cell cellFirmware = row.createCell(7);

                    cellObs.setCellValue(m.getObservacao());
                    cellFirmware.setCellValue(m.getEquipamento().getFirmware());
                    break;
                }
            }

            arquivo.close();
            FileOutputStream outFile = new FileOutputStream(new File(PATH));
            workbook.write(outFile);
            outFile.close();
            workbook.close();
            arquivo.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo Excel não encontrado!");
        } catch (IOException ex) {
            System.out.println("Erro ao abrir arquivo");
        }
    }

    public void salvar(List<Manutencao> mList) {

        try {

            FileOutputStream fileOut = new FileOutputStream(PATH);

            XSSFWorkbook workbook = new XSSFWorkbook();

            XSSFSheet sheet;

            sheet = workbook.createSheet();

            for (Manutencao m : mList) {
                Row row = sheet.createRow(sheet.getPhysicalNumberOfRows());

                Cell cellData = row.createCell(0);
                Cell cellModelo = row.createCell(1);
                Cell cellSN = row.createCell(2);
                Cell cellObs = row.createCell(3);
                Cell cellPon = row.createCell(4);
                Cell cellUpdate = row.createCell(5);
                Cell cellReset = row.createCell(6);
                Cell cellFirmware = row.createCell(7);
                Cell cellTipo = row.createCell(8);

                cellData.setCellValue(m.getData());
                cellModelo.setCellValue(m.getEquipamento().getModelo());
                cellSN.setCellValue(m.getEquipamento().getSn());
                cellObs.setCellValue(m.getObservacao());
//                cellPon.setCellValue(m.getEquipamento().getPon());
                cellFirmware.setCellValue(m.getEquipamento().getFirmware());
                cellTipo.setCellValue(m.getEquipamento().getTipo());
                if (m.isReset()) {
                    cellReset.setCellValue("true");
                } else {
                    cellReset.setCellValue("false");
                }

                if (m.isUpdate()) {
                    cellUpdate.setCellValue("true");
                } else {
                    cellUpdate.setCellValue("false");
                }

            }

            workbook.write(fileOut);
            workbook.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo não encontrado" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Erro ao salvar");
        }

    }

    public List<Manutencao> getList(String sn, int tipo) {

        List<Manutencao> lista = new ArrayList<>();

        try {
            FileInputStream arquivo = new FileInputStream(new File(PATH));

            XSSFWorkbook workbook = new XSSFWorkbook(arquivo);

            XSSFSheet sheet = workbook.getSheetAt(tipo);

            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                Manutencao m = new Manutencao();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    switch (cell.getColumnIndex()) {
                        case 0:
                            m.setData(cell.getStringCellValue());

                        case 1:
                            m.getEquipamento().setModelo(cell.getStringCellValue());

                        case 2:
                            m.getEquipamento().setSn(cell.getStringCellValue());

                        case 3:
                            m.setObservacao(cell.getStringCellValue());
                    }

                }
                if ((m.getEquipamento().getSn().toLowerCase()).contains((sn.toLowerCase()))) {
                    lista.add(m);
                }
                arquivo.close();
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo Excel não encontrado!");
        } catch (IOException ex) {
            System.out.println("Erro ao abrir arquivo");
        }
        return lista;
    }

    public List<Manutencao> getList(int tipo) {

        List<Manutencao> lista = new ArrayList<>();

        try {
            FileInputStream arquivo = new FileInputStream(new File(PATH));

            XSSFWorkbook workbook = new XSSFWorkbook(arquivo);

            XSSFSheet sheet = workbook.getSheetAt(tipo);

            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                Manutencao m = new Manutencao();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    switch (cell.getColumnIndex()) {
                        case 0:
                            m.setData(cell.getStringCellValue());

                        case 1:
                            m.getEquipamento().setModelo(cell.getStringCellValue());

                        case 2:
                            m.getEquipamento().setSn(cell.getStringCellValue());

                        case 3:
                            m.setObservacao(cell.getStringCellValue());
                    }

                }
                lista.add(m);
                arquivo.close();
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo Excel não encontrado!");
        } catch (IOException ex) {
            System.out.println("Erro ao abrir arquivo");
        }
        return lista;
    }

   List<Manutencao> restore() throws FileNotFoundException, IOException {
        
        List<Manutencao> lista = new ArrayList<>();
        
        FileInputStream arquivo = new FileInputStream(new File(PATH));

        XSSFWorkbook workbook = new XSSFWorkbook(arquivo);

        XSSFSheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();

            Manutencao m = new Manutencao();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                /*  Cell cellData = row.createCell(0);
                Cell cellModelo = row.createCell(1);
                Cell cellSN = row.createCell(2);
                Cell cellObs = row.createCell(3);
                Cell cellPon = row.createCell(4);
                Cell cellUpdate = row.createCell(5);
                Cell cellReset = row.createCell(6);
                Cell cellFirmware = row.createCell(7);
                Cell cellTipo = row.createCell(8);
                 
                switch (cell.getColumnIndex()) {
                    case 0:
                        m.setData(cell.getStringCellValue());

                    case 1:
                        m.getEquipamento().setModelo(cell.getStringCellValue());

                    case 2:
                        m.getEquipamento().setSn(cell.getStringCellValue());

                    case 3:
                        m.setObservacao(cell.getStringCellValue());

                    case 4:
                        m.setPon(cell.getStringCellValue());

                    case 7:
                        m.getEquipamento().setFirmware(cell.getStringCellValue());

                }
               
            }
            lista.add(m);
            arquivo.close();
        }
        return lista;
    }*/
}
