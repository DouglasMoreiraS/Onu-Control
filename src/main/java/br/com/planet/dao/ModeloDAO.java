package br.com.planet.dao;

import br.com.planet.model.bean.Modelo;
import br.com.planet.util.hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class ModeloDAO extends GenericDAO<Modelo> {

    public Modelo buscar(String nome) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria consulta = sessao.createCriteria(Modelo.class);
            consulta.add(Restrictions.eq("nome", nome));
            System.out.println(nome);
            Modelo resultado = (Modelo) consulta.uniqueResult();
            return resultado;
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }

    }
    public List<Modelo> buscaEspecifica(String nome) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria consulta = sessao.createCriteria(Modelo.class);
            consulta.add(Restrictions.eq("nome", nome));
            return consulta.list();
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }

    }

}
