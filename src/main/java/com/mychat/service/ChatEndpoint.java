package com.mychat.service;


import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/websocket/helloName")
public class ChatEndpoint {
    private static Map<String, Session> sessionMap = new ConcurrentHashMap<String, Session>();

    @OnOpen
    public void onOpen(Session session) {
        sessionMap.put(session.getId(), session);
    }

    @OnError
    public void onError(Throwable t) {
        // TODO: replace with logger
        System.out.println(t.getMessage());
    }

    @OnClose
    public void onClose(Session session) {
        sessionMap.remove(session.getId());
    }
}
