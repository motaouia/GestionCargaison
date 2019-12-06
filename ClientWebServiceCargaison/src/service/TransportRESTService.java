package service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import entities.Cargaison;
import entities.CargaisonAerienne;
import entities.CargaisonRoutiere;
import entities.Marchandise;
import metier.ITranportLocal;

@Stateless
@Path("/transport")
public class TransportRESTService {

	@EJB
	private ITranportLocal metier;

	@GET
	@Path("/addCargRout/{refCarg}/{distance}/{dateLiv}/{temp}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cargaison addCargaisonRoutiere(@PathParam(value="refCarg")String refCarg,
			@PathParam(value="distance")double distance,
			@PathParam(value="dateLiv")Date dateLiv,
			@PathParam(value="temp")double temp) {
		return metier.addCragaison(new CargaisonRoutiere(refCarg, distance, dateLiv, temp));
	}
	
	@GET
	@Path("/addCargAerienne/{refCarg}/{distance}/{dateLiv}/{poidsMax}")
	@Produces(MediaType.APPLICATION_JSON)
	public Cargaison addCargaisonAerienne(@PathParam(value="refCarg")String refCarg,
			@PathParam(value="distance")double distance,
			@PathParam(value="dateLiv")Date dateLiv,
			@PathParam(value="poidsMax")double poidsMax) {
		return metier.addCragaison(new CargaisonAerienne(refCarg, distance, dateLiv, poidsMax));
	}
	
	@GET
	@Path("/addCargAerienne/{refCarg}/{distance}/{dateLiv}/{poidsMax}")
	@Produces(MediaType.APPLICATION_JSON)
	public Marchandise addMarchandise(@PathParam(value="nomMarch")String nom,
			@PathParam(value="poids")double poids,
			@PathParam(value="vol")double vol,
			@PathParam(value="refCarg")String refCarg) {
		return metier.addMarchandise(new Marchandise(nom, poids, vol), refCarg);
		
	}
	@GET
	@Path("/lstAllCargos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cargaison> listAllCargaison() {
		return metier.listAllCargaison();
	}

	@GET
	@Path("/lstMarchsParCargs/{refCargaison}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Marchandise> listMarchandiseParCargaison(@PathParam(value="refCargaison")String refCargaison) {
		return metier.listMarchandiseParCargaison(refCargaison);
	}

	@GET
	@Path("/lstMarchsParMC/{motCle}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Marchandise> listMarchandiseParMC(@PathParam(value="motCle")String motCle) {
		return metier.listMarchandiseParMC(motCle);
	}

	@GET
	@Path("/deleteMarchandise/{numMarchandise}")
	public void deleteMarchandise(@PathParam(value="numMarchandise")Long numMarchandise) {
		metier.deleteMarchandise(numMarchandise);
	}
	
}