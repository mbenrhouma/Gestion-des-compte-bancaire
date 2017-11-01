package metier.entites;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Compte
 *
 */
@Entity

public class Compte implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long code;
	private double solde;
	private Date dateCreation;
	private static final long serialVersionUID = 1L;

	public Compte() {
		super();
	}   
	public Long getCode() {
		return this.code;
	}

	public void setCode(Long code) {
		this.code = code;
	}   
	public double getSolde() {
		return this.solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}   
	
	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
   
}
