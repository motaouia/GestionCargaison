package service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import entities.Cargaison;
import entities.CargaisonAerienne;
import entities.CargaisonRoutiere;
import entities.Marchandise;
import metier.ITranportLocal;

@Stateless
@WebService
public class TransportSOAPService {
	
	@EJB
	private ITranportLocal metier;

	@WebMethod
	public Cargaison addCaraisonRoutiere(@WebParam(name="referenceCargaison")String refCargiason,//
									    @WebParam(name="distance")double distance,//
										@WebParam(name="dateLivraison")Date dateLivraison,//
										@WebParam(name="temperatureConservation")double temperatureConservation) {
		
		return metier.addCragaison(new CargaisonRoutiere(refCargiason, distance, dateLivraison, temperatureConservation));
	}
	
	@WebMethod
	public Cargaison addCargaisonAerienne(@WebParam(name="referenceCargaison")String referenceCargaison,
											@WebParam(name="distance")double distance,
											@WebParam(name="dateLivraison")Date dateLivraison,
											@WebParam(name="poidsMax")double poidsMax) {
		
		return metier.addCragaison(new CargaisonAerienne(referenceCargaison, distance, dateLivraison, poidsMax));
	}
	
	@WebMethod
	public Marchandise addMarchandise(@WebParam(name="nomMarchandise")String nomMarchandise,
			@WebParam(name="poidsMarchandise")double poidsMarchandise,
			@WebParam(name="volumeMarchandise")double volumeMarchandise,
			@WebParam(name="referenceCargaison")String refCargaison) {
		return metier.addMarchandise(new Marchandise(nomMarchandise, poidsMarchandise, volumeMarchandise), refCargaison);
	}

	@WebMethod
	public List<Cargaison> listAllCargaison() {
		return metier.listAllCargaison();
	}
	
	@WebMethod
	public List<Marchandise> listMarchandiseParCargaison(@WebParam(name="referenceCargaison")String refCargaison) {
		return metier.listMarchandiseParCargaison(refCargaison);
	}

	@WebMethod
	public List<Marchandise> listMarchandiseParMC(@WebParam(name="MotCle")String motCle) {
		return metier.listMarchandiseParMC(motCle);
	}
	
	@WebMethod
	public void deleteMarchandise(@WebParam(name="numeroMarchandise")Long numMarchandise) {
		metier.deleteMarchandise(numMarchandise);
	}
	
}