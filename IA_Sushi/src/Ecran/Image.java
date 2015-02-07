package Ecran;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Image {
	private int [] pixels;
	private int width;
	private int height;
	public Image (int [] pixels, int w, int h){
		this.pixels = pixels;
		this.width = w;
		this.height= h;
		System.out.println(pixels.length);

	}

	public int getPixel (int i){
		return this.pixels[i];
	}

	public  int[] getPixels (){
		return this.pixels;
	}


	public  boolean testepixel (Image toID, int n ){
		int cpt = 0;
		int init = n ;
		for (int i = 0 ; i< toID.pixels.length ; i++){
			if (cpt == toID.width && n+this.width< this.pixels.length){
				cpt = 0;
				n = init + this.width;
				init = init + this.width;
			}
			if (toID.getPixel(i)!=this.getPixel(n)) return false;
			n++;
			cpt ++;
		}
		return true;
	}

	public int trouveDansImage(Image toID){
		for (int i = 0 ; i < this.pixels.length; i++){
			if (this.pixels[i]==toID.getPixel(0)){
				boolean res = this.testepixel(toID, i);
				if (res) return i;
			}
		}

		return -1;
	}

	public static int[]  computeImageCorner (int px, Image toID, Image screenshot){
		int [] coin = new int [2];
		coin[1] = px/screenshot.width;
		coin[0] = px%screenshot.width;
		if (coin[0]-1!=0) coin[1]=coin[1]+1;
		coin[0] += toID.width - 640;
		return coin;
	}




}
