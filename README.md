
# 📚 BookHive

An online platform where users can create or join book clubs, read books together, and participate in discussions.

---

## 🚀 Project Overview
**BookHive** is a social platform for book lovers to engage with others through book clubs, discussions, and reviews. It allows users to explore books, join clubs, participate in discussions, and share their thoughts through ratings and comments. The platform leverages Spring Boot for the backend and React for the frontend, with Redis caching for performance optimization.

---

## 🏗️ Tech Stack
### **Backend:**
- Spring Boot  
- Spring Security (JWT-based authentication)  
- Spring Data JPA (Hibernate)  
- PostgreSQL  
- Redis  
- Docker  

### **Frontend:**
- React  
- React Router  
- Axios  
- Tailwind CSS  

---

## 🎯 Features
### 🔐 **User Management**
✅ User registration and login (JWT-based authentication)  
✅ User profiles with reading history and preferences  
✅ Role-based access (Admin, Member)  

### 📖 **Book Management**
✅ Browse available books  
✅ Search and filter books by genre, author, and rating  
✅ Mark books as read or currently reading  

### 📚 **Book Club Management**
✅ Create and join book clubs  
✅ Manage book club membership  
✅ Assign roles (Owner, Moderator, Member)  
✅ Set reading goals and timelines  

### 💬 **Discussion Forum**
✅ Create discussion threads for books and clubs  
✅ Comment on discussions  
✅ Like and react to comments  
✅ Report inappropriate content  

### 🔔 **Notifications**
✅ Receive notifications for new discussions and replies  
✅ Notify users of new book clubs and invitations  

### ⭐ **Review and Rating**
✅ Rate and review books  
✅ Aggregate ratings for each book  

---

## 🗄️ ER Diagram
### **Entities and Relationships:**
✔️ **User ↔ Membership ↔ BookClub** → (Many-to-Many)  
✔️ **User ↔ Discussion ↔ Book** → (Many-to-Many)  
✔️ **Discussion ↔ Comment** → (One-to-Many)  
✔️ **User ↔ Notification** → (One-to-Many)  
✔️ **User ↔ Review ↔ Book** → (Many-to-Many)  
✔️ **User ↔ Follow ↔ User** → (Many-to-Many)  
✔️ **User ↔ Achievement** → (One-to-Many)  
✔️ **User ↔ Recommendation ↔ Book** → (Many-to-Many)  

---

## 🔄 Flow Diagram
### **User Registration and Login**
1. User registers or logs in  
2. JWT token is generated and sent to the frontend  

### **Browsing Books**
1. User searches or filters books  
2. List of books fetched from the backend  

### **Creating/Joining Book Clubs**
1. User creates or joins a club  
2. Owner assigns roles to members  

### **Discussions**
1. User starts a new discussion  
2. Other members comment on the discussion  

### **Notifications**
1. User receives notifications about new discussions and replies  

### **Reviews and Ratings**
1. User submits a rating and review  
2. Average rating is calculated  

---

## 🌐 API Endpoints
### **User APIs**
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/auth/register` | Register a new user |
| `POST` | `/api/auth/login` | Login and get JWT token |
| `GET` | `/api/users/{id}` | Get user details |
| `PUT` | `/api/users/{id}` | Update user details |

### **Book APIs**
| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/books` | Get all books (with sorting & pagination) |
| `POST` | `/api/books` | Add a new book |
| `GET` | `/api/books/{id}` | Get book details |

### **Book Club APIs**
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/clubs` | Create a new book club |
| `GET` | `/api/clubs` | Get all book clubs (with sorting & pagination) |
| `PUT` | `/api/clubs/{id}` | Update book club details |
| `DELETE` | `/api/clubs/{id}` | Delete a book club |

### **Discussion APIs**
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/discussions` | Create a new discussion |
| `GET` | `/api/discussions/{id}` | Get discussion details |
| `POST` | `/api/comments` | Add a comment to a discussion |

### **Notification APIs**
| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/api/notifications` | Get user notifications |
| `DELETE` | `/api/notifications/{id}` | Delete a notification |

### **Rating APIs**
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/ratings` | Add a rating |
| `GET` | `/api/ratings/{bookId}` | Get average rating for a book |

---

## 🛠️ Setup Instructions
### **Backend Setup**
1. Clone the repository:  
```bash
git clone https://github.com/your-username/bookhive.git
cd bookhive
```

2. Create a `.env` file in the `backend` directory with the following:  
```env
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/social
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=root
JWT_SECRET=mysecretkey
REDIS_HOST=localhost
REDIS_PORT=6379
```

3. Build and run the backend:  
```bash
./mvnw clean install
./mvnw spring-boot:run
```

### **Frontend Setup**
1. Go to the `frontend` directory:  
```bash
cd frontend
```

2. Install dependencies:  
```bash
npm install
```

3. Start the development server:  
```bash
npm start
```

---

## 🔎 Testing with CommandLineRunner
Sample data is automatically loaded using `CommandLineRunner`:  
✅ 2 Sample Users  
✅ 2 Sample Books  
✅ 1 Book Club  
✅ 1 Discussion  
✅ 1 Comment  

---

## 📈 Performance Enhancements
✅ Redis caching for fast book retrieval and user profile loading  
✅ Efficient pagination and sorting with Spring Data JPA  

---

## ✅ Best Practices Followed
✔️ Clean code with proper separation of concerns  
✔️ Role-based access control with Spring Security  
✔️ Efficient query handling with projections and sorting  
✔️ Test-driven development with unit tests and integration tests  

---

## 🏆 Future Enhancements
🚀 Add social login (Google, GitHub)  
🚀 Implement real-time notifications using WebSocket  
🚀 Enhance the recommendation engine with collaborative filtering  

---

## 🏁 Contributors
👤 **[Vivek Pandey]** – [codewithvivekpandey@gmail.com]  

---

## 🌟 License
This project is licensed under the **MIT License**.

🔥 Happy Coding! 😎
