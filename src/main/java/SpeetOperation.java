import java.time.LocalDateTime;
import java.util.Date;

public class SpeetOperation {
    public static void main(String[] args) {

        String x1 = 1 + "";
        String y1 = 2 + "";
        String result = "123";

        Date time1 = new Date();
        for (long i = 0; i < 2_036_854_775_807L; i++) {
            result = x1 + y1;
        }
        Date time2 = new Date();

        System.out.println(time2.getTime() - time1.getTime());

    }
}
