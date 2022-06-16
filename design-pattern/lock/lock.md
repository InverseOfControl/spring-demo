![image-20220515211040063](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20220515211040063.png)



# JMM



<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20220515211421208.png" alt="image-20220515211421208" style="zoom:80%;margin-left:0" />



<img src="C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20220515211652431.png" alt="image-20220515211652431" style="zoom:80%;margin-left:0" />



# Volitale

解决可见性问题



# HAPPEN-BEFORE

本质上是描述可见性规则。



1.程序顺序规则

2.传递性规则

3.volitale变量规则

4.监视器规则

~~~java
int x = 0;
syncthroized(this){
	if(this.x < 12){
        return;
    }    
}
~~~

5.start规则

6.join规则



# Lock

## ReentrantLock

避免死锁的问题。

一个线程获取了同一把锁之后，在释放所之前，再一次去获取锁的时候，不需要加锁，只需记录重入次数。

~~~java
static Lock lock = new ReentrantLock();
private static int count = 0;
void inc(){
    lock.lock(); // 没有抢占到锁的线程会阻塞，就会有线程的阻塞队列
    try{
       count++; 
    }finally{
        lock.unlock();
    }
}
void test(){
    for(int i = 0; i < 1000; i++) {
        new Thread(() -> Demo.inc()).start();
    }
}
~~~



# AQS





# 双重检查锁

~~~
if(instance == null){
	synchroized(this){
		if(instance == null){
			// new 操作不是原子操作，是三个操作，所以外部必须加锁。
			instance = new Demo();
		}
	}
}
~~~



