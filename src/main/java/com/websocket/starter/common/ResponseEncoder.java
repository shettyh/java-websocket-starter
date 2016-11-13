package com.websocket.starter.common;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;
import com.websocket.starter.response.AbstractResponse;

public class ResponseEncoder implements Encoder.Text<AbstractResponse> {

	@Override
	public void destroy() {
		System.out.println("In destroy");
	}

	@Override
	public void init(EndpointConfig arg0) {
		System.out.println("In init");
	}

	@Override
	public String encode(AbstractResponse response) throws EncodeException {
		Gson gson = new Gson();
		return gson.toJson(response);
	}

}
