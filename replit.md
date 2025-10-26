# Weather App

## Overview
This is a Spring Boot 3.5.7 weather application built with Java 21. The application uses Spring Data JPA for database operations, H2 as an embedded in-memory database, and Spring Boot Actuator for monitoring.

## Project Architecture
- **Framework**: Spring Boot 3.5.7
- **Java Version**: Java 21
- **Build Tool**: Maven 3.8.6
- **Database**: H2 (in-memory)
- **Dependencies**:
  - Spring Boot Starter Web
  - Spring Boot Starter Data JPA
  - Spring Boot Starter Cache
  - Spring Boot Starter Actuator
  - H2 Database
  - Lombok

## Configuration
- **Server Port**: 5000
- **Server Address**: 0.0.0.0 (accessible from all interfaces)
- **Database**: H2 in-memory database (`jdbc:h2:mem:weatherdb`)
- **H2 Console**: Enabled at `/h2-console`
- **Actuator Endpoints**: Available at `/actuator` (health, info)

## Development
The application runs on port 5000 and is configured to accept connections from all hosts, making it compatible with the Replit proxy environment.

### Running the Application
The application is automatically started via the configured workflow which runs:
```bash
export JAVA_HOME=$(dirname $(dirname $(which java))) && mvn spring-boot:run
```

### Available Endpoints
- `/` - Application root
- `/h2-console` - H2 Database Console
- `/actuator/health` - Health check endpoint
- `/actuator/info` - Application info endpoint

## Recent Changes
- **2025-10-26**: Initial setup in Replit environment
  - Installed Java 21 (OpenJDK 21.0.7)
  - Configured H2 embedded database
  - Set server to run on port 5000 with 0.0.0.0 binding
  - Enabled H2 console for database management
  - Configured Spring Boot Actuator for monitoring
