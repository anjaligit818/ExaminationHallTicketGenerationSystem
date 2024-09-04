/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hall.ticket.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener{
    
    Dashboard(){
       setBounds(0,0,1550,1000);
       
       setLayout(null);
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/da.png"));
        JLabel image=new JLabel(i1);
                image.setBounds(0,0,1600,1000);
                add(image);
        JLabel text= new JLabel("Welcome to the Dashboard");
                text.setBounds(400,80,1000,60);
                text.setFont(new Font("serif",Font.ROMAN_BASELINE,50));
                text.setForeground(Color.WHITE);
                image.add(text);
        JMenuBar mb= new JMenuBar();
                mb.setBounds(0,0,1550,30);
                image.add(mb);
                
                
        JMenu admin= new JMenu("ADMIN");
                admin.setForeground(Color.black);
                mb.add(admin); 
        
        JMenuItem login=new JMenuItem("Admin Panel");
                login.addActionListener(this);
                admin.add(login);
                
                
         JMenu faculty= new JMenu("FACULTY");
                faculty.setForeground(Color.black);
                mb.add(faculty); 
                
         JMenuItem flogin=new JMenuItem("Faculty Panel");
                flogin.addActionListener(this);
                faculty.add(flogin);        
                
        JMenu student= new JMenu("STUDENT");
                student.setForeground(Color.black);
                mb.add(student); 
        
        JMenuItem slogin=new JMenuItem("Student Panel");
               slogin.addActionListener(this);
                student.add(slogin);      
                
        JMenu exit=new JMenu("EXIT");
               exit.setForeground(Color.black);
                mb.add(exit); 
        
        JMenuItem ex=new JMenuItem("Exit");
               ex.addActionListener(this);
               exit.add(ex);           
                         
        setVisible(true);       
       
   } 
    
         public void actionPerformed(ActionEvent ae){
             if(ae.getActionCommand().equals("Admin Panel")){
                 
                 new Login();
                 }
             else if(ae.getActionCommand().equals("Faculty Panel")){
                 
                 new Flogin();
                 }
              else if(ae.getActionCommand().equals("Exit")){
               setVisible(false);   
              }
            else if(ae.getActionCommand().equals("Student Panel")){
                
                 new Slogin();
            }
         }
   public static void main(String[] args){
       new Dashboard();
   }
}        

