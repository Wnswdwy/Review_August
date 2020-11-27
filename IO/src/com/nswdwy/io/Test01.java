package com.nswdwy.io;

import org.junit.Test;

import java.io.*;

/**
 * @author yycstart
 * @create 2020-08-27 11:25
 */
public class Test01 {
    @Test
    public void test1() throws IOException {
        FileReader fileReader = null;

        try {
            fileReader = new FileReader("practice.txt");
            int read;
            while((read = fileReader.read()) != -1){
                System.out.print((char)read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileReader != null){
                fileReader.close();
            }
        }
    }
    @Test
    public void test2(){
        //读取并写入
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            fileReader = new FileReader("practice.txt");
            fileWriter = new FileWriter("copy_practice.txt");
            int ch;
            while((ch = fileReader.read()) != -1){
                fileWriter.write(ch);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileWriter != null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
