const proxy = require('express-http-proxy');
require('dotenv').config();

const express = require('express');
const app = express();

app.use(require('express-status-monitor')());

/**
*	Proxy for parking service
*/
app.use(process.env.PARKING_API_PATH, proxy(process.env.SERVICE_URL + process.env.PARKING_SERVICE));

/**
*	Proxy for ads service
*/
app.use(process.env.ADS_API_PATH, proxy(process.env.SERVICE_URL + process.env.ADS_SERVICE));

app.listen(process.env.PORT, () => {
	console.log('Parking service endpoint: ' + process.env.SERVICE_URL + process.env.PARKING_SERVICE);
	console.log('Running on: ' + process.env.PORT);
});