package com.tool;



public class DanLiThread  implements Runnable{


    public void run() {
        System.out.println("网络框架的hashcode:"+ HttpClientTool.getHttpClient().hashCode());
    }

    public static void main(String[] args) {
        DanLiThread[] danLiThreads=new DanLiThread[10];
        for (int i=0;i<danLiThreads.length;i++){
            danLiThreads[i]=new DanLiThread();
            Thread thread=new Thread(danLiThreads[i],"thread "+i);
            thread.start();
        }
    }
}
