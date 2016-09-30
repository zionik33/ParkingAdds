from flask import Flask, abort, jsonify
app = Flask(__name__)

import pika, json

@app.route('/email/<email>', methods=["GET"])
def send_email_to_queue(email):
	print email
	try:
		credentials = pika.PlainCredentials('guest', 'guest')
		connection = pika.BlockingConnection(pika.ConnectionParameters(
				host='localhost', port=5672, credentials=credentials))
		channel = connection.channel()
		channel.queue_declare(queue='email')
		channel.basic_publish(exchange='', routing_key='email', body=email)
		connection.close()
		print "queued message %s" % email
		return jsonify({"status":"done"})
	except:
		print "Error on queue"
		abort(404)

if __name__ == '__main__':
	app.run()
