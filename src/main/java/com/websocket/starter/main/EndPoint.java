package com.websocket.starter.main;

import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.websocket.starter.common.RequestDecoder;
import com.websocket.starter.common.ResponseEncoder;
import com.websocket.starter.request.AbstractRequest;
import com.websocket.starter.request.RegistrationRequest;

/**
 * Websocket endpoint
 * @author manjunathshetty
 *
 */
@ServerEndpoint(value = "/websocket", decoders = { RequestDecoder.class }, encoders = { ResponseEncoder.class })
public class EndPoint {

	@OnOpen
	public void onOpen(Session session, EndpointConfig config) {
		System.out.println("Session opened");
	}

	@OnMessage
	public void onMessage(Session session, AbstractRequest message) {
		if (message instanceof RegistrationRequest) {
			System.out.println("Registration request recieved.");
		}
	}

	@OnClose
	public void onClose(Session session) {
		System.out.println("Connection closed");
	}

	@OnError
	public void onError(Session session, Throwable throwable) {
		System.err.println("Connection closed due to error :" + throwable.getMessage());
	}

}
