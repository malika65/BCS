package com.company;

import javax.swing.*;
import java.io.*;

public class DB {
    final private String FILE_NAME = "file.txt";

    public User getUserByName(String userName){
        try {
            BufferedReader in = new BufferedReader(new FileReader(FILE_NAME));
            String[] lines  = in.readLine().split("@@");
            for (String line : lines ) {
                line = line.replace("@", "");
                String[] m = line.split("#");
                if(m[0].equals(userName)){
                    return new User(m[0], m[1]);
                }
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return new User("", "");
    }

    public void saveUserInDB(User u){
        try{
            BufferedReader in = new BufferedReader(new FileReader(FILE_NAME));
            BufferedWriter out = new BufferedWriter(new FileWriter(FILE_NAME, true));
            out.write("@" + u.name + "#" + u.pass + "@");
            out.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
