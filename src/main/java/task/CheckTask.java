package task;

import check.RestChecker;

import java.text.DateFormat;
import java.util.Date;
import java.util.TimerTask;

public class CheckTask extends TimerTask {
    public void run() {

        System.out.println("Start check " + getDate());

        RestChecker request = new RestChecker("http://issou-randomizer.herokuapp.com/issou/wallpaper/random");
        request.sendMailIfNotResponded("jordanmarques1994@gmail.com", "issou-randomizer");

        RestChecker request2 = new RestChecker(" https://issou-front.herokuapp.com");
        request2.sendMailIfNotResponded("jordanmarques1994@gmail.com", "issou-front");

        System.out.println("End check " + getDate());
    }

    private String getDate() {
        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
                DateFormat.SHORT,
                DateFormat.SHORT);
        return shortDateFormat.format(new Date());
    }
}
