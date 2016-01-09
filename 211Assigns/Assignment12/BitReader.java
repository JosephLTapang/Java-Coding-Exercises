 /**
 *@author Joseph Tapang
 *@(#)BitReader.java
 *@ 12/06/13
 */ 
import java.util.ArrayList;

public class BitReader{//bitReader class just reads the bits

	//used to check if a bit is 0 or 1, where masks[0] would be BIT-AND with the first bit of the byte.
	byte [] masks = {(byte)0x80, (byte)0x40, (byte)0x20, (byte)0x10, (byte)0x08, (byte)0x04, (byte)0x02, (byte)0x01};

	//The index of the bits throughout the byte array.
	int bitIndex;
	
	//A byte array to be used in BitReader constructor.
	ArrayList<Byte> aRay;

	public BitReader(ArrayList<Byte> b){
		aRay = b;
		bitIndex = 0;
	}
	/**
	 * Method is a way to find an individual bit in an array of bytes and check if it is 0 or 1.
	 * @return Returns an int representation of the bit.
	 */
	public int get(){
		int bitValue;	
		int byteIndex = bitIndex / 8;
		int innerByteIndex = bitIndex % 8;
		bitValue = (aRay.get(byteIndex) & 0xFF) & (masks[innerByteIndex] & 0xFF) ;	
		bitIndex++;
		if(bitValue != 0){
			return 1;
		}
		return bitValue;
	}	
}


