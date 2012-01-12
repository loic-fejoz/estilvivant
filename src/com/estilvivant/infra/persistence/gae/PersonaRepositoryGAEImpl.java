/**
 * Copyright 2012 estilvivant.com
 */
package com.estilvivant.infra.persistence.gae;

import java.util.Collections;
import java.util.List;

import javax.jdo.PersistenceManager;

import com.estilvivant.domain.persona.Persona;
import com.estilvivant.domain.persona.PersonaRepository;

/**
 * @author Loïc Fejoz
 * 
 */
public enum PersonaRepositoryGAEImpl implements PersonaRepository {
	INSTANCE;

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
		return null;
	}

	@Override
	public List<Persona> fullTextSearch(final String fullText) {
		return Collections.emptyList();
	}

	@Override
	public List<Persona> searchSeeAlso(Persona exactPersona) {
		return fullTextSearch(exactPersona.getFullName());
	}

}
