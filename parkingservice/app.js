const express = require('express');
const request = require('request');
const cacheResponseDirective = require('express-cache-response-directive');
const app = express();

app.use(cacheResponseDirective());

app.get('/', function(req, res){
	res.cacheControl({maxAge: 300});
	request('https://ucn-parking.herokuapp.com/places.json', function(error, response, body){
		if(!error && response.statusCode == 200){
			res.json(JSON.parse(body));
		}
	});
});



app.listen(8010, function(){
	console.log('Parking service listening on port: 8010');
});
