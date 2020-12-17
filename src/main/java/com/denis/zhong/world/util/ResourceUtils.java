package com.denis.zhong.world.util;

import org.springframework.core.io.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ResourceUtils {

    public static void readResource(String path){
        ResourceLoader loader = new DefaultResourceLoader();
        try {
            Resource resource = loader.getResource(path);
            InputStream is = resource.getInputStream();
            byte[] bytes = new byte[1024];
            while (is.read(bytes) !=-1){
                System.out.println(new String(bytes));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readResourceByClassPath(String path) throws IOException{
        Resource resource = new ClassPathResource(path);
        File file = resource.getFile();
        System.out.println(file.getName());
    }

    public static void readResourceByFilePath(String path) throws IOException{
        Resource resource = new FileSystemResource(path);
        File file = resource.getFile();
        System.out.println(file.getName());
    }

    /***
     * 读不到文件 可能是没有编译 发布到相应的目录下
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException{
        ResourceUtils.readResource("classpath:config/mybatis-config.xml");
//        ResourceUtils.readResourceByClassPath("mybatis-config.xml");
        ResourceUtils.readResourceByFilePath("/config/mybatis-config.xml");
    }
}
