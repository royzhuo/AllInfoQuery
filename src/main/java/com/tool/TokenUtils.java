package com.tool;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class TokenUtils {
    public static void main(String[] args) throws ParseException {
        for(int i=0;i<10;i++){
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            System.out.println(uuid);
        }
        stampToDate(System.currentTimeMillis());

       long tokenTimsStamp= setTokenTimeValidity(new Date());
        System.out.println("时间戳判断:"+isOverDue(tokenTimsStamp));
        File file=new File("/spring.xml");
        try {
            TokenUtils tokenUtils=new TokenUtils();
            InputStream fileInputStream=tokenUtils.getFile();

            BufferedInputStream bufferedInputStream=new BufferedInputStream(fileInputStream);
            try {
                int len=1024;
                byte[] bytes=new byte[len];
                while ((bufferedInputStream.read(bytes))!=-1){
                    System.out.println(new String(bytes,0,len));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(file.getName());
    }

    public  InputStream getFile(){
        return   this.getClass().getClassLoader().getResourceAsStream("spring.xml");
    }

    public static String stampToDate(long s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    public static Date stampToDate1(long currentTimeStamp){
        String res;
        long lt = new Long(currentTimeStamp);
        Date date = new Date(lt);
        return date;
    }

    /*
   * 将时间转换为时间戳
   */
    public static long dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
       // res = String.valueOf(ts);
        return ts;
    }

    //date转字符串
    public static String dateFormateString(Date date){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    public static Date stringFormateDate(String date){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    //设置touken有效期5天
    public static long setTokenTimeValidity(Date nowDate) throws ParseException {
        System.out.println("今天:"+dateFormateString(nowDate));
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(nowDate);
//        calendar.add(Calendar.DAY_OF_MONTH,5);
        calendar.add(Calendar.MINUTE,30);
        Date fitureDay=calendar.getTime();
        System.out.println("五天后:"+dateFormateString(fitureDay));
        System.out.println("五天后时间戳:"+dateToStamp(dateFormateString(fitureDay)));
        return dateToStamp(dateFormateString(fitureDay));
    }

    //判断有效期是否过期
    public static boolean isOverDue(long tokenTermOfValidity){
        //获取当前时间戳
        long nowTimeStamp=System.currentTimeMillis();

        return nowTimeStamp>tokenTermOfValidity;
    }


}
