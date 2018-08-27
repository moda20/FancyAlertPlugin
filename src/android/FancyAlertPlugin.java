package cordova.plugin.fancyalert;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import cn.refactor.lib.colordialog.ColorDialog;
import cn.refactor.lib.colordialog.PromptDialog;
/**
 * This class echoes a string called from JavaScript.
 */
public class FancyAlertPlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            return true;
        }else{
            if(action.equals("prompt")){
                String message = args.getString(0);
                String title = args.getString(1);
                String type = args.getString(2);
                String bttext = args.getString(3);
                this.prompt(message,title,type,bttext,callbackContext);
                return true;
            }else{
            if(action.equals("Dialog")){
                            String message = args.getString(0);
                            String title = args.getString(1);
                            String color = args.getString(2);
                            String bttext = args.getString(3);
                            this.Dialog(message,title,color,bttext,callbackContext);
                            return true;
                        }
            }
        }
        return false;
    }


    private void coolMethod(String message, CallbackContext callbackContext) {
        final CordovaInterface cordova = this.cordova;
        if (message != null && message.length() > 0) {

           try {

               ColorDialog dialog = new ColorDialog(cordova.getActivity());
               dialog.setColor("#8ECB54");
               dialog.setAnimationEnable(true);
               dialog.setTitle(message);
               dialog.setContentText(message);
               dialog.setPositiveListener(message, new ColorDialog.OnPositiveListener() {
                   @Override
                   public void onClick(ColorDialog dialog) {
                       Toast.makeText(cordova.getActivity(), dialog.getPositiveText().toString(), Toast.LENGTH_SHORT).show();
                   }
               }).show();
               callbackContext.success(message);
           }catch(Exception e){
               callbackContext.error(e.toString());
           }

        } else { 
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
    private void coolMethodtwo(String message, CallbackContext callbackContext) {
        final CordovaInterface cordova = this.cordova;
        if (message != null && message.length() > 0) {

            try {

                ColorDialog dialog = new ColorDialog(cordova.getActivity());
                dialog.setColor("#8ECB54");
                dialog.setAnimationEnable(true);
                dialog.setTitle(message);
                dialog.setContentText(message);
                dialog.setPositiveListener(message, new ColorDialog.OnPositiveListener() {
                    @Override
                    public void onClick(ColorDialog dialog) {
                        Toast.makeText(cordova.getActivity(), dialog.getPositiveText().toString(), Toast.LENGTH_SHORT).show();
                    }
                }).show();
                callbackContext.success(message);
            }catch(Exception e){
                callbackContext.error(e.toString());
            }

        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    private void prompt(String message, String title, String type ,String bttext,CallbackContext callbackContext) {
        PromptDialog PD = new PromptDialog(cordova.getActivity());
        final CallbackContext CB = callbackContext;
                if(message == null && message.length() == 0 ||
                 title == null && title.length() == 0
                 || type == null && type.length() == 0
                 || bttext == null && bttext.length() == 0 ){
                    CB.error("Expected one non-empty string argument.");
                    return;
                }

                if(type.equals("sucess")){
                    PD.setDialogType(PromptDialog.DIALOG_TYPE_SUCCESS);
                }else{
                    if(type.equals("info")){
                        PD.setDialogType(PromptDialog.DIALOG_TYPE_INFO);
                    }else{
                        if(type.equals("help")){
                            PD.setDialogType(PromptDialog.DIALOG_TYPE_HELP);
                        }else{
                            if(type.equals("error")){
                                PD.setDialogType(PromptDialog.DIALOG_TYPE_WRONG);
                            }else{
                                if(type.equals("warning")){
                                    PD.setDialogType(PromptDialog.DIALOG_TYPE_WARNING);
                                }else{
                                    CB.error("Bad type passed");
                                    return;
                                }
                            }
                        }
                    }
                }
                PD.setAnimationEnable(true);
                PD.setTitleText(title);
                PD.setContentText(message);
                PD.setPositiveListener(bttext, new PromptDialog.OnPositiveListener() {
                            @Override
                            public void onClick(PromptDialog dialog) {
                                dialog.dismiss();
                                CB.success("dismissed");
                            }
                        }).show();
    }

    private void Dialog(String message, String title, String color ,String okbttext,CallbackContext callbackContext){
     final CallbackContext CB = callbackContext;
        if(message == null && message.length() == 0 ||
         title == null && title.length() == 0
         || color == null && color.length() == 0
         || okbttext == null && okbttext.length() == 0 ){
            CB.error("Expected one non-empty string argument.");
            return;
        }

        ColorDialog dialog = new ColorDialog(cordova.getActivity());
                dialog.setColor(color);
                dialog.setAnimationEnable(true);
                dialog.setTitle(title);
                dialog.setContentText(message);
                dialog.setPositiveListener(okbttext, new ColorDialog.OnPositiveListener() {
                    @Override
                    public void onClick(ColorDialog dialog) {
                        dialog.dismiss();
                        CB.success("dismissed");
                    }
                }).show();
    }
}
