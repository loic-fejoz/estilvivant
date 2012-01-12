/**
 * Copyright 2012 estilvivant.com
 */
package com.estilvivant.infra.persistence.gae;

import java.util.Collections;
import java.util.List;

import com.estilvivant.domain.persona.Persona;
import com.estilvivant.domain.persona.PersonaRepository;

/**
 * @author Loïc Fejoz
 *
 */
public enum PersonaRepositoryGAEImpl implements PersonaRepository {
	INSTANCE;

	/* (non-Javadoc)
	 * @see com.estilvivant.domain.persona.PersonaRepository#createPersona(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Persona createPersona(final String fullName, final String description,
			final String permalinkPart) {
		throw new UnsupportedOperationException("NOT yet implemented");
	}

	/* (non-Javadoc)
	 * @see com.estilvivant.domain.persona.PersonaRepository#save(com.estilvivant.domain.persona.Persona)
	 */
	@Override
	public void save(final Persona personaToBeSaved) {
		throw new UnsupportedOperationException("NOT yet implemented");
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
