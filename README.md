# 🚂 Railway Ticket Booking System

A comprehensive system designed to manage and facilitate the booking of railway tickets. This project aims to provide an efficient and user-friendly platform for passengers to book, view, and cancel train tickets.

## ✨ Features

The system includes the core functionalities required for a complete railway booking experience.

* **User Authentication:** Secure login and registration for new and existing users.
* **Search Functionality:** Search for trains based on source station, destination station, and date of journey.
* **Ticket Booking:** Select preferred train, class (e.g., Sleeper, AC), and number of seats to book tickets.
* **PNR Status Check:** Check the real-time status (Confirmed, Waiting List) of a booked ticket.
* **Cancellation:** Easily cancel booked tickets and process refunds.
* **Local Data Storage:** Management of user profiles and booking records, possibly using a local database (as suggested by the `localdb/users` folder).

## 🛠️ Technologies Used

The core of this system is built using the following technologies:

| Technology | Purpose |
| :--- | :--- |
| **Java** | Primary programming language for business logic and application development. |
| **Gradle** | Build automation tool for managing dependencies and compiling the project. |
| **Local Database** | Used for persistent storage of user and booking data (e.g., SQLite or flat files). |
| **Android SDK** (If an Android App) | Used for developing the mobile application interface. |

## ⚙️ Installation and Setup

Follow these steps to get a local copy of the project up and running for development and testing.

### Prerequisites

* **Java Development Kit (JDK)** (Version 8 or higher is recommended)
* **Gradle** (If not using an IDE with built-in Gradle support)
* An Integrated Development Environment (IDE) like **IntelliJ IDEA** or **Android Studio**.

### Steps

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/prasangsawla76-design/RailwayTicketbookingSystem.git](https://github.com/prasangsawla76-design/RailwayTicketbookingSystem.git)
    ```
2.  **Navigate to the project directory:**
    ```bash
    cd RailwayTicketbookingSystem
    ```
3.  **Open the project in your IDE:**
    * If using IntelliJ/Android Studio, select "Open an existing project" and choose the `RailwayTicketbookingSystem` directory. The IDE should automatically detect and sync the Gradle project.
4.  **Build the project:**
    * The Gradle wrapper (`gradlew` or `gradlew.bat`) is included. You can build the project from the command line:
    ```bash
    # For Linux/macOS
    ./gradlew build

    # For Windows
    .\gradlew.bat build
    ```
5.  **Run the application:**
    * **For Console/Desktop App:** Find the main class (e.g., `main()` method) within the `TrainBookingSystem` directory and run it from your IDE.
    * **For Android App:** Use Android Studio to install and run the application on an emulator or physical device.

## 🚀 Usage

1.  **Start the Application:** Launch the application (either the console interface or the mobile app).
2.  **Registration/Login:** Create a new user account or log in with existing credentials.
3.  **Search Trains:** Input your desired origin, destination, and travel date.
4.  **Book Ticket:** Select a train and follow the prompts to complete the booking.
5.  **Manage Bookings:** View your booked tickets or cancel a journey from the user dashboard.

## 🤝 Contributing

Contributions are what make the open-source community an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1.  Fork the Project.
2.  Create your Feature Branch (`git checkout -b feature/AmazingFeature`).
3.  Commit your Changes (`git commit -m 'Add some AmazingFeature'`).
4.  Push to the Branch (`git push origin feature/AmazingFeature`).
5.  Open a Pull Request.


## 📧 Contact

**Prasang Sawla** - prasangsawla76@gmail.com

Project Link: [https://github.com/prasangsawla76-design/RailwayTicketbookingSystem](https://github.com/prasangsawla76-design/RailwayTicketbookingSystem)

