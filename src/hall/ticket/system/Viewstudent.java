
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

public class Viewstudent extends JFrame implements ActionListener {
   
    Choice troll;
    JTable table;
    JButton search,print,add,cancel;
    
    Viewstudent(){
     
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
        
      
       
       JLabel heading=new JLabel("Search by Roll Number");
        heading.setBounds(20,20,150,20);
        //heading.setFont(new Font("serif", Font.BOLD,12));
        add(heading); 
      
        
        troll=new Choice();
        troll.setBounds(180,20,150,20);
        add(troll);
        
       try{
           Conn c=new Conn();
           ResultSet rs=c.s.executeQuery("select* from student");
           while(rs.next()){
               troll.add(rs.getString("sroll"));
           }
           
       }catch(Exception e){
          e.printStackTrace();
            }
        
      table=new JTable();
      
     
      try{
           Conn c=new Conn();
           ResultSet rs=c.s.executeQuery("select* from student");
           table.setModel(DbUtils.resultSetToTableModel(rs));
           
           
       }catch(Exception e){
          e.printStackTrace();
            }
      
      JScrollPane jsp=new JScrollPane(table);
      jsp.setBounds(0,100,1300,600);
      add(jsp);
       
      search=new JButton("Search");
      search.setBounds(20,70,80,20);
      search.addActionListener(this);
      add(search);
      
      print=new JButton("Print");
      print.setBounds(120,70,80,20);
      print.addActionListener(this);
      add(print);
      
      add=new JButton("Add");
      add.setBounds(220,70,80,20);
      add.addActionListener(this);
      add(add);
      
      cancel=new JButton("Cancel");
      cancel.setBounds(320,70,80,20);
      cancel.addActionListener(this);
      add(cancel);
     
      setSize(1300,700);
       setLocation(90,80);
       setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
      if(ae.getSource()==search){
          String query="select* from student where sroll='"+troll.getSelectedItem()+"'";
          try{
             Conn c=new Conn();
             ResultSet rs=c.s.executeQuery(query);
             table.setModel(DbUtils.resultSetToTableModel(rs));
             
          }
          catch(Exception e){
              e.printStackTrace();
              
          }
          
          
          
      }else if(ae.getSource()==print){
          try{
             table.print();
          }
          catch(Exception e){
              e.printStackTrace();
              
          }
      }
      else if(ae.getSource()==add){
         setVisible(false);
         new Addstudent();
      }
      else{
        
       setVisible(false);  
      }
        
        
        
    }
   public static void main(String[] args){
       new Viewstudent();
   }  
}
