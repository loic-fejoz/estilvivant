/**
 * Copyright 2012 estilvivant.com
 * @author Bertrand SIFRÉ
 */
package com.estilvivant.infra.fulltextsearch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Utilitary class for the full text search.
 * Its is responsible to generate a normalised list of string
 * that will be used for full text search.
 * 
 * @author Bertrand SIFRÉ
 * 
 */
public final class FullTextSearch {

    public static final byte PRE_SUBSTRING = 1;
    public static final byte POST_SUBSTRING = 2;
    public static final byte ALL_SUBSTRING = 3;
    public static final byte DECLINATION = 4;
    public static final byte PRE_SUBSTRING_DECLINATION = 5;
    public static final byte POST_SUBSTRING_DECLINATION = 6;
    public static final byte ALL_SUBSTRING_DECLINATION = 7;

    /**
     * Generate the collection of token for the full text search
     * 
     * @param value
     *            the value at indexed
     * 
     * @param options
     *            the option for the generator
     * @return the collection of token
     */
    public final static Set<String> generateToken(final String value, final byte options) {
        final String[] words = value.split(" ");
        final Set<String> results = new HashSet<String>();
        for (String theWord : words) {
            results.addAll(generateTokenOneWord(theWord, options));
        }
        return results;
    }

    /**
     * Generate the collection of token for the full text search
     * 
     * @param theWord
     *            the word at indexed
     * @param options
     *            the option for the generator
     * @return the collection of token
     */
    private final static Set<String> generateTokenOneWord(final String theWord, final byte options) {
        final String word = theWord.toLowerCase();
        final Set<String> results = new HashSet<String>();
        if ((options & PRE_SUBSTRING) > 0) {
            results.addAll(generatePreSubString(word));
        }
        if ((options & POST_SUBSTRING) > 0) {
            results.addAll(generatePostSubString(word));
        }
        if((options & DECLINATION)>0){
            throw new UnsupportedOperationException("Not yet implements !");
        }
        return results;
    }

    /**
     * Generate the collection of pre-subString for an word
     * 
     * @param theWord
     *            the word
     * @return the collection of pre-subString
     */
    private final static Collection<String> generatePreSubString(final String theWord) {
        final int length = theWord.length();
        final Collection<String> results = new ArrayList<String>(length - 2);
        for (int i = length; i > 2; i--) {
            results.add(theWord.substring(0, i));
        }
        return results;
    }

    /**
     * Generate the collection of post-subString for an word
     * 
     * @param theWord
     *            the word
     * @return the collection of post-subString
     */
    private final static Collection<String> generatePostSubString(String theWord) {
        final int length = theWord.length();
        final Collection<String> results = new ArrayList<String>(length - 2);
        for (int i = length - 3; i >= 0; i--) {
            results.add(theWord.substring(i));
        }
        return results;
    }

}
