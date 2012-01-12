/**
 * Copyright 2012 estilvivant.com
 */
package com.estilvivant.infra.persistence.gae;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.estilvivant.domain.persona.Persona;

/**
 * @author Loïc Fejoz
 *
 */
@PersistenceCapable
public class PersonaGAEImpl implements Persona {

	@PrimaryKey
	@Persistent
	private String permalinkPart;
	
	@Persistent
	private String name;
	
	@Persistent
	private String description;

	/**
	 * 
	 */
	public PersonaGAEImpl(final String permalink, final String name, final String description) {
		this.permalinkPart = permalink;
		this.name = name;
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see com.estilvivant.domain.persona.Persona#getFullName()
	 */
	@Override
	public String getFullName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see com.estilvivant.domain.persona.Persona#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getPermalink() {
		return permalinkPart;
	}

}
