# jira-argonath

JIRA-Argonath is a project that was created as part of the PeopleNet hackdays initative.  The main
authors of the project are:

Miles Porter
Justin Doll

The goal of the project is to provide insight into the health of Jira stories, and specifically
the quality and completion of stories in a project backlog.

This project consists of several main components:

1.  The UI.  The main goal of the UI is to provide meaningful graphs that show the distribution
of stories in regards to completeness and clarity.  The graphs attempt to capture the following:

Story Description Completeness.  (Basically just an indication of if a story is over 40 characters.)
Story Format.  An indication of if the story follows the "As ___, I want ____ so that ____."
Acceptance Criteria.  Does the story have specified acceptance criteria.

2.  Backend Server.  The backend server interacts with the Jira server, and queries stories via
the Jira API.  The server keeps track of story trends over time, and provides data via its own
RESTful API, which is used by the UI components of the overall jira-argonath components.

## Requirements:

The application requires MySQL, Java 1.8, and a connection to a Jira 6.x server.

## Running the server:

After downloading the code, you can start the server by issuing the following command

./gradlew clean build test runBoot

The system will be available at the following url:

http://[server_address]:8080/jira-argonath/index.html

A Swagger UI is also provided, and can be accessed at:

http://[server_address]:8080/jira-argonath/swagger-ui.html

##  About the name.

![alt The Argonath](http://vignette1.wikia.nocookie.net/lotr/images/3/3b/Argonath.jpg/revision/latest?cb=20130610174513)

In the book Fellowship of the Ring by JRR Tolkien, The Argonath is a monument the consists
of two larger statues that represent the kings Isildur and Anàrion.  They are placed on opposite
sides of the river Anduin at the north enterance of Nen Hithoel, and mark the northern
border of the kingdom of Gondor.  The statues serve as guardians to the kingdom and as a
reminder to all that pass that they are entering the kingdom.

In agile development methodologies, stories are frequently created and stored in a backlog.  The
process of "backlog grooming" provides a mechanism for business owners, developers, quality and
verification engineers, and designers to make sure that stories that are brought into a sprint are
clear, actionable and verifiable.  The goal of this app is to help remind everyone involved in the
development team to make sure that *good* stories are critically important to the success of a
scrum team.

"Frodo, the Argonath! Long have I desired to look upon the kings of old. My kin."
-- Aragorn