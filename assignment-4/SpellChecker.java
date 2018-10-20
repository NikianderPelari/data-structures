/*
* Name:  Nikiander Pelari 
* Info:  Takes in two text arguments, dictionary and a file to be 
*        spell checked
*/

import java.util.*;
import java.io.*;


public class SpellChecker {

	
	public static final void main(String[] args){
		//Take file names from command line argument
		System.out.println("Dictionary file name: " + args[0]);
		System.out.println("Spellcheck target file name: " + args[1]);
		File dict = new File(args[0]);
		File text = new File(args[1]);
		Scanner readDict = null;
		Scanner readText = null;
				
		//In case the user inputs an invalid file - try/catch for both files
		try {
			readDict = new Scanner(dict);
			System.out.println("Dictionary text file successfully read.");		
		}
		catch(FileNotFoundException x){
			System.out.println("Reading failed - dictionary file might"
					+ " not exist.");
			System.exit(1);
		}
		try {
			readText = new Scanner(text);
			System.out.println("Spellcheck target file successfully read.");
		}
		catch(FileNotFoundException x){
			System.out.println("Reading failed - spellcheck target"
					+ " file might not exist.");
			System.exit(1);
		}

		//Read in entire dictionary into hashset
		HashSet dictset = new HashSet();
		while(readDict.hasNextLine()){
			String new1 = readDict.nextLine();
			String new2 = new1.toLowerCase();
			dictset.add(new2);
		}
			
		//Target file
		int lineIndex = 1;
		while(readText.hasNextLine()){
			String nextLine = readText.nextLine();
			//Check if line is empty. if it is, increment index & ignore
			if(nextLine.length()==0){
				lineIndex++;
				continue;
			}
			else{
				String line = nextLine.toLowerCase();
			    String[] lineA = line.split("\\s+");

			    for(String str : lineA){
					String str2 = str.replaceAll("[^A-z0-9]+$", "");
					String str3 = str2.replaceAll("^[^A-z0-9]+", "");

					if(!dictset.contains(str3)){
						System.out.println("Misspelled word: '" +
						str3 + "', at line number: "+ lineIndex);
						HashSet addsugset = new HashSet();
						HashSet remsugset = new HashSet();
						
						for(int j=0; j<=str3.length(); j++){
							for(int k=97;k<123;k++){
								StringBuilder addStr = new StringBuilder();
								addStr.append(str3);
								addStr.insert(j, (char)k);
								String finalStrA = addStr.toString();
								if(!addsugset.contains(finalStrA)
								&& dictset.contains(finalStrA)){
									addsugset.add(finalStrA);
									System.out.println("If you add a "
									+ "character at position " + j 
									+ ", you can get a valid word '" + 
									finalStrA + "'.");									
								}
							}
						}
						
						//Removal Check
						for(int n=0; n<str3.length(); n++){
							String remStr = str3.substring(0, n) + 
									str3.substring(n+1);
							if(dictset.contains(remStr)&&
							!remsugset.contains(remStr)){
								remsugset.add(remStr);
								System.out.println("If you remove the "
								+ "character at position " + n + ", you can "
								+ "get a valid word '" + remStr + "'.");
							}											
						}
						
						//Adjacent character swop check
						for(int y=0;y<str3.length()-1;y++){
							StringBuilder excStr = new StringBuilder();
							excStr.append(str3);
							char prev = str3.charAt(y);
							char next = str3.charAt(y+1);
							//swop here
							excStr.setCharAt(y, next);
							excStr.setCharAt(y+1, prev);
							String finalStrE = excStr.toString();
							if(dictset.contains(finalStrE)){
								System.out.println("If you swap the chars "
								+ "at positions " +y+" and "+(y+1)+
								", you can get a valid word '" + finalStrE
								+ "'.");
							}							
						}
					}
			    }
			    lineIndex++;
			}
		}
	
	System.out.println("End of output.");
	}
}
