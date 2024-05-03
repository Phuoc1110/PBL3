package View;
import javax.swing.*;
import java.awt.event.*;

public class TextFieldEventExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Text Field Event Example");
        JTextField textField = new JTextField(20);

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                System.out.println("Entered text: " + text);
                // Xử lý dữ liệu ở đây theo nhu cầu của bạn
            }
        });

        frame.getContentPane().add(textField);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}