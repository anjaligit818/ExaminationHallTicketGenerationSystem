/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hall.ticket.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Gentick extends JFrame implements ActionListener{
    String sroll,course,semester;
    JButton generate,print;
    JTextArea area;
    JTable table;
    JPanel panel;
  Gentick(String sroll,String course,String semester){
      this.sroll=sroll;
      this.course=course;
      this.semester=semester;
      
      setSize(1100,750);
      setLocation(350,50);
      
      setLayout(new BorderLayout());
       panel=new JPanel();
      JLabel heading=new JLabel("Generate Hall Ticket");
      JLabel rollno=new JLabel(sroll);
      area=new JTextArea(50,15);
      JScrollPane pane=new JScrollPane(area);
      generate=new JButton("Generate Hall Ticket");
      generate.addActionListener(this);
      print=new JButton("Print");
       print.addActionListener(this);
      panel.add(heading);
      
      panel.add(print);
      add(panel,"North");
      
      add(pane,"Center");
      add(generate,"South");
      
      setVisible(true);
  }  
 public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==print){
        try{
            area.print();
          }
          catch(Exception e){
              e.printStackTrace();
              
          }
     }
     
    if(ae.getSource()==generate){
     try{
         
         
          Conn c=new Conn();
          ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/akt.jpg"));
          JLabel image=new JLabel(i1);
          image.setBounds(0,0,1051,130);
          area.add(image);
          ResultSet rs=c.s.executeQuery("Select * from student where sroll='"+sroll+"'");
         
         if(rs.next()){
             area.append("\n\n\n\n\n\n\n ");
             area.append("\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- ");
             area.append("\n Roll no           :"+rs.getString("sroll"));
             area.append("\n Student Name :"+rs.getString("sname"));
             area.append("\n Gender          :"+rs.getString("gender"));
             area.append("\n DOB             :"+rs.getString("dob"));
             area.append("\n Branch          :"+rs.getString("branch"));
             area.append("\n Course          :"+rs.getString("course"));
             area.append("\n Semester       :"+rs.getString("semester"));
             area.append("\n Email            :"+rs.getString("semail"));
         }
            
            table= new JTable();
            try{
            rs =c.s.executeQuery("select * from subl where icourse='"+course+"' and isemester='"+semester+"'"); 
         
            }
            catch(Exception e){
            e.printStackTrace();
             }
             area.setFont(new Font("Senserif",Font.ITALIC,18));
             area.append("\n--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
             area.append("\n ");
             area.append("\n Important Note(Read Carefully)");
             area.setFont(new Font("Senserif",Font.BOLD,14));
             area.append("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
             area.append("\n 1:Reporting time at exam centre atleast an hour before the commencement of exam.No entry is allowed after the start of the exam.");
             area.append("\n 2:The student should bring the admit card along with a institute photo ID/other valid ID for appearing in the examination falling which he/she shall not be allowed \n    to appear in the examination.");
             area.append("\n 3:You are advised to follow COVID-19 safety and social distancing guidelines as issued by government from time to time.");
             area.append("\n *Please verify exam date with latest datesheet available on Circular/College website.");
             area.append("\n 4:Kindly keep checking Circulars at aktu.ac.in daily for updates in exam schedule.");
             area.setFont(new Font("Tahoma",Font.PLAIN, 14));
             area.append("\n\t\t\t\t\t\t\t Controller of Examination: AKTU University");
             area.append("\n\t\t\t\t\t\t\t(Digitally signed document ,hence does not need signature)");
         
      
       
     }catch(Exception e){
         e.printStackTrace();
     }
    
    }  
 }   

 public static void main(String[] args){
     new Gentick("","","");
 }   
}
