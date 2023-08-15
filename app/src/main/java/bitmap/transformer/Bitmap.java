package bitmap.transformer;

import org.checkerframework.checker.units.qual.C;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Bitmap {
    private static Path outputPath;
    private static BufferedImage imageData;
    private static BufferedImage newImage;
    private static   BufferedImage outputImage;
    public static int width , height;

    public Bitmap(String filePath , String outputPath) throws IOException {
        outputPath = String.valueOf(Paths.get(outputPath));
//        Path convertToPath = Paths.get(filePath);
        imageData = ImageIO.read(new File(filePath));
        height = imageData.getHeight();
        width = imageData.getWidth();
    }
    public void flipVertically() {
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height / 2; y++) {
                int topColor = imageData.getRGB(x, y);
                int bottomColor = imageData.getRGB(x, height - 1 - y);
                imageData.setRGB(x, y, bottomColor);
                imageData.setRGB(x, height - 1 - y, topColor);
            }
        }
    }
    public  void stretchVertically() {
        int heightM = (height * 2);
        newImage = new BufferedImage(width, heightM, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < heightM; y++) {
                int color = imageData.getRGB(x, y / 2);

                newImage.setRGB(x, y, color);
                y++;
                if (y != heightM) {
                    newImage.setRGB(x, y, color);
                }
            }
        }
    }
    public  void random() {
        int rgb;
        for (int y = 1; y < height; y++) {
            for (int x = 1; x < width; x++) {
                rgb = imageData.getRGB(x, y) / 2;
                imageData.setRGB(x, y, rgb);
            }
        }
    }
    public  void reverseBlackAndGreen() {
        Color black = new Color(0,0,0);
        Color white = new Color(255,255,255);
        Color green = new Color(46,255,0);


        for (int x = 0; x<width ; x++) {
            for (int y =0 ; y<height;y++){
//                int color = imageData.getRGB(x,y);
                Color color = new Color(imageData.getRGB(x,y));
                if(color.getRed() == 0 && color.getGreen() == 0 && color.getBlue() == 0){
                    imageData.setRGB(x,y,green.getRGB());
                } else  {
                    imageData.setRGB(x,y,black.getRGB());
                }
            }
        }
    }
    public  void setImageData(BufferedImage image, String outputPath) {
        imageData = image;
        outputPath = String.valueOf(Paths.get(outputPath));
    }
    public void save(String outputPath) {
        try {
            File file = new File(outputPath);
            ImageIO.write(imageData, "bmp", file);
            System.out.println("Image saved to: " + file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
