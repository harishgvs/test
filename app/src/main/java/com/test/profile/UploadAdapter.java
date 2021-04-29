package com.test.profile;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UploadAdapter extends RecyclerView.Adapter<UploadAdapter.ViewHolder> {

    private ArrayList<Upload> uploadArrayList = new ArrayList<>();
    Context context;

    //Constructor
    public UploadAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_upload_videos, parent, false);
        return new ViewHolder(listItem);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Upload upload = uploadArrayList.get(position);
        holder.ivEye.setColorFilter(context.getResources().getColor(R.color.white));
        holder.ivUploaded.setImageResource(upload.getImage());
        holder.tvViewed.setText(upload.getViewCount());

    }

    @Override
    public int getItemCount() {
        return uploadArrayList.size();
    }

    //setList
    public void setData(ArrayList<Upload> list) {
        uploadArrayList = list;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_uploaded)
        ImageView ivUploaded;
        @BindView(R.id.iv_eye)
        ImageView ivEye;
        @BindView(R.id.tv_viewed)
        TextView tvViewed;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }


}
