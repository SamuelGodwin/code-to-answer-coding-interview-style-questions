public class ScreenAsBytes {

	//byte[] intArray = new byte[3];
	
    public static void setPixel(byte[] screen, int width, int x, int y) {
    	
    	//length is number of bytes in the whole array
    	//width is a multiple of 8
    	//so width / 8 is the number of bytes wide.
    	//(you can work out height of image from length of the array and width
    	//int height = screen.length / (width / 8);
    	
    	//System.out.println(height);
    	
    	int bitPosition = x + (width*y); //this result is number of bits, not bytes
    	int exactByte = bitPosition / 8; //this is the byte index in the byte array
    	//NEED TO BE DIV (INTEGER DIVISION) NOT NORMAL??
    	
    	//indexes of array are still in bytes.....
    	
    	int pos = x % 8; //this is to single out the element in 1 specific byte,
    	//rather than the x value being 10 (for example).
    	//^mod just in case the x was 10, for example
    	//System.out.println(bitPosition);
    	//System.out.println(pos);
    	
    	int shiftToLeft = 8 - (pos + 1);

    	
    	//bitwise 'or' operator
    	screen[exactByte] = (byte)(screen[exactByte] | (1 << shiftToLeft));
    	
    	//screen[position] = 1;
    	//starting at zeroth, 
    	//coordinate is x value + width*y
    }

    //start and end x positions are inclusive
    public static void drawHorizontalLine(byte[] screen, int width, int startX, int endX, int y) {
    
    	
    	for (int i=startX; i <= endX; i++) {
    		setPixel(screen, width, i, y);
    	}
    }
    
    public static void drawVerticalLine(byte[] screen, int width, int x, int startY, int endY) {
    	//(you can work out height of image from length of the array and width
    	int height = screen.length / (width / 8);
    	
    	for (int i=startY; i <= endY; i++) { //any further checks to disallow for overflowing?
    		setPixel(screen, width, x, i);
    	}
    	
    }


}
