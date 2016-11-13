package com.websocket.starter.response;

import com.google.gson.Gson;
import com.websocket.starter.common.RequestType;

/**
 * Broadcast response entity
 * @author manjunathshetty
 *
 */
public class BroadcastResponse extends AbstractResponse {

	private String message;

	public BroadcastResponse() {
		super(RequestType.BROADCAST_REQUEST);
	}

	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
