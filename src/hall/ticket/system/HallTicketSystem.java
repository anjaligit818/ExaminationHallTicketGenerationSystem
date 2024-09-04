/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hall.ticket.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HallTicketSystem extends JFrame implements ActionListener{

   HallTicketSystem(){
        setSize(1366,565);
        setLocation(500,100);
        setBounds(100,100,1113,699);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/cover.jpg"));
        JLabel image=new JLabel(i1);
                image.setBounds(0,0,2700,1500);
                add(image);
        
        JLabel text=new JLabel("HALL TICKET GENERATION SYSTEM");
                text.setBounds(20,500,800,40);
                image.add(text);
                text.setForeground(Color.DARK_GRAY);
                text.setFont(new Font("serif",Font.ROMAN_BASELINE,40));
                
                
        JButton next=new JButton("NEXT");
                next.setBounds(900,500,150,35);
                next.setForeground(Color.pink);
                next.setBackground(Color.white);
                next.addActionListener(this);
                next.setFont((new Font("serif",Font.PLAIN,18)));
                add(next);
                
                setVisible(true);
                
    }
    public void actionPerformed(ActionEvent e){
        setVisible(false);
        new Dashboard();
    }
    public static void main(String[] args) {
        new HallTicketSystem();
    }
    
}
