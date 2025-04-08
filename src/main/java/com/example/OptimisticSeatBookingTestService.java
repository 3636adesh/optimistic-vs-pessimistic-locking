package com.example;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OptimisticSeatBookingTestService {

    private final MovieTicketService movieTicketService;

    public void bookSeat(long seatId) throws InterruptedException {
        var t1 = Thread.ofPlatform().name("Thread 1").start(()-> {
                    book(seatId);
                }
        );
        var t2 = Thread.ofPlatform().name("Thread 2").start(()-> {
                    book(seatId);
                }
        );

        t1.join();
        t2.join();

    }

    private void book(long seatId) {
            try {
                System.out.println(Thread.currentThread().getName() + " is attempting to book the seat");
                Seat seat = movieTicketService.bookSeat(seatId);
                System.out.println(Thread.currentThread().getName() + " successfully booked the seat with version " + seat.getVersion());
            } catch (Exception ex) {
                System.out.println(Thread.currentThread().getName() + " failed : " + ex.getMessage());
            }
    }


}
