package metier;

import java.util.List;

import javax.ejb.Local;

import entities.Cargaison;
import entities.Marchandise;

@Local
public interface ITranportLocal {

	public Cargaison addCragaison(Cargaison cargaison);
	public Marchandise addMarchandise(Marchandise marchandise, String refCargaison);
	public List<Cargaison> listAllCargaison();
	public List<Marchandise> listMarchandiseParCargaison(String refCargaison);
	public List<Marchandise> listMarchandiseParMC(String motCle);
	public void deleteMarchandise(Long numMarchandise);
}