package br.com.planet.model.bean;

import br.com.planet.dao.ModeloDAO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Modelo implements Serializable {

    
    public static final String ZYXEL = "Zyxel";
    public static final String CHIMA = "Chima";
    public static final String SUMEC = "Sumec";
    public static final String NEXT_FIBER = "Next Fiber";
    public static final String DLINK = "D-link DIR-842";
    public static final String HUAWEI_GPON = "Huawei GPON";
    public static final String HUAWEI_ECO = "Huawei EchoLife";
    public static final String TP_LINK = "Tp-Link WR840N";
    public static final String TP_LINK1 = "Tp-Link Archer C20";
    public static final String EASY_LINK = "Easy Link";
    public static final String MERCUSYS_ROUTER_AC12G = "Mercusys AC12G";
    public static final String ZYXEL_EMG5523  = "Zyxel EMG5523-T50B";
    
    public static List<Modelo> getListaDeModelos() {
        return new ModeloDAO().listar();
    }
    
    public static void salvar(Modelo modelo) throws Exception {

        ModeloDAO dao = new ModeloDAO();

        if (dao.buscar(modelo.getNome()) != null) {
            System.out.println(dao.buscar(modelo.getNome()));
            throw new Exception("Equipamento já existe no sistema");
        }

        dao.salvar(modelo);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    public Modelo (){
        
    }
    
    public Modelo (String nome){
        this.nome = nome;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
