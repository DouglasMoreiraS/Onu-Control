package br.com.planet.model.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Firmware implements Serializable {
    
    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String version;
    @Column (nullable = false, length = 250)
    private String caminho;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String path) {
        this.caminho = path;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    
}
