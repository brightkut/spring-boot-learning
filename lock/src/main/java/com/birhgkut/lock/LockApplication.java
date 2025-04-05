package com.birhgkut.lock;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LockApplication implements CommandLineRunner {

    private final SeatRepository seatRepository;

    public LockApplication(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(LockApplication.class, args);
    }

    @Override
    public void run(String... args) {

        Seat seat = new Seat();
        seat.setBooked(false);
        seat.setMovieName("Harry Potter");
        seat.setVersion(0);

        Seat seat2 = new Seat();
        seat2.setBooked(false);
        seat2.setMovieName("Harry Potter");
        seat2.setVersion(0);

        seatRepository.saveAll(List.of(seat, seat2));
    }
}
