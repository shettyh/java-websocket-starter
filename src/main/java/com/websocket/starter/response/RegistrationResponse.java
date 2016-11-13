package com.websocket.starter.response;

import com.websocket.starter.common.RequestType;

/**
 * Regostration response
 * @author manjunathshetty
 *
 */
public class RegistrationResponse extends AbstractResponse {

	private boolean status;

	public RegistrationResponse() {
		super(RequestType.REGISTRATION_REQUEST);
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
