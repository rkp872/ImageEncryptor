import javax.swing.*;

import java.awt.*;
import java.io.*;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Decrypt extends JFrame {
   
    static Scanner x;
    String name = "";

    JButton select, done;
    JLabel label, passLabel, sLabel;

    JPasswordField password;
    Font font;
    File file;
    String fileName = "";

    Decrypt()
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
        select.addActionListener(e->{
            JFileChooser fileChooser=new JFileChooser();
            fileChooser.showOpenDialog(null);
            file=fileChooser.getSelectedFile();
            fileName=file.getName();

           select.setBounds(200, 10, 250, 40);
           select.setForeground(Color.MAGENTA);
           select.setText(fileName);

        });



        passLabel=new JLabel("Enter password ");
        passLabel.setBounds(20, 90, 250, 40);
        passLabel.setFont(font);
        passLabel.setForeground(Color.white);
        add(passLabel);

        password=new JPasswordField(10);
        password.setBounds(200, 100, 100, 25);
        add(password);

        done=new JButton();
        done.setText("Proceed");
        done.setBounds(190, 300, 150, 40);
        done.setFont(font);
        add(done);
        done.addActionListener(el->{
        String pass=password.getText();
        String tfname="";
        String tfpass="";
       try {
        // FileReader fr=new FileReader(new File("record.txt"));
        // BufferedReader bf=new BufferedReader(fr);  
        x=new Scanner(new File("record.txt"));
        x.useDelimiter("[#\n]");
        boolean found=false;
        while(x.hasNext() && !found)
        {
            tfname=x.next();
            tfpass=x.next();
            if(tfname.trim().equals(fileName) && tfpass.trim().equals(pass))
            {
                found=true;
            }
        }
        if(found==true)
        {
            int key=1010;
            try {
                FileInputStream fis=new FileInputStream(file);
                byte [] data=new byte[fis.available()];
                fis.read(data);
                int i=0;
    
                for (byte b : data) 
                {
                    //System.out.println(b);
                    data[i]= (byte) ((byte) b ^ key);
                    i++;
                }
                JOptionPane.showInternalMessageDialog(null, "Done");
            
            }catch(Exception ex)
            {
                ex.printStackTrace();
            }
               

        getContentPane().setBackground(Color.GRAY);
        setLayout(null);
        setBounds(460, 260, 500, 400);
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Decrypt();
    }
}