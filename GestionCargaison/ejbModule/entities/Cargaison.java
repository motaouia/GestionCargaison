package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="CARGAISONS")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_CARGAISON", length=2)
@XmlSeeAlso({CargaisonAerienne.class, CargaisonRoutiere.class})
public class Cargaison implements Serializable {
	
	@Id
	@Column(name="REFERENCE_CARGAISON")
	private String referenceCargaison;
	private double distance;
	private Date dateLivraison;
	
	@OneToMany(mappedBy="cargaison",fetch=FetchType.LAZY)
	private List<Marchandise> marchandises;
	
	public Cargaison() {
		super();
	}
	public Cargaison(String referenceCargaison, double distance, Date dateLivraison) {
		super();
		this.referenceCargaison = referenceCargaison;
		this.distance = distance;
		this.dateLivraison = dateLivraison;
	}
	public String getReferenceCargaison() {
		return referenceCargaison;
	}
	public void setReferenceCargaison(String referenceCargaison) {
		this.referenceCargaison = referenceCargaison;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	
	public Date getDateLivraison() {
		return dateLivraison;
	}
	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}
	
	@XmlTransient
	
	public List<Marchandise> getMarchandises() {
		return marchandises;
	}
	public void setMarchandises(List<Marchandise> marchandises) {
		this.marchandises = marchandises;
	}
	
}