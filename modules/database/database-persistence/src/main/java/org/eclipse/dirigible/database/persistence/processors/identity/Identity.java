/*
 * Copyright (c) 2017 SAP and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * SAP - initial API and implementation
 */

package org.eclipse.dirigible.database.persistence.processors.identity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Identity transport object.
 */
@Table(name = "DIRIGIBLE_IDENTITY")
public class Identity {

	@Id
	@Column(name = "IDENTITY_TABLE", columnDefinition = "VARCHAR", nullable = false, length = 512)
	private String table;

	@Column(name = "IDENTITY_VALUE", columnDefinition = "BIGINT", nullable = false)
	private long value;

	/**
	 * Gets the table.
	 *
	 * @return the table
	 */
	public String getTable() {
		return table;
	}

	/**
	 * Sets the table.
	 *
	 * @param table
	 *            the new table
	 */
	public void setTable(String table) {
		this.table = table;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public long getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value
	 *            the new value
	 */
	public void setValue(long value) {
		this.value = value;
	}

}
