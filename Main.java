import PingPongPackage.*;
import java.awt.Color;
import javax.swing.*;

public class Main extends JFrame
{
    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 300;

    public Main()
    {
        this.setTitle("Game Selection");
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setVisible(true);
        this.setLocationRelativeTo(null);

        this.setLayout(null);

        JPanel pingPongPanel = new JPanel();
        pingPongPanel.setBounds((FRAME_WIDTH-400)/2 - 10, 10, 400, 40);
        pingPongPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        createPingPong(pingPongPanel);

        this.add(pingPongPanel);
        this.setVisible(true);
    }

    private void createPingPong(JPanel p)
    {
        ButtonGroup b1 = new ButtonGroup();

        JLabel pingPongLabel = new JLabel("Ping Pong Game: ");
        JRadioButton rb1 = new JRadioButton("Both AI");
        JRadioButton rb2 = new JRadioButton("Right AI");
        JRadioButton rb3 = new JRadioButton("No AI");

        b1.add(rb1);
        b1.add(rb2);
        b1.add(rb3);

        JButton play = new JButton("Play");
        play.addActionListener(e -> pingPongClick(p, rb1, rb2, rb3));
        
        p.add(pingPongLabel);
        p.add(rb1);
        p.add(rb2);
        p.add(rb3);
        p.add(play);
    }

    private void pingPongClick(JPanel p, JRadioButton rb1, JRadioButton rb2, JRadioButton rb3) 
    {
        if(rb1.isSelected() == false && rb2.isSelected() == false && rb3.isSelected() == false)
        {
            JOptionPane.showMessageDialog(p, "You Must Select a Option", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            String msg = "Player 1 (Left): Use W or A to move up. Use D or S to move down. \n" + 
                         "Player 2 (Right): Use UP or LEFT arrow key to move up. Use DOWN or RIGHT arrow key to move down. \n" + 
                         "Note: If you have chosen 'Right AI', then the instructions for Player 2 don't apply. \n" + 
                         "Press the SPACEBAR to start the ball!"; 

            JOptionPane.showMessageDialog(p, msg, "Game Instructions", JOptionPane.INFORMATION_MESSAGE);
            new PingPong(rb1.isSelected(), rb2.isSelected(), rb3.isSelected());
        }
    }

    public static void main(String[] args) 
    {
        new Main();
    }    
}
