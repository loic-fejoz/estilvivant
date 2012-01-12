/**
 * Copyright 2012 estilvivant.com
 */
package com.estilvivant.domain.persona;

/**
 * @author loic
 *
 */
public interface PersonaRepository {
	/**
	 * Create a new Persona. Later, it must be saved in a repository.
	 * @param fullName
	 * @param description
	 * @param permalinkPart
	 * @return the newly created Persona.
	 * @ requires fullName != null
	 * @ requires description != null
	 * @ requires permalinkPart != null
	 * @ ensures \result != null
	 */
	Persona createPersona(String fullName, String description, String permalinkPart);
	
	void save(Persona personaToBeSaved);

}
