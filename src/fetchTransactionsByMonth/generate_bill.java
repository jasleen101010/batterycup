package fetchTransactionsByMonth;

import connection.conn;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class generate_bill extends JFrame implements ActionListener{
    JLabel l1;
    JTextArea t1;
    JButton b1;
    Choice c1,c2;
    JPanel p1;
    public generate_bill(){
        setSize(500,900);
        setLayout(new BorderLayout());

        p1 = new JPanel();

        l1 = new JLabel("Generate Bill");

        c1 = new Choice();
        c2 = new Choice();

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


        c2.add("January");
        c2.add("February");
        c2.add("March");
        c2.add("April");
        c2.add("May");
        c2.add("June");
        c2.add("July");
        c2.add("August");
        c2.add("September");
        c2.add("October");
        c2.add("November");
        c2.add("December");


        t1 = new JTextArea(50,15);
        JScrollPane jsp = new JScrollPane(t1);
        t1.setFont(new Font("Senserif",Font.ITALIC,18));

        b1 = new JButton("Generate Bill");

        p1.add(l1);
        p1.add(c1);
        p1.add(c2);
        add(p1,"North");

        add(jsp,"Center");
        add(b1,"South");

        b1.addActionListener(this);

        setLocation(350,40);
    }
    public void actionPerformed(ActionEvent ae){
        try{

            String month = c2.getSelectedItem();
            t1.setText("BatteryCup Power Limited\nE-BILL FOR THE MONTH OF "+month+" ,2022\n\n\n");

            Connection c3  = conn.getConnection();
            Statement stmt = null;
            stmt = c3.createStatement();

            String query = "select * from emp where meter_number='"+c1.getSelectedItem()+"'";
            System.out.println("Query looks like : "+query);
            ResultSet rs = stmt.executeQuery(query);
            boolean foundUser=false;

            if(rs.next()){
                t1.append("\nCustomer Name:"+rs.getString("name"));
                t1.append("\nMeter Number:  "+rs.getString("meter_number"));
                t1.append("\nAddress: "+rs.getString("address"));
                t1.append("\nState: "+rs.getString("state"));
                t1.append("\nCity: "+rs.getString("city"));
                t1.append("\nCar Number: "+rs.getString("email"));
                t1.append("\nPhone Number "+rs.getString("phone"));
                t1.append("\nMember since "+rs.getString("date"));

                t1.append("\n-------------------------------------------------------------");
                t1.append("\n");
                foundUser=true;
            }

            if(!foundUser)
            {
                t1.setText("");
                t1.setText("User not found associated with "+c1.getSelectedItem()+"\n");
            }

            query = "select * from bill where meter_number='"+c1.getSelectedItem()+"' and month="+"'"+c2.getSelectedItem()+"'";
            System.out.println("Query looks like : "+query);
            rs = stmt.executeQuery(query);
            int sum=0;
            boolean foundEntries=false;
            while(rs.next()){
                foundEntries=true;
                t1.append("\nMonth : "+rs.getString("month"));
                t1.append("\nTrnasaction Timestamp : "+rs.getString("date"));

                t1.append("\nUnits Consumed: "+rs.getString("units")+"W");
                t1.append("\nTotal Charges : Rs "+rs.getString("amount"));
                t1.append("\n---------------------------------------------------------------\n");
                sum+=Integer.parseInt(rs.getString("amount"));
            }

            if(foundEntries)
            t1.append("\nTOTAL PAYABLE : Rs "+sum);
            else
            {
                t1.append("\n\n\nNo entries found for ID "+c1.getSelectedItem()+" for "+c2.getSelectedItem());

            }







        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new generate_bill().setVisible(true);
    }
}