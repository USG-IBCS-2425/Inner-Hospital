import java.awt.*;
import java.awt.image.*;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class ImageEditing {
    private JFrame startFrame;
    private JLabel welcomeText;
    public ImageIcon icon;
    public JLabel pixelCol;
    public BufferedImage im;
    public JButton daisyButton;
    public JButton contrastButton;
    public JButton highlightButton;
    public JButton resetButton;
    public JButton detectButton;
    public JButton blurButton;
    public JButton saturateButton;
    public JButton getPixel;
    public JTextField xCoord;
    public JTextField yCoord;
    public JButton change;
    public JFrame f;
    public JPanel p;
    public JLabel lab;
    public ArrayList<Integer> orginal;

    public ImageEditing() {
        orginal = new ArrayList<Integer>();
        

        startFrame = new JFrame("Image Example");
        startFrame.setSize(400, 700);
        welcomeText = new JLabel("Welcome to the Image Example", JLabel.CENTER);
        welcomeText.setBounds(100, 50, 200, 40);


        startFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }        
        });

        startFrame.add(welcomeText);
        startFrame.setLayout(null);
       
        daisyButton = new JButton("Rue!");
        daisyButton.setActionCommand("DAISY");
        daisyButton.addActionListener(new ButtonClickListener());
        daisyButton.setBounds(50, 150, 100,50);
        startFrame.add(daisyButton);

        
        //Contrast:
        contrastButton = new JButton("Contrast it!");
        contrastButton.setActionCommand("Contrast");
        contrastButton.addActionListener(new ButtonClickListener());
        contrastButton.setBounds(50, 350, 125, 75);
        startFrame.add(contrastButton);
        //endFrame.remove(contrastButton);

        //Highlight:
        highlightButton = new JButton("Highlight Green!");
        highlightButton.setActionCommand("Highlight");
        highlightButton.addActionListener(new ButtonClickListener());
        highlightButton.setBounds(50, 450, 125, 75);
        startFrame.add(highlightButton);

        //Reset:
        resetButton = new JButton("Reset it!");
        resetButton.setActionCommand("Reset");
        resetButton.addActionListener(new ButtonClickListener());
        resetButton.setBounds(50, 550, 125, 75);
        startFrame.add(resetButton);

        //Edge Detection:
        detectButton = new JButton("Zoom in!");
        detectButton.setActionCommand("Zoom");
        detectButton.addActionListener(new ButtonClickListener());
        detectButton.setBounds(225, 350, 125, 75);
        startFrame.add(detectButton);

        //Blur:
        blurButton = new JButton("Rotate it!");
        blurButton.setActionCommand("Rotate");
        blurButton.addActionListener(new ButtonClickListener());
        blurButton.setBounds(225, 450, 125, 75);
        startFrame.add(blurButton);

        //Saturate:
        saturateButton = new JButton("Saturate image!");
        saturateButton.setActionCommand("Saturate");
        saturateButton.addActionListener(new ButtonClickListener());
        saturateButton.setBounds(225, 550, 125, 75);
        startFrame.add(saturateButton);

        

        getPixel = new JButton("Get Pixel");
        getPixel.setActionCommand("PIX");
        getPixel.addActionListener(new ButtonClickListener());
        getPixel.setBounds(200, 150, 100, 40);
        //startFrame.add(getPixel);

        pixelCol = new JLabel("");
        pixelCol.setBounds(100, 20, 250, 40);
        xCoord = new JTextField("x");
        yCoord = new JTextField("y");
        xCoord.setBounds(220,270,40,30);
        yCoord.setBounds(260,270,40,30);
        startFrame.add(pixelCol);
        startFrame.add(xCoord);
        startFrame.add(yCoord);

        change = new JButton("go RED");
        change.setActionCommand("CHANGE");
        change.addActionListener(new ButtonClickListener());
        change.setBounds(100, 270, 100, 50);
        startFrame.add(change);

        icon = new ImageIcon("grandma.png");
        try {
            im = ImageIO.read(new File("grandma.png"));
        }
        catch(IOException e) {
            System.out.println("Error reading image: " + e.getMessage());
        }


        f = new JFrame();
        p = new JPanel();
        lab = new JLabel(icon);

        startFrame.setVisible(true);

        int width = im.getWidth();
        int height = im.getHeight();
            for (int i = 0; i < width; i++){
                for (int j = 0; j < height; j++){
                    int rgb = im.getRGB(i,j);
                    orginal.add(rgb);
                }
            } 
        
    }

    public static void main(String[] args) {
        ImageEditing mWin = new ImageEditing();
    }

    private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();  
            int h = 0;
            
         
            if(command.equals("DAISY"))  {
                f.add(p);
                p.add(lab);
                f.pack();
                startFrame.add(getPixel);
                f.setVisible(true);
                
            }    
            if (command.equals("PIX")) {
                // get coordinate
                int x = Integer.parseInt(xCoord.getText());
                int y = Integer.parseInt(yCoord.getText());

                int rgb = im.getRGB(x,y);
                int r = (rgb & 0x00ff0000) >> 16;
                int g = (rgb & 0x0000ff00) >> 8;
                int b = rgb & 0x000000ff;
                String myColor = "[" + r + ", " + g +", " + b + "]";
                pixelCol.setText("Color: " + myColor);
            }
            if (command.equals("CHANGE")) {
                int width = im.getWidth();
                int height = im.getHeight();
                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {

                        int rgb = im.getRGB(i,j);
                        int r = (rgb & 0x00ff0000) >> 16;
                        int g = (rgb & 0x0000ff00) >> 8;
                        int b = rgb & 0x000000ff;
                        r = 255;
                        g = 0;
                        b = 0;
                        int col = (0xFF << 24) | (r << 16) | (g << 8) | b;
                        im.setRGB(i, j, col);
                        //sets the color the sets above for every pixel
                        //(pixel x cordinate, pixel y cordinate, and then the color of it)
                    }
                }
                
                icon = new ImageIcon(im);
                //sets the picture as this new image 
                lab.setIcon(icon);
                lab.repaint();
            }
            
            //USE THIS FOR RESETING
            
            if (command.equals("Reset")) {
                int width = im.getWidth();
                int height = im.getHeight();
                ArrayList<Integer> o = (ArrayList)orginal.clone();
                for (int i = 0; i < width; i++){
                    for (int j = 0; j < height; j++){
                        int g = o.remove(0);
                        im.setRGB(i, j, g);


                    }
                }
                icon = new ImageIcon(im);
                //sets the picture as this new image 
                lab.setIcon(icon);
                lab.repaint();
            }
            

            if (command.equals("Contrast")) {
                int width = im.getWidth();
                int height = im.getHeight();
                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                        
                        int rgb = im.getRGB(i,j);
                        int r = (rgb & 0x00ff0000) >> 16;
                        int g = (rgb & 0x0000ff00) >> 8;
                        int b = rgb & 0x000000ff;

                        int total = r + g + b;

                        if ((total/3) < ((765/3)/2)){
                            r = r - 10;
                            g = g - 10;
                            b = b - 10;

                            if (r < 0){
                                r = 0;
                            }
                            if (g < 0){
                                g = 0;
                            }
                            if (b < 0){
                                b = 0;
                            }
                        }
                        else{
                            r = r + 10;
                            g = g + 10;
                            b = b + 10;
                            if (r > 255){
                                r = 255;
                            }
                            if (g > 255){
                                g = 255;
                            }
                            if (b > 255){
                                b = 255;
                            }
                        }

                        int col = (0xFF << 24) | (r << 16) | (g << 8) | b;
                        //cols.add(col);
                        im.setRGB(i, j, col);
    
                    }
                }
                icon = new ImageIcon(im);
                //sets the picture as this new image 
                lab.setIcon(icon);
                lab.repaint();
            }

            
            if (command.equals("Zoom")) {
                int width = im.getWidth();
                int height = im.getHeight();
                int wi = width/4;
                int w = width/2;
                int y = height/4;
                int yi = height/2;
                if((wi*2) == w){
                    wi = wi;
                }
                else if((wi*2) > w){
                    wi = wi - 1;
                }
                else if ((wi*2) < w){
                    wi = wi + 1;
                }
                if((y*2) == yi){
                    y = y;
                }
                else if((y*2) > yi){
                    y = y - 1;
                }
                else if ((y*2) < yi){
                    y = y + 1;
                }

                ArrayList<Integer> back1 = new ArrayList<Integer>();
                for (int i = wi; i < (wi+w); i++) {
                    for (int j = y; j < (y+yi); j++) {
                        int rgb = im.getRGB(i,j);
                        back1.add(rgb);

    
                    }
                }
                for (int i = 0; i < width - 1; i = i + 2) {
                    for (int j = 0; j < height - 1; j = j + 2) {
                        int col = back1.remove(0);
                        im.setRGB(i, j, col);
                        im.setRGB(i,j+1, col); 
                        im.setRGB(i+1,j, col); 
                        im.setRGB(i+1,j+1, col);
                    }
                }
                icon = new ImageIcon(im);
                //sets the picture as this new image 
                lab.setIcon(icon);
                lab.repaint();
            }

            

            if (command.equals("Highlight")) {
                int width = im.getWidth();
                int height = im.getHeight();
                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                        int rgb = im.getRGB(i,j); 
                        int r = (rgb & 0x00ff0000) >> 16;
                        int g = (rgb & 0x0000ff00) >> 8;
                        int b = rgb & 0x000000ff;

                        if (g > b && g > r){
                            r = r;
                            b = b;
                            g = g;
                        }
                        else{
                            int total = (r + b + g )/3;
                            r = total;
                            g = total;
                            b = total;
                        }

                        int col = (0xFF << 24) | (r << 16) | (g << 8) | b;
                        im.setRGB(i, j, col);
    
                    }
                }
                icon = new ImageIcon(im);
                //sets the picture as this new image 
                lab.setIcon(icon);
                lab.repaint();
            }
            if (command.equals("Rotate")) {
                int width = im.getWidth();
                int height = im.getHeight();
                ArrayList<Integer> back = new ArrayList<Integer>();
                for (int i = width - 1; i >= 0; i--){
                    for (int j = height - 1; j >= 0; j--){
                        int rgb = im.getRGB(i,j);
                        back.add(rgb);
                        
                    }
                }
                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                        int m = back.remove(0);
                        im.setRGB(i, j, m);
                    }
                }
                            

                icon = new ImageIcon(im);
                //sets the picture as this new image 
                lab.setIcon(icon);
                lab.repaint();
            }
            

            if (command.equals("Saturate")) {
                int width = im.getWidth();
                int height = im.getHeight();
                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                        int rgb = im.getRGB(i,j); 
                        int r = (rgb & 0x00ff0000) >> 16;
                        int g = (rgb & 0x0000ff00) >> 8;
                        int b = rgb & 0x000000ff;
                        
                        if (r > 255){
                            r = 255;
                        }
                        else if (r == 255){
                            r = 255;
                        }
                        else if (r < 0){
                            r = 0;
                        }
                        else if (r > (255/2)){
                            r = r + 2;
                        }
                        else if (r > (255/4)){
                            r = r + 1;
                        }
                        else if (r > 0){
                            r = r + 1;
                        }

                        else {
                            r = r;
                        }
                        if (g > 255){
                            g = 255;
                        }
                        else if (g == 255){
                            g = 255;
                        }
                        else if (g < 0){
                            g = 0;
                        }
                        else if (g > (255/2)){
                            g = g + 2;
                        }
                        else if (g > (255/4)){
                            g = g + 2;
                        }
                        else if (g >0){
                            g = g + 1;
                        }
                        else {
                            g = g;
                        }
                        if (b >= 255){
                            b = 255;
                        }
                        else if (b == 255){
                            b = 255;
                        }
                        else if (b < 0){
                            b = 0;
                        }
                        else if (b > (255/2)){
                            b = b + 2;
                        }
                        else if (b> (255/4)){
                            b = b + 1;
                        }
                        else if (b > 0){
                            b = b + 1;
                        }
                        else {
                            b = b;
                        }



                        int col = (0xFF << 24) | (r << 16) | (g << 8) | b;
                        im.setRGB(i, j, col);
                        //sets the color the sets above for every pixel
                        //(pixel x cordinate, pixel y cordinate, and then the color of it)
                    }
                }
                
                icon = new ImageIcon(im);
                //sets the picture as this new image 
                lab.setIcon(icon);
                lab.repaint();
            }
        }     
    }
}