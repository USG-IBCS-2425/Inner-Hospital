import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MuseumDisplay {
	private JFrame startFrame;
	private JLabel welcomeText;

	public MuseumDisplay() {
		startFrame = new JFrame("Image Example");
		startFrame.setSize(800, 850);
		welcomeText = new JLabel("All the Colors to Summer Fridays", JLabel.CENTER);
		welcomeText.setBounds(275, 50, 250, 40);

		startFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
                //way to make the program come to a stop(with this code, closing the window stops
                //program)
            }        
        });
        //creating a button
        JButton redButton = new JButton("Produce red");
        JButton greenButton = new JButton("Produce green");
        JButton beigeButton = new JButton("Produce beige");
        JButton caramelButton = new JButton("Produce caramel");
        JButton minisButton = new JButton("Produce minis");
        JButton pinkButton = new JButton("Produce pink");

        redButton.setActionCommand("red");
        //https://summerfridays.com/products/lip-butter-balm-cherry
        greenButton.setActionCommand("green");
        //https://summerfridays.com/products/lip-butter-balm-sweet-mint
        beigeButton.setActionCommand("beige");
        //https://summerfridays.com/products/lip-butter-balm
        caramelButton.setActionCommand("caramel");
        //https://summerfridays.com/products/lip-butter-balm-iced-coffee
        minisButton.setActionCommand("minis");
        //https://www.dhgate.com/product/wholesale-5g-4pcs-summer-fridays-the-mini/1015914136.html?skuId=1327043033965547520&stockCountry=CN
        pinkButton.setActionCommand("pink");
		//https://summerfridays.com/products/lip-butter-balm-pink-sugar
        redButton.addActionListener(new ButtonClickListener());
        redButton.setBounds(50,200,300,175);
        startFrame.add(redButton);
        greenButton.addActionListener(new ButtonClickListener());
        greenButton.setBounds(450,200,300,175);
        startFrame.add(greenButton);
        beigeButton.addActionListener(new ButtonClickListener());
        beigeButton.setBounds(50,400,300,175);
        startFrame.add(beigeButton);
        caramelButton.addActionListener(new ButtonClickListener());
        caramelButton.setBounds(450,400,300,175); 
        startFrame.add(caramelButton);
        minisButton.addActionListener(new ButtonClickListener());
        minisButton.setBounds(50,600,300,175);
        startFrame.add(minisButton);
        pinkButton.addActionListener(new ButtonClickListener());
  
        pinkButton.setBounds(450,600,300,175);
        startFrame.add(pinkButton);
        //(x, y, width, height)

        startFrame.add(welcomeText);
        startFrame.setLayout(null);
        startFrame.setVisible(true);

        
    
	}

	public static void main(String[] args) {
		MuseumDisplay mWin = new MuseumDisplay();
	}

	private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();  
         
            if(command.equals("red"))  {
            	JFrame f = new JFrame();
				JPanel p = new JPanel();
				ImageIcon icon = new ImageIcon("red.png");
				JLabel lab = new JLabel(icon);
				f.add(p);
				p.add(lab);
				f.pack();
				//used for frames to fit content true to size
				f.setVisible(true);
			}
			if(command.equals("green"))  {
            	JFrame f = new JFrame();
				JPanel p = new JPanel();
				ImageIcon icon = new ImageIcon("green.png");
				JLabel lab = new JLabel(icon);
				f.add(p);
				p.add(lab);
				f.pack();
				//used for frames to fit content true to size
				f.setVisible(true);
			}
			if(command.equals("beige"))  {
            	JFrame f = new JFrame();
				JPanel p = new JPanel();
				ImageIcon icon = new ImageIcon("beige.png");
				JLabel lab = new JLabel(icon);
				f.add(p);
				p.add(lab);
				f.pack();
				//used for frames to fit content true to size
				f.setVisible(true);
			}
			if(command.equals("caramel"))  {
            	JFrame f = new JFrame();
				JPanel p = new JPanel();
				ImageIcon icon = new ImageIcon("caramel.png");
				JLabel lab = new JLabel(icon);
				f.add(p);
				p.add(lab);
				f.pack();
				//used for frames to fit content true to size
				f.setVisible(true);
			}
			if(command.equals("minis"))  {
            	JFrame f = new JFrame();
				JPanel p = new JPanel();
				ImageIcon icon = new ImageIcon("minis.png");
				JLabel lab = new JLabel(icon);
				f.add(p);
				p.add(lab);
				f.pack();
				//used for frames to fit content true to size
				f.setVisible(true);
			}
			if(command.equals("pink"))  {
            	JFrame f = new JFrame();
				JPanel p = new JPanel();
				ImageIcon icon = new ImageIcon("Pink.png");
				JLabel lab = new JLabel(icon);
				f.add(p);
				p.add(lab);
				f.pack();
				//used for frames to fit content true to size
				f.setVisible(true);
			}
      }     
   }
}