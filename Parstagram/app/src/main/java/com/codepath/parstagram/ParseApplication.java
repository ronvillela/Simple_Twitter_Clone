package com.codepath.parstagram;

import android.app.Application;

import com.parse.Parse;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("rwxDgU5JzGyq1qkmNqwE5Jsqz1AvUeBKs1B3VlRs")
                .clientKey("kMUJOx468vHczacEY2V370ykdH5yJdRH1XtQDCe1")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
