package com.example.notifications_hover.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import com.example.notifications_hover.Notification.Notification;
import com.example.notifications_hover.R;
import com.example.notifications_hover.activity.MainActivity;
import com.example.notifications_hover.app.Config;
import com.example.notifications_hover.listeners.OnSwipeTouchListener;

import java.text.SimpleDateFormat;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CustomViewHolder> {

    private List<Notification> notificationList;
    private Context context;

    public MyAdapter(Context context, List<Notification> dataListNotifications){
        this.notificationList = dataListNotifications;
        this.context=context;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        //Get a reference to the Views in our layout//
        public final View myView;

        TextView textViewTitle;
        TextView textViewBody;
        TextView TextViewTimeStamp;
        ImageView ImageView;

        CustomViewHolder(View itemView) {
            super(itemView);
            myView = itemView;
            textViewTitle=myView.findViewById(R.id.danger_title);
            textViewBody=myView.findViewById(R.id.danger_body);
            TextViewTimeStamp=myView.findViewById(R.id.timestamp_danger);
            ImageView=myView.findViewById(R.id.big_icon);
        }
    }

    @Override
//Construct a RecyclerView.ViewHolder//

    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.notification_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, final int position) {
        holder.textViewTitle.setText(notificationList.get(position).getTitle());
        holder.textViewBody.setText(notificationList.get(position).getBody());
        SimpleDateFormat ft = new SimpleDateFormat ("hh:mm:ss");
        holder.TextViewTimeStamp.setText(ft.format(notificationList.get(position).getDate()));

        if( notificationList.get(position).getTitle().contains("distance") ){
            holder.ImageView.setImageResource(R.drawable.distance);
        }
        else
            holder.ImageView.setImageResource(R.drawable.mask);


        holder.itemView.setOnTouchListener(new OnSwipeTouchListener(context){

            public void onSwipeRight() {
                //Toast.makeText(context, "Swip Right ! at index:: "+position, Toast.LENGTH_SHORT).show();
            }

            public void onSwipeLeft() {
                Toast.makeText(context, "Swip Left ! at index:: "+position, Toast.LENGTH_SHORT).show();
                Config.list_notifications.remove(position);
                MainActivity.suppression=true;
            }
        });

        //holder.itemView.setOnTouchListener(new OnSwipeTouchListener(context));
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

}
