package com.dappervision.wearscript.events;

import android.content.Intent;

public class StartActivityEvent {
    private Intent intent;
    private int requestCode;


    public StartActivityEvent(Intent intent, int requestCode) {
        this.intent = intent;
        this.requestCode = requestCode;
    }

    public Intent getIntent() {
        return intent;
    }

    public int getRequestCode() {
        return requestCode;
    }
}
