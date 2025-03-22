package com.brightkut.serialize.serialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeDeserializer extends JsonDeserializer<ZonedDateTime> {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public ZonedDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException{
        String date = p.getText();
        LocalDate localDate = LocalDate.parse(date, dateTimeFormatter);
        // Convert LocalDate to ZonedDateTime, assuming the default time as start of the day and default timezone
        return localDate.atStartOfDay(ZoneId.of("Asia/Bangkok"));
    }
}
