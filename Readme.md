# NaikiSDA - Web Application

NaikiSDA is a web application built using Java and MySQL that provides an admin login interface and allows users to perform various tasks. This readme provides instructions on how to set up and run the application.

## Prerequisites

Before running the NaikiSDA web application, make sure you have the following:

- MySQL installed on your machine
- Eclipse IDE installed

## Setup

Follow these steps to set up and run the NaikiSDA web application:

1. Clone or download the repository to your local machine.

2. Open MySQL and execute the "NaikiSchema.sql" file located in the "Code" folder. This will create the necessary database schema for the application.

3. Open Eclipse IDE.

4. Click on **File** -> **Open Project From File Systems**.

5. In the **Import Source** section, select the path to the "Code" folder, and inside the folder, select the "NaikiSDA" folder from the "eclipse-workspace" directory.

6. Click **Finish** to import the project into Eclipse.

7. Once the project is imported, navigate to the following path:
   `NaikiSDA -> src -> main -> webapp -> WEB-INF -> Login.jsp`

8. Right-click on "Login.jsp" and select **Run As** -> **Run on server**.

9. Select **Apache Tomcat v9.0** as the run environment.

10. In the server configuration path, specify `/Servers/Tomcat v9.0 Server at localhost-config`.

11. The application will now start running on the selected server.

12. To access the admin login, use the following credentials:
    - Username: "zarmeenkaz"
    - Password: "112233"

Please note that you may need to configure the database connection settings in the application based on your local MySQL setup.

## Group Partners

This project was developed by the following group partners:

- Hamza Ahmad
- Noureen Fatima
- Zarmeen Zehra
- Fatima Tajammul
- Alishba Farooq
