package metier;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Cargaison;
import entities.Marchandise;

@Stateless(name="TRSPRT_EJB")
public class TranspotImplEJB implements ITranportLocal {
	
	@PersistenceContext(name="UP_GestionCargaison")
	private EntityManager entityManager;

	@Override
	public Cargaison addCragaison(Cargaison cargaison) {
		entityManager.persist(cargaison);
		return cargaison;
	}

	@Override
	public Marchandise addMarchandise(Marchandise marchandise, String refCargaison) {
		Cargaison cargaison = entityManager.find(Cargaison.class, refCargaison);
		if(cargaison == null) {
			throw new RuntimeException("Cargaison dont la reference est : "+ refCargaison + " est Introuvable");
		} 
		else {
			marchandise.setCargaison(cargaison);
			entityManager.persist(marchandise);
		}
		return marchandise;
	}

	@Override
	public List<Cargaison> listAllCargaison() {
		Query requestAllCargaison = entityManager.createQuery("select c from Cargaison c");
		return (List<Cargaison>)requestAllCargaison.getResultList();
	}

	@Override
	public List<Marchandise> listMarchandiseParCargaison(String refCargaison) {
		Query requestlistMarchandiseParCargaison = entityManager.createQuery("select m from Marchandise m where m.cargaison.referenceCargaison=:x");
		requestlistMarchandiseParCargaison.setParameter("x", refCargaison);
		return (List<Marchandise>)requestlistMarchandiseParCargaison.getResultList();
	}

	@Override
	public List<Marchandise> listMarchandiseParMC(String motCle) {
		Query requestlistMarchandiseParMC = entityManager.createQuery("select m from Marchandise m where m.nomMarchandise like :x");
		requestlistMarchandiseParMC.setParameter("x", "%" + motCle + "%");
		return (List<Marchandise>)requestlistMarchandiseParMC.getResultList();
	}

	@Override
	public void deleteMarchandise(Long numMarchandise) {
		Marchandise marchandise = entityManager.find(Marchandise.class, numMarchandise);
		if(marchandise == null) {
			throw new RuntimeException("Marchandise dont le numero est : "+ numMarchandise + " est Introuvable");
		}
		else {
			entityManager.remove(marchandise);
		}
	}

}
