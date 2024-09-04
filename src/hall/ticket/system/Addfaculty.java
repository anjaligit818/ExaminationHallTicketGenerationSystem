/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hall.ticket.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Addfaculty extends JFrame implements ActionListener{
      
    JTextField tfname,user,id,depmt;
    JPasswordField pass;
    JButton submit;
    
    Addfaculty(){
        
        setLayout(null);
        
         JLabel heading=new JLabel("New Faculty Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif", Font.BOLD,30));
        add(heading);
        
        
        JLabel fname=new JLabel("NAME");
        fname.setBounds(60,150,120,30);
        fname.setFont(new Font("Tahoma",Font.PLAIN, 17));
        add(fname);
        
        
        tfname=new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
         JLabel fuser=new JLabel("USERNAME");
        fuser.setBounds(60,200,200,30);
        fuser.setFont(new Font("Tahoma",Font.PLAIN, 17));
        add(fuser);
        
         user=new JTextField();
        user.setBounds(200,200,150,30);
        add(user);
        
        JLabel fpass=new JLabel("PASSWORD");
        fpass.setBounds(60,250,200,30);
        fpass.setFont(new Font("Tahoma",Font.PLAIN, 17));
        add(fpass);  
        
        pass=new JPasswordField();
        pass.setBounds(200,250,150,30);
        add(pass);
        
        JLabel fid=new JLabel("ID");
        fid.setBounds(60,300,300,30);
        fid.setFont(new Font("Tahoma",Font.PLAIN, 17));
        add(fid);
        
         id=new JTextField();
        id.setBounds(200,300,150,30);
        add(id);
        
        JLabel dept=new JLabel("DEPARTMENT");
        dept.setBounds(60,350,200,30);
        dept.setFont(new Font("Tahoma",Font.PLAIN, 17));
        add(dept);
        
         depmt=new JTextField();
        depmt.setBounds(200,350,150,30);
        add(depmt);
        
         submit= new JButton("SUBMIT");
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.setBounds(300,450,120,30);
        submit.addActionListener(this);
        add(submit);
        
        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,850,600);
        setVisible(true);    
    }
    public void actionPerformed(ActionEvent ae){
        String fname=tfname.getText();
        String fuser=user.getText();
        String fpass =pass.getText();
        String fid= id.getText();
        String dept= depmt.getText();
        
        if(fname.equals("")){
            JOptionPane.showMessageDialog(null, "Name can't be empty.");
        }
        if(fid.equals("")){
            JOptionPane.showMessageDialog(null, "ID can't be empty.");
        }
        if(dept.equals("")){
            JOptionPane.showMessageDialog(null, "Insert department details.");
            return;
        }
        try{
           Conn conn=new Conn();
           String query="insert into faculty values('"+fname+"', '"+fuser+"', '"+fpass+"', '"+fid+"', '"+dept+"')";
           
           conn.s.executeUpdate(query);
           
           JOptionPane.showMessageDialog(null,"Faculty added successfully");
           
           setVisible(false);
          
        }
        catch(Exception e){
            e.printStackTrace();
                    
                    }
        setVisible(false);
        
    }
    
    public static void main(String[] args){
        new Addfaculty();
    }
}
