package com.example.journaltheworld;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class addListenerOnTextChange implements TextWatcher {

    StartJournalingActivity startJournalingActivity;
    EditText locationEditText;

    public addListenerOnTextChange(StartJournalingActivity startJournalingActivity, EditText locationEditText) {
        this.startJournalingActivity = startJournalingActivity;
        this.locationEditText = locationEditText;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if(s.toString().length() > 0) {
            locationEditText.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        } else {
            //Assign your image again to the view, otherwise it will always be gone even if the text is 0 again.
            locationEditText.setCompoundDrawablesWithIntrinsicBounds(R.drawable.location50, 0, 0, 0);
        }
    }
}
