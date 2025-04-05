package com.birhgkut.lock;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class BookingService {
    private final SeatRepository seatRepository;

    public BookingService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public void testOptimistic(Long seatId) throws InterruptedException {
        Thread user1 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "is attempting to book seat");
                Seat seat = bookSeatOptimistic(seatId);
                System.out.println(
                        Thread.currentThread().getName() + "is booking successfully with version" + seat.getVersion());
            } catch (Exception e) {
                System.out.println(
                        Thread.currentThread().getName() + "is failed when booking with message: " + e.getMessage());
            }
        });
        Thread user2 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "is attempting to book seat");
                Seat seat = bookSeatOptimistic(seatId);
                System.out.println(
                        Thread.currentThread().getName() + "is booking successfully with version" + seat.getVersion());
            } catch (Exception e) {
                System.out.println(
                        Thread.currentThread().getName() + "is failed when booking with message: " + e.getMessage());
            }
        });

        user1.start();
        user2.start();
        user1.join();
        user2.join();

    }

    @Transactional
    public Seat bookSeatOptimistic(Long seatId) {
        Seat seat = seatRepository.findById(seatId).orElseThrow(() -> new RuntimeException("Seat not found"));

        System.out.println(Thread.currentThread().getName() + " fetch seat from DB with verion: " + seat.getVersion());

        if (seat.isBooked()) {
            throw new RuntimeException("Seat is already booked.");
        }

        seat.setBooked(true);

        return seatRepository.save(seat);
    }
}
