package com.HarshChourasiya;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class test {

    public static void main(String[] args) throws Exception{
        File file  = new File("G:\\3.Harsh\\emails.txt");
        System.out.println(file.getAbsoluteFile());
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line ;
        while((line=reader.readLine())!=null){
            System.out.println(line);
        }
    }
}
