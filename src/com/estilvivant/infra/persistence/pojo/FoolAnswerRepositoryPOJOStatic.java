/**
 * Copyright 2012 estilvivant.com
 */
package com.estilvivant.infra.persistence.pojo;

import java.util.Random;

import com.estilvivant.domain.persona.FoolAnswer;
import com.estilvivant.domain.persona.FoolAnswerRepository;

/**
 * @author Loïc Fejoz
 *
 */
public enum FoolAnswerRepositoryPOJOStatic implements FoolAnswerRepository {
	INSTANCE;

	private static final FoolAnswer[] answers = new FoolAnswer[3];
	static {
		answers[0] = new FoolAnswerPOJOImpl("Le Normand", "%s est-il vivant&nbsp;? ", "<p>Ptet ben que oui, Ptet que non</p>", "/images//johnny_automatic_Viking_pointing_1.png", "http://openclipart.org/detail/4434/viking-pointing-by-johnny_automatic");
		answers[1] = new FoolAnswerPOJOImpl("La starlette", "%s&nbsp;? Quel bel homme !", "<p>Mais je n'ai jamais couché avec&hellip;</p>", "/images/liftarn_Pin-up_blue.png", "http://openclipart.org/detail/15560/pin-up-blue-by-liftarn");
		answers[2] = new FoolAnswerPOJOImpl("L'enquêteur", "%s est-il vivant&nbsp;? ", "<p>Je lance mes meilleurs indics sur la question&hellip;</p>", "/images/papapishu_Policeman_head.png", "http://openclipart.org/detail/22907/policeman-head-by-papapishu");
	}
	
	private static final Random randGen = new Random();

	@Override
	public FoolAnswer createFoolAnswer(final String title, final String answer) {
		throw new UnsupportedOperationException("This reposotory cannot create any answer.");
	}

	@Override
	public void save(final FoolAnswer answer) {
		throw new UnsupportedOperationException("This reposotory cannot save any answer.");
	}

	@Override
	public FoolAnswer random() {
		return answers[randGen.nextInt(answers.length)];
	}



}
