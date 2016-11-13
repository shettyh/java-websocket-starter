package com.websocket.starter.common;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.websocket.starter.request.AbstractRequest;
import com.websocket.starter.request.BroadcastRequest;
import com.websocket.starter.request.RegistrationRequest;

/**
 * 
 * Websocket request decoder
 * 
 * @author manjunathshetty
 *
 */
public class RequestDecoder implements Decoder.Text<AbstractRequest> {

	private AbstractRequest request;

	@Override
	public void destroy() {
		System.out.println("In Destroy");
	}

	@Override
	public void init(EndpointConfig arg0) {
		System.out.println("In init");
	}

	@Override
	public AbstractRequest decode(String requestString) throws DecodeException {
		Gson gson = new Gson();
		return gson.fromJson(requestString, request.getClass());
	}

	@Override
	public boolean willDecode(String requestString) {
		Gson gson = new Gson();
		JsonObject jsonObject = gson.fromJson(requestString, JsonObject.class);
		String type = jsonObject.get("type").getAsString();
		RequestType requestType = RequestType.fromString(type);
		switch (requestType) {
		case REGISTRATION_REQUEST:
			request = new RegistrationRequest();
			break;
		case BROADCAST_REQUEST:
			request = new BroadcastRequest();
			break;
		default:
			request = null;
			break;
		}
		return request == null ? false : true;
	}

}
