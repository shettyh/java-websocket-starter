package com.websocket.starter.common;

/**
 * Websocket request type
 * @author manjunathshetty
 *
 */
public enum RequestType {
	REGISTRATION_REQUEST,BROADCAST_REQUEST;

	public static RequestType fromString(String type) {
		return RequestType.valueOf(type);
	}
}
