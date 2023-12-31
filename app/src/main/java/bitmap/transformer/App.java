/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitmap.transformer;

import org.checkerframework.checker.units.qual.C;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class App {

    public static void main(String[] args) {
        try {
            if (args.length < 3) {
                System.err.println("usage gradle run --args inputFile outputfile transform");
            } else {
                String inputFile = args[0];
                String directoryPath = new File(inputFile).getParent() + "\\" + args[1];
                Bitmap bitmap = new Bitmap(inputFile, directoryPath);

                switch (args[2].toLowerCase()) {
                    case "random": {
                        bitmap.random();
                    }
                        break;
                    case "reverseblackandgreen": {
                        bitmap.reverseBlackAndGreen();
                    }
                        break;
                    case "flipvertically": {
                        bitmap.flipVertically();
                    }
                        break;
                    case "stretchvertically": {
                        bitmap.stretchVertically();
                    }
                        break;
                    default:
                        System.err.println("Invalid transform type");
                }
                bitmap.save(directoryPath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
// public void seeBMPImage(String BMPFileName) throws IOException {
// BufferedImage image = ImageIO.read(new File(BMPFileName));
//
// int[][] array2D = new int[image.getWidth()][image.getHeight()];
//
// for (int xPixel = 0; xPixel < image.getWidth(); xPixel++)
// {
// for (int yPixel = 0; yPixel < image.getHeight(); yPixel++)
// {
// int color = image.getRGB(xPixel, yPixel);
// if (color== Color.BLACK.getRGB()) {
// array2D[xPixel][yPixel] = 1;
// } else {
// array2D[xPixel][yPixel] = 0; // ?
// }
// }
// }
// } }
