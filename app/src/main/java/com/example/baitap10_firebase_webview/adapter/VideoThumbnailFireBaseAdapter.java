package com.example.baitap10_firebase_webview.adapter;

import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.baitap10_firebase_webview.R;
import com.example.baitap10_firebase_webview.databinding.VideoThumbnailBinding;
import com.example.baitap10_firebase_webview.model.User;
import com.example.baitap10_firebase_webview.model.VideoModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class VideoThumbnailFireBaseAdapter extends FirebaseRecyclerAdapter<VideoModel,VideoThumbnailFireBaseAdapter.MyHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public VideoThumbnailFireBaseAdapter(@NonNull FirebaseRecyclerOptions<VideoModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull VideoThumbnailFireBaseAdapter.MyHolder holder, int position, @NonNull VideoModel model) {
//        Glide.with(holder.binding.getRoot())
//                .asBitmap()
//                .load(model.getUrl()) // truyền URL video
//                .frame(1000000) // lấy khung tại 1 giây (1_000_000 microseconds)
//                .into(holder.binding.videoThumbnail);
//        holder.binding.textView.setText(model.getLike());
    }

    @NonNull
    @Override
    public VideoThumbnailFireBaseAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_thumbnail, parent, false);
        return new VideoThumbnailFireBaseAdapter.MyHolder(view);
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        VideoThumbnailBinding binding;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            binding = VideoThumbnailBinding.bind(itemView);
        }
    }
}
