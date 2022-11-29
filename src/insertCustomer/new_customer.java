package insertCustomer;

import connection.conn;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class new_customer extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;

    Choice c1;

    public new_customer(){
        super("Add Customer");
        setLocation(350,200);
        setSize(650,600);

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(9,2,10,10));

        p.setBackground(Color.WHITE);

        l1 = new JLabel("Name");
        t1 = new JTextField();
        p.add(l1);
        p.add(t1);

        l2 = new JLabel("Assigned BatteryCup-ID");
        p.add(l2);
        c1 = new Choice();
        c1.add("1001");
        c1.add("1002");
        c1.add("1003");
        c1.add("1004");
        c1.add("1005");
        c1.add("1006");
        c1.add("1007");
        c1.add("1008");
        c1.add("1009");
        c1.add("1010");
        p.add(c1);

        l3 = new JLabel("Address");
        t3 = new JTextField();
        p.add(l3);
        p.add(t3);
        l4 = new JLabel("State");
        t4 = new JTextField();
        p.add(l4);
        p.add(t4);
        l5 = new JLabel("City");
        t5 = new JTextField();
        p.add(l5);
        p.add(t5);
        l6 = new JLabel("Car Number");
        t6 = new JTextField();
        p.add(l6);
        p.add(t6);
        l7 = new JLabel("Phone Number");
        t7 = new JTextField();
        p.add(l7);
        p.add(t7);

        b1 = new JButton("Submit");

        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.BLACK);


        p.add(b1);
        setLayout(new BorderLayout());

        add(p,"Center");

        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("images/hicon1.jpg"));
        Image i3 = ic1.getImage().getScaledInstance(150, 280,Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i3);
        l8 = new JLabel(ic2);


        add(l8,"West");
        //for changing the color of the whole 
        getContentPane().setBackground(Color.WHITE);

        b1.addActionListener(this);

    }
    public void actionPerformed(ActionEvent ae){

        String a = t1.getText();
        String c = c1.getSelectedItem();
        String d = t3.getText();
        String e = t4.getText();
        String f = t5.getText();
        String g = t6.getText();
        String h = t7.getText();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String date=dtf.format(now);

        String q1 = "insert into emp values('"+a+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"','"+date+"')";
        System.out.println("Insert query looks like : "+q1);
        try{

            Connection c3  = conn.getConnection();
            Statement stmt = null;
            stmt = c3.createStatement();

            int rs = stmt.executeUpdate(q1);
            JOptionPane.showMessageDialog(null,"User Created");
            this.setVisible(false);


        }catch(Exception ex){
            ex.printStackTrace();
        }

    }


    public static void main(String[] args){
        new new_customer().setVisible(true);
    }
}