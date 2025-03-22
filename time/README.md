## Learn Time

### Package (Time)
- We use `LocalDate` class to get the date from the computer only with this format `2025-03-23` (`YYYY-MM-DD`)
- We use `LocalTime` class to get the time from the computer only with this format `00-30-23.036030` (`HH-MM-SS.SSSSSS`) -> with microseconds
- We use `LocalDateTime` class to get the date time from the computer only with this format `2025-03-23T00:30:23.036053` (`YYYY-MM-DDTHH-MM-SS.SSSSSS`)
- We use `ZonedDateTime` class to get the date time with time zone from the computer only with this format `2025-03-23T00:30:23.037070+07:00[Asia/Bangkok]` (`YYYY-MM-DDTHH-MM-SS.SSSSSS+07:00[Asia/Bangkok]`)
- We use `TimeZone.getDefault()` to get the default time zone from your computer
- We use `DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")` to define date time format and assign to `ZonedDateTime` with
`.format(...)` function
- We use string `2024-05-02T10:15:30+07:00[Asia/Bangkok]` with `ZonedDateTime.parse(...)` to parse string to `ZonedDateTime`
- We use `Period.between(...)` to compare date without time
- We use `ChronoUnit.DAYS.between(...,...)` or `Duration.between(...,...)` to compare with time 