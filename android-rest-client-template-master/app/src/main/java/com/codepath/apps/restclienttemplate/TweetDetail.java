package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.graphics.Movie;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;
import com.codepath.apps.restclienttemplate.models.User;
import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.parceler.Parcels;

import okhttp3.Headers;

public class TweetDetail extends AppCompatActivity {

    Context context;
    ImageView ivProfileImage;
    TextView tvBody;
    TextView tvScreenName;
    TextView tvTime;
    public String name;
    public String publicImageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_tweet_detail);

        ivProfileImage = findViewById(R.id.ivProfileImage);
        tvBody = findViewById((R.id.tvBody));
        tvScreenName = findViewById(R.id.tvScreenName);
        tvTime = findViewById(R.id.tvTime);

        User user = Parcels.unwrap(getIntent().getParcelableExtra("user"));
        Tweet tweet = Parcels.unwrap(getIntent().getParcelableExtra("tweet"));
        tvScreenName.setText(user.screenName);
        tvBody.setText(tweet.body);
        tvTime.setText(tweet.getFormattedTimesStamp());
        Glide.with(context).load(tweet.user.publicImageUrl).into(ivProfileImage);


    }
}
