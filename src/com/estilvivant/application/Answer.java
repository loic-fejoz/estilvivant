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
public interface Answer {
	String getTitle();
	String getAvatarName();
	String getAvatarImageURL();
	String getAvatarLinkURL();
	String getAvatarAnswer();
	List<Persona> getSimilarPersona();
}
