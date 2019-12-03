package entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CR")
public class CargaisonRoutiere extends Cargaison {
	
	private double temperatureConservation;

	public CargaisonRoutiere() {
		super();
	}

	public CargaisonRoutiere(String referenceCargaison, double distance, Date dateLivraison,
			double temperatureConservation) {
		super(referenceCargaison, distance, dateLivraison);
		this.temperatureConservation = temperatureConservation;
	}

	public double getTemperatureConservation() {
		return temperatureConservation;
	}

	public void setTemperatureConservation(double temperatureConservation) {
		this.temperatureConservation = temperatureConservation;
	}
	
}