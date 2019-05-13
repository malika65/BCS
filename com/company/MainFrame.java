package com.company;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MainFrame extends BCS implements ActionListener {
    DB data = new DB();
    JLabel title, idLabel, nameLabel, frameLabel,YouLabel, PassLabel;
    JTextField idField, passField, nameF, pasF;
    JButton registerButton, exitButton, backButton, logInButton, wishRegistButton, enterLogButton, backForLogBtn;
    JPanel panel1,panel2,panel3;
    JFrame mainFrame, secondFrame, logInFrame;




    MainFrame(){
        // Frame


        mainFrame = new JFrame("BCS");
        mainFrame.setBounds(60,7,300,300);

        secondFrame = new JFrame("Budget Controlling System");
        secondFrame.setBounds(60,7,500,500);

        logInFrame = new JFrame("Enter Your login and password");
        logInFrame.setBounds(60,7,300,300);

        frameLabel = new JLabel("Welcome to Budget Controling System");
        frameLabel.setBounds(30,70,250,100);

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
        registerButton.setBounds(110, 200, 100, 30);
        registerButton.addActionListener(this);


        backButton = new JButton("Back");
        backButton.setBounds(110,170,100,30);
        backButton.addActionListener(this);


        enterLogButton = new JButton("OK");
        enterLogButton.setBounds(110,170,100,30);
        enterLogButton.addActionListener(this);


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



        mainFrame.setVisible(true);


    }
    public void actionPerformed(ActionEvent ae) {

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
            String err = "";

            String name = idField.getText();
            String pass = passField.getText();

            User user = data.getUserByName(name);

            if (name.equals("") || pass.equals("")) {
                err = "Fields will not be blank";
            }

            if(name.length() < 3 ){
                err = "TOO LESS CHAR IN NAME";
            }

            if(user.name.equals(name)){
                err = "ALREADY EXIST";
            }

            if(!err.equals("")){
                JOptionPane.showMessageDialog(idField, err);
                return;
            }else {
                data.saveUserInDB(new User(name, pass));

                // using for DialogBox
                JOptionPane.showMessageDialog(secondFrame, "Successfully Registered");
                idField.setText("");
                passField.setText("");
                return;
            }

        }
        if (ae.getSource() == enterLogButton) {
            String err = "";
            String name = nameF.getText();

            User user = data.getUserByName(name);

            System.out.println(user.toString());
            String pass = pasF.getText();


            if (name.equals("") || pass.equals("")) {
                err = "Fields  not be blank";
            }

            if(user.name.equals("")){
                err = user.name + "Empty ";
            }

            if(!user.pass.equals(pass)){
                err = "Wrong password ";
            }

            if (!err.equals("")) {
                JOptionPane.showMessageDialog(idField, err);
            } else {
                JOptionPane.showMessageDialog(idField, "logged in ");

                panel2.setVisible(false);
                logInFrame.setVisible(false);
                frame.setVisible(true);




                // open proj panel
                new BCS();



                // here
            }

        }

        }

        //Adding records in List

        public static void main (String[]args){
        new MainFrame();
    }
}

