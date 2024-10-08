package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login(){
        setTitle("ATM");
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(450,10,100,100);
        
        add(label);
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,45));
        text.setBounds(330,150,400,50);
        add(text);
        
        JLabel cardno = new JLabel("Enter Card no. :");
        cardno.setFont(new Font("Raleway",Font.ITALIC,45));
        cardno.setBounds(120,250,350,50);
        add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(450,265,250,35);
        cardTextField.setFont(new Font("Arial", Font.BOLD,20));
        add(cardTextField);
        
        JLabel pin = new JLabel("Enter PIN :");
        pin.setFont(new Font("Raleway",Font.ITALIC,45));
        pin.setBounds(120,350,300,50);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(350,365,250,35);
        pinTextField.setFont(new Font("Arial", Font.BOLD,20));
        add(pinTextField);
        
        login = new JButton("SIGN IN");
        login.setBounds(350,425,150,30);
        login.setBackground(Color.ORANGE);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(510,425,150,30);
        clear.setBackground(Color.RED);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGNUP");
        signup.setBounds(425,465,150,30);
        signup.setBackground(Color.GREEN);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(1000,600);
        setVisible(true);
        setLocation(400,200);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== clear){
            cardTextField.setText("");
            pinTextField.setText("");
    } else if(ae.getSource()== login){
        Conn conn = new Conn();
        String cardnumber = cardTextField.getText();
        String pinnumber = pinTextField.getText();
        String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"' ";
        try{
            ResultSet rs =conn.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }else if (ae.getSource()== signup){
        setVisible(false);
        new SignupOne().setVisible(true);
    }
    }
    public static void main(String args[]){
        new Login();
    }
}
