var request = require('request');
var express = require('express');
var path = require('path');
var app = express();

'use strict';
app.listen(8080, function () {
	console.log("Listening on port 8080");
	console.log("Hello \x1b[32mgreen\x1b[0m world");
});

var url = 'http://datastore.iatistandard.org/api/1/access/activity.json?recipient-country=SE';

app.get('/', function (req, res) {
	res.sendFile(path.join(__dirname + '/IATI.html'));
});

app.get('/data', function (req, res) {
	res.setHeader("Access-Control-Allow-Origin", '*');
	request(url, function (error, response, body) {
		if (!error && response.statusCode == 200) {
			res.send(body);
		}
	});
});