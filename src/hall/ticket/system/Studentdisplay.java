/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hall.ticket.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.*;


public class Studentdisplay extends JFrame implements ActionListener{
    String sroll,course,semester;
    Studentdisplay(String sroll, String course, String semester)
    {
          this.sroll=sroll;
          this.course=course;
          this.semester=semester;
          setBounds(0,0,1550,1000);
       
       setLayout(null);
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/sd.jpg"));
        JLabel image=new JLabel(i1);
                image.setBounds(0,0,1600,900);
                add(image);
        JLabel text= new JLabel("Welcome to the Student Panel");
                text.setBounds(400,80,1000,60);
                text.setFont(new Font("serif",Font.ROMAN_BASELINE,50));
                text.setForeground(Color.WHITE);
                image.add(text);
        JMenuBar mb= new JMenuBar();
                mb.setBounds(0,0,1550,30);
                image.add(mb);
                  
                
                
        JMenu studentsec= new JMenu("VIEW");
                studentsec.setForeground(Color.black);
                mb.add(studentsec); 
      
        JMenuItem gd=new JMenuItem("View Hall Ticket");
                gd.addActionListener(this);
               studentsec.add(gd);     
        
        JMenu exit=new JMenu("LOGOUT");
               exit.setForeground(Color.black);
                mb.add(exit); 
        
        JMenuItem ex=new JMenuItem("Logout");
               ex.addActionListener(this);
               exit.add(ex);          
               
        setVisible(true);       
       
   } 
     public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("View Hall Ticket")){
            new Gentick(sroll,course,semester);
        }
         else if(ae.getActionCommand().equals("Logout")){
             setVisible(false);
            new Dashboard();   
        }
     
     }
    public static void main(String[] args){
       new Studentdisplay("","","");
   }
}   

