/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ResizeImages {      
    public static BufferedImage resize(BufferedImage img, int height, int width) {
        //getting image resize Images
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB_PRE);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
    public static void main(String[] args) throws IOException{
           File[] images = new File("src/Segmentation").listFiles();

        for (File f : images) {
            System.out.println("Processing: " + f.getName() + "...");

            if (f.isDirectory()) {
                System.out.println("\tSkipping, file is a directory...");
            } else
                process(f);
        }

        
        
    }        private static void process(File file) throws IOException {
        // Load image.
        BufferedImage image = ImageIO.read(file);

        // Resize image.
        image = resize(image, 250,250);

        // Save the resized image as the thumbnail.
        saveThumbnail(file, image);
    }
    private static void saveThumbnail(File originalFile, BufferedImage thumbnail)
            throws IOException {
        String filename = originalFile.getName();

        // Determine file extension.
        String fileExt = filename.substring(filename.lastIndexOf('.') + 1);

        // Save the thumbnail to the resized dir.
        ImageIO.write(thumbnail, fileExt, new File("src\\segmentationImage(250x250)\\" + filename));
    }
    
}
