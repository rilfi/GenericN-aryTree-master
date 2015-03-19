package com.c05mic.generictree;

import com.sun.org.apache.xpath.internal.SourceTree;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by rilfi on 3/10/2015.
 */
public class UniqNodeGen {
    static BufferedReader reader;
    static Node<String> root;
    static Tree<String> catree;
    static ArrayList<String> al;
    static BufferedWriter outputfile;
    static BufferedWriter listdef;

    public static void main(String[] args) {

        al = new ArrayList<String>();
        String line, results = "";
        try {
            reader = new BufferedReader(new FileReader("taxonomy.en-US.txt"));
            root = new Node<String>("Categories");
            catree = new Tree<String>(root);
            listdef = new BufferedWriter(new FileWriter("list.txt"));
            while ((line = reader.readLine()) != null) {
                al.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        for (String li : al) {
            String perant = "Categories";
            String[] elements = li.split(">");
            for (String el : elements) {

                if (catree.exists(el)) {
                    perant = el;
                    // System.out.println("****  "+perant);

                } else if (!catree.exists(el)) {
                    Node<String> perantNode = catree.findNode(root, perant);
                    perantNode.addChild(new Node<String>(el));
                    //System.out.println(el);
                }

            }
        }
        System.out.println(catree.getNumberOfNodes());
        System.out.println(catree.getMaxDepth());
        //System.out.println(catree.getPathsFromRootToAnyLeaf());
        //System.out.println(catree.getPostOrderTraversal());
        // System.out.println(catree.getPreOrderTraversal());
        ArrayList<Node<String>> nodes = catree.getPreOrderTraversal();
        int oi=0;
        try {
            outputfile = new BufferedWriter(new FileWriter("NodeList.txt"));
        }
        catch (IOException ioeg){
            ioeg.printStackTrace();
        }
        for (Node<String> nod : nodes) {
            /*oi++;
            if(oi==100)
                break;*/

            try {



                outputfile.write(nod.getData());

                        outputfile.newLine();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                try {
                    outputfile.flush();
                    outputfile.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }










    }
}
