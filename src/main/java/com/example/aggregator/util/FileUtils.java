package com.example.aggregator.util;

import java.io.*;
import java.util.HashSet;

public class FileUtils {

    public static HashSet<String> readFile(InputStream file) {
        HashSet<String> prefixes = new HashSet<String>(1000000);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                try {
                    prefixes.add(Integer.toString(Integer.parseInt(line)));
                }catch (NumberFormatException e){
                    System.out.println(line + " is incorrect number. It will be skipped");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        return prefixes;
    }

    public static HashSet<String> readFile(String file) {
        HashSet<String> prefixes = new HashSet<String>(1000000);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new java.io.FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                try {
                    prefixes.add(Integer.toString(Integer.parseInt(line)));
                }catch (NumberFormatException e){
                    System.out.println(line + " is incorrect number. It will be skipped");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        return prefixes;
    }
}
