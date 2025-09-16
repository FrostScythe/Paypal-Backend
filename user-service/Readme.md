# PayPal User Service

A robust Spring Boot microservice for user management, featuring JWT authentication, password encryption, and production-grade architecture.

## 🚀 Quick Start

### Prerequisites
- Java JDK 17 or higher
- Maven 3.6.x or higher
- Your favorite IDE (Spring Tool Suite, IntelliJ IDEA, or VS Code)

### Setup and Installation

1. Clone the repository:
```bash
git clone [repository-url]
cd user-service
```

2. Build the project:
```bash
mvn clean install
```

3. Run the application:
```bash
mvn spring-boot:run
```

The service will start on `http://localhost:8080`

## 🏗 Project Architecture

### Project Structure
```
src/
├── main/
│   ├── java/
│   │   └── com/paypal/user_service/
│   │       ├── controller/     # REST API endpoints (Auth & User)
│   │       ├── dto/           # Data Transfer Objects
│   │       ├── entity/        # JPA Entities
│   │       ├── mapper/        # DTO <-> Entity converters
│   │       ├── repository/    # Data access layer
│   │       ├── security/      # Security configurations
│   │       ├── service/       # Business logic
│   │       └── util/          # JWT utilities & filters
│   └── resources/
│       └── application.properties  # Application configuration
└── test/
    └── java/                  # Test cases
```

### Architectural Flow
1. Client Request → AuthController/UserController (REST Layer)
2. DTOs (Data Validation)
3. Mapper (DTO ↔ Entity conversion)
4. Service (Business Logic)
5. Repository (Data Access)
6. Database

## 🔐 Security Features
- Spring Security with JWT authentication
- Password encryption (BCrypt)
- API endpoint protection
- CSRF disabled (for API usage)

## 📡 API Endpoints

### Authentication
```
POST /auth/signup        - Register a new user
POST /auth/login         - Login and receive JWT token
```

#### Example: Signup
```json
POST /auth/signup
Request:
{
    "name": "John Doe",
    "email": "john@example.com",
    "password": "securePassword123"
}
Response:
"User registered successfully" or error message
```

#### Example: Login
```json
POST /auth/login
Request:
{
    "email": "john@example.com",
    "password": "securePassword123"
}
Response:
{
    "token": "<JWT_TOKEN>",
    "email": "john@example.com"
}
```

### User Management
```
POST /api/users/create     - Create a new user
GET  /api/users/{id}      - Get user by ID
GET  /api/users/all       - Get all users
```

#### Example: Create User
```json
POST /api/users/create
Request:
{
    "name": "Jane Doe",
    "email": "jane@example.com",
    "password": "anotherPassword"
}
Response:
{
    "id": 2,
    "name": "Jane Doe",
    "email": "jane@example.com"
}
```

## 🔧 Technical Implementation

### Key Components

#### 1. Data Transfer Objects (DTO)
- Separate API contract from database entities
- Input validation using Jakarta validation
- Security through data filtering

```java
@NotBlank(message = "Name cannot be blank")
private String name;

@Email(message = "Invalid email format")
private String email;
```

#### 2. Service Layer
- Interface-based design for loose coupling
- Business logic implementation
- Transaction management

#### 3. Repository Layer
- JPA implementation
- Database operations
- Custom query methods

#### 4. JWT Authentication
- JWT token generation and validation
- Request filtering for protected endpoints
- Stateless authentication

## 🧪 Testing

Run tests using:
```bash
mvn test
```

## 🛠 Production-Grade Features

1. **Clean Architecture**
   - Layered approach
   - Separation of concerns
   - Interface-based design

2. **Security**
   - JWT authentication
   - Password encryption
   - Protected endpoints
   - Input validation

3. **Data Management**
   - DTO pattern
   - Entity mapping
   - Validation

4. **Best Practices**
   - SOLID principles
   - DRY (Don't Repeat Yourself)
   - Dependency Injection

## 📚 Technical Stack

- **Framework**: Spring Boot 3.x
- **Security**: Spring Security, JWT
- **Database**: JPA/Hibernate
- **Build Tool**: Maven
- **Testing**: JUnit 5

## 🎯 For Interviewers

Key technical highlights that demonstrate production-readiness:

1. **Architecture**
   - Clear separation of concerns
   - DTO pattern implementation
   - Interface-based service layer

2. **Security Measures**
   - Spring Security integration
   - JWT authentication
   - Password encryption
   - Protected endpoints

3. **Code Quality**
   - SOLID principles
   - Clean architecture
   - Proper error handling

4. **Production Readiness**
   - Input validation
   - Error handling
   - Proper logging

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch
3. Commit changes
4. Push to the branch
5. Create a Pull Request

## 📝 Development Notes

### Future Enhancements
- Add role-based access control
- Add API documentation with Swagger
- Implement caching
- Add monitoring and metrics

### Known Issues
- None at the moment

## 📜 License

[Add your license information here]

## 👥 Authors

[Your Name/Team Information]

---

For any questions or issues, please open a GitHub issue or contact the maintainers.
