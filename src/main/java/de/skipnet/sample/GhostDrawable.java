package main.java.de.skipnet.sample;



import main.java.de.skipnet.SpriteEngine.CenteredSpriteDrawbale;
import main.java.de.skipnet.SpriteEngine.Sprite;
import main.java.de.skipnet.SpriteEngine.SpriteStore;

public class GhostDrawable extends CenteredSpriteDrawbale {

	public static enum Color {blue, green};
	
	public GhostDrawable(Color c, int x, int y) {
		super(getSpriteFromColor(c), 0, x, y);
		// TODO Auto-generated constructor stub
	}
	
	private static Sprite getSpriteFromColor(Color c){
		String base = "src/main/res/java/skipnet/sample/";
		switch(c){
		case blue: return SpriteStore.get().getSprite(base+"ghost_b.png");
		case green: return SpriteStore.get().getSprite(base+"ghost_g.png");
		default: return null;
		}
		
	}

}
