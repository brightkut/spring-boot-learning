package com.brightkut.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) {
        // time of our computer
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        TimeZone timeZone = TimeZone.getDefault();

        System.out.println("LocalDate: " + localDate);
        System.out.println("LocalTime: " + localTime);
        System.out.println("LocalDateTime: " + localDateTime);
        System.out.println("ZonedDateTime: " + zonedDateTime);
        System.out.println("TimeZone: " + timeZone);

        System.out.println("---------------- After Change Time Zone to UTC -----------------------");

        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        LocalDate localDate2 = LocalDate.now();
        LocalTime localTime2 = LocalTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.now();
        ZonedDateTime zonedDateTime2 = ZonedDateTime.now();
        TimeZone timeZone2 = TimeZone.getDefault();

        System.out.println("LocalDate: " + localDate2);
        System.out.println("LocalTime: " + localTime2);
        System.out.println("LocalDateTime: " + localDateTime2);
        System.out.println("ZonedDateTime: " + zonedDateTime2);
        System.out.println("TimeZone: " + timeZone2);

        System.out.println("---------------- Before Formatting -----------------------");
        ZonedDateTime zonedDateTime3 = ZonedDateTime.now();
        System.out.println("ZonedDateTime: " + zonedDateTime3);
        System.out.println("---------------- After Formatting -----------------------");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("ZonedDateTime: " + zonedDateTime3.format(dateTimeFormatter));

        System.out.println("---------------- Parse String to Zoned DateTime -----------------------");
        ZonedDateTime zonedDateTime4 = ZonedDateTime.parse("2024-05-02T10:15:30+07:00[Asia/Bangkok]");
        System.out.println("ZonedDateTime: " + zonedDateTime4);

        System.out.println("---------------- Calculate Period of 2 Zoned DateTime -----------------------");
        ZonedDateTime zonedDateTime5 = ZonedDateTime.parse("2024-05-02T23:15:30+07:00[Asia/Bangkok]");
        ZonedDateTime zonedDateTime6 = ZonedDateTime.parse("2024-05-03T10:15:30+07:00[Asia/Bangkok]");

        // #1 not suggest to use because not calculate time
        int days = Period.between(zonedDateTime5.toLocalDate(), zonedDateTime6.toLocalDate()).getDays();

        // #2 suggest to use
        long days2 = ChronoUnit.DAYS.between(zonedDateTime5,zonedDateTime6);

        // #3 suggest to use
        Duration duration = Duration.between(zonedDateTime5, zonedDateTime6);
        long days3 = duration.toDays();

        // It is not calculate time
        System.out.println("Days from Period (Not Recommend): "+days);
        // It calculates time
        System.out.println("Days from ChronosUnit (Recommend): "+days2);
        System.out.println("Days from Duration (Recommend): "+days3);

    }
}
