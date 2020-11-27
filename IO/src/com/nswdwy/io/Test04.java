package com.nswdwy.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author yycstart
 * @create 2020-08-27 15:17
 */
public class Test04 {
    @Test
    public static void main(String[] args) {
        InputStream ins = System.in;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;


            inputStreamReader = new InputStreamReader(ins);
            bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            try {
               while ((line = bufferedReader.readLine()) != null){
                    if(line.equals("exit")){
                        break;
                    }
                    System.out.println(line);
                }

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
