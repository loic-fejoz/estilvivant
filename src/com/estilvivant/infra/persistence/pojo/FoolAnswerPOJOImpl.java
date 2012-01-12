/**
 * Copyright 2012 estilvivant.com
 */
package com.estilvivant.infra.persistence.pojo;

import com.estilvivant.domain.persona.FoolAnswer;

/**
 * @author Loïc Fejoz
 * 
 */
public class FoolAnswerPOJOImpl implements FoolAnswer {

	private final String name;
	private final String title;
	private final String description;
	private String link;
	private String image;

	/**
	 * 
	 */
	public FoolAnswerPOJOImpl(final String name, final String title,
			final String description, final String image, final String link) {
		this.name = name;
		this.title = title;
		this.description = description;
		this.link = link;
		this.image = image;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.estilvivant.domain.persona.FoolAnswer#getTitleHtmlFormat()
	 */
	@Override
	public String getTitleHtmlFormat() {
		return title;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.estilvivant.domain.persona.FoolAnswer#getAnswerHtmlFormat()
	 */
	@Override
	public String getAnswerHtmlFormat() {
		return description;
	}

	@Override
	public String getAvatarName() {
		return name;
	}

	@Override
	public String getAvatarLinkURL() {
		return link;
	}

	@Override
	public String getAvatarImageURL() {
		return image;
	}

}
