package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="MARCHANDISES")
public class Marchandise implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numeroMarchandise;
	private String nomMarchandise;
	private double poidsMarchandise;
	private double volumeMarchandise;
	
	@ManyToOne
	@JoinColumn(name="REFERENCE_CARGAISON")
	private Cargaison cargaison;

	public Marchandise() {
		super();
	}

	public Marchandise(String nomMarchandise, double poidsMarchandise, double volumeMarchandise, Cargaison cargaison) {
		super();
		this.nomMarchandise = nomMarchandise;
		this.poidsMarchandise = poidsMarchandise;
		this.volumeMarchandise = volumeMarchandise;
		this.cargaison = cargaison;
	}

	public String getNomMarchandise() {
		return nomMarchandise;
	}

	public void setNomMarchandise(String nomMarchandise) {
		this.nomMarchandise = nomMarchandise;
	}

	public double getPoidsMarchandise() {
		return poidsMarchandise;
	}

	public void setPoidsMarchandise(double poidsMarchandise) {
		this.poidsMarchandise = poidsMarchandise;
	}

	public double getVolumeMarchandise() {
		return volumeMarchandise;
	}

	public void setVolumeMarchandise(double volumeMarchandise) {
		this.volumeMarchandise = volumeMarchandise;
	}

	public Cargaison getCargaison() {
		return cargaison;
	}

	public void setCargaison(Cargaison cargaison) {
		this.cargaison = cargaison;
	}

	public Long getNumeroMarchandise() {
		return numeroMarchandise;
	}

}