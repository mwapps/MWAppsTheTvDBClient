package com.manriqueweb.thetvdbclient.exceptions;

import java.lang.Throwable;

/**
 * A generic Client exception.
 */
public class TheTvDBClientException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4288151926364335344L;

	public TheTvDBClientException(String msg) {
        super(msg);
    }

    public TheTvDBClientException(String msg, Throwable cause) {
        super(msg, cause);
    }
}

