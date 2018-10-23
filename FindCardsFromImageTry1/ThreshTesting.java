package FindCardsFromImageTry1;

import static marvin.MarvinPluginCollection.thresholding;
import static marvin.MarvinPluginCollection.thresholdingNeighborhood;

import marvin.image.MarvinImage;
import marvin.image.MarvinSegment;

import java.awt.*;
import java.util.List;

public class ThreshTesting {
    public static final double border = 0.3;
    public static void findColor(List<MarvinSegment> segments, MarvinImage marvinImage) {
        for(int s = 0; s < segments.size(); s++) {
            MarvinSegment segment = segments.get(s);
            int widthBorder = (int)(border * segment.width / 2);
            int heightBorder = (int)(border * segment.height / 2);
            MarvinImage subImage = marvinImage.subimage(segment.x1 + widthBorder, segment.y1 + heightBorder, segment.width - 2 * widthBorder, segment.height - 2 * heightBorder);
            //thresholding(subImage, 150);
            thresholdingNeighborhood(subImage, subImage, 0.2, 0, 10);
            new DisplayImage(subImage, "" + s);

            int n = 0;
            int rSum = 0, gSum = 0, bSum = 0;
            for(int x = 0; x < subImage.getWidth(); x++) {
                for(int y = 0; y < subImage.getHeight(); y++) {
                    n++;
                    rSum += subImage.getIntComponent0(x, y);
                    gSum += subImage.getIntComponent1(x, y);
                    bSum += subImage.getIntComponent2(x, y);
                }
            }

            System.out.println("Segment " + s + ": " + segment.x1 + " " + segment.y1);
            System.out.println("R: " + rSum / n);
            System.out.println("G: " + gSum / n);
            System.out.println("B: " + bSum / n);

            if(Math.abs(rSum / n - gSum / n) <= 5) {
                marvinImage.fillRect(segment.x1, segment.y1, segment.width, segment.height, Color.BLACK);
            }


        }
    }
}
