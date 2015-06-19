var connect = require('connect');
var serveStatic = require('serve-static');
// Server de test contenant le template
connect().use(serveStatic(__dirname + '/bower_components/admin-lte')).listen(1235);
connect().use(serveStatic(__dirname)).listen(1234);
