import java.time.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        person p1=new person();
        LocalDate dob = LocalDate.of(1999, 11, 17);
        p1.setPerson("Emam", "19-2",dob);
        LocalDate curDate = LocalDate.now();
        Period period = Period.between(dob, curDate);
        p1.show();
        System.out.printf("Your age is %d years %d months and %d days.", period.getYears(), period.getMonths(), period.getDays());
    }
}