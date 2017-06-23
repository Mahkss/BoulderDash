package projet.secours.dev.codenmore.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 16, height = 16;
	
	public static BufferedImage wall, mud, rock, diamond, exit, monster1, monster2;
	public static BufferedImage[] player_down_left, player_down_right, player_up_left, player_up_right, player_left, player_right, player_afk;
	
	public static void init(){
		SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/74336.png"));
		
		player_down_left = new BufferedImage[2];
		
		player_down_left[0] = sheet.crop(0,  height * 4, width, height);
		player_down_left[1] = sheet.crop(width,  height * 4, width, height);
		
		player_down_right = new BufferedImage[2];
		
		player_down_right[0] = sheet.crop(width * 2, height * 4, width, height);
		player_down_right[1] = sheet.crop(width * 3, height * 4, width, height);
		
		player_up_left = new BufferedImage[2];
		
		player_up_left[0] = sheet.crop(0, height * 2, width, height);
		player_up_left[1] = sheet.crop(width, height * 2, width, height);
		
		player_up_right = new BufferedImage[2];
		
		player_up_right[0] = sheet.crop(width * 2, height * 2, width, height);
		player_up_right[1] = sheet.crop(width * 3, height * 2, width, height);
		
		player_left = new BufferedImage[3];
		
		player_left[0] = sheet.crop(0, height, width, height);
		player_left[1] = sheet.crop(width, height, width, height);
		player_left[2] = sheet.crop(width * 2, height, width, height);
		
		player_right = new BufferedImage[3];
		
		player_right[0] = sheet.crop(0, height * 3, width, height);
		player_right[1] = sheet.crop(width, height * 3, width, height);
		player_right[2] = sheet.crop(width * 2, height * 3, width, height);
		
		player_afk = new BufferedImage[2];
		
		player_afk[0] = sheet.crop(0, 0, width, height);
		player_afk[1] = sheet.crop(width, 0, width, height);
		
		SpriteSheet sheet2 = new SpriteSheet(ImageLoader.LoadImage("/textures/Spritedecorsetmonstres.png"));
		
		wall  = sheet2.crop(0, 0, width, height);
		mud = sheet2.crop(width, 0, width, height);
		rock = sheet2.crop(width * 3, 0, width, height);
		diamond = sheet2.crop(width * 4, 0, width, height);
		exit = sheet2.crop(width * 6, 0, width, height);
		monster1 = sheet2.crop(width * 9, 0, width, height);
		monster2 = sheet2.crop(width * 10, 0, width, height);
	}

}
