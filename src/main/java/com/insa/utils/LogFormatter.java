package com.insa.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
public class LogFormatter extends Formatter {
    // ANSI escape code
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    // Here you can configure the format of the output and
    // its color by using the ANSI escape codes defined above.

    // format is called for every console log message
    @Override
    public String format(LogRecord record)
    {
        // This example will print date/time, class, and log level in yellow,
        // followed by the log message and it's parameters in white .
        StringBuilder builder = new StringBuilder();

        builder.append(ANSI_BOLD);
        if (record.getLevel() == Level.INFO)
            builder.append(ANSI_GREEN);
        else if (record.getLevel() == Level.SEVERE)
            builder.append(ANSI_RED);
        else if (record.getLevel() == Level.WARNING)
            builder.append(ANSI_YELLOW);
        else if (record.getLevel() == Level.CONFIG)
            builder.append(ANSI_CYAN);
        else if (record.getLevel() == Level.FINE)
            builder.append(ANSI_BLUE);
        else if (record.getLevel() == Level.FINER)
            builder.append(ANSI_BLUE);
        else if (record.getLevel() == Level.FINEST)
            builder.append(ANSI_BLUE);
        else
            builder.append(ANSI_WHITE);
        builder.append("[");
        builder.append(record.getLevel().getName());
        builder.append("]");

        builder.append(ANSI_RESET);

        builder.append(ANSI_BLUE);

        builder.append("[");
        builder.append(calcDate(record.getMillis()));
        builder.append("]");

        builder.append(ANSI_PURPLE);


        builder.append(" [");
        builder.append(record.getLoggerName());
        builder.append("]");



        builder.append(ANSI_WHITE);
        builder.append(" - ");
        builder.append(record.getMessage());

        Object[] params = record.getParameters();

        if (params != null)
        {
            builder.append("\t");
            for (int i = 0; i < params.length; i++)
            {
                builder.append(params[i]);
                if (i < params.length - 1)
                    builder.append(", ");
            }
        }

        builder.append(ANSI_RESET);
        builder.append("\n");
        return builder.toString();
    }

    private String calcDate(long millisecs) {
        SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date resultdate = new Date(millisecs);
        return date_format.format(resultdate);
    }
}
