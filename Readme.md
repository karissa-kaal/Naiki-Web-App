# NaikiSDA - Web Application

NaikiSDA is a web application built using Java and MySQL that provides an admin login interface and allows users to perform various tasks. This readme provides instructions on how to set up and run the application.


## Phases

The development of NaikiSDA was divided into three phases:

### Phase 1 - Use Cases and Analysis Class Diagram

In this phase, the use cases for the application were defined, and an analysis class diagram was created. The use cases helped identify the various functionalities of the application, while the analysis class diagram depicted the relationships between different classes.
`Documentation -> Phase1.pdf`

### Phase 2 - Design Class Diagram, Sequence Diagrams, and Package Diagram

During the second phase, a design class diagram, sequence diagrams, and a package diagram were created. The design class diagram represented the class structure of the application, showcasing the relationships and attributes of each class. The sequence diagrams illustrated the flow of interactions between different components of the application. The package diagram depicted the organization and dependencies of different packages within the project.
`Documentation -> Phase2.pdf`

### Phase 3 - Complete Executable Java Web Application and Software Architecture Document (SAD)

The third phase involved the development of a fully functional Java web application. The application was implemented using Eclipse IDE and connected to a MySQL database. It incorporated the functionalities defined in the use cases and adhered to the design specifications from the previous phases. Additionally, a Software Architecture Document (SAD) was created to provide an overview of the application's architecture, including details on the chosen technologies, system components, and deployment strategy.
`Documentation -> SAD.pdf`

## Software Used

The following software tools were used in the development of NaikiSDA:

- Eclipse IDE: An integrated development environment for Java development.
- MySQL: A relational database management system used to store and retrieve data.

## UML Diagrams

Throughout the project, various UML diagrams were created to aid in the design and understanding of the application. These diagrams include:

- Use Case Diagrams: Illustrating the different use cases and interactions between actors and the system.
- Class Diagrams: Depicting the class structure, relationships, and attributes of the application.
- Sequence Diagrams: Visualizing the flow of interactions between different components or objects.
- Package Diagrams: Representing the organization and dependencies of different packages within the project.

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
