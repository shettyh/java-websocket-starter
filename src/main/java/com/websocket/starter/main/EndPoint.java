package com.websocket.starter.main;

import java.io.IOException;
import java.util.HashSet;

import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.websocket.starter.common.Configurator;
import com.websocket.starter.common.RequestDecoder;
import com.websocket.starter.common.ResponseEncoder;
import com.websocket.starter.common.SessionStorage;
import com.websocket.starter.request.AbstractRequest;
import com.websocket.starter.request.BroadcastRequest;
import com.websocket.starter.request.RegistrationRequest;
import com.websocket.starter.response.BroadcastResponse;
import com.websocket.starter.response.RegistrationResponse;

/**
 * Websocket endpoint
 * 
 * @author manjunathshetty
 *
 */
@ServerEndpoint(value = "/websocket", decoders = { RequestDecoder.class }, encoders = {
		ResponseEncoder.class }, configurator = Configurator.class)
public class EndPoint {

	@OnOpen
	public void onOpen(Session session, EndpointConfig config) {
		System.out.println("Session opened :" + session.getId());
	}

	@OnMessage
	public void onMessage(Session session, AbstractRequest message) {
		try {
			if (message instanceof RegistrationRequest) {
				System.out.println("Registration request recieved.");
				// Add registration validation here
				SessionStorage.INSTANCE.addSession(session);
				RegistrationResponse response = new RegistrationResponse();
				response.setStatus(true);
				session.getBasicRemote().sendObject(response);
				System.out.println("Registration success.");
			} else if (message instanceof BroadcastRequest) {
				System.out.println("Broadcast request recieved.");
				BroadcastRequest request = (BroadcastRequest) message;
				System.out.println("Broadcast request message :" + request.getMessage());
				BroadcastResponse response = new BroadcastResponse();
				response.setMessage(request.getMessage());
				/* Send message to all the registered sessions */
				HashSet<Session> sessions = SessionStorage.INSTANCE.getSessions();
				System.out.println("Active sessions :" + sessions.size());
				sessions.forEach(s -> {
					try {
						System.out.println("Sending broadcast message to session :" + s.getId());
						s.getBasicRemote().sendObject(response);
					} catch (IOException | EncodeException e) {
						System.out.println(
								"Error while sending the response back." + e.getMessage() + " to session " + s.getId());
						e.printStackTrace();
					}
				});
			} else {
				System.out.println("Invalid request.");
			}
		} catch (IOException | EncodeException e) {
			System.out.println("Error while sending the response back." + e.getMessage());
			e.printStackTrace();
		}
	}

	@OnClose
	public void onClose(Session session) {
		System.out.println("Connection closed :" + session.getId());
		SessionStorage.INSTANCE.removeSession(session);
	}

	@OnError
	public void onError(Session session, Throwable throwable) {
		System.err.println(
				"Connection closed due to error :" + throwable.getMessage() + " for session " + session.getId());
		throwable.printStackTrace();
		SessionStorage.INSTANCE.removeSession(session);
	}

}
