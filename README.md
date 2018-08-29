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
        
        
window.cordova.plugins.FancyAlertPlugin.dialog(['Message Message Message Message', "TITLE", "#c60808", "Okey"],
            function (args) {
                console.log(args);
            },
            function (e) {
                console.log(e);
                alert("Errored")
            })
```
***Docs :***
```
The `FancyAlertPlugin` has only Two method : `prompt` and `dialog`. `prompt`takes 3 arguments only the first is mandatory.



- FancyAlertPlugin.prompt(Args,SuccessCallback,ErrorCallback)

    Args : Array of STRINGS: [ 'PROMPT_MESSAGE', 'PROMPT_TITLE', 'PROMPT_TYPE', 'PROMPT_BUTTON_TEXT' ]

        - PROMPT_TYPE can only be one of : 'sucess' => Sucess Prompt
                                     'info' => Info Prompt
                                     'help' => Help Prompt
                                     'error' => Error Prompt
                                     'warning' => Warning Prompt
                                     
        if PROMPT_TYPE is passed as any other type or value, the plugin will send back an error.
        
        - PROMPT_TITLE is the title of the prompt.
        - PROMPT_MESSAGE is the long message displayed by the prompt.
        - PROMPT_BUTTON_TEXT is the text on the button.
    
    SuccessCallback and ErrorCallback are regular callbacks, see the example above.
    

- FancyAlertPlugin.dialog(Args,SuccessCallback,ErrorCallback)

    Args : Array of STRINGS: [ 'DIALOG_MESSAGE', 'DIALOG_TITLE', 'DIALOG_COLOR', 'DIALOG_BUTTON_TEXT' ]
    
        - DIALOG_MESSAGE is the dialog's message.
        - DIALOG_TITLE is the dialog's title.
        - DIALOG_COLOR is the the background color of the dialog. MUST BE A HEX STRING.  e.g. : "#c60808".
        - DIALOG_BUTTON_TEXT is the text on the dialog's single button.
    
    SuccessCallback and ErrorCallback are regular callbacks, see the example above.
```
```
Plugin.xml :

You may have to change the com.android.support:appcompat-v7:27.1.1 to a certain version.
Note that this version needs to be unique with all components in your app, so make sure you have it fixed.

```

# ChangeLog

- V 0.1.2 : 
    - Added prompt function argument validation.
    - Dismissing the prompt with the button tap will result in a success callback with the message `"dismissed"

- V 0.2.0 : 
    - Added Colored Dialog feature, see docs.

- V 0.2.1 :
    - Fixed Compiling Bug when using android studio build.
    - Added Dialog Argument Validation.      

- V 0.2.1 :
    - README fix.
    - Plugin Version fix.   
    
# Licence 

MIT
