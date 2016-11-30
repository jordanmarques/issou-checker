import task.CheckTask;

import java.util.Timer;

public class Application {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new CheckTask(), 0, 1000 * 60);
    }
}
