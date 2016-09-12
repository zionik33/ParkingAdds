#Parking service
Parking app project for class PSU0216 at UCN.

##Requirements
- Docker

##Docker
- docker build -t parkingservice /path/to/dockerfile/folder
- docker images
- docker run -p 49170:8010 parkingservice

##Build process
- Docker will pull down a node.js build from docker hub.
- Docker then runs npm install
- At last it exposes the service port.