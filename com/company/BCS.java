package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;

public class BCS {
    JTextField transport1,  culture1,selfDevelop1,clothes1, life1, nutrition1, household1;
    JLabel  transport, household, nutrition, life, clothes, selfDevelop, culture , msgLabel;
    JButton btnSubmit, btnCancel, btnBack;
    public JFrame frame;
    TestDraw draw;
    JPanel panel;

    public static void main(String[] args) {
        new BCS();
    }

    BCS(){
        frame = new JFrame();
        frame.setBounds(60,7,500,500);


        panel = new JPanel();
        panel.setSize(500,500);
        panel.setLayout(null);


        //Labels

        transport = new JLabel("Transport:");
        transport.setBounds(30,85,100,30);
        transport.setOpaque(true);
        transport.setForeground(Color.RED);
        household = new JLabel("Household:");
        household.setBounds(30,125,100,30);
        household.setForeground(Color.ORANGE);
        nutrition = new JLabel("Nutrition:");
        nutrition.setBounds(30,165,100,30);
        nutrition.setForeground(Color.YELLOW);
        life = new JLabel("Life:");
        life.setBounds(30,205,100,30);
        life.setForeground(Color.GREEN);
        clothes = new JLabel("Clothes:");
        clothes.setBounds(30,245,100,30);
        clothes.setForeground(Color.BLUE);
        selfDevelop = new JLabel("Self development:");
        selfDevelop.setBounds(30,285,150,30);
        selfDevelop.setForeground(Color.MAGENTA);
        culture = new JLabel("Culture:");
        culture.setBounds(30,325,100,30);
        culture.setForeground(Color.PINK);
        msgLabel = new JLabel();
        msgLabel.setBounds(255,100,300,300);

        //Fiels
        transport1 = new JTextField();
        transport1.setBounds(150,85,100,30);
        household1 = new JTextField();
        household1.setBounds(150,125,100,30);
        nutrition1 = new JTextField();
        nutrition1.setBounds(150,165,100,30);
        life1 = new JTextField();
        life1.setBounds(150,205,100,30);
        clothes1 = new JTextField();
        clothes1.setBounds(150,245,100,30);
        selfDevelop1 = new JTextField();
        selfDevelop1.setBounds(150,285,100,30);
        culture1 = new JTextField();
        culture1.setBounds(150,325,100,30);

        //Buttons
        btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(150,370,100,30);
        btnSubmit.addActionListener(new LoginListener());

        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(270,370,100,30);
        btnCancel.addActionListener(new CancelListener());

        btnBack = new JButton("Back");
        btnBack.setBounds(200,400,100,30);
        btnBack.addActionListener(new BackListener());


        //Add


        panel.add(transport);
        panel.add(household);
        panel.add(nutrition);
        panel.add(life);
        panel.add(clothes);
        panel.add(selfDevelop);
        panel.add(culture);

        panel.add(msgLabel);

        panel.add(btnSubmit);
        panel.add(btnCancel);
        panel.add(btnBack);

        panel.add(transport1);
        panel.add(household1);
        panel.add(nutrition1);
        panel.add(life1);
        panel.add(clothes1);
        panel.add(selfDevelop1);
        panel.add(culture1);



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(panel);



    }public class LoginListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
                int tran = Integer.parseInt(transport1.getText());
                int hous = Integer.parseInt(household1.getText());
                int nutr = Integer.parseInt(nutrition1.getText());
                int lif = Integer.parseInt(life1.getText());
                int clot = Integer.parseInt(clothes1.getText());
                int selfd = Integer.parseInt(selfDevelop1.getText());
                int cul = Integer.parseInt(culture1.getText());


                int total = tran + hous + nutr + lif + clot + selfd + cul ;

                initComponents();
                Integer[] values = {total,tran,hous,nutr,lif,clot,selfd,cul};
            Integer[] values1 = {tran,hous,nutr,lif,clot,selfd,cul};
            int max = Collections.max(Arrays.asList(values1));
            msgLabel.setText("YOU SPENT A LOT OF MONEY FOR: "+ max);
            String transProc = Double.toString(Math.round(((tran*100)/total)*100.0)/100.0);
                String housProc = Double.toString(Math.round(((hous*100)/total)*100.0)/100.0);
                String nutrProc = Double.toString(Math.round(((nutr*100)/total)*100.0)/100.0);
                String lifeProc = Double.toString(Math.round(((lif*100)/total)*100.0)/100.0);
                String clotProc = Double.toString(Math.round(((clot*100)/total)*100.0)/100.0);
                String selfdProc = Double.toString(Math.round(((selfd*100)/total)*100.0)/100.0);
                String cultProc = Double.toString(Math.round(((cul*100)/total)*100.0)/100.0);

                transport1.setText(transProc+"%");
                household1.setText(housProc+"%");
                nutrition1.setText(nutrProc+"%");
                life1.setText(lifeProc+"%");
                clothes1.setText(clotProc+"%");
                selfDevelop1.setText(selfdProc+"%");
                culture1.setText(cultProc+"%");
                draw.setValues(values);
                draw.setVisible(true);
                panel.setVisible(true);
                frame.setVisible(true);



    }
    }
    public class CancelListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            transport1.setText("");
            household1.setText("");
            nutrition1.setText("");
            life1.setText("");
            clothes1.setText("");
            selfDevelop1.setText("");
            culture1.setText("");
            draw.setVisible(false);
            msgLabel.setText("");

        }
    }
    public class BackListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            frame.setVisible(false);
            MainFrame me = new MainFrame();
            me.panel2.setVisible(true);
            me.logInFrame.setVisible(true);


        }
    }



    private void initComponents() {

        draw = new TestDraw();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GroupLayout jPanel1Layout = new GroupLayout(draw);
        draw.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 300, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(draw, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(draw, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        //panel.pack();
    }
}
