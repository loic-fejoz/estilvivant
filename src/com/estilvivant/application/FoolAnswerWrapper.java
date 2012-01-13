/**
 * Copyright 2012 estilvivant.com
 */
package com.estilvivant.application;

import java.util.List;

import com.estilvivant.domain.persona.FoolAnswer;
import com.estilvivant.domain.persona.Persona;

/**
 * Build an Answer from a Fool one,
 * ie instantiate the generic FoolAnswer into a specific one. 
 * @author Loïc Fejoz
 *
 */
public class FoolAnswerWrapper implements Answer {

	private final String fts;
	private final FoolAnswer foolAnswer;
	private final List<Persona> similar;

	/**
	 * @param foolAnswer 
	 * @param fullTextSearch 
	 * @param similarPersonae 
	 * 
	 */
	public FoolAnswerWrapper(final String fullTextSearch, final FoolAnswer foolAnswer, final List<Persona> similarPersonae) {
		this.fts = fullTextSearch;
		this.foolAnswer = foolAnswer;
		this.similar = similarPersonae;
	}

	/* (non-Javadoc)
	 * @see com.estilvivant.application.Answer#getTitle()
	 */
	@Override
	public String getTitle() {
		return String.format(foolAnswer.getTitleHtmlFormat(), fts);
	}

	/* (non-Javadoc)
	 * @see com.estilvivant.application.Answer#getAvatarName()
	 */
	@Override
	public String getAvatarName() {
		return foolAnswer.getAvatarName();
	}

	/* (non-Javadoc)
	 * @see com.estilvivant.application.Answer#getAvatarImageURL()
	 */
	@Override
	public String getAvatarImageURL() {
		return foolAnswer.getAvatarImageURL();
	}

	/* (non-Javadoc)
	 * @see com.estilvivant.application.Answer#getAvatarLinkURL()
	 */
	@Override
	public String getAvatarLinkURL() {
		return foolAnswer.getAvatarLinkURL();
	}

	/* (non-Javadoc)
	 * @see com.estilvivant.application.Answer#getAvatarAnswer()
	 */
	@Override
	public String getAvatarAnswer() {
		return String.format(foolAnswer.getAnswerHtmlFormat(), fts);
	}

	@Override
	public List<Persona> getSimilarPersonae() {
		return similar;
	}

}
