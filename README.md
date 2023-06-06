<h2>
This is the README file for a project based on Spring 3.1.0 and Java 17. 
</h2>

<h2>
Project description
</h2>
  
This project is based on the Spring framework and uses Java 17. The assumption of the project is to return information about the user using the Github platform:
- return names of all user repositories that are not forked
- returning owner login for the user
- names of each branch from user repositories
- ssh of the last commit for a given branch

<h2>
Requirements
</h2>

To run this project, you must have the following tools and environment installed:

- Java Development Kit (JDK) 17
- Apache Maven
- Spring Framework

<h2>
Installation
</h2>

- Clone the repository to your local environment:

  https://github.com/MateuszLesisz/Atipera.git

- Go to the project directory:

  cd project_name

- Start building the project using Apache Maven:

  mvn clean install

<h2>
Configuration
</h2>

The project does not use a database, so no new configurations are needed.

<h2>
Startup
</h2>

To run the application, follow these steps:

- Go to the project directory:

  cd project_name
  
- Run the application using the Maven command:

  mvn spring-boot:run
  
After successful launch, the application will be available at http://localhost:8080/api/users/{username}.

<h2>
Documentation
</h2>

The application provides one endpoint which returns all information from the project description:
- http://localhost:8080/api/users/{username} 

The application connects to the Github Api (https://developer.github.com/v3)

Endpoints used:

- https://api.github.com/users/{username}/repos -> lists public repositories for the specified user
- https://api.github.com/repos/{owner}/{repo}/branches -> list all branches for the specific repo
- https://api.github.com/users/{username} -> check the specific user exist

<h2>
Making changes
</h2>

If you wish to make changes to this design, please follow the following process:

- Create a branch for your changes:

  git checkout -b branch_name
  
- Make the necessary changes and commit them:

  git commit -m "Description of changes made"
  
- Push the branch to the remote repository:

  git push origin branch_name
  
- Go to the repository page and create a new pull request.

<h2>
License
</h2
  
This project is not under the MIT license.

<h2>
Contact
</h2>

email: m.lesisz97@wp.pl
