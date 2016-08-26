package be.vdab.repositories;

import javax.persistence.EntityManager;

import be.vdab.entities.Artikel;
import be.vdab.filters.JPAFilter;

public class ArtikelRepository {
	public Artikel read(long id) {
		EntityManager entityManager = JPAFilter.getEntityManager();
		try {
			return entityManager.find(Artikel.class, id);
		} finally {
			entityManager.close();
		}
	}
}