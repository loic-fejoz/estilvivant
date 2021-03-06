/**
 * Copyright 2012 estilvivant.com
 */
package com.estilvivant.application;

import java.util.Collection;

import com.estilvivant.domain.persona.FoolAnswerRepository;
import com.estilvivant.domain.persona.Persona;
import com.estilvivant.domain.persona.PersonaRepository;
import com.estilvivant.infra.persistence.gae.PersonaRepositoryGAEImpl;
import com.estilvivant.infra.persistence.pojo.FoolAnswerRepositoryPOJOStatic;

/**
 * @author Loïc Fejoz
 * 
 */
public enum AnswerBuilder {
	INSTANCE;

	private static final PersonaRepository personaRepo = PersonaRepositoryGAEImpl.INSTANCE;
	// TODO inject FoolAnswerRepository instead of hard code.
	private static final FoolAnswerRepository foolRepo = FoolAnswerRepositoryPOJOStatic.INSTANCE;

	public Answer buildAnswer(final String fullTextSearch) {
		final Persona exactPersona = personaRepo.exactSearch(fullTextSearch);
		if (exactPersona == null) {
			final Collection<Persona> similarPersonae = personaRepo
					.fullTextSearch(fullTextSearch);
			return new FoolAnswerWrapper(fullTextSearch, foolRepo.random(),
					similarPersonae);
		} else {
			return buildAnswer(exactPersona);
		}

	}

	public Answer buildAnswer(final Persona persona) {
		assert persona != null;
		final Collection<Persona> seeAlsoPersonae = personaRepo
				.searchSeeAlso(persona);
		return new PersonaAnswerWrapper(persona.getFullName(), persona,
				seeAlsoPersonae);
	}
}
