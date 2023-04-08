package com.yet.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yet.spring.beans.Client;
import com.yet.spring.loggers.EventLogger;

public class Main {

    private Client client;

    private EventLogger eventLogger;

    public static void main(String[] args) {
        @SuppressWarnings("resource") // We will remove this suppress in further lessons
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        Main app = (Main) ctx.getBean("main");

        app.logEvent("Some event for 1");
        app.logEvent("Some event for 2");
    }

    public Main(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
    }

    private void logEvent(String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        eventLogger.logEvent(message);
    }

}