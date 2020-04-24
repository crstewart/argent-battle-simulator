# argent-battle-simulator

The Argent Battle Simulator runs fights between two opponents, each
given their own sets of statistics, strengths and weaknesses, 
abilities, and powers. The simulator comes with a set of video game
characters bundled in to give you ideas or get you started with your
own simulated battles!

_Note: The simulator is under an LGPL license and thus marked for 
commercial use. The characters bundled into this project are 
copyright their respective owners. If using the simulator as is, it
is meant to be used for parody under fair use and provided free of 
charge. No one is to use this project for profit without 
modification and removing the copyrighted characters. Please fork
this project and modify it as needed if intended to be used for
profit._

### Getting Started

This project has two portions: An Angular frontend and a Java
backend. To build the frontend, run the following commands in the
argent-battle-simulator-frontend directory:

```shell script
npm install
npm run build
```

This will install the frontend into `src/main/webapp`. From there,
you can build the server by going into the project root and
running the Gradle build:

```shell script
gradle clean bootWar test
```

This will create an executable war file that will run a Tomcat
server on port 80.

A Dockerfile is also provided. With the war file created, a Docker
container based on Alpine Linux can be built to run the service.

### API

`v1/fighters` gets the full list of fighters, sorted in 
alphabetical order.

`v1/fighters/{name}` gets the fighter information for the given
fighter name, organized in JSON format.

`v1/simulation?fighter1={name1}&fighter2={name2}` runs a
simulation between two fighters. The two names must be different.
The returned object is a JSON with the winner, battle log, and a
UUID name for the stored log.

`v1/files/{uuid}.txt` retrieves the stored file based on the UUID
of the run simulation.