# PayPal User Service

A robust Spring Boot microservice that handles user management operations with production-grade implementation.

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
│   │       ├── controller/     # REST API endpoints
│   │       ├── dto/           # Data Transfer Objects
│   │       ├── entity/        # JPA Entities
│   │       ├── mapper/        # DTO <-> Entity converters
│   │       ├── repository/    # Data access layer
│   │       ├── security/      # Security configurations
│   │       └── service/       # Business logic
│   └── resources/
│       └── application.properties  # Application configuration
└── test/
    └── java/                  # Test cases
```

### Architectural Flow
1. Client Request → UserController (REST Layer)
2. UserDTO (Data Validation)
3. UserMapper (DTO ↔ Entity conversion)
4. UserService (Business Logic)
5. UserRepository (Data Access)
6. Database

## 🔐 Security Features
- Spring Security implementation
- Password encryption
- API endpoint protection
- CSRF security measures

## 📡 API Endpoints

### User Management
```
POST /api/users/create     - Create a new user
GET  /api/users/{id}      - Get user by ID
GET  /api/users/all       - Get all users
```

### Request/Response Examples

#### Create User
```json
POST /api/users/create
Request:
{
    "name": "John Doe",
    "email": "john@example.com",
    "password": "securePassword123"
}

Response:
{
    "id": 1,
    "name": "John Doe",
    "email": "john@example.com"
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
- **Security**: Spring Security
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
- Implement JWT authentication
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
