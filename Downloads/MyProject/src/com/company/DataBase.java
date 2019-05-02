package com.company;

import javax.swing.*;
import java.io.*;

public class DataBase {
    public void writeToFile(JTextField username, JTextField password) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("file.txt"));
        String pass = in.readLine();
        if (pass.contains(username.getText() + "#" + password.getText()+"@")) {
            JOptionPane.showMessageDialog(secondFrame,"Already exists");
        } else {
            BufferedWriter out = new BufferedWriter(new FileWriter("file.txt", true));

            out.write(username.getText() + "#" + password.getText() + "@");
            out.close();
        }
    }public String findUser(String name){
        try{
            BufferedReader in = new BufferedReader(new FileReader("file.txt"));
            String user = in.readLine();
            String nameInFile;
            while (user != null){

                nameInFile = user.substring(3,user.indexOf("#"));
                //System.out.println(nameInFile);

                if(name.equals(nameInFile)){
                    return user;
                }

                user = in.readLine();
            }
            return "";
        }catch (IOException e){
            return "";
        }
}
