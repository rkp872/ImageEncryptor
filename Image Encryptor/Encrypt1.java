import java.awt.Color;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import java.awt.Cursor;

public class Encrypt1 extends JFrame
{
    JButton select,done;
    JLabel label,passLabel,cnfpassLabel,sLabel;

    JPasswordField password,cnfpassword;
    Font font;
    File file;
    String fileName="";
    Encrypt1()
    {
        
        font=new Font("Roboto", Font.BOLD, 20);
        select=new JButton();

        sLabel=new JLabel("Select an image ");
        sLabel.setBounds(20, 10, 250, 40);
        sLabel.setForeground(Color.white);
        sLabel.setFont(font);
        add(sLabel);

        select.setText("Choose");
        select.setFont(font);
        select.setBounds(250, 10, 150, 40);
        add(select);

        passLabel=new JLabel("Enter password ");
        passLabel.setBounds(20, 90, 250, 40);
        passLabel.setFont(font);
        passLabel.setForeground(Color.white);
        add(passLabel);

        password=new JPasswordField(10);
        password.setBounds(200, 100, 100, 25);
        add(password);

        cnfpassLabel=new JLabel("Confirm password ");
        cnfpassLabel.setBounds(20, 200, 250, 40);
        cnfpassLabel.setFont(font);
        cnfpassLabel.setForeground(Color.white);
        add(cnfpassLabel);

        cnfpassword=new JPasswordField(10);
        cnfpassword.setBounds(200, 200, 100, 25);
        add(cnfpassword);



        select.addActionListener(e->{
            JFileChooser fileChooser=new JFileChooser();
            fileChooser.showOpenDialog(null);
            file=fileChooser.getSelectedFile();
            fileName=file.getName();

           select.setBounds(200, 10, 250, 40);
           select.setForeground(Color.MAGENTA);
           select.setText(fileName);

        });

        done=new JButton();
        done.setText("Proceed");
        done.setBounds(190, 300, 150, 40);
        done.setFont(font);
        add(done);
        done.addActionListener(e->{
            String pass=password.getText();
            String cnfpass=cnfpassword.getText();
            if(pass.equals(cnfpass))
            {
                int key=1010;
                try {
                    FileInputStream fis=new FileInputStream(file);
                    byte [] data=new byte[fis.available()];
                    fis.read(data);
                    int i=0;
        
                    for (byte b : data) {
                        //System.out.println(b);
                        data[i]= (byte) ((byte) b ^ key);
                        i++;
                    }
                    FileOutputStream fos=new FileOutputStream(file);
                    fos.write(data);
                    FileWriter fr=new FileWriter(new File("record.txt"),true);
                    BufferedWriter out=new BufferedWriter(fr);
                    out.write(fileName+"#"+pass);
                    out.newLine();
                    out.close();
                    
                    fos.close();
                    fis.close();
                    
                    JOptionPane.showMessageDialog(null, "Done");
                    this.setVisible(false);
                    new HomePage().setVisible(true);
        
                } catch (Exception ex) {
                    ex.printStackTrace();//TODO: handle exception
                }
            }
            
            else
            {
                JOptionPane.showMessageDialog(null, "Confirm password not same with password");
            }




           // this.setVisible(false);

            //new Encrypt2().setVisible(true);



        });



        getContentPane().setBackground(Color.GRAY);
        setLayout(null);
        setBounds(460, 260, 500, 400);
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
}