package com.up360.ffmpeg_demo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.up360.ffmpeg.utils.FFmpegUtil;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
        }

        TextView tvMsg = findViewById(R.id.message);
        tvMsg.setText(FFmpegUtil.test());

        ffmpegTest();
    }

    private void ffmpegTest() {
        new Thread() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis();
                String input = Environment.getExternalStorageDirectory().getAbsolutePath() + "/360/207070.mp4";
                String output = Environment.getExternalStorageDirectory().getAbsolutePath() + "/360/output.mp4";
                File file = new File(input);
                if (!file.exists()) {
                    return;
                }
                //剪切视频从00：20-00：28的片段
                String cmd = "ffmpeg -d -ss 00:00:20 -t 00:00:08 -i %s -vcodec copy -acodec copy %s";
                cmd = String.format(cmd, input, output);
                FFmpegUtil.run(cmd.split(" "));
                Log.d("FFmpegTest", "run: 耗时：" + (System.currentTimeMillis() - startTime));
            }
        }.start();
    }

}
