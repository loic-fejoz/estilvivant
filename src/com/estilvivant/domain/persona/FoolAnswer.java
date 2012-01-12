/**
 * Copyright 2012 estilvivant.com
 */
package com.estilvivant.domain.persona;

/**
 * @author loic
 *
 */
public interface FoolAnswer {
	/**
	 * 
	 * @return the name of the avatar.
	 */
	String getAvatarName();
	
	String getAvatarLinkURL();
	
	String getAvatarImageURL();
	
	/**
	 * A format string for title.
	 * @see http://docs.oracle.com/javase/1.5.0/docs/api/java/util/Formatter.html#syntax
	 * @return the format string to be used to build title.
	 */
	String getTitleHtmlFormat();
	
	/**
	 * A format string for answer.
	 * @see http://docs.oracle.com/javase/1.5.0/docs/api/java/util/Formatter.html#syntax
	 * @return the format string to be used to build answer.
	 */
	String getAnswerHtmlFormat();
}
