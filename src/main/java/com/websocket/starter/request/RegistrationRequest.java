package com.websocket.starter.request;

import com.websocket.starter.common.RequestType;

/**
 * Registration request
 * @author manjunathshetty
 *
 */
public class RegistrationRequest extends AbstractRequest {

	private String registrationData;

	public RegistrationRequest() {
		super(RequestType.REGISTRATION_REQUEST);
	}

	public String getRegistrationData() {
		return registrationData;
	}

	public void setRegistrationData(String registrationData) {
		this.registrationData = registrationData;
	}

}
