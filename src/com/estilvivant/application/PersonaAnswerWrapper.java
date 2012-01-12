/**
 * Copyright 2012 estilvivant.com
 */
package com.estilvivant.application;

import java.util.List;

import com.estilvivant.domain.persona.Persona;

/**
 * @author Loïc Fejoz
 *
 */
public class PersonaAnswerWrapper implements Answer {

	private final List<Persona> seeAlso;
	private final Persona persona;

	public PersonaAnswerWrapper(final String fullTextSearch, final Persona exactPersona, final List<Persona> seeAlsoPersonae) {
		this.seeAlso = seeAlsoPersonae;
		this.persona = exactPersona;
	}

	/* (non-Javadoc)
	 * @see com.estilvivant.application.Answer#getTitle()
	 */
	@Override
	public String getTitle() {
		return persona.getFullName() + "est-il mort ?";
	}

	/* (non-Javadoc)
	 * @see com.estilvivant.application.Answer#getAvatarName()
	 */
	@Override
	public String getAvatarName() {
		return "Admin";
	}

	/* (non-Javadoc)
	 * @see com.estilvivant.application.Answer#getAvatarImageURL()
	 */
	@Override
	public String getAvatarImageURL() {
		return "/images/Admin.png";
	}

	/* (non-Javadoc)
	 * @see com.estilvivant.application.Answer#getAvatarLinkURL()
	 */
	@Override
	public String getAvatarLinkURL() {
		return "";
	}

	/* (non-Javadoc)
	 * @see com.estilvivant.application.Answer#getAvatarAnswer()
	 */
	@Override
	public String getAvatarAnswer() {
		return persona.getDescription();
	}

	/* (non-Javadoc)
	 * @see com.estilvivant.application.Answer#getSimilarPersona()
	 */
	@Override
	public List<Persona> getSimilarPersona() {
		return seeAlso;
	}

}
