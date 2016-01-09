 /**
 *@author Joseph Tapang, Zach Tomaszewski
 *@(#)TapangA12.java
 *@ 12/06/13
 */ 

import java.io.IOException;

public class TapangA12 {
	
	  /**
	   * Takes a filename to process as a command line argument.
	   * If the filename ends in ".huff", decompresses it into a file with the
	   * ".huff" extension removed.  If the filename does not end in ".huff",
	   * compresses the file into a new file with ".huff" appended to the name.
	   */
	  public static void main(String[] args) {
	    if (args.length == 0) {
	      System.out.println("Error: No filename given.");
	      System.out.println();
	      System.out.println("Usage: java TapangA12 filename");
	      System.out.println("If filename ends in .huff, will decompress.");
	      System.out.println("If filename does not end in .huff, will compress.");
	      return;
	    }
	    try {
	      String filename = args[0];
	      if (filename.endsWith(".huff")) {
	        Huffman.decompress(filename);
	      }else {
	        Huffman.compress(filename);
	      }
	    }catch (IOException e) {
	      System.err.println("Error: Could not complete: " + e.getMessage());
	    }
	  }
		//Main method ends.
}
