/**
 * Copyright 2012 estilvivant.com
 */
package com.estilvivant.domain.persona;

/**
 * @author Loïc Fejoz
 *
 */
public interface Persona {
	/**
	 * Getter for the full name as usually written.
	 * @return full name of the person
	 * @ ensures \result != null
	 */
    String getFullName();
    
    /**
     * Getter for a description about this person.
     * @return the answer about this person
     * @ ensures \result != null
     */
    String getDescription();
    
    /**
     * Getter for the text to build the full url.
     * @return permalink part
     * @ ensures \result != null
     */
    String getPermalink();
}
