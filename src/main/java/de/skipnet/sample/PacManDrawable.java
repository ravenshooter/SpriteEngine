package main.java.de.skipnet.sample;

import main.java.de.skipnet.SpriteEngine.CenteredSpriteDrawbale;
import main.java.de.skipnet.SpriteEngine.Sprite;
import main.java.de.skipnet.SpriteEngine.SpriteStore;

public class PacManDrawable extends CenteredSpriteDrawbale {

	public PacManDrawable(int x, int y) {
		super(SpriteStore.get().getSprite("src/main/res/java/skipnet/sample/pacman.png"), 0, x, y);
	}

}
