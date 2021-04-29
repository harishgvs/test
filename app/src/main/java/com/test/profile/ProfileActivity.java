package com.test.profile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.ll_likes)
    LinearLayout llLikes;
    @BindView(R.id.ll_videos)
    LinearLayout llVideos;
    @BindView(R.id.iv_video)
    ImageView ivVideo;
    @BindView(R.id.tv_videos)
    TextView tvVideos;
    @BindView(R.id.iv_like)
    ImageView ivLike;
    @BindView(R.id.tv_liked)
    TextView tvLiked;
    @BindView(R.id.iv_menu)
    ImageView ivMenu;
    @BindView(R.id.iv_back)
    ImageView ivBack;

    //ArrayList
    ArrayList<Upload> uploadArrayList = new ArrayList<>();
    ArrayList<Upload> likeArrayList = new ArrayList<>();

    //Adapter
    UploadAdapter uploadAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ivBack.setColorFilter(getResources().getColor(R.color.white));
        ivMenu.setColorFilter(getResources().getColor(R.color.white));

        initUi();

        ivVideo.setColorFilter(getResources().getColor(R.color.green));
        tvVideos.setTextColor(getResources().getColor(R.color.green));
        uploadAdapter.setData(uploadArrayList);

    }

    //Adding List
    public void initUi() {

        Upload upload = new Upload(R.drawable.image1, "1000");
        Upload upload2 = new Upload(R.drawable.image2, "8545");
        Upload upload3 = new Upload(R.drawable.image4, "15.2k");
        Upload upload4 = new Upload(R.drawable.images3, "2584");

        uploadArrayList.add(upload);
        uploadArrayList.add(upload2);
        uploadArrayList.add(upload3);

        for (int i = 0; i < 4; i++) {
            uploadArrayList.add(upload4);
        }

        Upload like = new Upload(R.drawable.images3, "2584");

        for (int i = 0; i < 4; i++) {
            likeArrayList.add(like);
        }
         //Adapter

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(gridLayoutManager);
        uploadAdapter = new UploadAdapter(this);
        recyclerView.setAdapter(uploadAdapter);

    }

    @OnClick({R.id.ll_videos, R.id.ll_likes})
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.ll_videos:

                reset();

                ivVideo.setColorFilter(getResources().getColor(R.color.green));
                tvVideos.setTextColor(getResources().getColor(R.color.green));

                uploadAdapter.setData(uploadArrayList);
                break;

            case R.id.ll_likes:

                reset();

                ivLike.setColorFilter(getResources().getColor(R.color.green));
                tvLiked.setTextColor(getResources().getColor(R.color.green));

                uploadAdapter.setData(likeArrayList);
                break;
        }
    }

    public void reset() {
        ivLike.setColorFilter(getResources().getColor(R.color.color_light));
        ivVideo.setColorFilter(getResources().getColor(R.color.color_light));
        tvLiked.setTextColor(getResources().getColor(R.color.color_light));
        tvVideos.setTextColor(getResources().getColor(R.color.color_light));
    }

    @OnClick(R.id.iv_menu)
    public void menuClick(View v) {
        PopupMenu popup = new PopupMenu(ProfileActivity.this, v);
        popup.setOnMenuItemClickListener(ProfileActivity.this);
        popup.inflate(R.menu.icon);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.share:
                Toast.makeText(this, "share", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.report:
                Toast.makeText(this, "report", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }


}