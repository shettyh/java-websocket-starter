package com.websocket.starter.response;

import com.websocket.starter.common.RequestType;

/**
 * Abstract response
 * 
 * @author manjunathshetty
 *
 */
public abstract class AbstractResponse {

	private RequestType type;

	protected AbstractResponse(RequestType type) {
		this.type = type;
	}

	public RequestType getType() {
		return type;
	}

	public void setType(RequestType type) {
		this.type = type;
	}

	@Override
	abstract public String toString();

}
