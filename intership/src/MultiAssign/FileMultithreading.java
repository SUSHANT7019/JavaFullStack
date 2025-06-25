package MultiAssign;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*3) write local class to get second line from file and save it in another file (before save string, make
sure it must encode)

*
*
*
*
*OUTPUT
in ABC.txt 

HII 
SUSHANT
 
in XYZ.txt

WQWLEJP

 
 
}
 
 
*/
public class FileMultithreading {
	

	public static void main(String[] args) {
		Files f = new Files();
		
		Runnable r = ()->{
			try {
				f.files();
			} catch (IOException e) {
				e.printStackTrace();
			}
		};
		
		Thread t1 = new Thread(r,"");
		t1.start();
	}
}


class Files {
	 
	public static String encode(String input, int key) {
	    StringBuilder output = new StringBuilder();
	    for (int i = 0; i < input.length(); i++) {
	        char c = input.charAt(i);
	        c = (char) (c ^ key);
	        output.append(c);
	    }
	    return output.toString();
	}
	
	public synchronized void files() throws IOException {
		File f = new File("ABC.txt");
		if (f.createNewFile()) {
			FileWriter fw = new FileWriter("ABC.txt");
			fw.write("HI \nSUSHANT");
			fw.close();
		}
		
		
		File f2 = new File("XYZ.txt");
		f2.createNewFile();
		BufferedReader br = new BufferedReader(new FileReader("ABC.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("XYZ.txt"));
		String line;
		int i=1;
		while ((line = br.readLine()) != null) {

			if(i==2) {
				String enStr = encode(line,4);
				bw.write(enStr);
				bw.newLine();
			}

			i++;

		}
		br.close();
		bw.close();
		
	}
}



