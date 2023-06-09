package Package;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridWindow extends JFrame {

    public GridWindow() {
        // Set up the JFrame
        setTitle("15x15 Grid Window with Big Squares");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Create the JPanel with a GridLayout manager
        JPanel gridPanel = new JPanel(new GridLayout(18, 18));

        // Add squares to the grid
        for (int i = 0; i < 324; i++) {
            JPanel squarePanel = new JPanel();
            squarePanel.setPreferredSize(new Dimension(50, 50));
            squarePanel.setBackground(Color.WHITE);
            squarePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            
            // Add a MouseListener to each squarePanel
            squarePanel.addMouseListener(new MouseAdapter() {
                int num = 0;
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Change the color of the square that was clicked to sky blue
                    if(num == 0)
                    {
                        squarePanel.setBackground(Color.BLUE);
                        num++;
                    }
                    else if(num == 1)
                    {
                        squarePanel.setBackground(Color.YELLOW);
                        num++;
                    }
                    else if(num == 2)
                    {
                        squarePanel.setBackground(Color.BLACK);
                        num++;
                    }
                    else if(num == 3)
                    {
                        squarePanel.setBackground(Color.GREEN);
                        num = 0;
                    }
                }
            });
            
            

            gridPanel.add(squarePanel);
        }

        // Add the gridPanel to the JFrame
        add(gridPanel);

        // Pack the JFrame and make it visible
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new GridWindow();
    }
}
