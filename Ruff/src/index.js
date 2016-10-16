'use strict';

$.ready(function (error) {
    if (error) {
        console.log(error);
        return;
    }

    console.log('Welcome!');
    
    setInterval(
        function () {
            $('#humirature').getTemperature(function (error, temperature) {
                if (error) {
                    console.error(error);
                    return;
                }
                console.log('temperature', temperature);
            });
        }, 1000);

    setInterval(function () {
        $('#humirature').getRelativeHumidity(function (error, humidity) {
            if (error) {
                console.error(error);
                return;
            }
            console.log('humidity', humidity);
        });
    }, 1000)


    setInterval(function () {
	    $('#lightsensor').getIlluminance(function(err, value){
		    console.log(value);
		    console.log('LIGHT:' + value);
	    });
    }, 1000)

    $('#button').on('push', function () {
            beee();
            console.log('turned on');
    });

    $('#button').on('release', function () {
        stopBeee();
            console.log('turned off');
    });
});

function beep(){
    beee();
    stopBeee();
    console.log('Beeped');
}

function beee(){
    $('#buzzer').turnOn(function (error) {
        if (error) {
            console.error(error);
            return;
        }});
    console.log('Beee');
}

function stopBeee(){
    $('#buzzer').turnOff(function (error) {
            if (error) {
                console.error(error);
                return;
            }});
    console.log('Stop beee');
}
