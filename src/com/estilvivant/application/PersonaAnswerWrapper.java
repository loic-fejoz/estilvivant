/**
 * Copyright 2012 estilvivant.com
 */
package com.estilvivant.application;

import java.util.Collection;

import com.estilvivant.domain.persona.Persona;

/**
 * @author Loïc Fejoz
 *
 */
public class PersonaAnswerWrapper implements Answer {

	private final Collection<Persona> seeAlso;
	private final Persona persona;

	public PersonaAnswerWrapper(final String fullTextSearch, final Persona exactPersona, final Collection<Persona> seeAlsoPersonae) {
		this.seeAlso = seeAlsoPersonae;
		this.persona = exactPersona;
	}

	/* (non-Javadoc)
	 * @see com.estilvivant.application.Answer#getTitle()
	 */
	@Override
	public String getTitle() {
		return persona.getFullName() + " est-il vivant ?";
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
		return "/images/mairin_Punk_Vampire.png";
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
	public Collection<Persona> getSimilarPersonae() {
		return seeAlso;
	}

}
