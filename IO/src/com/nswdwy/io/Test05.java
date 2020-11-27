package com.nswdwy.io;

import java.io.*;

/**
 * @author yycstart
 * @create 2020-08-27 15:37
 */
public class Test05 {
    public static void main(String[] args) {
        InputStream in = System.in;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;


        try {
            inputStreamReader = new InputStreamReader(in);
            bufferedReader = new BufferedReader(inputStreamReader);
            fileOutputStream = new FileOutputStream("input_key.txt");
            outputStreamWriter = new OutputStreamWriter(fileOutputStream,"utf8");
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            String line;
            while((line = bufferedReader.readLine()) != null){
                if(line.equals("exit")){
                    break;
                }
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bufferedReader != null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bufferedWriter != null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
