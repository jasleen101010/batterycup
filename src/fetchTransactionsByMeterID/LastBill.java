package fetchTransactionsByMeterID;

import connection.conn;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class LastBill extends JFrame implements ActionListener
{
    JLabel l1;
    JTextArea t1;
    JButton b1;
    Choice c1;
    JPanel p1;
    public LastBill(){
        setSize(500,900);
        setLayout(new BorderLayout());

        p1 = new JPanel();

        l1 = new JLabel("Fetch History");

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


        t1 = new JTextArea(50,15);
        JScrollPane jsp = new JScrollPane(t1);
        t1.setFont(new Font("Senserif",Font.ITALIC,18));

        b1 = new JButton("Fetch History");

        p1.add(l1);
        p1.add(c1);
        add(p1,"North");

        add(jsp,"Center");
        add(b1,"South");

        b1.addActionListener(this);

        setLocation(350,40);
    }
    public void actionPerformed(ActionEvent ae){
        try{

            t1.setText("");
            Connection c2 = conn.getConnection();
            Statement stmt = null;
            stmt = c2.createStatement();

            String query = "select * from emp where meter_number="+c1.getSelectedItem();

            ResultSet rs = stmt.executeQuery(query);
            boolean foundUser=false;
            if(rs.next()){
                foundUser=true;
                t1.append("\nCustomer Name: "+rs.getString("name"));
                t1.append("\nMeter Number: "+rs.getString("meter_number"));
                t1.append("\nAddress: "+rs.getString("address"));
                t1.append("\nState: "+rs.getString("state"));
                t1.append("\nCity: "+rs.getString("city"));
                t1.append("\nCar Number: "+rs.getString("email"));
                t1.append("\nPhone Number "+rs.getString("phone"));
                t1.append("\nMember Since "+rs.getString("date"));

                t1.append("\n-------------------------------------------------------------");
                t1.append("\n");
            }

            if(!foundUser)
            {
                t1.setText("");
                t1.setText("User not found associated with "+c1.getSelectedItem()+"\n");
            }


            query = "select * from bill where meter_number="+c1.getSelectedItem();
            rs = stmt.executeQuery(query);
            boolean foundEntries=false;
            int sum=0;
            while(rs.next()){
                if(!foundEntries)
                {
                    t1.append("Details of the Last Bills\n\n\n");
                    t1.append("Month"+"\t"+"Entry\n");

                }
                foundEntries=true;

                t1.append(rs.getString("month") + "\tRs " +rs.getString("amount") + " for "+rs.getString("units")+"W\n");
                sum+=Integer.parseInt(rs.getString("amount"));
            }

            if(!foundEntries)
            {
                t1.append("No incoming entries found for this BatteryCup ID");
            }
            else{
                t1.append("\n\nTotal \tRs "+sum);
            }





        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new LastBill().setVisible(true);
    }
}