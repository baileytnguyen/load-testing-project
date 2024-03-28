package edu.uta.loadtestingproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@RestController
public class LoadTestingProjectApplication {
    private static final Logger logger = LoggerFactory.getLogger(LoadTestingProjectApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LoadTestingProjectApplication.class, args);
    }

    @GetMapping("/primes")
    public List<Integer> generatePrimeNumbers(@RequestParam("start") int start, @RequestParam("end") int end) {
        long startTime = System.currentTimeMillis(); // Record start time

        List<Integer> primes = new ArrayList<>();

        for (int num = start; num <= end; num++) {
            boolean isPrime = true;
            if (num <= 1) {
                isPrime = false;
            } else {
                for (int i = 2; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            if (isPrime) {
                primes.add(num);
            }
        }

        long endTime = System.currentTimeMillis(); // Record end time
        long latency = endTime - startTime; // Calculate latency

        logger.info("Generated prime numbers from {} to {}: Latency: {} ms", start, end, latency);

        return primes;
    }

    @GetMapping("/ping")
    public String ping() {
        UUID randomId = UUID.randomUUID();
        return "pong! Random ID: " + randomId;
    }


}
