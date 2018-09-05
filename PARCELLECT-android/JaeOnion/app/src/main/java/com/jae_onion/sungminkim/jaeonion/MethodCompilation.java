package com.jae_onion.sungminkim.jaeonion;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

public class MethodCompilation{

    Context context;

    public MethodCompilation(Context context){
        this.context = context;
    }

    public void HideKeyboard(View view){

        view = ((Activity) context).getCurrentFocus();
        if(view != null){
            InputMethodManager touchHide = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            touchHide.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

    }
}