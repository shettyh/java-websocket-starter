package com.websocket.starter.common;

public enum RequestType {
	REGISTRATION_REQUEST;

	public static RequestType fromString(String type) {
		return RequestType.valueOf(type);
	}
}
