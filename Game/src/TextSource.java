
import java.awt.Component;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


//텍스트를 제공해줌
public class TextSource {
	private Vector<String> wordVector = new Vector<String>(30000); //문자를 저장
	
	public TextSource(Component parent) {
		try {
			Scanner scanner = new Scanner(new FileReader("words.txt"));
			while(scanner.hasNext()) {
				String word = scanner.nextLine();
				wordVector.add(word);
				
			}
			scanner.close(); //닫아 줘야함
			//몇개가 읽혀졌는지 다이얼로그(책 769p)
			//JOptionPane.showMessageDialog(parent,"word read complete"); //(componet)parent의 중앙에 뜸 frame에 중앙에뜸
			
			
		} catch (FileNotFoundException e) {
			System.out.print("no File");
			System.exit(0);
			
		}
	}
	public String next() {
		int n = wordVector.size();
		int index = (int)(Math.random()*n);
		return wordVector.get(index);
	}
	
	
 
}
