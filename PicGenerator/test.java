
public class test{

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

    public static Color[][] toArray(Picture p){
	Color[][] map = new Color[p.getWidth()][p.getHeight()];
	for(int i = 0; i < p.getWidth(); i++){
	    for(int j = 0; j < p.getHeight(); j++){
		map[i][j] = p.getPixelColor(i,j);
	    }
	}
	return map;
    }

		

    public static void main(String[] args){

	String file_name = args[0];
	Picture pic = new Picture (file_name);
	pic = Grayscale(pic);
	Color[][] map = toArray(pic);
	pic.display();
    }
}
