/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hall.ticket.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Admindisplay extends JFrame implements ActionListener {
    
    Admindisplay(){
        setBounds(0,0,1550,1000);
       
       setLayout(null);
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/adp.jpg"));
        JLabel image=new JLabel(i1);
                image.setBounds(0,0,1600,900);
                add(image);
        JLabel text= new JLabel("Welcome to the Admin Panel");
                text.setBounds(400,80,1000,60);
                text.setFont(new Font("serif",Font.ROMAN_BASELINE,50));
                text.setForeground(Color.WHITE);
                image.add(text);
        JMenuBar mb= new JMenuBar();
                mb.setBounds(0,0,1550,30);
                image.add(mb);
                
                
        JMenu facultysec= new JMenu("Faculty Section");
                facultysec.setForeground(Color.black);
                mb.add(facultysec); 
        
        JMenuItem fd=new JMenuItem("Add Faculty Details");
               fd.addActionListener(this);
               facultysec.add(fd);
       
        JMenuItem vd=new JMenuItem("View Faculty Details");
               vd.addActionListener(this);
               facultysec.add(vd);       
                
                
        JMenu studentsec= new JMenu("Student Section");
                studentsec.setForeground(Color.black);
                mb.add(studentsec); 
                
        JMenuItem sd=new JMenuItem("Add Student Details");
               sd.addActionListener(this);
               studentsec.add(sd);
               
        JMenuItem us=new JMenuItem("Update Student Details");
               us.addActionListener(this);
               studentsec.add(us);       
               
        JMenuItem vs=new JMenuItem("View Student Details");
               vs.addActionListener(this);
               studentsec.add(vs); 
               
        JMenu exit=new JMenu("Logout");
               exit.setForeground(Color.black);
                mb.add(exit); 
        
        JMenuItem ex=new JMenuItem("Logout");
               ex.addActionListener(this);
               exit.add(ex);       
               
        setVisible(true);       
       
   } 
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("Add Faculty Details")){
            new Addfaculty();
        }
        else if(ae.getActionCommand().equals("View Faculty Details")){
            new Viewfaculty();
        }
        
        else if(ae.getActionCommand().equals("Add Student Details")){
            new Addstudent();
        }
       else if(ae.getActionCommand().equals("Update Student Details")){
            new Updatestudent();
        }
         else if(ae.getActionCommand().equals("View Student Details")){
            new Viewstudent();    
        }
         else if(ae.getActionCommand().equals("Logout")){
            setVisible(false);
            new Dashboard();   
        }
    }
    public static void main(String[] args){
       new Admindisplay();
   }
}   
