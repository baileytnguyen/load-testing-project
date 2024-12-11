# jmeter-testing-prime-number-generator

## Description

PrimeNumberGeneratorApplication is a Spring Boot application that generates prime numbers within a specified range. The application exposes a RESTful API endpoint to generate prime numbers and logs the latency of the operation. This project is designed to be used with Apache JMeter for load testing.

## Features

- Generate prime numbers within a specified range.
- RESTful API endpoint to request prime numbers.
- Logs the latency of the prime number generation process.
- Designed for load testing with Apache JMeter.

## Requirements

- Java 11 or higher
- Maven
- Spring Boot
- Apache JMeter

## Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/prime-number-generator-application.git
   ```
2. Navigate to the project directory:
   ```sh
   cd prime-number-generator-application
   ```
3. Build the project using Maven:
   ```sh
   mvn clean install
   ```

## Usage

1. Run the application:
   ```sh
   mvn spring-boot:run
   ```
2. Access the prime number generation endpoint:
   ```
   GET http://localhost:8080/primes?start=0&end=10
   ```
   This will generate prime numbers from 0 to 10,000,000.

## API Endpoints

- `GET /primes?start={start}&end={end}`: Generates prime numbers within the specified range.
  - `start`: The starting number of the range (default is 0).
  - `end`: The ending number of the range (multiplied by 1,000,000).

## Load Testing with JMeter

1. Download and install [Apache JMeter](https://jmeter.apache.org/download_jmeter.cgi).
2. Create a new test plan in JMeter.
3. Add a Thread Group to the test plan.
4. Add an HTTP Request sampler to the Thread Group.
   - Set the method to `GET`.
   - Set the URL to `http://localhost:8080/primes`.
   - Add parameters `start` and `end` with appropriate values.
5. Add a Listener (e.g., View Results Tree) to the Thread Group to view the results.
6. Run the test plan to perform load testing on the application.

## Example

Request:
