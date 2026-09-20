package br.display;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import br.Game;

public class Background {

	private BufferedImage img = null;
	private int x =0;
	private int y=0;
	
	//CONSTRUTOR
	public Background() {
		try {
			img = ImageIO.read(new File("src/fundo.png"));
		} catch (IOException e) {
			System.out.println("N�o foi poss�vel carregar a imagem de fundo");
			e.printStackTrace();
		}
	}
	
	public void print(Graphics g) {
		g.drawImage(img, x, y, x + Game.WIDTH, y + Game.HEIGHT, 0, 0, img.getWidth(), img.getHeight(), null);
	}
}
