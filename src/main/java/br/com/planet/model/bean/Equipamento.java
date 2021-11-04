package br.com.planet.model.bean;

import br.com.planet.dao.EquipamentoDAO;
import br.com.planet.dao.ManutencaoDAO;
import br.com.planet.dao.ModeloDAO;
import br.com.planet.exception.DeleteViolationException;
import br.com.planet.exception.PatrimonioViolationException;
import br.com.planet.exception.SerialNumberViolationException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Equipamento implements Serializable {

    public static final String ZYXEL = "Zyxel";
    public static final String CHIMA = "Chima";
    public static final String SUMEC = "Sumec";
    public static final String NEXT_FIBER = "Next Fiber";
    public static final String DLINK = "D-link";
    public static final String HUAWEI_GPON = "Huawei GPON";
    public static final String HUAWEI_ECO = "Huawei EchoLife";
    public static final String TP_LINK = "Tp-Link WR840N";
    public static final String TP_LINK1 = "Tp-Link Archer C20";
    public static final String EASY_LINK = "Easy Link";
    public static final String MERCUSYS_ROUTER_AC12G = "Mercusys AC12G";
    public static final String ZYXEL_EMG5523  = "Zyxel EMG5523-T50B";
    public static final String UNKNOWN = "Unknown";

    @Id
    @Column(nullable = false)
    private String sn;

    @Column(nullable = false, length = 50)
    private String firmware;
    @Column(nullable = true, length = 10)
    private String patrimonio;

    @ManyToOne
    @JoinColumn(name = "modelo_id", nullable = true)
    private Modelo modelo;

    @Column()
    private boolean status;

    @Transient
    private int tipo;

    public Equipamento() {
    }

    public Equipamento(int tipo) {
        this.tipo = tipo;
    }

    public Equipamento(String modelo) {
        this.modelo.setNome(modelo);
    }

    public Equipamento(String sn, String modelo) {
        this.sn = sn;
        this.modelo.setNome(modelo);
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    /*  public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
     */
    @Override
    public String toString() {
        return "Equipamento{" + "sn=" + sn + ", modelo=" + modelo + ", firmware=" + firmware + '}';
    }

    public String getFirmware() {
        return firmware;
    }

    public void setFirmware(String firmware) {
        this.firmware = firmware;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo m) {
        this.modelo = m;
    }
    
    public void setModelo(String m){
        this.modelo = new ModeloDAO().buscar(m);
    }

    public static boolean salvar(Equipamento e) throws PatrimonioViolationException, SerialNumberViolationException {
        if (e.getSn().equals("")) {
            throw new SerialNumberViolationException("Serial Number não pode ser nulo");
        } else if (e.getModelo().getNome().equals("")) {

        } else if (e.getFirmware().equals("")) {
            e.setFirmware(Equipamento.UNKNOWN);
        }

        try {
            EquipamentoDAO dao = new EquipamentoDAO();

            Equipamento ee = dao.buscarPorPatrimonio(e.getPatrimonio());

            if (ee != null) {
                if (!ee.getSn().equals(e.getSn())) {
                    throw new PatrimonioViolationException("Esse patrimonio já foi cadastrado");
                }
            }
            ModeloDAO dao1 = new ModeloDAO();
            
            Modelo mm = dao1.buscar(e.getModelo().getNome());
            
            if (mm == null){
                System.out.println("é nulo");
                new ModeloDAO().salvar(e.getModelo());
            }
            
            dao.salvar(e);

            return true;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public static boolean editar(Equipamento e) throws PatrimonioViolationException, SerialNumberViolationException {
        if (e.getSn().equals("")) {
            throw new SerialNumberViolationException("Serial Number não pode ser nulo");
        } else if (e.getModelo().equals("")) {
            
        } else if (e.getFirmware().equals("")) {
            e.setFirmware(Equipamento.UNKNOWN);
        }

        try {
            EquipamentoDAO dao = new EquipamentoDAO();
            Equipamento ee = dao.buscarPorPatrimonio(e.getPatrimonio());

            if (ee != null) {
                if (!ee.getSn().equals(e.getSn())) {
                    throw new PatrimonioViolationException("Esse patrimonio já foi cadastrado");
                }
            }
            dao.salvar(e);
            return true;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public static int getQuantidadeDeEquipamentos(String nome) {
        List <Equipamento> retorno = new EquipamentoDAO().buscarPorModelo(new ModeloDAO().buscar(nome));
        
        if (retorno == null)
            return 0;
        else
            return retorno.size();
        
    }

    public static void deletar(Equipamento e) throws DeleteViolationException {
        ManutencaoDAO dao = new ManutencaoDAO();
        if (dao.listarPorEquipamento(e).isEmpty()) {
            new EquipamentoDAO().excluir(e);
        } else {
            throw new DeleteViolationException("");
        }
    }

    public static String[] getAllEquipaments() {

        String[] retorno = new String[]{Equipamento.CHIMA, Equipamento.DLINK, Equipamento.HUAWEI_ECO, Equipamento.HUAWEI_GPON, Equipamento.NEXT_FIBER, Equipamento.SUMEC, Equipamento.ZYXEL, Equipamento.TP_LINK, Equipamento.EASY_LINK, Equipamento.MERCUSYS_ROUTER_AC12G};

        return retorno;

    }

}
