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
		image: 'http://www.bmw.dk/content/dam/bmw/marketDK/common/Katalog_billeder/BMW-2-serie-Active-Tourer-L.jpg/jcr:content/renditions/cq5dam.resized.img.585.low.time1453046042050.jpg',
		link: 'http://www.bmw.dk/da/alle_modeller/2-series/activetourer/2014/start.html'
	});
});

app.listen(8020, function(){
	console.log('Ads service listening on port: 8020');
});
