package com.nswdwy.io;

import org.junit.Test;

import java.io.*;

/**
 * @author yycstart
 * @create 2020-08-27 14:10
 */
public class Test02 {
    @Test
    public void test(){
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader("practice.txt");
            bufferedReader = new BufferedReader(fileReader);
            String line ;
            while(true){
                try {
                    if (((line = bufferedReader.readLine()) != null)){
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                if(fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

        @Test
        public void test2(){
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
            try {
                fileReader = new FileReader("practice.txt");
                bufferedReader = new BufferedReader(fileReader);
                fileWriter = new FileWriter("practice_copy02.txt");
                bufferedWriter = new BufferedWriter(fileWriter);
                String s;
                while((s = bufferedReader.readLine()) != null){
                    bufferedWriter.write(s);
                    bufferedWriter.newLine();
                }
            } catch (FileNotFoundException e) {
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
                if(bufferedReader != null ){
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

}
