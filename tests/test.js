const http = require('http');

const options = {
	hostname: 'localhost',
	port: 8080,
	path: '/',
	method: 'GET'
}

const req = http.request(options, res => {
	console.log(`Status Code: ${res.statusCode}`);

	res.on('data', data => {
		process.stdout.write(data);
	});
});

req.on('error', error => {
	console.error(error);
});

req.end();
