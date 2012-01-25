/**
 * Copyright 2012 estilvivant.com
 */
package com.estilvivant.infra.persistence.gae;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.estilvivant.domain.persona.Persona;
import com.estilvivant.domain.persona.PersonaRepository;

/**
 * @author Loïc Fejoz
 * 
 */
public enum PersonaRepositoryGAEImpl implements PersonaRepository {
	INSTANCE;
	
	static {
//		INSTANCE.save(INSTANCE.createPersona("Steve Jobs", "<p>Steve Jobs est mort.</p>", "Steve_Jobs"));
//		INSTANCE.save(INSTANCE.createPersona("Christian Morin", "<p>Non, Christian Morin n'est mort.</p>", "Christian_Morin"));
//		INSTANCE.save(INSTANCE.createPersona("Hervé Morin", "<p>Hervé Morin n'est pas mort, sauf peut-être en politique.</p>", "Herve_Morin"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.estilvivant.domain.persona.PersonaRepository#createPersona(java.lang
	 * .String, java.lang.String, java.lang.String)
	 */
	@Override
	public Persona createPersona(final String fullName,
			final String description, final String permalinkPart) {
		return new PersonaGAEImpl(permalinkPart, fullName, description);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.estilvivant.domain.persona.PersonaRepository#save(com.estilvivant
	 * .domain.persona.Persona)
	 */
	@Override
	public void save(final Persona personaToBeSaved) {
		final PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.makePersistent(personaToBeSaved);
		} finally {
			pm.close();
		}
	}

	@Override
	public Persona exactSearch(final String fullName) {
		final PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
            final Query query = pm.newQuery(PersonaGAEImpl.class);
            query.setFilter("name == fullName");
            query.declareParameters("String fullName");
            query.setRange(0, 1);
            query.setUnique(true);
            return (Persona)query.execute(fullName);
        } finally {
            pm.close();
        }
	}

	@Override
	public List<Persona> fullTextSearch(final String fullText) {
		final PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
            final Query query = pm.newQuery(PersonaGAEImpl.class);
            query.setFilter("tokenisedNameForFullTextSearch == fullText");
            query.declareParameters("String fullText");
            final List<Persona> personaeWithText = (List<Persona>)query.execute(fullText);
            personaeWithText.size(); // See http://code.google.com/p/datanucleus-appengine/issues/detail?id=24
            return personaeWithText;
        } finally {
            pm.close();
        }
	}

	@Override
	public List<Persona> searchSeeAlso(Persona exactPersona) {
		return fullTextSearch(exactPersona.getFullName());
	}

	@Override
	public Persona findByPermalinkPart(final String permalinkPart) {
		final PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
            final Query query = pm.newQuery(PersonaGAEImpl.class);
            query.setFilter("permalinkPart == param");
            query.setUnique(true);
            query.declareParameters("String param");
            final Persona personaWithGivenPermaLink = (Persona)query.execute(permalinkPart);
            return personaWithGivenPermaLink;
        } finally {
            pm.close();
        }
	}

}
