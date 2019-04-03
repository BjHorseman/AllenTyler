/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import entity.Citation;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author zxd170230
 */
@Stateless
public class TylerEJB {
@PersistenceContext(unitName = "tylerPU")
    private EntityManager em;
    //presist the object
    public void persist(Object object) {
        em.persist(object);
    }
      public List<Citation> findAllCases()
    {
        return em.createNamedQuery("Citation.findAll", Citation.class).getResultList(); 
    }
    public List<Citation> getCaseByName(String firstName, String lastName)
    {
        return em.createNamedQuery("Citation.findByName", Citation.class).setParameter("lastName", lastName)
                .setParameter("firstName", firstName)
                .getResultList();
    }   
    public List<Citation> getCaseByBusiness(String businessName)
    {
        return em.createNamedQuery("Citation.findByBusinessName", Citation.class)
                .setParameter("businessName", businessName)
                .getResultList();
    }
    public List<Citation> getCaseByCitation(String citationNumber)
    {
        return em.createNamedQuery("Citation.findByCitation", Citation.class)
                .setParameter("citationNumber", citationNumber)
                .getResultList();
    }

    public List<Citation> getCaseByCaseNumber(String caseNumber)
    {
        return em.createNamedQuery("Citation.findByCaseNumber", Citation.class)
                .setParameter("caseNumber", caseNumber)
                .getResultList();
    }
}
