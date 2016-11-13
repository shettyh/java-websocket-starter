package com.websocket.starter.common;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.Session;

/**
 * Websocket Session storage Singleton instance
 * 
 * @author manjunathshetty
 */
public enum SessionStorage {
	INSTANCE;

	private HashSet<Session> sessions = new HashSet<>();

	public boolean addSession(Session session) {
		return sessions.add(session);
	}

	public boolean removeSession(Session session) {
		return sessions.remove(session);
	}

	public HashSet<Session> getSessions() {
		return this.sessions;
	}
}
