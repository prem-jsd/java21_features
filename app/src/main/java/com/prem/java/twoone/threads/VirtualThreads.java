package com.prem.java.twoone.threads;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * todo:: jep444
 * todo:: virtual threads are light weight threads that dramatically reduce the effort of writing, maintaining and observing
 * todo::  high-throughput concurrent applications.  Up till now, threads were implemented as wrappers around Operating System (OS)
 * todo::  threads.  OS threads are costly and if you are sending an http request to another server, you will block this thread until
 * todo::  you have received the answer of the server.  This processing part (creating the request and processing the answer) is just
 * todo::  a small portion of the enter time the thread was blocked.  Sending the request and waiting for the answer takes up much
 * todo::  more time than the processing part.  A way to circumvent this, is to use asynchronous style. Disadvantage of this approach is
 * todo::  the more complex implementation.  This is where virutal threads come to the rescue. You are able to keep the implementation
 * todo::  like you did before and still have the scalability of the asynchronous style.
 *
 */
public class VirtualThreads {

    public static void main(String[] args) {
        testPlatformThreads(1000);
        testPlatformThreads(10_000);
        testPlatformThreads(100_000);
        testPlatformThreads(1_000_000);
    }

    private static void testPlatformThreads(int maximum) {
        long time = System.currentTimeMillis();

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, maximum).forEach(i -> {
                executor.submit(() -> {
                    Thread.sleep(Duration.ofSeconds(1));
                    return i;
                });
            });
        }

        time = System.currentTimeMillis() - time;
        System.out.println("Number of threads = " + maximum + ", Duration(ms) = " + time);
    }

}
