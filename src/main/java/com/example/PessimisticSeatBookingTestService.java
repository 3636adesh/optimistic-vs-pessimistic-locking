package com.example;

import org.springframework.stereotype.Service;

@Service
public class PessimisticSeatBookingTestService {


    private final MovieTicketService movieTicketService;

    public PessimisticSeatBookingTestService(MovieTicketService movieTicketService) {
        this.movieTicketService = movieTicketService;
    }

    public void testPessimisticLocking(Long seatId) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                movieTicketService.bookSeatWithPessimistic(seatId);
            } catch (RuntimeException e) {
                System.out.println(Thread.currentThread().getName() + " failed: " + e.getMessage());
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                movieTicketService.bookSeatWithPessimistic(seatId);
            } catch (RuntimeException e) {
                System.out.println(Thread.currentThread().getName() + " failed: " + e.getMessage());
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
