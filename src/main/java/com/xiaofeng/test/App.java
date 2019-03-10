package com.xiaofeng.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.commons.lang3.StringUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println(compress("aaaaa"));
    	readerWriterFile();
    }
    
    public static String compress(String s){
        String result = "";
        if (StringUtils.isBlank(s)){
            result ="你输入为空!";
        }else if (s.contains(" ")){
            result ="请不要输入空格!";
        }else {
            int length = s.length();
            System.out.println("length: "+length);
            int count  = 0;
            for (int i= 1;i<=length;i++){
                String[] strings1 = s.split(s.substring(0,i));
                if (strings1.length==0){
                    System.out.println("切分到"+i);
                    count = i;
                    break;
                }
            }
            result = length/count + s.substring(0,count);
        }
        return result;
    }
    
    /**
     * 读入TXT文件
     */
    public static void readFile() {
        String pathname = "C:\\ProgramData\\MySQL\\MySQL Server 5.7\\Uploads\\2.txt"; // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
        //防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw;
        //不关闭文件会导致资源的泄露，读写文件都同理
        //Java7的try-with-resources可以优雅关闭文件，异常时自动关闭文件；详细解读https://stackoverflow.com/a/12665271
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;
            //网友推荐更加简洁的写法
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 写入TXT文件
     */
    public static void writeFile() {
        try {
            File writeName = new File("output.txt"); // 相对路径，如果没有则要建立一个新的output.txt文件
            writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
            try (FileWriter writer = new FileWriter(writeName);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
                out.write("我会写入文件啦1\r\n"); // \r\n即为换行
                out.write("我会写入文件啦2\r\n"); // \r\n即为换行
                out.flush(); // 把缓存区内容压入文件
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void readerWriterFile(){
    	String pathname = "C:\\ProgramData\\MySQL\\MySQL Server 5.7\\Uploads\\2.txt"; // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
        //防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw;
        //不关闭文件会导致资源的泄露，读写文件都同理
        //Java7的try-with-resources可以优雅关闭文件，异常时自动关闭文件；详细解读https://stackoverflow.com/a/12665271
    	File writeName = new File("D:\\output.txt"); // 相对路径，如果没有则要建立一个新的output.txt文件
        try {
			writeName.createNewFile();// 创建新文件,有同名的文件的话直接覆盖
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
    	try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
        		FileWriter writer = new FileWriter(writeName);
                BufferedWriter out = new BufferedWriter(writer);
        ) {
            String line;
            //网友推荐更加简洁的写法
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                System.out.println(line);
                out.write(line+"\r\n");
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
