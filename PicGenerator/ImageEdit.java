// Eli Rosenberg
// My Image Editor
// 10/3/12

import java.util.*;

public class ImageEdit{
	
	public static void main ( String[] args ){
		
		
		Scanner console = new Scanner(System.in);
		System.out.print( "Please input the file name: ");
		String file = console.nextLine();
		Picture canvas = new Picture( file );
		
		canvas.display();
		boolean list = false;
		while (!list) {
			System.out.println("What would you like to do to the image? ");
			PossibleOperations();
			System.out.print( "Your choice? ");
			int choice = console.nextInt();
			switch(choice){
			case 1:
				HorizontalFlip(canvas).display();
				break;
			case 2:
				Mirror(canvas).display();
				break;
			case 3:
				Scroll(canvas).display();
				break;
			case 4: 
				Negative(canvas).display();
				break;
			case 5: 
				Grayscale(canvas).display();
				break;
			case 6:
				CycleColors(canvas).display();
				break;
			case 7:
				Zoom(canvas).display();
				break;
			case 8: 
				Posterize(canvas).display();
				break;
			case 9: 
				Brightness(canvas).display();
				break;	
			case 10: 
				IncreaseContrast(canvas).display();
				break;
			case 11: 
				Blur(canvas).display();
				break;
			case 12: 
				Rotate(canvas).display();
				break;
			case 13:
				MyEffect1_Screen(canvas).display();
				break;
			case 14: 
				MyEffect2_Shadow(canvas).display();
				break;
				
			}
		}
	}
		


	public static void PossibleOperations() {
		System.out.println("1. Flip Horizontally" );
		System.out.println("2. Mirror Horizontally" );
		System.out.println("3. Scroll Horizontally");
		System.out.println("4. Make Negative");
		System.out.println("5. Make Grayscale");
		System.out.println("6. Cycle Color Channels");
		System.out.println("7. Zoom");
		System.out.println("8. Posterize");
		System.out.println("9. Change Brightness");
		System.out.println("10. Increase Contrast");
		System.out.println("11. Blur");
		System.out.println("12. Rotate 180 degrees");
		System.out.println("13. (My Effect) Screen");
		System.out.println("14. (My Effect) Shadow");
	}
	
	// Method that takes a picture and returns a copy of it
	public static Picture copyPic(Picture p){
		
	int W = p.getWidth();
	int H = p.getHeight();
	Picture copy = new Picture(W,H);
		for(int x = 0; x < W - 1; x++){
			for(int y = 0; y < H - 1; y++){
			copy.setPixelRed(x,y,p.getPixelRed(x,y));
			copy.setPixelBlue(x,y,p.getPixelBlue(x,y));
			copy.setPixelGreen(x,y,p.getPixelGreen(x,y));
			}
		}
		return copy;
	}
		
	// Flips an image across the y-axis	
	public static Picture HorizontalFlip(Picture pic){
	
	int W = pic.getWidth();
	int H = pic.getHeight();	
	Picture flipPic = new Picture(W,H);
	for(int x = 0; x < W - 1; x++){
		for(int y = 0; y < H - 1; y++){
			flipPic.setPixelRed(W - 1 - x,y,pic.getPixelRed(x,y));
			flipPic.setPixelBlue(W - 1 - x,y,pic.getPixelBlue(x,y));
			flipPic.setPixelGreen(W - 1 - x,y,pic.getPixelGreen(x,y));
		}
	}
	return flipPic;
	}
	
	
	// Mirrors the left side of a picture over the center y axis
	public static Picture Mirror(Picture pic){
		
	int W = pic.getWidth();
	int H = pic.getHeight();
	Picture mirroredpic = new Picture(W,H);
	for(int x = 0; x < W / 2; x++){
		for(int y = 0; y < H - 1; y++){
			mirroredpic.setPixelRed(x,y,pic.getPixelRed(x,y));
			mirroredpic.setPixelBlue(x,y,pic.getPixelBlue(x,y));
			mirroredpic.setPixelGreen(x,y,pic.getPixelGreen(x,y));
		}
	}
	for(int x = 0; x < W / 2; x++){
		for(int y = 0; y < H - 1; y++){
			mirroredpic.setPixelRed(W - x - 1,y,mirroredpic.getPixelRed(x,y));
			mirroredpic.setPixelBlue(W - x - 1,y,mirroredpic.getPixelBlue(x,y));
			mirroredpic.setPixelGreen(W - x - 1,y,mirroredpic.getPixelGreen(x,y));
			
			}
		}
		return mirroredpic;
	}
	
	// Scrolls the picture to the right a given number of units
	// note: cannot scroll more pixels than the actual picture has
	public static Picture Scroll(Picture pic){
	int W = pic.getWidth();
	int H = pic.getHeight();
	int d;
	Picture changedpic = new Picture(W,H);
	Scanner console;
	console = new Scanner(System.in);
      	System.out.println("How many pixels to the right would you like to scroll?");
      	d = console.nextInt();
      	
      	for(int x = 0; x < W - d; x++){
		for(int y = 0; y < H - 1; y++){
			changedpic.setPixelRed(x + d,y,pic.getPixelRed(x,y));
			changedpic.setPixelBlue(x + d,y,pic.getPixelBlue(x,y));
			changedpic.setPixelGreen(x + d,y,pic.getPixelGreen(x,y));
		}
	}
	
	for(int x = W - d; x < W ; x++){
		for(int y = 0; y < H - 1; y++){
			changedpic.setPixelRed(x + d - W ,y,pic.getPixelRed(x,y));
			changedpic.setPixelBlue(x + d - W ,y,pic.getPixelBlue(x,y));
			changedpic.setPixelGreen(x + d - W ,y,pic.getPixelGreen(x,y));
		}
	}
	return changedpic;
	}
	
	
	//Negates the colors in the image
	public static Picture Negative(Picture pic){
	int W = pic.getWidth();
	int H = pic.getHeight();
		for(int x = 0; x < W - 1 ; x++){
			for(int y = 0; y < H - 1; y++){
			pic.setPixelRed(x,y,255 - pic.getPixelRed(x,y));
			pic.setPixelBlue(x,y,255 - pic.getPixelBlue(x,y));
			pic.setPixelGreen(x,y,255 - pic.getPixelGreen(x,y));
		}
		}
		return pic;
	}
	
	//Makes the image grayscale
	public static Picture Grayscale(Picture pic){
	int W = pic.getWidth();
	int H = pic.getHeight();
		for(int x = 0; x < W - 1 ; x++){
			for(int y = 0; y < H - 1; y++){
			int sum = pic.getPixelGreen(x,y) + pic.getPixelBlue(x,y) + pic.getPixelRed(x,y);
			int AVG = sum/3;
			pic.setPixelRed(x,y,AVG);
			pic.setPixelBlue(x,y,AVG);
			pic.setPixelGreen(x,y,AVG);
		}
		}
		return pic;
	}
	
	//increases brightness by a given amount
	public static Picture Brightness(Picture pic){
		int W = pic.getWidth();
		int H = pic.getHeight();
		Scanner console = new Scanner(System.in);
		System.out.println("By how much would you like to change the brightness by?");
		int c = console.nextInt();
		for(int x = 0; x < W - 1 ; x++){
			for(int y = 0; y < H - 1; y++){
				if(pic.getPixelRed(x,y) + c < 256 && pic.getPixelRed(x,y) + c >= 0){
				pic.setPixelRed(x,y,pic.getPixelRed(x,y) + c);
				}
				else{ 
					if( pic.getPixelRed(x,y) + c > 256){
						pic.setPixelRed(x,y,255);
					}
					else{
						if(pic.getPixelRed(x,y) + c < 0){
							pic.setPixelRed(x,y,0);
						}
					}
				}
			
					
				if(pic.getPixelGreen(x,y) + c < 256 && pic.getPixelGreen(x,y) + c >= 0){
				pic.setPixelGreen(x,y,pic.getPixelGreen(x,y) + c);
				}
				else{ 
					if( pic.getPixelGreen(x,y) + c > 256){
						pic.setPixelGreen(x,y,255);
					}
					else{
						if(pic.getPixelGreen(x,y) + c < 0){
							pic.setPixelGreen(x,y,0);
						}
					}
				}
				
				if(pic.getPixelBlue(x,y) + c < 256 && pic.getPixelBlue(x,y) + c >= 0){
				pic.setPixelBlue(x,y,pic.getPixelBlue(x,y) + c);
				}
				else{ 
					if( pic.getPixelBlue(x,y) + c > 256){
						pic.setPixelBlue(x,y,255);
					}
					else{
						if(pic.getPixelBlue(x,y) + c < 0){
							pic.setPixelBlue(x,y,0);
						}
					}
				}
				
	}}
	
	return pic;
	}
	
	//Sets the blue value to the original green value, the green to the original red, and the red to the original blue.
	public static Picture CycleColors(Picture pic){
	int W = pic.getWidth();
	int H = pic.getHeight();
		for(int x = 0; x < W - 1 ; x++){
			for(int y = 0; y < H - 1; y++){
				int b = pic.getPixelGreen(x,y);
				int g = pic.getPixelRed(x,y);
				int r = pic.getPixelBlue(x,y);
				pic.setPixelRed(x,y,r);
				pic.setPixelBlue(x,y,b);
				pic.setPixelGreen(x,y,g);
			}
		}
		return pic;
	}
		

	//zooms in on the center of the picture	
      	public static Picture Zoom(Picture pic) {
		int W = pic.getWidth();
		int H = pic.getHeight();
		
		Picture zoom = new Picture(W,H);
		Picture small = new Picture (W / 2  , H / 2 );
		for (int x = W / 4 ; x< 3*W / 4 ; x++) {
			for (int y = H / 4 ; y < 3*H / 4 ; y++) {
			
				int red = pic.getPixelRed(x,y);
				int green = pic.getPixelGreen(x,y);
				int blue = pic.getPixelBlue(x, y);
				small.setPixelRed(x - (W / 4),y - (H / 4),red);
				small.setPixelBlue(x - (W / 4),y - (H / 4),blue);
				small.setPixelGreen(x - (W / 4),y - (H / 4), green);
				
			}
		}
				
			int red = 0;
			int green = 0;
			int blue = 0;	
			
		for( int x = 0 ; x < W - 1 ; x = x+2){
			
			for( int y = 0; y < H - 1; y = y + 2){ 	
				
			
			red = small.getPixelRed(x / 2 , y / 2 );
			green = small.getPixelGreen(x / 2 , y / 2 );
			blue = small.getPixelBlue(x / 2 , y / 2 );
			
	
			
				zoom.setPixelRed(x,y,red);
				zoom.setPixelBlue(x,y,blue);
				zoom.setPixelGreen(x,y,green);
				
				zoom.setPixelRed(x + 1,y,red);
				zoom.setPixelBlue(x + 1,y,blue);
				zoom.setPixelGreen(x + 1,y,green);
				
				zoom.setPixelRed(x,y + 1,red);
				zoom.setPixelBlue(x,y + 1,blue);
				zoom.setPixelGreen(x,y + 1,green);
				
				zoom.setPixelRed(x+ 1,y + 1,red);
				zoom.setPixelBlue(x + 1,y + 1,blue);
				zoom.setPixelGreen(x + 1,y + 1,green);
						}
	

		}
			
		
		return zoom;
	}
	
	
	// calulates the number for posterize
	public static int PostNumber( int x) {
		int y = x%32;
		int fin = x-y;
		return fin;
	}
	
	//makes the picture look posterized
	public static Picture Posterize(Picture pic) {
		int W = pic.getWidth();
		int H = pic.getHeight();
		Picture post = new Picture(W,H);
		for (int x = 0 ; x<=(W-1); x++) {
			for (int y = 0; y <= (H-1); y++) {
				int red = pic.getPixelRed(x,y);
				int green = pic.getPixelGreen(x,y);
				int blue = pic.getPixelBlue(x, y);
				post.setPixelRed(x,y,PostNumber(red));
				post.setPixelBlue(x,y,PostNumber(blue));
				post.setPixelGreen(x,y,PostNumber(green));
			}
		}
		return post; 
	}
	
	// increases contrast of the picture
	public static Picture IncreaseContrast(Picture canvas) {
		int w = canvas.getWidth();
		int h = canvas.getHeight();
		Picture pic = new Picture(w, h);
		for(int x = 0; x<w; x++) {
			for(int y = 0; y<h; y++) {
				int r = canvas.getPixelRed(x, y);
				int g = canvas.getPixelGreen(x, y);
				int b = canvas.getPixelBlue(x, y);
				if( r == 128) {
					r = r;
				}
				else {
					r = r-128;
					r = 2*r;
					r = 128 +r;
				}
				if( g == 128) {
					g = g;
				}
				else {
					g = g - 128;
					g = 2*g;
					g = 128 + g;
				}
				if ( b == 128) {
					b = b;
				}
				else {
					b = b - 128;
					b = 2*b;
					b = 128 + b;
				}
				if (r < 0) {
					r = 0;
				}
				if (r > 255) {
					r = 255;
				}
				if (g < 0) {
					g = 0;
				}
				if (g > 255) {
					g = 255;
				}
				if (b < 0) {
					b = 0;
				}
				if (b > 255) {
					b = 255;
				}
				pic.setPixelColor(x, y, r, g, b);
			}
		}
		
		return pic;
	}
	
	//blurs the image
	public static Picture Blur(Picture canvas) {
		int w = canvas.getWidth();
		int h = canvas.getHeight();
		Picture pic = new Picture(w, h);
		for( int x = 1; x < w - 1; x++) {
			for( int y = 1; y < h - 1; y++) {
				int gone = canvas.getPixelGreen(x, y);
				int gtwo = canvas.getPixelGreen(x-1, y);
				int gthree = canvas.getPixelGreen(x+1, y);
				int gfour = canvas.getPixelGreen(x, y-1);
				int gfive = canvas.getPixelGreen(x, y+1);
				int gsix = canvas.getPixelGreen(x+1, y+1);
				int gseven = canvas.getPixelGreen(x-1, y-1);
				int geight = canvas.getPixelGreen(x+1, y-1);
				int gnine = canvas.getPixelGreen(x-1, y+1);
				int g = (gone+gtwo+gthree+gfour+gfive+gsix+gseven+geight+gnine)/9;
				int bone = canvas.getPixelBlue(x, y);
				int btwo = canvas.getPixelBlue(x-1, y);
				int bthree = canvas.getPixelBlue(x+1, y);
				int bfour = canvas.getPixelBlue(x, y-1);
				int bfive = canvas.getPixelBlue(x, y+1);
				int bsix = canvas.getPixelBlue(x+1, y+1);
				int bseven = canvas.getPixelBlue(x-1, y-1);
				int beight = canvas.getPixelBlue(x+1, y-1);
				int bnine = canvas.getPixelBlue(x-1, y+1);
				int b = (bone+btwo+bthree+bfour+bfive+bsix+bseven+beight+bnine)/9;
				int rone = canvas.getPixelRed(x, y);
				int rtwo = canvas.getPixelRed(x-1, y);
				int rthree = canvas.getPixelRed(x+1, y);
				int rfour = canvas.getPixelRed(x, y-1);
				int rfive = canvas.getPixelRed(x, y+1);
				int rsix = canvas.getPixelRed(x+1, y+1);
				int rseven = canvas.getPixelRed(x-1, y-1);
				int reight = canvas.getPixelRed(x+1, y-1);
				int rnine = canvas.getPixelRed(x-1, y+1);
				int r = (rone+rtwo+rthree+rfour+rfive+rsix+rseven+reight+rnine)/9;
				if( x < 1) {
					r = rone;
					g = gone;
					b = bone;
				}
				if(x > (w-2)) {
					r = rone;
					g = gone;
					b = bone;
				}
				if(y<1) {
					r = rone;
					g = gone;
					b = bone;
				}
				if( y > (h - 2)) {
					r = rone;
					g = gone;
					b = bone;
				}
				if (r < 0) {
					r = 0;
				}
				if (r > 255) {
					r = 255;
				}
				if (g <0) {
					g = 0;
				}
				if (g > 255) {
					g = 255;
				}
				if (b < 0) {
					b = 0;
				}
				if (b > 255) {
					b = 255;
				}
				pic.setPixelColor(x, y, r, g, b);
			}
		}
		return pic;
	}
	
	//Rotates the picture 180 degrees
	public static Picture Rotate(Picture pic) {
	int W = pic.getWidth();
	int H = pic.getHeight();	
	Picture flipPic = new Picture(W,H);
	for(int x = 0; x < W - 1; x++){
		for(int y = 0; y < H - 1; y++){
			flipPic.setPixelRed(x,H - 1 - y,pic.getPixelRed(x,y));
			flipPic.setPixelBlue(x,H - 1 - y,pic.getPixelBlue(x,y));
			flipPic.setPixelGreen(x,H - 1 - y,pic.getPixelGreen(x,y));
		}
	}
	return HorizontalFlip(flipPic);
	}
	
	//Makes the image into a semi-opaque "screen"
	public static Picture MyEffect1_Screen(Picture pic) {
	int W = pic.getWidth();
	int H = pic.getHeight();	
	Picture cPic = new Picture(W,H);
	for(int x = 0; x < W - 1; x++){
		for(int y = 0; y < H - 1; y++){
			if(x%2 == 0 && y%2 == 0){
			cPic.setPixelRed(x,y,pic.getPixelRed(x,y));
			cPic.setPixelBlue(x,y,pic.getPixelBlue(x,y));
			cPic.setPixelGreen(x,y,pic.getPixelGreen(x,y));
		}
	}
	
	}
	return cPic;
	}
	
	// creates a shodow effect 
	public static Picture MyEffect2_Shadow(Picture pic) {
	int W = pic.getWidth();
	int H = pic.getHeight();	
	Picture cPic = new Picture(W,H);
	for(int x = 0; x < W - 1; x++){
		for(int y = 0; y < H - 1; y++){
			if(x > 0 && y > 0){
				if(pic.getPixelRed(x,y) - pic.getPixelRed(x-1,y-1) > 50
				&& pic.getPixelBlue(x,y) - pic.getPixelRed(x-1,y-1) > 50
			&& pic.getPixelGreen(x,y) - pic.getPixelGreen(x-1,y-1) > 50){
			}
			else{
			pic.setPixelRed(x,y,0);
			pic.setPixelBlue(x,y,0);
			pic.setPixelGreen(x,y,0);
		}
	}
	
	}
	
	}
	return pic;
	
	
}}
		
	
	

