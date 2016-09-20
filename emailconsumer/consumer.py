import pika, requests
from settings import ADSSERVICE, PARKINGSERVICE

connection = pika.BlockingConnection(pika.ConnectionParameters(host='localhost'))
channel = connection.channel()

channel.queue_declare(queue='email')

def callback(ch, method, properties, body):
	ads = requests.get(ADSSERVICE)
	parkspots = requests.get(PARKINGSERVICE)
	print "[x] Received %r" % body
	print "Ads: %r" % ads.json()
	print "Parking spots: %r" % ads.json()

channel.basic_consume(callback, queue='email', no_ack=True)

print " [*] Waiting for messages. To exit press CTRL+C"
channel.start_consuming() 