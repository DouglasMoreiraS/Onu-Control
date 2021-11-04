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
