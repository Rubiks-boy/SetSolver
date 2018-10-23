package FindCardsFromImageTry1;

import marvin.image.MarvinImage;
import marvin.image.MarvinSegment;
import marvin.io.MarvinImageIO;

import java.util.List;

public class Test {
    public static final double border = 0.3;

    public static void main(String [] args) {
        for(int img = 1; img <= 7; img++) {
            MarvinImage marvinImage = MarvinImageIO.loadImage("./src/Resources/IMG_127" + img + ".jpg");

            List<MarvinSegment> segments = Find12Cards.getCardSegments(marvinImage);
            for (int i = 0; i < segments.size(); i++) {
                MarvinSegment segment = segments.get(i);

                int widthBorder = (int) (border * segment.width / 2);
                int heightBorder = (int) (border * segment.height / 2);

                MarvinImage subImage = marvinImage.subimage(segment.x1 + widthBorder, segment.y1 + heightBorder, segment.width - 2 * widthBorder, segment.height - 2 * heightBorder);

                new RemoveSubImageBackground(subImage);
            }
            Find12Cards.showSegments(segments, marvinImage);

            new DisplayImage(marvinImage, "IMG_127" + img);

        }
    }
}
