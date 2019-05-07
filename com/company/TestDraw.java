package com.company;


import java.awt.*;

public class TestDraw extends javax.swing.JPanel {
    private Integer[] values ;
    private Insets insets;
    Color colors[] = {
            Color.RED,
            Color.ORANGE,
            Color.YELLOW,
            Color.GREEN,
            Color.BLUE,
            Color.MAGENTA,
            Color.PINK
    };

    /** Creates new form TestDraw */
    public TestDraw() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 50, Short.MAX_VALUE)
        );
    }// </editor-fold>

    // Variables declaration - do not modify
    // End of variables declaration
    @Override
    public void paint(Graphics g) {
        Graphics2D gd = (Graphics2D) g;
        gd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        super.paint(g);
        if (insets == null) {
            insets = getInsets();
        }
        int x = 300;//insets.left;
        int y = 30;//insets.top;
        int width  = 150;//getWidth()  - insets.left - insets.right;
        int height = 150;//getHeight() - insets.top  - insets.bottom;
        int start  = 0;

        int steps    = values.length;
        int stepSize ;
        int total    = values[0];
        for (int i = 1; i < steps; i++) {
            stepSize = getStepSize(values[i],total);
            g.setColor(colors[i-1]);
            g.fillArc(x, y, width, height, start, stepSize);
            start += stepSize;
        }
    }


    private int getStepSize(Integer val,int total){
        return (int)(364*val)/total;
    }

    public void setValues(Integer[] values){
        this.values = values;
    }

}