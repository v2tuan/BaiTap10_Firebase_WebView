package com.example.baitap10_firebase_webview.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;

import com.bumptech.glide.Glide;
import com.example.baitap10_firebase_webview.R;
import com.example.baitap10_firebase_webview.adapter.VideoFireBaseAdapter;
import com.example.baitap10_firebase_webview.adapter.VideoThumbnailFireBaseAdapter;
import com.example.baitap10_firebase_webview.databinding.ActivityProfileBinding;
import com.example.baitap10_firebase_webview.model.User;
import com.example.baitap10_firebase_webview.model.VideoModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {
    private VideoThumbnailFireBaseAdapter videoThumbnailFireBaseAdapter;
    private ActivityProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        String uid = currentUser.getUid();

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("users").child(uid);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    // Hoặc Cách 2: Đổ thẳng vào một object
                    User user = snapshot.getValue(User.class);
                    Glide.with(ProfileActivity.this).load(user.getProfileImageUrl())
                            .into(binding.circleImageView);
                    binding.textView.setText(user.getName());
                    binding.textView2.setText(user.getEmail());
                    getVideos(user.getUid());
                    // In ra thử
                    Log.d("TAG", "Tên: " + user.getName() + ", Email: " + user.getEmail());
                } else {
                    Log.d("TAG", "Người dùng không tồn tại");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.w("TAG", "Lỗi khi đọc dữ liệu", error.toException());
            }
        });
    }

    private void getVideos(String uid) {
        DatabaseReference mDataBase = FirebaseDatabase.getInstance().getReference("videos");

        // Truy vấn chỉ lấy các video có userId bằng uid
        Query query = mDataBase.orderByChild("userId").equalTo(uid);

        FirebaseRecyclerOptions<VideoModel> options = new FirebaseRecyclerOptions.Builder<VideoModel>()
                .setQuery(query, VideoModel.class)
                .build();

        videoThumbnailFireBaseAdapter = new VideoThumbnailFireBaseAdapter(options);
        binding.recyclerView.setAdapter(videoThumbnailFireBaseAdapter);
        // Set layout dạng lưới với 3 cột
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        binding.recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Bắt đầu nhận dữ liệu khi Activity được hiển thị
        videoThumbnailFireBaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        // Dừng nhận dữ liệu khi Activity bị ẩn hoặc dừng
        videoThumbnailFireBaseAdapter.stopListening();
    }

    @Override
    protected void onResume() {
        super.onResume();
        videoThumbnailFireBaseAdapter.notifyDataSetChanged();
    }
}