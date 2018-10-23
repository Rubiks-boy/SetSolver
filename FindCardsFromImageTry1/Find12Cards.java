package FindCardsFromImage;

import marvin.color.MarvinColorModelConverter;
import marvin.image.MarvinImage;
import marvin.image.MarvinSegment;
import marvin.math.MarvinMath;
import marvin.plugin.MarvinImagePlugin;
import marvin.util.MarvinPluginLoader;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static marvin.MarvinPluginCollection.floodfillSegmentation;
import static marvin.MarvinPluginCollection.thresholding;

public class Find12Cards {

    private static MarvinImagePlugin erosion = MarvinPluginLoader.loadImagePlugin("org.marvinproject.image.morphological.erosion.jar");

    public static List<MarvinSegment> getCardSegments(MarvinImage marvinImage){
        List<MarvinSegment> listSegments = new ArrayList<>();
        List<MarvinSegment> listSegmentsTmp = new ArrayList<>();

        for(int thresh = 75; thresh < 175; thresh += 25) {
            MarvinImage image = marvinImage.clone();

            thresholding(image, thresh);

            MarvinImage binImage = MarvinColorModelConverter.rgbToBinary(image, 127);

            erosion.setAttribute("matrix", MarvinMath.getTrueMatrix(2, 2));
            erosion.process(binImage.clone(), binImage);

            MarvinImage binImageRGB = MarvinColorModelConverter.binaryToRgb(binImage);
            MarvinSegment[] segments =  floodfillSegmentation(binImageRGB);

            for(MarvinSegment s:segments) {
                if(s.width * s.height > 10000 && s.width * s.height < 30000 && Math.abs(s.height - s.width) < 70) {
                    listSegments.add(s);
                    listSegmentsTmp.add(s);
                    System.out.println(s.width + " " + s.height);
                }
            }
        }

        // 6. Remove segments that are too near.
        //MarvinSegment.segmentMinDistance(listSegments, 30);

        return listSegments;
    }

    public static void showSegments(List<MarvinSegment> segments, MarvinImage image){
        for(MarvinSegment s:segments){
            int width = s.x2 - s.x1;
            int height = s.y2 - s.y1;
            double innerBox = 0.3;
            image.drawRect(s.x1 + (int)(innerBox/2*width), s.y1 + (int)(innerBox/2*height), width - (int)(innerBox*width), height - (int)(innerBox*height), Color.green);
            image.drawRect(s.x1, s.y1, width, height, Color.blue);
            image.fillRect((s.x1+s.x2)/2, (s.y1+s.y2)/2, 5, 5, Color.red);
        }
    }
}