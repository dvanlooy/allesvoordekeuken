package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "artikels")

public class Artikel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String naam;
	private BigDecimal aankoopprijs;
	private BigDecimal verkoopprijs;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public BigDecimal getAankoopprijs() {
		return aankoopprijs;
	}
	public void setAankoopprijs(BigDecimal aankoopprijs) {
		this.aankoopprijs = aankoopprijs;
	}
	public BigDecimal getVerkoopprijs() {
		return verkoopprijs;
	}
	public void setVerkoopprijs(BigDecimal verkoopprijs) {
		this.verkoopprijs = verkoopprijs;
	}
	
	
	
}
