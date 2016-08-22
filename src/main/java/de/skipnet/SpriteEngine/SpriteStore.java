package main.java.de.skipnet.SpriteEngine;


import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;

/**
 * SpriteStore is a Singleton, must be acceseble from everywhere,
 * to ensure each image is only loaded once into RAM and then reused.
 * For more information check out: http://www.cokeandcode.com/info/tut2d.html
 *
 * @author Stephan
 */
public class SpriteStore {
    private static SpriteStore instance = new SpriteStore();

    /**
     * Getter for singleton, call this instead of creating an instace with constructor.
     *
     * @return
     */
    public static SpriteStore get() {
        return instance;
    }

    private HashMap<String, Sprite> sprites;
    


    private SpriteStore() {
        sprites = new HashMap<>();
    }

    public boolean loadSprite(String ref) {
    	BufferedImage sourceImage = null;
        try{
        	URL url = new File(ref).toURI().toURL();
            sourceImage = ImageIO.read(url);
        }catch(IOException e){
            System.out.println("Failed to load image " + ref);
            e.printStackTrace();
            return false;
        }
        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment()
                                                      .getDefaultScreenDevice()
                                                      .getDefaultConfiguration();
        Image image = gc.createCompatibleImage(sourceImage.getWidth(), sourceImage.getHeight(),
                                               Transparency.TRANSLUCENT);

        image.getGraphics().drawImage(sourceImage, 0, 0, null);

        Sprite sprite = new Sprite(image);
        sprites.put(ref, sprite);
        return true;
    }

    public Sprite getSprite(String ref) {
        Sprite sprite = (Sprite) sprites.get(ref);
        if (sprite == null) {
            if (loadSprite(ref)) {
                return (Sprite) sprites.get(ref);
            }
        }
        return sprite;
    }
    

    
    

}
