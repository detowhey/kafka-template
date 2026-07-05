# Person Consumer Service

This is a data processing microservice responsible for consuming person-related messages from an **Apache Kafka** topic and persisting this information into a **MongoDB** database.

## 🚀 Technologies
- **Java 21**
- **Spring Boot 3**
- **Spring Cloud Stream Kafka** (Messaging)
- **Spring Data MongoDB**
- **Docker & Docker Compose** (Automatically managed by Spring)

## 📋 Prerequisites
To run this project, you need to have the following installed on your machine:
1. [Docker Desktop](https://www.docker.com/products/docker-desktop/) (or Docker Engine + Docker Compose).
2. [JDK 21](https://adoptium.net/) installed.

## ⚙️ How to run

This project uses the `spring-boot-docker-compose` dependency. This means **you do not need to run manual Docker commands** to bring up the infrastructure.

1. Clone the repository.
2. Ensure **Docker Desktop** is running on your machine.
3. Start the application through your IDE (IntelliJ, Eclipse, VS Code) or via the terminal:
   ```bash
   ./gradlew bootRun

**What will happen automatically:**

* Spring Boot will detect the `docker-compose.yml` file.
* It will automatically spin up the **MongoDB**, **Kafka**, and **Kafka UI** containers.
* When you stop the application, the containers will be managed/paused by Spring.

## 🌐 Support Tools

### Kafka UI
Access [http://localhost:8081](http://localhost:8081). This interface is used to visualize the Kafka cluster, topics, and, most importantly, to manually create test messages in the `register-person-topic` topic.

### MongoDB
To view the persisted data, you can connect your **MongoDB Compass** or any other database client using the following connection string:

`mongodb://root:secret@localhost:27017/persondatabase?authSource=admin`

## 🛠️ Messaging Structure
The service consumes messages from the `register-person-topic` topic through the `person-consumer-group` consumer group. Serialization and deserialization are handled automatically via JSON (`application/json`).