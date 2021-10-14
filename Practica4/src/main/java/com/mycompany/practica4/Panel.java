/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.practica4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class Panel extends JPanel {
    
    private final ArrayList<Point> myShapes;
    private Color color;
    private Color trace;
    public Panel(){
        myShapes = new ArrayList<>();
        color = Color.WHITE;
        trace = Color.BLACK;
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);    
        this.setBackground(color);
        this.setForeground(trace);
        
        myShapes.forEach((p) -> {
            g.fillOval(p.x, p.y, 10, 10);
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    //this funcion draws a circle with the coordinates x and y    

    void addNewPoint(Point point) {
        myShapes.add(0, point);
    }
    void removeLastPoint() {
        if (myShapes.size() > 5) {
            myShapes.remove(5);
        }
    }
    
    void setColor(Color c){
        this.setBackground(c);
        color = c;
    }
    
    void setTrace (Color c){
        this.setForeground(c);
        trace = c;
    }
}
