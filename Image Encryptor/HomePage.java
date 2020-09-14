import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Cursor;

public class HomePage extends JFrame
{
    JLabel label;
    JButton encrypt;
    JButton decrypt;
    HomePage()
    {
        Font font=new Font("Roboto", Font.BOLD, 25);

        label =new JLabel("WELCOME TO FILE ENCRYPTOR");
        label.setForeground(Color.PINK);
        label.setBounds(50, 10, 450, 30);
        label.setFont(font);
        add(label);

        encrypt =new JButton();
        encrypt.setBackground(Color.LIGHT_GRAY);
        encrypt.setForeground(Color.BLACK);
        encrypt.setBounds(110, 100, 250, 50);
        encrypt.setText("ENCRYPT");
        encrypt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        encrypt.setFont(font);
        add(encrypt);
        encrypt.addActionListener(e->{
            this.setVisible(false);
            new Encrypt1().setVisible(true);
        });

        decrypt = new JButton();
        decrypt.setBackground(Color.LIGHT_GRAY);
        decrypt.setForeground(Color.BLACK);
        decrypt.setBounds(110, 200, 250, 50);
        decrypt.setText("DECRYPT");       
        decrypt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        decrypt.setFont(font);
        add(decrypt);
        decrypt.addActionListener(ae->{
            this.setVisible(false);
            new Decrypt().setVisible(true);
        });
       


        getContentPane().setBackground(Color.GRAY);
        setLayout(null);
        setBounds(460, 260, 500, 400);
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }
    public static void main(String[] args) {
        new HomePage();
    }
    
}