package com.nswdwy.io;

import org.junit.Test;

import java.io.*;

/**
 * @author yycstart
 * @create 2020-08-27 14:47
 */
public class Test03 {

    @Test
    public void test2(){
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileInputStream = new FileInputStream("practice.txt");
            inputStreamReader = new InputStreamReader(fileInputStream,"gbk");
            bufferedReader = new BufferedReader(inputStreamReader);

            fileOutputStream = new FileOutputStream("pracitce_copy3.txt");
            outputStreamWriter = new OutputStreamWriter(fileOutputStream,"gbk");
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            String s;
            while((s = bufferedReader.readLine()) != null){
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bufferedWriter != null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void test1(){
       FileInputStream fileInputStream = null;
       InputStreamReader inputStreamReader = null;
       BufferedReader bufferedReader = null;
        try {
            fileInputStream = new FileInputStream("practice.txt");
            inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            int s ;
            while((s = bufferedReader.read()) != -1){
                System.out.print((char)s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
