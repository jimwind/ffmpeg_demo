1.将ubuntu下生成的ffmpeg库，放在G:\share\FFmpeg-n4.0.1中 对应Android.mk中的LOCAL_C_INCLUDES := G:\share\FFmpeg-n4.0.1
2.在jni目录下运行ndk-build，会在jni同级目录下创建libs目录生成so库文件
3.然后在src/main下与java和res同级目录下创建jniLibs，把so库文件放入
编译好的FFmpeg-n4.0.1放在百度云上：链接：https://pan.baidu.com/s/1s17_XyhdpAlcY7FCy3Gg0w 提取码：2q1n 
