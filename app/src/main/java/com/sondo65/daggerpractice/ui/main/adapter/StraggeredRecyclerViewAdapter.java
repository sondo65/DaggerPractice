package com.sondo65.daggerpractice.ui.main.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sondo65.daggerpractice.R;
import com.sondo65.daggerpractice.models.Photo;

import java.util.List;


public class StraggeredRecyclerViewAdapter extends RecyclerView.Adapter<StraggeredRecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "StraggeredRecyclerView";

    Context mContext;
    List<Photo> mListPhoto;

    public StraggeredRecyclerViewAdapter(Context mContext, List<Photo> mListPhoto) {
        this.mContext = mContext;
        this.mListPhoto = mListPhoto;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_photos,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Log.d(TAG, "onBindViewHolder:  called");

        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.white_background);

        Glide.with(mContext)
                .load(mListPhoto.get(position).getUrl())
                .apply(requestOptions)
                .into(holder.imageView);

        holder.textView.setText(mListPhoto.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return mListPhoto.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageview_photo);
            textView = itemView.findViewById(R.id.tv_title);
        }

    }
}
