#Ads service
Parking app project for class PSU0216 at UCN.

##Requirements
- Docker

##RabbitMQ
- docker pull rabbitmq
- docker run -d --hostname rabbitmq-server --name rabbit-server -p 8080:15672 rabbitmq:3-management

##Docker
- docker build -t python-email-producer /path/to/emailservice
- docker images
- docker run -p 49200:5000 -d python-email-producer

##Build process
- Docker will pull down a node.js build from docker hub.
- Docker then runs npm install
- At last it exposes the service port.
