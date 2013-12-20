package net.authorize;

import java.io.Serializable;

public abstract class Result<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Transaction transaction;

	protected T target;

	/**
	 * Get the request transaction.
	 *
	 * @return Transaction
	 */
	public Transaction getTransaction() {
		return this.transaction;
	}

	/**
	 * Get the target (request + response transaction).
	 *
	 * @return Transaction
	 */
	public T getTarget() {
		return this.target;
	}

}
