#Ads service
Parking app project for class PSU0216 at UCN.

##Requirements
- Docker

##Docker
- docker build -t nodeapp /path/to/dockerfile/folder
- docker images
- docker run -p 49170:8030 -d nodeapp

##Build process
- Docker will pull down a node.js build from docker hub.
- Docker then runs npm install
- At last it exposes the service port.
