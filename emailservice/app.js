const express = require('express');
const helper = require('sendgrid').mail;

const app = express();

app.post('/', function(req, res){
	from_email = helper.Email(process.env.FROM_EMAIL);
	to_email = helper.Email(req.body.useremail);
	


});