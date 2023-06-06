
This is the README file for a project based on Spring 3.1.0 and Java 17. 

Project description
This project is based on the Spring framework and uses Java 17. The assumption of the project is to return information about the user using the Github platform:
- return names of all user repositories that are not forked
- returning owner login for the user
- names of each branch
- ssh of the last commit for a given branch

Requirements
To run this project, you must have the following tools and environment installed:

Java Development Kit (JDK) 17
Apache Maven
Spring Framework
Other dependencies (see pom.xml file)
Installation
Clone the repository to your local environment:
https://github.com/MateuszLesisz/Atipera.git
Go to the project directory:
cd project_name
Start building the project using Apache Maven:
mvn clean install

Configuration
The project does not use a database, so no new configurations are needed.

Startup
To run the application, follow these steps:

Go to the project directory:
cd project_name
Run the application using the Maven command:
mvn spring-boot:run
After successful launch, the application will be available at http://localhost:8080/api/users/{username}.

Documentation
The application provides one endpoint:
- http://localhost:8080/api/users/{username} which returns all information from the project description.

The application connects to the Github Api (https://developer.github.com/v3)
Endpoints used:
- https://api.github.com/users/{username}/repos -> Lists public repositories for the specified user
- https://api.github.com/repos/{owner}/{repo}/branches -> list all branches for the specific repo
- https://api.github.com/users/{username} -> check the specific user exist

Making changes
If you wish to make changes to this design, please follow the following process:

Create a branch for your changes:
git checkout -b branch_name
Make the necessary changes and commit them:
git commit -m "Description of changes made"
Push the branch to the remote repository:
git push origin branch_name
Go to the repository page and create a new pull request.
License
This project is not under the MIT license.

Contact
email: m.lesisz97@wp.pl
