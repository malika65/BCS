package com.company;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.*;
import java.awt.*;

public class MainFrame implements ActionListener {
    JLabel title, idLabel, nameLabel, frameLabel,YouLabel, PassLabel;
    JTextField idField, passField, nameF, pasF;
    JButton registerButton, exitButton, backButton, logInButton, wishRegistButton, enterLogButton, backForLogBtn;
    JPanel panel1,panel2,panel3;
    JFrame mainFrame, secondFrame, logInFrame;
    List<User> list = new ArrayList<User>();
    JTable table,table1;
    DefaultTableModel model,model1;

    MainFrame(){
        // Frame
        mainFrame = new JFrame("BCS");
        mainFrame.setBounds(60,7,300,300);
        secondFrame = new JFrame("Budget Controlling System");
        secondFrame.setBounds(60,7,500,500);
        logInFrame = new JFrame("Enter Your login and password");
        logInFrame.setBounds(60,7,300,300);
        frameLabel = new JLabel("Welcome to BCS");
        frameLabel.setBounds(110,70,200,100);
        title = new JLabel("Registration Form");
        title.setBounds(60, 7, 200, 30);
        idLabel = new JLabel("Name");
        idLabel.setBounds(30, 50, 60, 30);
        nameLabel = new JLabel("Password");
        nameLabel.setBounds(30, 85, 60, 30);
        YouLabel = new JLabel("Login");
        YouLabel.setBounds(30, 50, 80, 30);
        PassLabel = new JLabel("Password");
        PassLabel.setBounds(30, 85, 60, 30);
        //Panel
        panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setSize(300,300);

        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setSize(300,300);

        panel3 = new JPanel();
        panel3.setLayout(null);
        panel3.setSize(300,300);

        // Fields
        idField = new JTextField();
        idField.setBounds(95, 50, 100, 30);

        passField = new JTextField();
        passField.setBounds(95, 85, 100, 30);

        nameF = new JTextField();
        nameF.setBounds(95, 50, 100, 30);

        pasF = new JTextField();
        pasF.setBounds(95, 85, 100, 30);
        // Buttons
        exitButton = new JButton("Exit");
        exitButton.setBounds(110, 230, 100, 30);
        exitButton.addActionListener(this);
        logInButton = new JButton("Log in");
        logInButton.setBounds(110,200,100,30);
        logInButton.addActionListener(this);
        wishRegistButton = new JButton("Registrate");
        wishRegistButton.setBounds(110,170,100,30);
        wishRegistButton.addActionListener(this);
        registerButton = new JButton("Register");
        registerButton.setBounds(110, 230, 100, 30);
        registerButton.addActionListener(this);
        backButton = new JButton("Back");
        backButton.setBounds(110,170,100,30);
        backButton.addActionListener(this);
        enterLogButton = new JButton("OK");
        enterLogButton.setBounds(110,170,100,30);
        backForLogBtn = new JButton("BACK");
        backForLogBtn.setBounds(110,200,100,30);
        backForLogBtn.addActionListener(this);


        // Add
        panel1.add(exitButton);
        panel1.add(logInButton);
        panel1.add(wishRegistButton);
        panel1.add(frameLabel);
        mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
        mainFrame.setContentPane(panel1);
        panel2.add(enterLogButton);
        panel2.add(backForLogBtn);
        panel2.add(YouLabel);
        panel2.add(PassLabel);
        panel2.add(nameF);
        panel2.add(pasF);
        logInFrame.setDefaultCloseOperation(logInFrame.EXIT_ON_CLOSE);
        logInFrame.setContentPane(panel2);
        panel3.add(title);
        panel3.add(idLabel);
        panel3.add(nameLabel);
        panel3.add(idField);
        panel3.add(passField);
        panel3.add(registerButton);
        panel3.add(backButton,BorderLayout.CENTER);
        secondFrame.setDefaultCloseOperation(secondFrame.EXIT_ON_CLOSE);
        secondFrame.setContentPane(panel3);

        /*backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondFrame.setVisible(false);
            }
        });*/


        //panel.setVisible(true);

        mainFrame.setVisible(true);


    }public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == exitButton) {
            System.exit(0);

        }
        if (ae.getSource() == wishRegistButton) {
            secondFrame.setVisible(true);
            panel3.setVisible(true);
        }
        if (ae.getSource() == logInButton) {
            mainFrame.setVisible(false);
            logInFrame.setVisible(true);
            panel2.setVisible(true);

        }
        if (ae.getSource() == backButton) {

            panel3.setVisible(false);
            secondFrame.setVisible(false);
            mainFrame.setVisible(true);
        }
        if (ae.getSource() == backForLogBtn){
            panel2.setVisible(false);
            logInFrame.setVisible(false);
            mainFrame.setVisible(true);
        }

        if (ae.getSource() == registerButton) {

            String name = idField.getText();
            String pass = passField.getText();

            String userLine = findUser(name);

            if (!userLine.equals("")) {

                if (pass.equals(userLine.substring(userLine.indexOf("#")))) {
                    JOptionPane.showMessageDialog(idField, "logged in ");

                } else {
                    JOptionPane.showMessageDialog(idField, "Wrong password ");
                    return;

                }
            }


            if (name.equals("") || pass.equals("")) JOptionPane.showMessageDialog(idField, "Fields will not be blank");
            else {
                //Storing records in List
                list.add(new User(name, pass));
                try {
                    writeToFile(idField, passField);
                } catch (IOException e) {
                    e.printStackTrace();
                }


                // using for DialogBox
                JOptionPane.showMessageDialog(secondFrame, "Successfully Registered");
                idField.setText("");
                passField.setText("");
                //bg.clearSelection();
                //secondFrame.setVisible(true);


            }


            }
        }//Adding records in List
    public void writeToFile(JTextField username, JTextField password) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("file.txt"));
        String pass = in.readLine();
        if (pass.contains("---"+ username.getText() + "#" + password.getText()+"---")) {
            JOptionPane.showMessageDialog(secondFrame,"Already exists");
        } else {
            BufferedWriter out = new BufferedWriter(new FileWriter("file.txt", true));

            out.write("---" + username.getText() + "#" + password.getText() + "---");
            out.close();
        }
    }public String findUser(String name){
        try{
            BufferedReader in = new BufferedReader(new FileReader("file.txt"));
            String user = in.readLine();
            String nameInFile;
            while (user != null){

                nameInFile = user.substring(3);
                System.out.println(nameInFile);

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

        public static void main (String[]args){
        new MainFrame();
    }
}

