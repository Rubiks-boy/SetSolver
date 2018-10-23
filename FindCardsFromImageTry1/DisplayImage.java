package FindCardsFromImageTry1;

import marvin.gui.MarvinImagePanel;
import marvin.image.MarvinImage;

import javax.swing.*;
import java.awt.*;

public class DisplayImage extends JFrame
{
    private MarvinImagePanel imagePanel;
    private MarvinImage image;

    public DisplayImage(MarvinImage marvinImage, String title)
    {
        super(title);

        // ImagePanel
        imagePanel = new MarvinImagePanel();

        Container l_c = getContentPane();
        l_c.setLayout(new BorderLayout());
        l_c.add(imagePanel, BorderLayout.NORTH);

        // Load image
        //loadImage(bufferedImage);
        image = marvinImage.clone();

        imagePanel.setImage(image);

        setSize(marvinImage.getWidth(),marvinImage.getHeight() + 50);
        setVisible(true);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}