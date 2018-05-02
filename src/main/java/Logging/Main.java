package Logging;

import java.util.logging.*;

public class Main {
    //private static final Logger logger2 = Logger.getGlobal();
    //private static final Logger logger2 = Logger.getLogger("Loggining.Main");
    private static final Logger logger = Logger.getLogger(Main.class.getName());


    public static void main(String[] args) throws Exception {
        //-Djava.util.logging.config.file=c:\java_projects\sources\java_samples\src\main\java\Logging\log.properties

        //LogManager.getLogManager().readConfiguration();
        //System.out.println(System.clearProperty("java.util.logging.config.file"));
        //logger.info("message");

        //logger.log(Level.FINER, "finer");
        //logger.log(Level.INFO, "info");
        //logger.log(Level.WARNING, "warning", new Throwable());

        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new MyFormatter());
        consoleHandler.setFilter(new MyFilter());

        Handler fileHandler = new FileHandler("%h/myJavaLog.log");
        fileHandler.setFilter(new MyFilter());
        fileHandler.setFormatter(new MyFormatter());

        //new StreamHandler();
        //new SocketHandler();

        logger.setUseParentHandlers(false);
        logger.addHandler(fileHandler);
        logger.addHandler(consoleHandler);
        logger.info("info");
        logger.info("info max");
    }

    static class MyFilter implements Filter {

        @Override
        public boolean isLoggable(LogRecord record) {
            return record.getMessage().endsWith("max");
        }
    }

    static class MyFormatter extends Formatter {

        @Override
        public String format(LogRecord record) {
            return record.getLevel() + " - " + record.getMessage();
        }
    }
}
