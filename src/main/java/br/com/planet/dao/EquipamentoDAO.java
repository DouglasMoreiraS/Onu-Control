package br.com.planet.dao;

import java.util.List;
import br.com.planet.model.bean.Equipamento;
import br.com.planet.model.bean.Modelo;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import br.com.planet.util.HibernateUtil;
import javax.persistence.Query;
import org.hibernate.criterion.Order;

public class EquipamentoDAO extends GenericDAO<Equipamento> {
    
    public Equipamento buscar(String sn) {
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria consulta = sessao.createCriteria(Equipamento.class);
            consulta.add(Restrictions.idEq(sn));
            Equipamento resultado = (Equipamento) consulta.uniqueResult();
            return resultado;
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
        
    }
    
    public List<Equipamento> buscarPorModelo(Modelo modelo) {
        
        if (modelo == null){
            return null;
        }
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria query = sessao.createCriteria(Equipamento.class);
            
            query.createAlias("modelo", "id");
            
            query.add(Restrictions.eq("modelo.id", modelo.getId()));
            return query.list();
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
    
    public List<Equipamento> buscarPorSn(String sn) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria query = sessao.createCriteria(Equipamento.class);
            query.add(Restrictions.like("sn", sn, MatchMode.START));
            List<Equipamento> resultado = (List<Equipamento>) query.list();
            return resultado;
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
    }
    
    public Equipamento buscarPorPatrimonio(String patrimonio) {
        if (patrimonio.equals("")){
            return null;
        }
        
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria consulta = sessao.createCriteria(Equipamento.class);
            consulta.add(Restrictions.like("patrimonio", patrimonio));
            Equipamento resultado = (Equipamento) consulta.uniqueResult();
            return resultado;
        } catch (RuntimeException erro) {
            throw erro;
        } finally {
            sessao.close();
        }
        
    }
    
    public List<Equipamento> buscaEspecifica(String busca[], int status) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
      
        try {
            
            Criteria consulta = sessao.createCriteria(Equipamento.class);
            //Sn
            if (!busca[0].equals("")) {
                consulta.add(Restrictions.like("sn", busca[0], MatchMode.ANYWHERE));
            }
            //Modelo
            if (!busca[1].equals("")) {
                Modelo m = new ModeloDAO().buscar(busca[1]);
                
                consulta.createAlias("modelo", "id");
                
                consulta.add(Restrictions.eq("modelo.id", m.getId()));
            }
            //Firmware
            if (!busca[2].equals("")) {
                consulta.add(Restrictions.like("firmware", busca[2], MatchMode.ANYWHERE));
            }
            //Patrimonio
            if (!busca[3].equals("")) {
                consulta.add(Restrictions.like("patrimonio", busca[3], MatchMode.ANYWHERE));
            }
            
            switch (status){
                case 0: // todos
                    break;
            
                case 1: //apenas os ativos
                    consulta.add(Restrictions.eq("status", true));
                    break;
                    
                case 2: //apenas os desativados
                    consulta.add(Restrictions.eq("status", false));
                    break;
            }
            
            consulta.addOrder(Order.desc("id"));
            return consulta.list();
        } catch (RuntimeException e) {
            throw e;
        } finally {
            sessao.close();
        }
    }
    
    public List<String> firmwaresCadastrados(String equipamento){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try {
            
            String hql = "select distinct equipamento.firmware from equipamento where modelo.nome > :equipamento";
            Query query = sessao.createQuery(hql);
            
            query.setParameter("equipamento", equipamento);
            
            return query.getResultList();
            
            
            
            
        } catch (Exception e) {
        }
        
        return null;
    }
    
}
