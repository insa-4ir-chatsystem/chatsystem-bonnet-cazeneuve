package com.insa.utils;
import java.util.UUID;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;

public class MyLogger {
    private static volatile MyLogger instance;

    private static java.util.logging.Logger myLog = java.util.logging.Logger.getAnonymousLogger();

    private final UUID sessionUUID;

    private MyLogger() {

        this.sessionUUID = UUID.randomUUID();
        if(instance != null) {
            throw new RuntimeException("Logger already instanced");
        }
        ConsoleHandler handler = new ConsoleHandler();
        Formatter formatter = new LogFormatter();
        handler.setFormatter(formatter);

        myLog.addHandler(handler);
        myLog.setUseParentHandlers(false);
        myLog.info("Logger created");
    }

    synchronized static public MyLogger getInstance() {
        MyLogger result = instance;
        if(result != null) {
            return result;
        }
        synchronized (MyLogger.class) {
            if(instance == null) {
                instance = new MyLogger();
            }
            return instance;
        }
    }

    public void info(String message) {
        log(message, Level.INFO);
    }

    public void log(String message, Level level) {
        myLog.log(level, message);
    }
}
