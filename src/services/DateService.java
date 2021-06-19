package services;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateService {

    public String getCreatedDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }

    public String getDeliveredDate() {
            System.out.println("Доставлена");
            return getCreatedDate();
    }

}
