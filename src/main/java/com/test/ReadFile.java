package com.test;

import java.io.File;

public class ReadFile {

    public static void main(String[] args) {
       readFile("d:\\");
    }

    public static void readFile(String filePath){
        File file=new File(filePath);
        File[] files=file.listFiles();
        if (files!=null && files.length>0){
            for (File file1:files){
                if (file1.isDirectory()){
                    System.out.println("文件夹名称:"+file1.getName());
                    readFile(file1.getAbsolutePath());
                }else{
                   // System.out.println("文件名:"+file1.getName());
                }

            }
        }

    }
}
