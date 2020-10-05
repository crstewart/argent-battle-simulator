# argent-battle-simulator

The Argent Battle Simulator runs fights between two opponents, each
given their own sets of statistics, strengths and weaknesses, 
abilities, and powers. The simulator comes with a set of video game
characters bundled in to give you ideas or get you started with your
own simulated battles!

_Note: The simulator is under an LGPL license and thus marked for 
commercial use. The characters bundled into this project are 
copyright their respective owners and intended for the purposes of
demonstration. If using the simulator as is, it is meant to be 
provided free of charge. No one is to use this project for profit
without modification and removing the copyrighted characters. 
Please fork this project and modify it as needed if intended to 
be used for profit._

### Getting Started

This project has two portions: An Angular frontend and a Java
backend. To build the frontend, run the following commands in the
argent-battle-simulator-frontend directory:

```shell script
npm install
npm run build
```

This will install the frontend into `src/main/webapp`. When ready
to build for production, run the follow command:
                                                       
```shell script
npm run prod
```

From there,
you can build the server by going into the project root and
running the Gradle build:

```shell script
gradle clean bootWar test
```

This will create an executable war file that will run a Tomcat
server on port 80.

A Dockerfile is also provided. With the war file created, a Docker
container based on Alpine Linux can be built to run the service.

Running the war file or the Docker container requires a PostgreSQL 
backend. The database must have a league schema. An example SQL file is
provided that can create all the schemas and tables for you. The 
access information for the database can be defined by three environment 
variables:
```
LEAGUE_DATABASE_URL = The full jdbc URL of the database
LEAGUE_DATABASE_USER = The username that has access to the table
LEAGUE_DATABASE_PASS = The password for the user
```

### API

`GET v1/fighters` gets the full list of fighters, sorted in 
alphabetical order.

`GET v1/fighters/{name}` gets the fighter information for the given
fighter name, organized in JSON format.

`GET v1/simulation?fighter1={name1}&fighter2={name2}` runs a
simulation between two fighters. The two names must be different.
The returned object is a JSON with the winner, battle log, and a
UUID name for the stored log.

`GET v1/files/{id}.txt` retrieves the stored file based on the UUID
of the run simulation.

`GET v1/seasons/{season}/teams` retrieves all the teams for the given
season.

`GET v1/seasons/{season}/standings` retrieves the up-to-date standings
information for all the teams for the given season.

`GET v1/seasons/{season}/rosters?team={team}` gets the roster for the
given team in the given season.

`GET v1/seasons/{season}/weeks` gets the list of week numbers for the
given season.

`GET v1/seasons/{season}/schedule?week={week}` gets the full or weekly
schedule for the given season.

`GET v1/seasons/{season}/schedule?teamName={team}&week={week}` gets the full or 
weekly schedule for the given team on the given season.