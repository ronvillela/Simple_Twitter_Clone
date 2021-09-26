package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.parceler.Parcels;
import java.text.BreakIterator;
import java.text.StringCharacterIterator;
import java.util.List;

public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.ViewHolder>{


    Context context;
    List<Tweet> tweets;
    // Pass in the context and the list of tweets
    public TweetsAdapter(Context context, List<Tweet> tweets) {
        this.context = context;
        this.tweets = tweets;
    }

    // For each row, inflate a layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false);
        return new ViewHolder(view);
    }
    // Bind values based on the position of the element
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get the data at position
        Tweet tweet = tweets.get(position);
        // Bind the tweet with the view holder
        holder.bind(tweet);
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    // Clean all elements of the recycler
    public void clear() {
        tweets.clear();
        notifyDataSetChanged();
    }

    // Add a list of items
    public void addAll(List<Tweet> tweetsList) {
        tweets.addAll(tweetsList);
        notifyDataSetChanged();
    }

    // Define a viewholder
    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout container;
        ImageView ivProfileImage;
        TextView tvBody;
        TextView tvScreenName;
        TextView tvTime;

        public ViewHolder(@NonNull View itemView)   {
            super(itemView);
            ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
            tvBody = itemView.findViewById((R.id.tvBody));
            tvScreenName = itemView.findViewById(R.id.tvScreenName);
            tvTime = itemView.findViewById(R.id.tvTime);
            container = itemView.findViewById(R.id.container);
        }

        public void bind(Tweet tweet) {
            tvBody.setText(tweet.body);
            tvScreenName.setText(tweet.user.screenName);
            tvTime.setText(tweet.getFormattedTimesStamp());
            Glide.with(context).load(tweet.user.publicImageUrl).into(ivProfileImage);

             // 1. Register the click listener on the whole container
            container.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // 2. Navigate to a new activity on tap
                Intent i = new Intent(context, TweetDetail.class);
                i.putExtra("tweet", Parcels.wrap(tweet));
                context.startActivity(i);

            }
        });
    }
 }
}
