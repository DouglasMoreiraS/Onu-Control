package br.com.planet.model.bean;

import br.com.planet.dao.ManutencaoDAO;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Manutencao implements Serializable {
    
    @Id
    @GeneratedValue
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "equipamento_id", nullable = false)
    private Equipamento equipamento;
    @Column(nullable = false)
    private String data;
    @Column(nullable = true, length = 100)
    private String observacao;
    @Column(nullable = true, length = 50)
    private String pon;
    
    @Transient
    private boolean update;
    @Transient
    private boolean reset;

    public Manutencao() {
        equipamento = new Equipamento();
    }

    public Manutencao(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public boolean isReset() {
        return reset;
    }

    public void setReset(boolean reset) {
        this.reset = reset;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPon() {
        return pon;
    }

    public void setPon(String pon) {
        this.pon = pon;
    }
    
    @Override
    public String toString() {
        return "Manutencao{" + "equipamento=" + equipamento.toString() + ", data=" + data + ", observacao=" + observacao + '}';
    }

    public void excluir(Manutencao m) throws Exception {
        try{
        ManutencaoDAO dao = new ManutencaoDAO();
        dao.excluir(m);
        } catch (Exception e){
            throw new Exception(e);
        }
    }

    public static void salvar(Manutencao m) {
        ManutencaoDAO dao = new ManutencaoDAO();
        dao.salvar(m);
    }


}
