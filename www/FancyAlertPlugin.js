var exec = require('cordova/exec');

/*
exports.coolMethod = function (arg0, success, error) {
    exec(success, error, 'FancyAlertPlugin', 'coolMethod', [arg0]);
};
*/

exports.prompt = function (args, success, error) {
    exec(success, error, 'FancyAlertPlugin', 'prompt', args);
};

exports.dialog = function (args, success, error) {
    exec(success, error, 'FancyAlertPlugin', 'Dialog', args);
};

