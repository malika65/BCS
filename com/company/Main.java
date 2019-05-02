package com.company;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.*;
import java.nio.file.Path;
import java.awt.GridLayout;
//@SuppressWarnings("serial")



public class Main extends MainFrame implements ActionListener{
    JLabel title, idLabel, nameLabel, frameLabel;
    JTextField idField, nameField;
    JButton registerButton, exitButton, backButton, logInButton, wishRegistButton;
    ButtonGroup bg;
    JPanel panel;
    JFrame mainFrame, myFrame;
    List<User> list = new ArrayList<User>();
    JTable table;
    // Returns a column class of Object
    DefaultTableModel model;
    JScrollPane scrollpane;

    // Defining Constructor
    Main() {
        //setSize(700, 360);
        //setLayout(null);
        //Defining Labels
        //myFrame = new JFrame("Budget Controlling System");
        //myFrame.setBounds(60,7,500,500);
        //mainFrame = new JFrame("BCS");
        //mainFrame.setBounds(60,7,300,300);
        //frameLabel = new JLabel("Welcome to BCS");
        //frameLabel.setBounds(110,70,200,100);
       /* title = new JLabel("Registration Form");
        title.setBounds(60, 7, 200, 30);
        idLabel = new JLabel("Name");
        idLabel.setBounds(30, 50, 60, 30);
        nameLabel = new JLabel("Password");
        nameLabel.setBounds(30, 85, 60, 30);
// Defining name field
        idField = new JTextField();
        idField.setBounds(95, 50, 100, 30);
// Defining Password field
        nameField = new JTextField();
        nameField.setBounds(95, 85, 100, 30);
        bg = new ButtonGroup();*/

        //Defining Exit Button
        //exitButton = new JButton("Exit");
        //exitButton.setBounds(25, 230, 80, 30);
        //exitButton.addActionListener(this);
        //Defining Register Button
        //registerButton = new JButton("Register");
        //registerButton.setBounds(110, 230, 100, 30);
        //registerButton.addActionListener(this);
        //backButton = new JButton("BACK");
        //backButton.setBounds(25,230,80,30);
        //backButton.addActionListener(this);
        /*logInButton = new JButton("Log in");
        logInButton.setBounds(110,200,100,30);
        logInButton.addActionListener(this);
        wishRegistButton = new JButton("Registrate");
        wishRegistButton.setBounds(110,160,100,30);
        wishRegistButton.addActionListener(this);*/
        // fixing all Label,TextField,Button
        /*myFrame.add(title);
        myFrame.add(idLabel);
        myFrame.add(nameLabel);
        myFrame.add(idField);
        myFrame.add(nameField);
        //mainFrame.add(exitButton);
        myFrame.add(registerButton);
        //mainFrame.add(logInButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myFrame.setVisible(false);
            }
        });
        myFrame.add(backButton);
        //mainFrame.add(wishRegistButton);
        //mainFrame.add(frameLabel);*/
        //Defining Panel
        //panel = new JPanel();
        // Defining Model for table
       /* model = new DefaultTableModel();
        table = new JTable(model);
        table.setEnabled(false);
        // Defining Column Names on model
        model.addColumn("Name");
        model.addColumn("Password");*/

        /*// Enable Scrolling on table
        scrollpane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);panel.add(scrollpane);
        panel.setEnabled(false);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setResizable(false);
        //mainFrame.setVisible(true);*/

    }

    /*public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() == exitButton) {
            System.exit(0);

        }if (ae.getSource() == wishRegistButton){
            myFrame.setVisible(true);
        }if (ae.getSource() == logInButton){
            myFrame.setVisible(true);
        }
        if (ae.getSource() == backButton){
            myFrame.setVisible(false);
            mainFrame.setVisible(true);
        }

        if(ae.getSource() == registerButton) {

            String name = idField.getText();
            String pass = nameField.getText();

            String userLine = findUser(name);

            if(!userLine.equals("")){

                if(pass.equals(userLine.substring(userLine.indexOf("#")))){
                    JOptionPane.showMessageDialog(idField,  "logged in ");

                }else
                {
                    JOptionPane.showMessageDialog(idField,  "Wrong password ");
                    return;

                }
            }


            if(name.equals("") || pass.equals(""))JOptionPane.showMessageDialog(idField,  "Fields will not be blank");
            else{
                //Storing records in List
                list.add(new User(name, pass));
                try {
                    writeToFile(idField, nameField);
                } catch (IOException e) {
                    e.printStackTrace();
                }


                // using for DialogBox
                JOptionPane.showMessageDialog(myFrame,"Successfully Registered");
                idField.setText("");
                nameField.setText("");
                bg.clearSelection();
                myFrame.setVisible(true);




            }


        }
    }*/
    /*//Adding records in List
    public void writeToFile(JTextField username, JTextField password) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("file.txt"));
        String pass = in.readLine();
        if (pass.contains("---"+ username.getText() + "#" + password.getText()+"---")) {
            JOptionPane.showMessageDialog(myFrame,"Already exists");
        } else {
            BufferedWriter out = new BufferedWriter(new FileWriter("file.txt", true));

            out.write("---" + username.getText() + "#" + password.getText() + "---");
            out.close();
        }
    }*/

    /*public boolean isExists(String name){
        try{
            BufferedReader in = new BufferedReader(new FileReader("file.txt"));
            String pass = in.readLine();
            String nameInFile;
            while (pass != null){

                nameInFile = pass.substring(3, pass.indexOf("#"));

                if(name.equals(nameInFile)){
                    return true;
                }

                pass = in.readLine();
            }
            return false;
        }catch (IOException e){
            return false;
        }
    }*/





}