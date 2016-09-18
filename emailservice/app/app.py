from flask import Flask
app = Flask(__name__)

import pika

@app.route('/')
def send_email_to_queue():
	try:
		connection = pika.BlockingConnection(pika.ConnectionParameters(
				host='localhost'))
		channel = connection.channel()
		channel.queue_declare(queue='hello')
		channel.basic_publish(exchange='', routing_key='hello', body='Whats up?')
		connection.close()
		return 'Works'
	except:
		print "Error on queue"
		return 'Error'

if __name__ == '__main__':
	app.run()
