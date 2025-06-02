package 날짜와시간;
// LocalDate : 년, 월, 일
// LocalTime : 시, 분, 초, 나노초
// LocalDateTime : 날짜, 시간 (시간대 없음)
// ZonedDateTime : 날짜, 시간, 시간대



import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateMain {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        ZonedDateTime zoned = ZonedDateTime.now();

        System.out.println(date);
        System.out.println(time);
        System.out.println(dateTime);
        System.out.println(zoned);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초");
        String rst = dateTime.format(formatter);
        System.out.println(rst);
    }
}
