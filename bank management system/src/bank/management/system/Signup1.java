
package bank.management.system;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;


public class Signup1 extends JFrame implements ActionListener {
    
    long random;
    JTextField nametext,fnametext,emailtext,addrtext,citytext,statetext,pintext;
    JDateChooser date;
    JRadioButton male,female,married,unmarried,other;
    JButton next;
    
    
    Signup1(){
        setLayout(null);
        
        setTitle("New Account Application Form - Page 1");
        
        Random ran=new Random();
         random=Math.abs((ran.nextLong()%9000)+1000L);
        
        JLabel formno=new JLabel("APPLICATION FORM NO. "+random);
        formno.setFont(new Font("Raleway",Font.BOLD,30));
        formno.setBounds(150, 10, 600, 40);
        add(formno);
        
        JLabel personal=new JLabel("Page 1: Peronal Details ");
        personal.setFont(new Font("Raleway",Font.BOLD,20));
        personal.setBounds(250, 50, 600, 40);
        add(personal);
        
        JLabel name=new JLabel("Name :");
        name.setFont(new Font("Raleway",Font.BOLD,18));
        name.setBounds(100, 100, 200, 30);
        add(name);
        
         nametext=new JTextField();
        nametext.setFont(new Font("Raleway",Font.BOLD,14));
        nametext.setBounds(300, 100, 350, 30);
        add(nametext);
        
         JLabel fname=new JLabel("Father's Name :");
        fname.setFont(new Font("Raleway",Font.BOLD,18));
        fname.setBounds(100, 140, 200, 30);
        add(fname);
        
         fnametext=new JTextField();
        fnametext.setFont(new Font("Raleway",Font.BOLD,14));
        fnametext.setBounds(300, 140, 350, 30);
        add(fnametext);
        
         JLabel dob=new JLabel("Date of Birth :");
        dob.setFont(new Font("Raleway",Font.BOLD,18));
        dob.setBounds(100, 180, 200, 30);
        add(dob);
        
         date=new JDateChooser();
        date.setBounds(300, 180, 350, 30);
        date.setForeground(Color.BLACK);
        add(date);
        
         JLabel gender=new JLabel("Gender :");
        gender.setFont(new Font("Raleway",Font.BOLD,18));
        gender.setBounds(100, 220, 200, 30);
        add(gender);
        
         male=new JRadioButton("Male");
        male.setBounds(300, 220, 100, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
         female=new JRadioButton("Female");
        female.setBounds(400, 220, 100, 30);
        female.setBackground(Color.WHITE);
        add(female);
        
         other=new JRadioButton("Other");
        other.setBounds(500, 220, 100, 30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup gengergrp=new ButtonGroup();
        gengergrp.add(male);
        gengergrp.add(female);
        gengergrp.add(other);
        
         JLabel email=new JLabel("Email Address :");
        email.setFont(new Font("Raleway",Font.BOLD,18));
        email.setBounds(100, 260, 200, 30);
        add(email);
        
         emailtext=new JTextField();
        emailtext.setFont(new Font("Raleway",Font.BOLD,14));
        emailtext.setBounds(300, 260, 350, 30);
        add(emailtext);
        
         JLabel marital=new JLabel("Marital Status :");
        marital.setFont(new Font("Raleway",Font.BOLD,18));
        marital.setBounds(100, 300, 200, 30);
        add(marital);
        
         married=new JRadioButton("Married");
        married.setBounds(300, 300, 100, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
         unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(400, 300, 100, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        ButtonGroup maritalgrp=new ButtonGroup();
        maritalgrp.add(married);
        maritalgrp.add(unmarried);
        
         JLabel address=new JLabel("Address :");
        address.setFont(new Font("Raleway",Font.BOLD,18));
        address.setBounds(100, 340, 200, 30);
        add(address);
        
         addrtext=new JTextField();
        addrtext.setFont(new Font("Raleway",Font.BOLD,14));
        addrtext.setBounds(300, 340, 350, 30);
        add(addrtext);
        
         JLabel city=new JLabel("City :");
        city.setFont(new Font("Raleway",Font.BOLD,18));
        city.setBounds(100, 380, 200, 30);
        add(city);
        
         citytext=new JTextField();
        citytext.setFont(new Font("Raleway",Font.BOLD,14));
        citytext.setBounds(300, 380, 350, 30);
        add(citytext);
        
         JLabel state=new JLabel("State :");
        state.setFont(new Font("Raleway",Font.BOLD,18));
        state.setBounds(100, 420, 200, 30);
        add(state);
        
         statetext=new JTextField();
        statetext.setFont(new Font("Raleway",Font.BOLD,14));
        statetext.setBounds(300, 420, 350, 30);
        add(statetext);
        
         JLabel pin=new JLabel("Pincode :");
        pin.setFont(new Font("Raleway",Font.BOLD,18));
        pin.setBounds(100, 460, 200, 30);
        add(pin);
        
         pintext=new JTextField();
        pintext.setFont(new Font("Raleway",Font.BOLD,14));
        pintext.setBounds(300, 460, 350, 30);
        add(pintext);
        
         next =new JButton ("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(550, 520, 80, 30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(750,650);
        setLocation(300,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String formno=""+random;
        String name=nametext.getText();
        String fname=fnametext.getText();
        String dob=((JTextField) date.getDateEditor().getUiComponent()).getText();

        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }else if(female.isSelected()){
            gender="Female";
        }else
            gender="Other";
        
        String email=emailtext.getText();
        
         String marital=null;
        if(married.isSelected()){
            marital="Married";
        }else if(unmarried.isSelected()){
            marital="Unmarried";
        }
        
        String address=addrtext.getText();
        String city=citytext.getText();
        String state=statetext.getText();
        String pin=pintext.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required");
            }
            else{
                Conn c=new Conn();
                String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new Signup2(formno).setVisible(true);
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
        
    }
    
    public static void main(String[] args){
        new Signup1();
    }
}
