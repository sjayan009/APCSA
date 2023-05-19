package Package;


import javax.swing.*;
import java.awt.*;

public class GridWindow2 extends JFrame
{
    public JPanel gridPanel;

    public GridWindow2() {
        // Set up the JFrame
        setTitle("18x18 Grid Window with Big Squares");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    
        // Create the JPanel with a GridLayout manager
        gridPanel = new JPanel(new GridLayout(18, 18));
    
        // Add squares to the grid
        for (int i = 0; i < 18 * 18; i++) {
            JPanel squarePanel = new JPanel();
            squarePanel.setPreferredSize(new Dimension(50, 50));
            squarePanel.setBackground(Color.WHITE);
            squarePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            gridPanel.add(squarePanel);
        }
    
        // Add the gridPanel to the JFrame
        add(gridPanel);
    
        // Pack the JFrame and make it visible
        pack();
        setVisible(true);
    }
    
    public void makeElements()
    {

        setDiagonalToptoBottom(0, 13, 0);
        setDiagonalToptoBottom(18, 12, 0);
        setDiagonalToptoBottom(36, 11, 0);
        setRectangle(245, 7, 5, 0);

        initializeGrass();
        makeTrees();
    }
    public static void main(String[] args) 
    {
        GridWindow2 g = new GridWindow2();
        g.makeElements();

    }

    public void initializeGrass()
    {
        for(int i = 0; i < 324; i++)
        {
            JPanel squarePanel = (JPanel) gridPanel.getComponent(i);
            if(squarePanel.getBackground().equals(Color.BLUE) == false) {
                Nature n = new Nature(4);
                squarePanel.add(n);
                squarePanel.setBackground(n.getColor()); 
                n.setVisible(false);
            }
        }
    }
    public void setDiagonalToptoBottom(int index, int numDiagonals, int id)
    {
        for(int i = 1; i <= numDiagonals; i++)
        {
            if(index < 324)
            {
                JPanel squarePanel = (JPanel) gridPanel.getComponent(index);
                Nature n = new Nature(id);
                squarePanel.add(n);
                squarePanel.setBackground(n.getColor()); 
                n.setVisible(false);

                index += 19;
            }
        }
    }
    public void setRectangle(int index, int length, int height, int id)
    {
        int i = 0;
        int outerLoop = 0;
        while(outerLoop < height)
        {
            while(i < length)
            {

                JPanel squarePanel = (JPanel) gridPanel.getComponent(index+i);
                Nature n = new Nature(id);
                squarePanel.add(n);
                squarePanel.setBackground(n.getColor()); 
                n.setVisible(false);

                i++;
            }
            i = 0;
            index += 18;
            outerLoop++;
        }

    }
    public JLabel resizeImage(String path, int desiredWidth, int desiredHeight)
    {
	    ImageIcon originalIcon = new ImageIcon(path);
	    Image originalImage = originalIcon.getImage();

	    Image resizedImage = originalImage.getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);

	    // Create a new ImageIcon from the resized image
	    ImageIcon resizedIcon = new ImageIcon(resizedImage);

	    // Create a JLabel to hold the resized image
	    JLabel imageLabel = new JLabel(resizedIcon);

	    return imageLabel;
    }
    public void makeTrees()
    {
        for (int i = 0; i < 324; i++) 
        {
            JPanel squarePanel = (JPanel) gridPanel.getComponent(i);
            
            //Get the components in the panel
            Component[] componentList = squarePanel.getComponents();

            //Loop through the components
            for(Component c : componentList){

            //Find the components you want to remove
            if(c instanceof Nature)
            {
                if( ((Nature) c).getID() == 4)
                {
                    Color color = new Color(136, 213, 107);
                    if(squarePanel.getBackground().equals(color))
                    {
                        if( ((int) (Math.random() * 11 + 1)) == 5)
                        {
                            //Remove it
                            squarePanel.remove(c);

                            String path = "C:\\Users\\Jayan Sirikonda\\Downloads\\tree.png";

                            //Add the JLabel
                            JLabel imageLabel = resizeImage(path, 50, 30);

                            //Add the Tree Component
                            Nature n = new Nature(1);
                            n.add(imageLabel);
                            
                            squarePanel.add(n);
                            squarePanel.setBackground(n.getColor()); 
                            n.setVisible(true);
                        } 
                    }
                } 
            }
            //IMPORTANT
            squarePanel.revalidate();
            squarePanel.repaint();
        }


    }
}

    public void deployRabbit()
    {

    }

    public void printComponents()
    {
        for(int i = 0; i < 324; i++)
        {
            JPanel squarePanel = (JPanel) gridPanel.getComponent(i);
            int componentCount = squarePanel.getComponentCount();
            System.out.println(componentCount + " i: " + i);
        }
    }

}
