/**
 * Copyright 2012 estilvivant.com
 */
package com.estilvivant.domain.persona;

import java.util.Collection;

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

	/**
	 * Search persona excatly identified by the given text.
	 * Return null if none.
	 * @param fullName
	 * @return
	 */
	Persona exactSearch(String fullName);
	
	Persona findByPermalinkPart(String permalinkPart);
	
	/**
	 * Return Persona with a similar name.
	 * @param fullText
	 * @return
	 * @ requires fullText != null
	 * @ ensures \result != null
	 */
	Collection<Persona> fullTextSearch(String fullText);

	/**
	 * Return Persona related to the given persona.
	 * It could be homonyms, etc.
	 * @param exactPersona
	 * @return
	 * @ requires exactPersona != null
	 * @ ensures \result != null;
	 */
	Collection<Persona> searchSeeAlso(Persona exactPersona);
}
