/**
 * Copyright 2012 estilvivant.com
 */
package com.estilvivant.application;

import com.estilvivant.infra.persistence.pojo.FoolAnswerRepositoryPOJOStatic;


/**
 * @author Loïc Fejoz
 *
 */
public enum AnswerBuilder {
	INSTANCE;

	public Answer buildAnswer(final String fullTextSearch) {
		//TODO search in PersonaRepository
		return new FoolAnswerWrapper(fullTextSearch, FoolAnswerRepositoryPOJOStatic.INSTANCE.random());
	}
}
