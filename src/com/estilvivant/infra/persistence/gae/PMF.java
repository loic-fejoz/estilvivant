/**
 * Copyright 2012 estilvivant.com
 */
package com.estilvivant.infra.persistence.gae;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

/**
 * 
 */
public final class PMF {
	/**
	 * The instance of persistence manager.
	 */
	private static final PersistenceManagerFactory PMF_INSTANCE = JDOHelper
			.getPersistenceManagerFactory("transactions-optional");

	/**
	 * Private constructor.
	 */
	private PMF() {
	}

	/**
	 * Recovery of singleton instance.
	 * 
	 * @return the singleton of class
	 */
	public static PersistenceManagerFactory get() {
		return PMF_INSTANCE;
	}
}