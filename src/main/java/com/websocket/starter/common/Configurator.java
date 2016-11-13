package com.websocket.starter.common;

import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

/**
 * Websocket configurator
 * @author manjunathshetty
 *
 */
public class Configurator extends javax.websocket.server.ServerEndpointConfig.Configurator{

	@Override
	public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
		//Add to change the configuration, to get the http session etc
		super.modifyHandshake(sec, request, response);
	}
	
}
