package com.up360.ffmpeg.utils;

public class FFmpegUtil {
    static {
        System.loadLibrary("avcodec");
        System.loadLibrary("swresample");
        System.loadLibrary("avformat");
        System.loadLibrary("swscale");
        System.loadLibrary("avfilter");
        System.loadLibrary("avdevice");
        System.loadLibrary("avutil");
        System.loadLibrary("ffmpeg-invoke");

    }
    private static native int run(int cmdLen, String[] cmd);
    public static native String test();
    public static int run(String[] cmd){
        return run(cmd.length,cmd);
    }

}
