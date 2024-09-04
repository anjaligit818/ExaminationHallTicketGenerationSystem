/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hall.ticket.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;


public class Viewfaculty extends JFrame implements ActionListener {
        
    Choice cid;
    JTable table;
    JButton search,print,add,cancel;
    
    Viewfaculty(){
        
       getContentPane().setBackground(Color.WHITE);
       setLayout(null);
       
       JLabel heading=new JLabel("Search by ID");
        heading.setBounds(20,20,150,20);
        //heading.setFont(new Font("serif", Font.BOLD,12));
        add(heading); 
      
        cid=new Choice();
        cid.setBounds(180,20,150,20);
        add(cid);
        
       try{
           Conn c=new Conn();
           ResultSet rs=c.s.executeQuery("select* from faculty");
           while(rs.next()){
               cid.add(rs.getString("fid"));
           }
           
       }catch(Exception e){
          e.printStackTrace();
            }
        
      table=new JTable();
      
     
      try{
           Conn c=new Conn();
           ResultSet rs=c.s.executeQuery("select* from faculty");
           table.setModel(DbUtils.resultSetToTableModel(rs));
           
           
       }catch(Exception e){
          e.printStackTrace();
            }
      
      JScrollPane jsp=new JScrollPane(table);
      jsp.setBounds(0,100,900,600);
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
     
      setSize(900,700);
       setLocation(300,100);
       setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
      if(ae.getSource()==search){
          String query="select* from faculty where fid='"+cid.getSelectedItem()+"'";
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
         new Addfaculty();
      }
      else{
        
       setVisible(false);  
      }
    }
     public static void main(String[] args){
       new Viewfaculty();
   }
}
