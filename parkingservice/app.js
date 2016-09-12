const express = require('express');
const request = require('request');
const cacheResponseDirective = require('express-cache-response-directive');
const morgan = require('morgan');
const path = require('path');
const fs = require('fs');
const app = express();

var accessLogStream = fs.createWriteStream(path.join(__dirname, 'access.log'), {flags: 'a'})

app.use(cacheResponseDirective());
app.use(morgan('combined', { stream: accessLogStream }));

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
