import java.util.Scanner;

public class Word {
	private String myWord;
	private int size;
	private char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
	private char[] consonants = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z'};
	private int syllableType;
	
	//Constructors
	public Word(){
		myWord = "";
	}
	
	public Word(String gw){
		myWord = gw.toLowerCase();
	}
	
	//Member Functions
	
	public void setWord(String gw){
		myWord = gw;
	}

	public String getWord(){
		return myWord;
	}
	public int findLength(){
		return myWord.length();
	}
	
	public int findConsonants(){
		int numConsonants = 0;
		char[] myLtrs = findLetters();
		for(int i = 0; i < myWord.length(); i++){
			for(int j = 0; j < 19; j++){
				if(myLtrs[i] == consonants[j]){
					numConsonants++;
				}
			}
		}
		return numConsonants;
	}
	
	public int findVowels(){
		int numVowels = 0;
		char[] myLtrs = findLetters();
		for(int i = 0; i < myWord.length(); i++){
			for(int j = 0; j < 6; j++){
				if(myLtrs[i] == vowels[j]){
					numVowels++;
				}
			}
		}
		return numVowels;
	}
	public char[] findLetters(){
		char[] ltrs = new char[30];
		size = myWord.length();
		for(int i = 0; i < myWord.length(); i++){ 
			ltrs[i] = myWord.charAt(i);
		}
		ltrs[size + 1] = '|';
		return ltrs;
	}
	
	public int findSyllables(){
		char[] myLtrs = findLetters();
		int syllableCount = 0;
		boolean isDipthong = false;
		for(int i = 0; i < size; i++){
			isDipthong = false;
			if(myLtrs[i] == '|'){ 
				break; //Checks if at end of word
			}
			for(int j = 0; j < 6; j++){
				if(myLtrs[i] == vowels[j]){
					for(int k = 0; k < 6; k++){
						if(myLtrs[i + 1] == vowels[k]){		
							isDipthong = true;
						}
					}
					if(isDipthong == false){
						syllableCount++;
					}
				}
			}
		}
		if(syllableCount == 1){
			return syllableCount;
		}else if(myLtrs[size - 1] == 'e'){
			syllableCount--;
			return syllableCount;
		}else{
			return syllableCount;
		}
	}
	
	public String toString(){
		String str;
		str = 	"SYLLABLES: " + findSyllables() + '\n' +
				"LETTERS: " + findLength() + '\n' +
				"VOWELS: " + findVowels() + '\n' +
				"CONSONANTS: " + findConsonants();
		return str;
	}
}
