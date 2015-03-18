package com.c05mic.generictree;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rilfi on 3/10/2015.
 */
public class tesy {
    public static void main(String[] args) throws IOException{
        ArrayList<String> al=new ArrayList<String>();
        String line,results="";
        BufferedReader reader = new BufferedReader(new FileReader("taxonomy.en-US.txt"));
        Node<String>root=new Node<String>("Categories");
        Tree<String> catree=new Tree<String>(root);
        while ((line=reader.readLine())!=null){
            al.add(line);
        }


        for(String li:al) {
            String perant = "Categories";
            String[] elements = li.split(">");
            System.out.println(elements.length);
            break;
        }





    }


}
