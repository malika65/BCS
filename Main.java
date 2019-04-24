package com.company;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.*;



public class Main implements  ActionListener{
    private JButton buttonSubmit, buttonClose;
    private JPanel panel;

     private JPanel createFrame(){
         JPanel panel = new JPanel();
         panel.setLayout(null);
         JTextField login = new JTextField(10);
         JTextField password = new JTextField(20);
         panel.add(new JLabel("Enter your login: "));
         panel.add(login);
         panel.add(new JLabel("Enter your password "));
         panel.add(password);
         buttonSubmit = new JButton("Submit");
         buttonClose = new JButton("Close");
         buttonSubmit.setLocation(40, 40);
         buttonSubmit.setSize(90, 30);
         buttonClose.setLocation(10, 60);
         buttonClose.setSize(50, 30);
         buttonSubmit.addActionListener( this);
         buttonClose.addActionListener( this);
         panel.add(buttonSubmit);
         panel.add(buttonClose);

        panel.setOpaque(true);
        return panel;
    } public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonSubmit){
            JLabel text = new JLabel("You are free");
            panel.add(text);

        }
        else if (e.getSource() == buttonClose){
            panel.setVisible(false);

        }
    }private static void show(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame MainWindow = new JFrame("Budget Contriling System");
        Main demo = new Main();
        MainWindow.setContentPane(demo.createFrame());
        MainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainWindow.setBackground(Color.orange);
        MainWindow.setSize(400, 400);
        MainWindow.setLocation(100, 200);
        MainWindow.setVisible(true);

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                show();
            }
        });

    }

}
