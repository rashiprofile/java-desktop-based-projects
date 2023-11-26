package bank.management.system;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;


public class PinChange extends JFrame implements ActionListener{
    
    JButton change,back;
    String pinno;
    JPasswordField pintext,repintext;
    PinChange(String pinno){
        this.pinno=pinno;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")); 
        Image i2=i1.getImage().getScaledInstance(800, 650, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(0, 0, 800, 650);
        add(label);
        
        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setBounds(200, 200, 500, 40);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,18));
        label.add(text);
        
        JLabel pin=new JLabel("New PIN:");
        pin.setBounds(150, 240, 200, 20);
        pin.setForeground(Color.WHITE);
        pin.setFont(new Font("System",Font.BOLD,14));
        label.add(pin);
        
        pintext=new JPasswordField();
        pintext.setBounds(300, 240, 120, 20);
        pintext.setForeground(Color.BLACK);
        pintext.setFont(new Font("System",Font.BOLD,14));
        label.add(pintext);
        
        JLabel repin=new JLabel("Re-Enter New PIN:");
        repin.setBounds(150, 270, 200, 20);
        repin.setForeground(Color.WHITE);
        repin.setFont(new Font("System",Font.BOLD,14));
        label.add(repin);
        
        repintext=new JPasswordField();
        repintext.setBounds(300, 270, 120, 20);
        repintext.setForeground(Color.BLACK);
        repintext.setFont(new Font("System",Font.BOLD,14));
        label.add(repintext);
        
        change=new JButton("Change");
        change.setBounds(350, 340, 100, 20);
        change.addActionListener(this);
        label.add(change);
        
        back=new JButton("Back");
        back.setBounds(350, 370, 100, 20);
        back.addActionListener(this);
        label.add(back);
        
         setSize(800,650);
        setLocation(300,10);
        setVisible(true);
        
 }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==change){
            try{
                String npin=pintext.getText();
                String rpin=repintext.getText();
                
                if(!npin.equals(rpin)){
                   JOptionPane.showMessageDialog(null, "Entered PIN do not match");
                   return;
                }
                if(npin.equals("")){
                   JOptionPane.showMessageDialog(null, "Please enter new PIN");
                   return;
                }
                if(rpin.equals("")){
                   JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                   return;
                }
                
                Conn c=new Conn();
                String query1="update bank set PIN_number='"+rpin+"' where PIN_number='"+pinno+"'";
                String query2="update login set PIN_Number='"+rpin+"' where PIN_Number='"+pinno+"'";
                String query3="update signup3 set PIN_Number='"+rpin+"' where PIN_Number='"+pinno+"'";
                  c.s.executeUpdate(query1);
                  c.s.executeUpdate(query2);
                  c.s.executeUpdate(query3); 
                
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                  
                setVisible(false);
                new Transactions(npin).setVisible(true);
                  
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
        else{
            setVisible(false);
            new Transactions(pinno).setVisible(true);
        }
    }
    public static void main(String[] args){
        new PinChange("");
    }
}
