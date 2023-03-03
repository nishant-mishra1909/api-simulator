# api-simulator

The Simulator app is a Spring Boot application that can simulate different scenarios for testing and development purposes. It allows developers to define mappings between incoming requests and outgoing responses, making it ideal for testing APIs and microservices. The app is built on top of WireMock, a popular open-source tool for mocking HTTP services, which provides a variety of options for defining request/response mappings.

In addition to basic request/response mappings, the Simulator app also supports more complex mappings using templates, regular expressions, and data-driven testing. This allows developers to simulate real-world scenarios, including error conditions, retries, and load testing. The app also includes built-in support for monitoring and logging, with metrics provided by Micrometer and extended JSON logging for easy integration with popular log analysis tools like Splunk.

The app is designed to be easy to configure and deploy, with support for Docker containers and Kubernetes orchestration. It also includes a user-friendly UI for managing mappings and viewing metrics, making it a powerful tool for testing and development teams.
