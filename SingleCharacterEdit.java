import java.util.Arrays;

public class SingleCharacterEdit {

    public static String singleCharacterEditWillTurnAIntoB(String a, String b) {
    	
		//	convert a and b into arrays 
		char[] aArray = a.toCharArray();
		char[] bArray = b.toCharArray();
			
		if (aArray.length == bArray.length){
			char[] tempArray = aArray;
			
			for (int i = 0; i < aArray.length; i++) {
				if (aArray[i] != bArray[i]) {
					tempArray[i] = bArray[i];
					
					if (Arrays.equals(tempArray, bArray)) {
						return "replace," + i + "," + bArray[i];
					}
					else return null;		
				}
			}
		}
				
		else if (aArray.length + 1 == bArray.length){
			// insertion
			String tempString = "";
			
			for (int i = 0; i < aArray.length; i++) {
				tempString = "";
				
				if (aArray[i] != bArray[i]) {
					
					for (int x = 0; x < i; x++) {
						tempString = tempString + aArray[x];
					}
					
					tempString = tempString + bArray[i];
			
					for (int y = i; y < aArray.length; y++) {	
						tempString = tempString + aArray[y];	
					}
					
					if (Arrays.equals(tempString.toCharArray(), bArray)) {
						return "insert," + i + "," + bArray[i];
					}
					
					else return null;	
				} 
				
				else {
					for (int x = 0; x < aArray.length; x++) {
						tempString = tempString + aArray[x];
					}
					
					tempString = tempString + bArray[bArray.length - 1];
					
					if (Arrays.equals(tempString.toCharArray(), bArray)) {
						return "insert," + aArray.length + "," + bArray[bArray.length-1];
					}					
				}
			}
		}
			
		else if (aArray.length == bArray.length + 1){
			// deletion
			String tempString = "";
			
			for (int i = 0; i < bArray.length; i++) {
				tempString = "";
				
				if (aArray[i] != bArray[i]) {
					
					for (int x = 0; x < i; x++) {
						tempString = tempString + aArray[x];
					}
					
					for (int y = i+1; y <= bArray.length; y++) {
						tempString = tempString + aArray[y];	
					}
				
					if (Arrays.equals(tempString.toCharArray(), bArray)) {
						return "remove," + i;
					}
					
					else return null;	
				} 
				
				else {
					for (int x = 0; x < bArray.length; x++) {
						tempString = tempString + aArray[x];
					}
					
					if (Arrays.equals(tempString.toCharArray(), bArray)) {
						return "remove," + aArray.length;
					}						
				}
			}
		}
		
		// else by default...
		return null;
    }
}
