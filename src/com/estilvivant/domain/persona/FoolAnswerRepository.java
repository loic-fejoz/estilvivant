/**
 * Copyright 2012 estilvivant.com
 */
package com.estilvivant.domain.persona;

/**
 * @author Loïc Fejoz
 *
 */
public interface FoolAnswerRepository {
	FoolAnswer createFoolAnswer(String title, String answer);
	void save(FoolAnswer answer);
	FoolAnswer random();
}
