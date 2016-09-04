package be.vdab.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "artikelgroepen")
public class Artikelgroep implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String naam;
	@OneToMany(mappedBy = "artikelgroep")
	private Set<Artikel> artikels;

	// Je maakt een getter voor id en naam
	public Set<Artikel> getArtikels() {
		return Collections.unmodifiableSet(artikels);
	}

	public void add(Artikel artikel) {
		artikels.add(artikel);
		if (artikel.getArtikelgroep() != this) {
			artikel.setArtikelgroep(this);
		}
	}

	public void remove(Artikel artikel) {
		artikels.remove(artikel);
		if (artikel.getArtikelgroep() == this) {
			artikel.setArtikelgroep(null);
		}
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Artikelgroep)) {
			return false;
		}
		Artikelgroep andereArtikelgroep = (Artikelgroep) object;
		return naam.equalsIgnoreCase(andereArtikelgroep.naam);
	}

	@Override
	public int hashCode() {
		return naam.toUpperCase().hashCode();
	}

	public long getId() {
		return id;
	}

	public String getNaam() {
		return naam;
	}
}