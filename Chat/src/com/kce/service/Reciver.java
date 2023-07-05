package com.kce.service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.RandomAccessFile;
class Reciver{
   Reciver(int UserId)throws Exception{
    
     FileReader fileReader = new FileReader("data.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader);
            String id="to "+Integer.toString(UserId);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
               String ne=line;
               if(ne.contains(id)){
                String data=ne.replace(id,"");
                   System.out.println(data);
               }
            }
   }
}