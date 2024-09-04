/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hall.ticket.system;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Slogin extends JFrame implements ActionListener {
    JTextField username;
    JPasswordField password;
    JButton login,cancel;
    
    Slogin() {
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       
       JLabel fuser= new JLabel("Username");
       fuser.setBounds(40,20,100,30);
       add(fuser);
       
       username=new JTextField();
       username.setBounds(150,20,150,30);
       add(username);
       
       
       JLabel fpass= new JLabel("Password");
       fpass.setBounds(40,70,100,30);
       add(fpass);
       
        password=new JPasswordField();
        password.setBounds(150,70,150,30);
        add(password);
        
        login= new JButton("LOGIN");
        login.setBounds(40,150,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        cancel= new JButton("CANCEL");
        cancel.setBounds(180,150,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
       
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/adm.png"));
        Image i2=i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
                image.setBounds(350,10,200,200);
                add(image);
        setBounds(500,200,600,300);
        setVisible(true);
        
        
       setBounds(500,200,600,300);
       setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== login){
           String user= username.getText();
           
           String pass =password.getText();
           
           try{
              Conn c=new Conn();
              
              String query="select* from student where suser='"+ user +"'and spass ='"+ pass+"'";
              
            ResultSet rs= c.s.executeQuery(query);
            
            if(rs.next()){
                String sroll=rs.getString("sroll");
                String course=rs.getString("course");
                 String semester=rs.getString("semester");
               setVisible(false);
               new Studentdisplay(sroll,course,semester);
            }
            else{
                JOptionPane.showMessageDialog(null, "INVALID USERNAME OR PASSWORD");
                setVisible(false);
            }
             
           }
           catch(Exception e){
               e.printStackTrace();
           }
              
        }
        else if(ae.getSource()== cancel){
            setVisible(false);
        }
    }
    
    
    
    public static void main(String args[]) {
        new Slogin();
    }      
}


