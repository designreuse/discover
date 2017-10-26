package com.tongna;

import java.io.File;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       UploadUtils utils=new UploadUtils("avatars","http://xunlu.gz.bcebos.com/");

       boolean isok= utils.updload("a.jpg",new File("d:\\yhj.jpg"));
       if (isok){
           System.out.println("上传文件成功");
       }else{
           System.out.println("上传文件失败");
       }
    }
}
