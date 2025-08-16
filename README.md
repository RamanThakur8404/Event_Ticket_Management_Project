# 🎟️ Event Ticket Management System

![GitHub stars](https://img.shields.io/github/stars/RamanThakur8404/Event_Ticket_Management_Project?style=social)
![GitHub forks](https://img.shields.io/github/forks/RamanThakur8404/Event_Ticket_Management_Project?style=social)

A full-stack web application designed to streamline event and ticket management. This platform allows organizers to create events, manage ticket sales, and provides a seamless experience for users to purchase tickets for their favorite events.

---

## 📋 Table of Contents

1.  [About The Project](#-about-the-project)
    -   [Key Features](#-key-features)
    -   [Built With](#-built-with)
2.  [Getting Started](#-getting-started)
    -   [Prerequisites](#-prerequisites)
    -   [Installation](#-installation)
3.  [Usage](#️-usage)
4.  [API Endpoints](#-api-endpoints)
5.  [Contributing](#-contributing)
6.  [Contact](#-contact)

---

## 📖 About The Project

This project provides a centralized platform for event organizers and attendees. Organizers can effortlessly create and manage event listings, while users can browse, search, and securely purchase tickets. The system is designed with a clean separation between the frontend client and the backend server, ensuring maintainability and scalability.

### ✨ Key Features

* **User Authentication:** Secure user registration and login functionality.
* **Event Management:** Organizers can create, update, and delete events.
* **Ticket Booking:** Users can browse events and book tickets.
* **Event Search:** Users can search for events by name or category.
* **Responsive UI:** A user-friendly interface built with React that works on different devices.
* **RESTful API:** A well-structured backend API built with Spring Boot.

### 🛠️ Built With

This project is built with the following technologies:

* **Frontend:**
    * [React.js](https://reactjs.org/)
    * [Axios](https://axios-http.com/) for API requests
    * CSS for styling
* **Backend:**
    * [Spring Boot](https://spring.io/projects/spring-boot)
    * [Spring Data JPA](https://spring.io/projects/spring-data-jpa) / Hibernate
    * [Maven](https://maven.apache.org/) for dependency management
    * [Spring Security](https://spring.io/projects/spring-security) for authentication & authorization
* **Database:**
    * [MySQL](https://www.mysql.com/)

---

## 🚀 Getting Started

To get a local copy up and running, follow these simple steps.

### ✅ Prerequisites

Make sure you have the following installed on your machine:

* Java Development Kit (JDK 17 or later)
* Maven
* MySQL Server
* Node.js (for the frontend)
* npm (Node Package Manager)

### 💻 Installation

1.  **Clone the repository**
    ```sh
    git clone [https://github.com/RamanThakur8404/Event_Ticket_Management_Project.git](https://github.com/RamanThakur8404/Event_Ticket_Management_Project.git)
    cd Event_Ticket_Management_Project
    ```

2.  **Configure the Backend**
    * Navigate to the `server` directory.
    * Open the `src/main/resources/application.properties` file.
    * Update the `spring.datasource` properties to point to your local or remote MySQL database. You will need to create a database schema for the project first.
    ```properties
    # src/main/resources/application.properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your_event_db_schema
    spring.datasource.username=your_mysql_username
    spring.datasource.password=your_mysql_password
    spring.jpa.hibernate.ddl-auto=update
    ```

3.  **Install Frontend Dependencies**
    Navigate to the `client` directory and install the required packages.
    ```sh
    cd ../client
    npm install
    ```

---

## ⚙️ Usage

Once the installation and configuration are complete, you can run the application.

1.  **Start the Backend Server**
    From the `server` directory, run the following Maven command:
    ```sh
    mvn spring-boot:run
    ```
    The backend API will be running on `http://localhost:8080`.

2.  **Start the Frontend Application**
    From the `client` directory, run:
    ```sh
    npm start
    ```
    The frontend React application will open in your browser at `http://localhost:3000`.

You can now register a new user, create events, and book tickets through the web interface.

---

## API Endpoints

The backend server exposes the following RESTful API endpoints:

* `POST /register`: Register a new user.
* `POST /login`: Log in an existing user.
* `POST /events`: Create a new event.
* `GET /events`: Fetch all events.
* `GET /events/search/:key`: Search for events by name or category.
* `GET /events/:id`: Get details for a specific event.
* `PUT /events/:id`: Update an event.
* `DELETE /events/:id`: Delete an event.
* `POST /bookings`: Create a new booking.
* `GET /bookings`: Fetch all bookings.

---

## 🤝 Contributing

Contributions are welcome! If you have suggestions to improve the project, please fork the repository and create a pull request.

1.  Fork the Project
2.  Create your Feature Branch (`git checkout -b feature/NewFeature`)
3.  Commit your Changes (`git commit -m 'Add some NewFeature'`)
4.  Push to the Branch (`git push origin feature/NewFeature`)
5.  Open a Pull Request

---

## 📞 Contact

Raman Thakur - [GitHub Profile](https://github.com/RamanThakur8404)

Project Link: [https://github.com/RamanThakur8404/Event_Ticket_Management_Project](https://github.com/RamanThakur8404/Event_Ticket_Management_Project)
