
class Logger {
    private static Logger instance;

    private Logger() {
        // Private constructor to prevent instantiation
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}

class Singleton {
    public static void main(String[] args) {
       Logger logger1 = Logger.getInstance();

        logger1.log("Application Started");

        Logger logger2 = Logger.getInstance();

        logger2.log("User Logged In");

        Logger logger3 = Logger.getInstance();

        logger3.log("Money Transfer Completed");

        System.out.println();

        System.out.println("Logger1 HashCode : "
                + logger1.hashCode());

        System.out.println("Logger2 HashCode : "
                + logger2.hashCode());

        System.out.println("Logger3 HashCode : "
                + logger3.hashCode());
    }
}