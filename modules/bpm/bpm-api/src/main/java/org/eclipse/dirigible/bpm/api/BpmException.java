/*
 * Copyright (c) 2017 SAP and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * SAP - initial API and implementation
 */

package org.eclipse.dirigible.bpm.api;

/**
 * The Content Management System Exception.
 */
public class BpmException extends RuntimeException {

	private static final long serialVersionUID = -2161860568272479874L;

	/**
	 * Instantiates a new Content Management System exception.
	 */
	public BpmException() {
		super();
	}

	/**
	 * Instantiates a new Content Management System exception.
	 *
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 * @param enableSuppression
	 *            the enable suppression
	 * @param writableStackTrace
	 *            the writable stack trace
	 */
	public BpmException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * Instantiates a new Content Management System exception.
	 *
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public BpmException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new Content Management System exception.
	 *
	 * @param message
	 *            the message
	 */
	public BpmException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new Content Management System exception.
	 *
	 * @param cause
	 *            the cause
	 */
	public BpmException(Throwable cause) {
		super(cause);
	}

}
