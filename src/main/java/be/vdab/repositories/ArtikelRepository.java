package be.vdab.repositories;

import java.math.BigDecimal;
import java.util.List;

import be.vdab.entities.Artikel;

public class ArtikelRepository extends AbstractRepository {
	public Artikel read(long id) {
		return getEntityManager().find(Artikel.class, id);
	}

	public void create(Artikel artikel) {
		getEntityManager().persist(artikel);
	}

	public List<Artikel> findByNaamContains(String woord) {
		return getEntityManager().createNamedQuery("Artikel.findByNaamContains", Artikel.class)
				.setParameter("zoals", '%' + woord + '%').getResultList();
	}

	public void prijsverhoging(BigDecimal factor) {
		getEntityManager().createNamedQuery("Artikel.prijsverhoging").setParameter("factor", factor).executeUpdate();
	}
}