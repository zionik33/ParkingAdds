const express = require('express');
const cacheResponseDirective = require('express-cache-response-directive');
const app = express();

app.use(cacheResponseDirective());

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
