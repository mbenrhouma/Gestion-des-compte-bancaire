package metierr;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entites.Compte;

@Stateless(name="BK")
public class BanqueEJBImpl implements BanqueLocal,BanqueRemote {
   
	@PersistenceContext(unitName="BanqueEJB")
	private EntityManager em ;
   
   	@Override
	public Compte addCompte(Compte cp) {
		em.persist(cp);
		return cp;
	}

	@Override
	public Compte getCompte(Long code) {	
		Compte cp=em.find(Compte.class, code);
		if (cp==null) throw new RuntimeException("compte introuvable");
		return cp;
	}

	@Override
	public List<Compte> listCompte() {
	Query req = em.createQuery("select c from Compte c");
		return req.getResultList();
	}

	@Override
	public void verser(Long code, double mt) {
		 Compte cp=getCompte(code);
		 cp.setSolde(cp.getSolde()+mt);
		
	}

	@Override
	public void retirer(Long code, double mt) {
		Compte cp=getCompte(code);
		if(cp.getSolde()<mt) throw new RuntimeException("solde insuffisant");
		cp.setSolde(cp.getSolde()-mt);
		
	}

	@Override
	public void virement(Long cp1, Long cp2, double mt) {
		retirer(cp1,mt);
		verser(cp2,mt);
	}

}
