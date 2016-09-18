#Email consumer

This will start a RabbitMQ listener. When a message ticks in will it tricker a callback that will call the different microservices and create a mail that will be sent with an email service.

##Requirements
- Python 2.7.x
- Pip
- Docker
- Python virtualenv

##Guide
- Make sure emailservice part is running.
- virtualenv venv
- (Linux/OSX) source venv/bin/activate
- (Windows) venv\Scripts\activate
- pip install -r requirements.txt
- python consumer.py
