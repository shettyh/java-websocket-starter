package com.websocket.starter.request;

import com.websocket.starter.common.RequestType;

/**
 * Broadcast request entity
 * @author manjunathshetty
 *
 */
public class BroadcastRequest extends AbstractRequest {

	private String message;

	public BroadcastRequest() {
		super(RequestType.BROADCAST_REQUEST);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
