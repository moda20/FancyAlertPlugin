# Cordova FancyAlertPlugin

**Based On :** 
Color Dialog : https://github.com/andyxialm/ColorDialog


**Cordova plugin : Fancy Alerts** 
This plugin is available on NPM on https://www.npmjs.com/package/cordova-plugin-fancyalert .

Platforms available : **android**


***install :***

1 ) run `cordova plugin add https://github.com/moda20/FancyAlertPlugin.git`

2 ) use directly from the `window` available `cordova` object.

# Usage

***Example :***

```
window.cordova.plugins.FancyAlertPlugin.prompt(['Message Message Message Message',"TITLE","sucess","Okey"],
        function(res){
            console.log(res);
        },
        function(e){
            console.log(e);
            alert("Errored");
        })
```
***Docs :***
```
The `FancyAlertPlugin` has only one method : `prompt`. `prompt`takes 3 arguments only the first is mandatory.


FancyAlertPlugin.prompt(Args,SuccessCallback,ErrorCallback)

Args : Array of STRINGS: [ 'PROMPT_MESSAGE', 'PROMPT_TITLE', 'PROMPT_TYPE', 'PROMPT_BUTTON_TEXT' ]

PROMPT_TYPE can only be one of : 'sucess' => Sucess Prompt
                                 'info' => Info Prompt
                                 'help' => Help Prompt
                                 'error' => Error Prompt
                                 'warning' => Warning Prompt
                                 
if PROMPT_TYPE is passed as any other type or value, the plugin will send back an error.

SuccessCallback and ErrorCallback are regular callbacks, see the example above.
```

# Licence 

MIT
