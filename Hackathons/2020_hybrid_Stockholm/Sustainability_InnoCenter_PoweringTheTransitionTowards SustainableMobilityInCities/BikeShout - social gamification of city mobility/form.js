// Source: https://stackoverflow.com/questions/17762188/simple-form-node-js-application
//app.js
// Load the built in 'http' library
var http = require('http'); 
var util = require('util');

// Create a function to handle every HTTP request
function handler(req, res){
  if(req.method == "GET"){ 
    console.log('get');
    res.setHeader('Content-Type', 'text/html');
    res.writeHead(200);
    res.end("<html><body><h4>What prevents you from regular biking today?</h4><br>Please pick all that apply or add your own:<br><br><form action='/' method='post'><label for='1'>Roads and traffic</label><br><input type='checkbox' name='1'><br><label for='2'>No Parking</label><br><input type='checkbox' name='2'><br><label for='3'>Vandalism</label><br><input type='checkbox' name='3'><br><label for='4'>Bike prices & repair costs</label><br><input type='checkbox' name='4'><br><label for='5'>Need help with routine</label><br><input type='checkbox' name='5'><br><label for='6'>Other, please specify:</label><br><input type='text' name='6'> <br><input type='submit'></form></body></html>");
  } else if(req.method == 'POST'){
    console.log('post');
    // Here you could use a library to extract the form content
    // The Express.js web framework helpfully does just that
    // For simplicity's sake we will always respond with 'hello world' here
    // var hello = req.body.hello;
    var hello = 'submission';
    res.setHeader('Content-Type', 'text/html');
    res.writeHead(200);
    res.end("<html><body><h1>Thank You for your anonymous "+hello+"!</h1></body></html>");
  } else {
    res.writeHead(200);
    res.end();
  };
};

// Create a server that invokes the `handler` function upon receiving a request
// And have that server start listening for HTTP requests
// The callback function is executed at some time in the future, when the server
// is done with its long-running task (setting up the network and port etc)
http.createServer(handler).listen(3000, function(err){
  if(err){
    console.log('Error starting http server');
  } else {
    console.log('Server listening on port 3000');
  };
});