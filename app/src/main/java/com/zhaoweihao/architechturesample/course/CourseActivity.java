package com.zhaoweihao.architechturesample.course;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.google.gson.Gson;
import com.zhaoweihao.architechturesample.R;
import com.zhaoweihao.architechturesample.leave.LeaveListActivity;
import com.zhaoweihao.architechturesample.quiz.QuizActivity;
import com.zhaoweihao.architechturesample.seat.CreateActivity;
import com.zhaoweihao.architechturesample.seat.EnterActivity;
import com.zhaoweihao.architechturesample.vote.ResultActivity;
import com.zhaoweihao.architechturesample.vote.ShowActivity;
import com.zhaoweihao.architechturesample.vote.VoteActivity;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 4 testing UI
 */

public class CourseActivity extends AppCompatActivity {

    private int courseId;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @OnClick(R.id.check_stu)
    void checkStu() {
        Intent intent = new Intent(this, QuerySelectCourseActivity.class);
        intent.putExtra("courseId", courseId);
        startActivity(intent);
    }

    @OnClick(R.id.check_noti)
    void checkNoti() {
        Intent intent = new Intent(this, QueryNotiActivity.class);
        intent.putExtra("courseId", courseId);
        startActivity(intent);
    }

    @OnClick(R.id.to_vote)
    void toVote() {
        Intent intent = new Intent(this, ShowActivity.class);
        intent.putExtra("courseId", courseId);
        startActivity(intent);
    }

    @OnClick(R.id.to_discuss)
    void toDiscuss() {
        Intent intent = new Intent(this, QueryTopicActivity.class);
        intent.putExtra("courseId", courseId);
        startActivity(intent);
    }

    @OnClick(R.id.to_rank)
    void toRank() {
        Intent intent = new Intent(this, QuizActivity.class);
        intent.putExtra("courseId", courseId);
        startActivity(intent);
    }

    @OnClick(R.id.to_leave)
    void toLeave() {
        Intent intent = new Intent(this, LeaveListActivity.class);
        intent.putExtra("courseId", courseId);
        startActivity(intent);
    }

    @OnClick(R.id.to_seat)
    void toSeat() {

        //Make new Dialog
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("点名系统 ");

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        final ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.school);
        layout.addView(imageView);
        imageView.getLayoutParams().height = 350;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);

        final Button toVote = new Button(this);
        toVote.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
        toVote.setTextColor(ContextCompat.getColor(this, R.color.white));
        toVote.setText("进入点名系统");
        toVote.setOnClickListener(v1 -> {
            Intent intent = new Intent(this, EnterActivity.class);
            intent.putExtra("courseId", courseId);
            startActivity(intent);
        });
        layout.addView(toVote);
        final Button toResult = new Button(this);
        toResult.setOnClickListener(v12 -> {
            Intent intent = new Intent(this, CreateActivity.class);
            intent.putExtra("courseId", courseId);
            startActivity(intent);
        });
        toResult.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
        toResult.setTextColor(ContextCompat.getColor(this, R.color.white));
        toResult.setText("创建点名房间");
        layout.addView(toResult);

        dialog.setView(layout);

        dialog.show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_fav_new);

        courseId = getIntent().getIntExtra("courseId", 0);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
