const express = require('express');
const cacheResponseDirective = require('express-cache-response-directive');
const morgan = require('morgan');
const fs = require('fs');
const path = require('path');
const app = express();

var accessLogStream = fs.createWriteStream(path.join(__dirname, 'access.log'), {flags: 'a'})

app.use(cacheResponseDirective());
app.use(morgan('combined', { stream: accessLogStream }));

app.get('/', function(req, res){
	res.cacheControl({maxAge: 300});
	res.json({
		title: 'Buy Viagra',
		description: 'Blue pills for men',
		catchPhrase: 'Buy 3 get 1 free',
		price: '99,-'
	});
});

app.listen(8020, function(){
	console.log('Ads service listening on port: 8020');
});
