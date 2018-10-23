//package FindCardsFromImageTry1;
//
//import marvin.gui.MarvinImagePanel;
//import marvin.image.MarvinImage;
//import marvin.plugin.MarvinImagePlugin;
//
//import javax.swing.*;
//import javax.swing.event.ChangeEvent;
//import javax.swing.event.ChangeListener;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.image.BufferedImage;
//
public class DisplayImageOld {}
//public class DisplayImageOld extends JFrame
//{
//    private MarvinImagePanel imagePanel;
//    private MarvinImage image;
//    private MarvinImage backupImage;
//
//    private JSlider rs = new JSlider(0,255);
//    private JSlider gs = new JSlider(0,255);
//    private JSlider bs = new JSlider(0,255);
//    private JSlider thresh = new JSlider(0,100);
//
//    private JPanel panelBottom;
//
////    private JButton buttonGray;
////    private JButton buttonSepia;
////    private JButton buttonInvert;
////    private JButton buttonReset;
//
//    private MarvinImagePlugin imagePlugin;
//
//    public DisplayImageOld(MarvinImage marvinImage)
//    {
//        super("Filters Sample");
//
//        // Create Graphical Interface
////        ButtonHandler buttonHandler = new ButtonHandler();
////        buttonGray = new JButton("Gray");
////        buttonGray.addActionListener(buttonHandler);
////        buttonSepia = new JButton("Sepia");
////        buttonSepia.addActionListener(buttonHandler);
////        buttonInvert = new JButton("Invert");
////        buttonInvert.addActionListener(buttonHandler);
////        buttonReset = new JButton("Reset");
////        buttonReset.addActionListener(buttonHandler);
//
//        SliderHandler slideHandler = new SliderHandler();
//        panelBottom = new JPanel();
//        panelBottom.add(rs);
//        panelBottom.add(gs);
//        panelBottom.add(bs);
//        panelBottom.add(thresh);
//        rs.addChangeListener(slideHandler);
//        gs.addChangeListener(slideHandler);
//        bs.addChangeListener(slideHandler);
//        thresh.addChangeListener(slideHandler);
//
//        // ImagePanel
//        imagePanel = new MarvinImagePanel();
//
//        Container l_c = getContentPane();
//        l_c.setLayout(new BorderLayout());
//        l_c.add(imagePanel, BorderLayout.NORTH);
//        l_c.add(panelBottom, BorderLayout.SOUTH);
//
//        // Load image
//        //loadImage(bufferedImage);
//        image = marvinImage.clone();
//        backupImage = marvinImage.clone();
//
//        imagePanel.setImage(image);
//
//        setSize(800,700);
//        setVisible(true);
//
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
//
//    private void loadImage(BufferedImage bufferedImage){
//        image = new MarvinImage(bufferedImage);
//        backupImage = image.clone();
//    }
//
////    private class ButtonHandler implements ActionListener
////    {
////        public void actionPerformed(ActionEvent a_event){
////            image = backupImage.clone();
////            if(a_event.getSource() == buttonGray){
////                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.color.grayScale.jar");
////                imagePlugin.process(image, image);
////            }
////            else if(a_event.getSource() == buttonSepia){
////                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.color.sepia.jar");
////                imagePlugin.setAttribute("hsIntensidade", 50);
////                imagePlugin.process(image, image);
////            }
////            else if(a_event.getSource() == buttonInvert){
////                imagePlugin = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.color.invert.jar");
////                imagePlugin.process(image, image);
////            }
////            image.update();
////            imagePanel.setImage(image);
////        }
////    }
//
//    private class SliderHandler implements ChangeListener
//    {
//        public void stateChanged(ChangeEvent a_event){
//            image = backupImage.clone();
//            imagePanel.setImage(FindCardOutlines.highlightWhite(
//                    FindCardOutlines.bwFilter(image, rs.getValue(), gs.getValue(), bs.getValue()), 3, ((float) thresh.getValue()) / 100));
//        }
//    }
//}