package com.example.millionproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Ranking_User_Adapter extends ArrayAdapter<User>{
    private ArrayList<User> userList;
    Context context;
    private int lastPosition = -1;

    private static class ViewHolder {
        TextView userName;
        TextView userScore;
        TextView userTime;
    }

    public Ranking_User_Adapter(ArrayList<User> userList, Context context) {
        super(context, R.layout.ranking_user_layout_of_list, userList);
        this.userList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        User user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.ranking_user_layout_of_list, parent, false);
            viewHolder.userName =  convertView.findViewById(R.id.ranking_user_name);
            viewHolder.userScore =  convertView.findViewById(R.id.ranking_user_score);
            viewHolder.userTime =  convertView.findViewById(R.id.ranking_user_time);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(context, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        Long minute = (user.getTimeUsed()/1000) / 60;
        Long seconds = (user.getTimeUsed()/1000) % 60;


        viewHolder.userName.setText(user.getUsername());
        viewHolder.userScore.setText(Integer.toString(user.getScore()));
        viewHolder.userTime.setText(minute + ":" + seconds + " minute(s)");
        return convertView;

    }

}
