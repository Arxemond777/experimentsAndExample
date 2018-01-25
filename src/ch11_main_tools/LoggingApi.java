package ch11_main_tools;

import java.io.IOException;
import java.util.logging.*;

public class LoggingApi
{
    static Logger log = Logger.getLogger("ch11_main_tools.LoggingApi");

    public static void main(String[] args) throws IOException {
        LoggingApi.a();
        System.exit(0);

        log.setLevel(Level.CONFIG);
        Filter filter = new Filter()
        {
            @Override
            public boolean isLoggable(LogRecord record) {
                return record.getMessage().startsWith("FINER");
            }
        };
        log.setFilter(filter);
        log.warning("warning");
        //pw.println(log.warning("warning"));
        log.info("info");
        Logger.global.info("123");

    }

    static void a() throws IOException {
        boolean append = false;
        FileHandler handler = new FileHandler("default.log", append);

        handler.setFilter(new Filter() {
            @Override
            public boolean isLoggable(LogRecord record) {
                return record.getMessage().startsWith("IMPORTANT");
            }
        });

        Logger logger = Logger.getLogger("com.javacodegeeks.snippets.core");
        logger.addHandler(handler);
        logger.setLevel(Level.FINEST);

        logger.info("info message");
        logger.info("IMPORTANT info message");
    }
}
