import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup {

    public Signup(){
        Analyzer analyser = new Analyzer();
        JTextField comp = new JTextField();
        comp.addKeyListener(analyser);

        JLabel info = new JLabel("Type the given text", JLabel.CENTER);
        JLabel phrase = new JLabel("Hello World", JLabel.CENTER);
        JLabel user = new JLabel("Enter username", JLabel.CENTER);
        JLabel register = new JLabel("SignUp", JLabel.CENTER);
        JTextField username = new JTextField();

        JButton submit = new JButton("SignUp");

        Box box = Box.createVerticalBox();
        JPanel panel = new JPanel();
        panel.add(box);

        JFrame frame = new JFrame("SignUp");

        frame.add(panel);
        box.add(register);
        box.add(user);
        box.add(username);
        box.add(info);
        box.add(phrase);
        box.add(comp);
        box.add(submit);
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(username.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(submit,"Enter a valid username");
                }
                else if(phrase.getText().equals(comp.getText())){
                    SaveProf.saveProfile(analyser.saveProfile());
                    JOptionPane.showMessageDialog(submit,"User has been successfully signed up");
                    frame.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(submit,"Enter the verification phrase correctly");
                }
            }
        });
    }

}
