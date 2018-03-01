import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signin {

    public Signin(){
        Analyzer analyser = new Analyzer();
        JTextField comp = new JTextField();
        comp.addKeyListener(analyser);

        JLabel info = new JLabel("Enter the following verification phrase",JLabel.CENTER);
        JLabel phrase = new JLabel("Hello World",JLabel.CENTER);
        JLabel login = new JLabel("SignIn",JLabel.CENTER);
        JLabel user = new JLabel("Enter the username",JLabel.CENTER);

        JButton submit = new JButton("SignIn");

        Box box = Box.createVerticalBox();
        JPanel panel = new JPanel();
        panel.add(box);

        JFrame frame = new JFrame("SignIn");

        frame.add(panel);
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
                if(phrase.getText().equals(comp.getText())){
                    String master = SaveProf.getProfile();
                    String slave = analyser.saveProfile();
                    Examiner ex = new Examiner();
                    if(ex.match(master,slave)){
                        JOptionPane.showMessageDialog(submit,"You are signed in");
                        frame.dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(submit,"SignIn failed");
                        frame.dispose();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(submit,"Error");
                }
            }
        });
    }
}
