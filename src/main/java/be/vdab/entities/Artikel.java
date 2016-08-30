package be.vdab.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "artikels")

public class Artikel implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final BigDecimal MINIMUM_AANKOOPPRIJS = BigDecimal.valueOf(0.01);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String naam;
	private BigDecimal aankoopprijs;
	private BigDecimal verkoopprijs;

	protected Artikel() {
	}

	public Artikel(String naam, BigDecimal aankoopprijs, BigDecimal verkoopprijs) {
		setNaam(naam);
		setAankoopprijs(aankoopprijs);
		setVerkoopprijs(verkoopprijs);
	}

	public static boolean isNaamValid(String naam) {
		return naam != null && !naam.isEmpty();
	}

	public static boolean isAankoopprijsValid(BigDecimal aankoopprijs) {
		return aankoopprijs != null && aankoopprijs.compareTo(MINIMUM_AANKOOPPRIJS) >= 0;
	}

	public static boolean isVerkoopprijsValid(BigDecimal verkoopprijs) {
		return verkoopprijs != null;
	}

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
		if (!isNaamValid(naam)) {
			throw new IllegalArgumentException();
		}
		this.naam = naam;
	}

	public BigDecimal getAankoopprijs() {
		return aankoopprijs;
	}

	public void setAankoopprijs(BigDecimal aankoopprijs) {
		if (!isAankoopprijsValid(aankoopprijs)) {
			throw new IllegalArgumentException();
		}
		this.aankoopprijs = aankoopprijs;
	}

	public BigDecimal getVerkoopprijs() {
		return verkoopprijs;
	}

	public void setVerkoopprijs(BigDecimal verkoopprijs) {
		if (!isVerkoopprijsValid(verkoopprijs) && verkoopprijs.compareTo(aankoopprijs) <= 0) {
			throw new IllegalArgumentException();
		}
		this.verkoopprijs = verkoopprijs;
	}
	
	public BigDecimal getWinstPercentage() {
		return verkoopprijs.subtract(aankoopprijs).divide(aankoopprijs, 2,
		RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
		}

}
