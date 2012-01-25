/**
 * Copyright 2012 estilvivant.com
 */
package com.estilvivant.application.router;

import javax.servlet.http.HttpServletRequest;

import com.estilvivant.domain.persona.Persona;
import com.estilvivant.infra.persistence.gae.PersonaRepositoryGAEImpl;

/**
 * @author Loïc Fejoz
 *
 */
public enum URLMapper {
	INSTANCE;

	public Persona asPersona(final HttpServletRequest request) {
		final String permalinkPart = request.getRequestURI().replaceAll("/persona/", "");
		final Persona thePersona = PersonaRepositoryGAEImpl.INSTANCE.findByPermalinkPart(permalinkPart);
		return thePersona;
	}

}
