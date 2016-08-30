package be.vdab.services;

import be.vdab.repositories.ArtikelRepository;
import be.vdab.entities.Artikel;

public class ArtikelService extends AbstractService {
	private final ArtikelRepository artikelRepository = new ArtikelRepository();

	public Artikel read(long id) {
		return artikelRepository.read(id);
	}

	public void create(Artikel artikel) {
		beginTransaction();
		artikelRepository.create(artikel);
		commit();
	}
}