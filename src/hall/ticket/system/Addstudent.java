/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hall.ticket.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.sql.*;

public class Addstudent extends JFrame implements ActionListener{
    
    JTextField tsname,roll,user,email;
    JRadioButton rbmale,rbfemale;
    JComboBox scourse,sem,brn;
    JPasswordField pass;
    JDateChooser cdob;
    JButton submit,cancel;
    
    
    Addstudent(){
          
        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        
        JLabel heading=new JLabel("New Student Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif", Font.BOLD,30));
        add(heading);
        
        JLabel sname=new JLabel("NAME");
        sname.setBounds(50,150,100,30);
        sname.setFont(new Font("serif",Font.BOLD, 17));
        add(sname);
        
        tsname=new JTextField();
        tsname.setBounds(200,150,150,30);
        add(tsname);
        
       JLabel sroll=new JLabel("ROLL NUMBER");
        sroll.setBounds(400,150,200,30);
        sroll.setFont(new Font("serif",Font.BOLD, 17));
        add(sroll);
        
        roll=new JTextField();
        roll.setBounds(600,150,150,30);
        add(roll); 
        
        JLabel course=new JLabel("COURSE");
        course.setBounds(50,200,200,30);
       course.setFont(new Font("serif",Font.BOLD, 17));
        add(course);
        
        String courses[]={"BCA","BBA","MCA","MBA"};
        scourse=new JComboBox(courses);
        scourse.setBounds(200,200,150,30);
        scourse.setBackground(Color.WHITE);
        add(scourse);
        
         JLabel suser=new JLabel("USERNAME");
        suser.setBounds(400,200,200,30);
         suser.setFont(new Font("serif",Font.BOLD, 17));
        add(suser);
        
         user=new JTextField();
        user.setBounds(600,200,150,30);
        add(user);
        
        JLabel spass=new JLabel("PASSWORD");
        spass.setBounds(50,250,200,30);
        spass.setFont(new Font("serif",Font.BOLD, 17));
        add(spass);  
        
        pass=new JPasswordField();
        pass.setBounds(200,250,150,30);
        add(pass);
        
        JLabel dob=new JLabel("DOB");
        dob.setBounds(400,250,200,30);
        dob.setFont(new Font("serif",Font.BOLD, 17));
        add(dob);
        
        cdob=new JDateChooser();
        cdob.setBounds(600,250,150,30);
        add(cdob);
        
        JLabel gender=new JLabel("GENDER");
        gender.setBounds(50,300,200,30);
        gender.setFont(new Font("serif",Font.BOLD, 17));
        add(gender);
        
        rbmale=new JRadioButton("Male");
        rbmale.setBounds(200,300,150,30);
        rbmale.setFont(new Font("serif",Font.BOLD, 14));
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
        
        rbfemale=new JRadioButton("Female");
        rbfemale.setBounds(360,300,150,30);
        rbfemale.setFont(new Font("serif",Font.BOLD, 14));
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        ButtonGroup bg=new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        JLabel branch=new JLabel("BRANCH");
        branch.setBounds(50,350,200,30);
       branch.setFont(new Font("serif",Font.BOLD, 17));
        add(branch);
        
        String branches[]={"Computer Science","Management"};
        brn=new JComboBox(branches);
        brn.setBounds(200,350,150,30);
        brn.setBackground(Color.WHITE);
        add(brn);
        
        JLabel semester=new JLabel("SEMESTER");
        semester.setBounds(400,350,150,30);
       semester.setFont(new Font("serif",Font.BOLD, 17));
        add(semester);
        
        String semesters[]={"1","2","3","4","5","6"};
        sem=new JComboBox(semesters);
        sem.setBounds(600,350,150,30);
        sem.setBackground(Color.WHITE);
        add(sem);
        
        
        JLabel semail=new JLabel("EMAIL");
        semail.setBounds(50,400,200,30);
        semail.setFont(new Font("serif",Font.BOLD, 17));
        add(semail);
        
        email=new JTextField();
        email.setBounds(200,400,200,30);
        add(email);
        
        submit= new JButton("SUBMIT");
        submit.setBackground(Color.black);
        submit.setForeground(Color.WHITE);
        submit.setBounds(300,550,120,30);
        submit.addActionListener(this);
        add(submit);
        
       
        
         cancel= new JButton("CANCEL");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
          
    }
    public void actionPerformed(ActionEvent ae){
        
     if(ae.getSource()==submit){
        String sname=tsname.getText();
        String sroll=roll.getText();
        String course=(String)scourse.getSelectedItem();
        String suser=user.getText();
        String spass =pass.getText();
        String dob=((JTextField)cdob.getDateEditor().getUiComponent()).getText();
        String branch=(String)brn.getSelectedItem();
        String semester=(String)sem.getSelectedItem();
         String gender=null;
        
            if(rbmale.isSelected()){
            gender="Male";
            }else if(rbfemale.isSelected()){
            gender="Female";
            }
        String semail=(String)email.getText();
        
        if(sname.equals("")){
            JOptionPane.showMessageDialog(null, "Name can't be empty.");
            return;
        }
        if(sroll.equals("")){
            JOptionPane.showMessageDialog(null, "Roll no can't be empty.");
            return;
        }
        if(semail.equals("")|| !semail.contains("@")|| !semail.contains(".")){
            JOptionPane.showMessageDialog(null, "EMAIL should be in correct format.");
            return;
        }
        if(gender.equals("")){
            JOptionPane.showMessageDialog(null, "Insert gender details.");
            return;
        }
         if(dob.equals("")){
            JOptionPane.showMessageDialog(null, "Insert DOB.");
            return;
        }
         try{
         
          String query="insert into student values('"+sname+"','"+sroll+"','"+course+"','"+suser+"','"+spass+"','"+dob+"','"+gender+"','"+branch+"','"+semester+"','"+semail+"')"; 
         
             
                 
         Conn con=new Conn();
         con.s.executeUpdate(query);
             
         JOptionPane.showMessageDialog(null, "Student Details Inserted Succcessfully");
         setVisible(false);
         }
         catch(Exception e){
          e.printStackTrace();
            }
     }
        else {
            setVisible(false);
        }
        
        
        
    }
    public static void main(String[] args){
        new Addstudent();
    }
}
