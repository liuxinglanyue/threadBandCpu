# threadBandCpu
将java线程绑定到具体的cpu上执行

环境：Ubuntu 12.04

具体介绍请移步这里：

[通过JNI调用线程执行](http://javagoo.tk/java/java_native_thread_1.html)

[Java线程绑定到具体的cpu上执行](http://javagoo.tk/java/java_native_thread_2.html)

如何使用？
调用ThreadBandCpu.bandCpu并实现Runnable的run方法，第二个参数的意思是在第几个cpu上执行
假如有4个cpu，那么就是 2%4 = 2，就是在第三个cpu上执行。
当第二个参数为负数时，不绑定cpu，随系统调度到哪个cpu。

可以通过查看top，得知。

``` java
ThreadBandCpu.bandCpu(new Runnable() {
			
			@Override
			public void run() {
				for(;;){}
			}
		}, 2);
```

帖一下编译.so文件的命令：

```
g++ -std=c++0x -I/home/jjf/hadoop/jdk1.6.0_45/include/linux/ -I/home/jjf/hadoop/jdk1.6.0_45/include/ -O0 -g3 -Wall -c -fmessage-length=0 -fPIC -MMD -MP -MF"ThreadBandCpu.d" -MT"ThreadBandCpu.d" -o "ThreadBandCpu.o" "ThreadBandCpu.cpp"

g++ -shared -o "libbandCpu.so" ./ThreadBandCpu.o
```

其中/home/jjf/hadoop/jdk1.6.0_45是JDK安装目录