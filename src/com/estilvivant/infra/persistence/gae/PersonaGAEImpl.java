/**
 * Copyright 2012 estilvivant.com
 */
package com.estilvivant.infra.persistence.gae;

import java.util.Set;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.listener.StoreCallback;

import com.estilvivant.domain.persona.Persona;
import com.estilvivant.infra.fulltextsearch.FullTextSearch;

/**
 * @author Loïc Fejoz
 *
 */
@PersistenceCapable
public class PersonaGAEImpl implements Persona, StoreCallback {

	@PrimaryKey
	@Persistent
	private String permalinkPart;
	
	@Persistent
	private String name;
	
	@Persistent
	private Set<String> tokenisedNameForFullTextSearch;
	
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

	@Override
	public void jdoPreStore() {
		tokenisedNameForFullTextSearch = FullTextSearch.generateToken(name, FullTextSearch.ALL_SUBSTRING);
	}

	@Override
	public int hashCode() {
		return permalinkPart.hashCode();
	}
	
	@Override
	public boolean equals(final Object other) {
		if (other == this) {
			return true;
		}
		if (other == null) {
			return false;
		}
		if (getClass().equals(other.getClass())) {
			// Permalink shall be the identifier thus we only compare on it.
			final PersonaGAEImpl otherPersona = (PersonaGAEImpl)other;
			return permalinkPart.equals(otherPersona.permalinkPart);
		}
		return false;
	}
}
