package br.com.planet.dao;

import java.util.List;
import br.com.planet.model.bean.Equipamento;
import br.com.planet.model.bean.Manutencao;
import br.com.planet.model.bean.Modelo;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import br.com.planet.util.HibernateUtil;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;

public class ManutencaoDAO extends GenericDAO<Manutencao> {

    public List<Manutencao> listarPorEquipamento(Equipamento e) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            Criteria consulta = sessao.createCriteria(Manutencao.class);
            consulta.add(Restrictions.eq("equipamento.sn", e.getSn()));
            List<Manutencao> resultado = (List<Manutencao>) consulta.list();
            return resultado;
        } catch (Exception ex) {
            throw ex;
        } finally {
            sessao.close();
        }
    }

    public List<Manutencao> buscaEspecifica(String[] busca, int filtro) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            Criteria consulta = sessao.createCriteria(Manutencao.class);
           
            consulta.createAlias("equipamento", "e");
            
            
            //Modelo
            if (!busca[0].equals("")) {
                Modelo m = new ModeloDAO().buscar(busca[0]);
                
                consulta.createAlias("e.modelo", "id");
                
                consulta.add(Restrictions.eq("e.modelo.id", m.getId()));
            }
            //Data
            if (!busca[1].equals("")) {
                consulta.add(Restrictions.like("data", busca[1], MatchMode.ANYWHERE));
            }
            //Observacao
            if (!busca[2].equals("")) {
                consulta.add(Restrictions.like("observacao", busca[2], MatchMode.ANYWHERE));
            }
            
            if (!busca[3].equals("")){
                consulta.add(Restrictions.like("e.sn", busca[3], MatchMode.ANYWHERE));
            }

            consulta.addOrder(Order.desc("id"));
            List<Manutencao> retorno = consulta.list();

            if (!retorno.isEmpty() && filtro == 1) {

                List<Manutencao> manList = new ArrayList<>();

                for (int i = 0; i < retorno.size(); i++) {
                    int key = 0;
                    Equipamento e = retorno.get(i).getEquipamento();

                    for (int j = 0; j < manList.size(); j++) {
                        if (manList.get(j).getEquipamento().equals(e)) {
                            key = 1;
                            break;
                        }
                    }
                    if (key == 0) {
                        manList.add(retorno.get(i));
                    }
                }
                return manList;
            }

            return retorno;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            sessao.close();
        }

    }
}
