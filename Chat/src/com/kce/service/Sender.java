package com.kce.service;
import java.io.BufferedReader;
import java.io.CharConversionException;
//import java.io.Exception;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Sender {
      static RandomAccessFile file; 
      
      Sender(int UserId,int reciverId,String a) throws Exception{
          
          file= new RandomAccessFile("data.txt", "rw");
          FileReader reader1 = new FileReader("data.txt");
          BufferedReader reader = new BufferedReader(reader1) ;
            String line;
            int i=1;
           String full="";
            while ((line = reader.readLine()) != null) {
                    i++;
                 full+=line+"\n";
                }
        fileRewriter();
        String str="From "+UserId+" to "+reciverId+"(" +a+")"+i+"\n"+full;
        file.write(str.getBytes());
           }
public void fileRewriter() throws Exception{
    
    FileWriter writer = new FileWriter("data.txt");
   
    writer.close();
}

}