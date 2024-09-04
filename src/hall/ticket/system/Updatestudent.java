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

public class Updatestudent extends JFrame implements ActionListener{
    
    JTextField lcourse,lbranch,lgender,luser,lpass,lsem,lemail,lasubject1,lasubject2;
    JLabel labelrollno;
    JRadioButton rbmale,rbfemale;
    JDateChooser cdob;
    Choice croll;
    JButton update,cancel;
    
    Updatestudent(){
          
        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        
        JLabel heading=new JLabel("Update Student Details");
        heading.setBounds(310,10,500,50);
        heading.setFont(new Font("serif", Font.BOLD,35));
        add(heading);
        
        JLabel lblrollno=new JLabel("Select Roll Number");
        lblrollno.setBounds(50,100,200,20);
        lblrollno.setFont(new Font("serif",Font.PLAIN, 20));
        add(lblrollno);
        
        croll=new Choice();
        croll.setBounds(250,100,200,20);
        add(croll); 
        
        
        try{
             Conn c=new Conn();
             ResultSet rs=c.s.executeQuery("select*from student");
             while(rs.next()){
                 croll.add(rs.getString("sroll"));
             }
             
             
          }
          catch(Exception e){
              e.printStackTrace();
              
          }
        
        
        JLabel lblname=new JLabel("NAME");
        lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("serif",Font.BOLD, 17));
        add(lblname);
        
        JLabel labelname=new JLabel();
        labelname.setBounds(200,150,150,30);
        labelname.setFont(new Font("serif",Font.BOLD, 17));
        add(labelname);
        
       JLabel lblroll=new JLabel("ROLL NUMBER");
        lblroll.setBounds(400,150,200,30);
        lblroll.setFont(new Font("serif",Font.BOLD, 17));
        add(lblroll);
        
        labelrollno=new JLabel();
        labelrollno.setBounds(600,150,150,30);
        labelrollno.setFont(new Font("serif",Font.BOLD, 17));
        add(labelrollno); 
        
        JLabel lblcourse=new JLabel("COURSE");
        lblcourse.setBounds(50,200,200,30);
       lblcourse.setFont(new Font("serif",Font.BOLD, 17));
        add(lblcourse);
        
        
        lcourse=new JTextField();
        lcourse.setBounds(200,200,150,30);
        add(lcourse);
        
         JLabel lbluser=new JLabel("USERNAME");
        lbluser.setBounds(400,200,200,30);
         lbluser.setFont(new Font("serif",Font.BOLD, 17));
        add(lbluser);
        
        luser=new JTextField();
        luser.setBounds(600,200,150,30);
        add(luser);
        
        JLabel lblpass=new JLabel("PASSWORD");
        lblpass.setBounds(50,250,200,30);
        lblpass.setFont(new Font("serif",Font.BOLD, 17));
        add(lblpass);  
        
        lpass=new JTextField();
        lpass.setBounds(200,250,150,30);
        add(lpass);
        
        JLabel lbldob=new JLabel("DOB");
        lbldob.setBounds(400,250,200,30);
        lbldob.setFont(new Font("serif",Font.BOLD, 17));
        add(lbldob);
        
       JLabel labeldob=new JLabel();
        labeldob.setBounds(600,250,150,30);
        labeldob.setFont(new Font("serif",Font.BOLD, 17));
        add(labeldob);
        
        JLabel lblgender=new JLabel("GENDER");
        lblgender.setBounds(50,300,200,30);
        lblgender.setFont(new Font("serif",Font.BOLD, 17));
        add(lblgender);
        
        JLabel lgender=new JLabel();
        lgender.setBounds(200,300,150,30);
        lgender.setFont(new Font("serif",Font.BOLD, 17));
        add(lgender);
        
        JLabel lblbranch=new JLabel("BRANCH");
        lblbranch.setBounds(50,350,200,30);
       lblbranch.setFont(new Font("serif",Font.BOLD, 17));
        add(lblbranch);
        
        lbranch=new JTextField();
        lbranch.setBounds(200,350,150,30);
        add(lbranch);
        
        JLabel lblsemester=new JLabel("SEMESTER");
        lblsemester.setBounds(400,350,150,30);
       lblsemester.setFont(new Font("serif",Font.BOLD, 17));
        add(lblsemester);
        
        lsem=new JTextField();
        lsem.setBounds(600,350,150,30);
        lsem.setBackground(Color.WHITE);
        add(lsem);
        
        
        JLabel lblemail=new JLabel("EMAIL");
        lblemail.setBounds(50,400,150,30);
        lblemail.setFont(new Font("serif",Font.BOLD, 17));
        add(lblemail);
        
        lemail=new JTextField();
        lemail.setBounds(200,400,150,30);
        add(lemail);
        
    
        
        try{
            Conn c=new Conn();
            String query="select * from student where sroll='"+croll.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("sname"));
                labelrollno.setText(rs.getString("sroll"));
                labeldob.setText(rs.getString("dob"));
                lgender.setText(rs.getString("gender"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        croll.addItemListener(new ItemListener(){
         public void itemStateChanged(ItemEvent ie){
              try{
            Conn c=new Conn();
            String query="select * from student where sroll='"+croll.getSelectedItem()+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("sname"));
                labelrollno.setText(rs.getString("sroll"));
                lcourse.setText(rs.getString("course"));
                luser.setText(rs.getString("suser"));
                lpass.setText(rs.getString("spass"));
                labeldob.setText(rs.getString("dob"));
                lgender.setText(rs.getString("gender"));
                lbranch.setText(rs.getString("branch"));
                lsem.setText(rs.getString("semester"));
                lemail.setText(rs.getString("semail"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
             
         }
        });
        
        update= new JButton("UPDATE");
        update.setBackground(Color.black);
        update.setForeground(Color.WHITE);
        update.setBounds(300,550,120,30);
        update.addActionListener(this);
        add(update);
        
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
        
     if(ae.getSource()==update){
        
        String sroll=labelrollno.getText();
        String course=lcourse.getText();
        String suser=luser.getText();
        String spass =lpass.getText();
        String branch=lbranch.getText();
        String semester=lsem.getText();
        String semail=lemail.getText();
        
       
         try{
         
         String query="update student set course='"+course+"',suser='"+suser+"',spass='"+spass+"',branch='"+branch+"',semester='"+semester+"',semail='"+semail+"'where sroll='"+sroll+"'"; 
         Conn con=new Conn();
         con.s.executeUpdate(query);
         
         JOptionPane.showMessageDialog(null, "Student Details Updated Succcessfully");
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
        new Updatestudent();
    }
}
