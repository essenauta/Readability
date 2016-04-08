import java.util.ArrayList;

public class FleschKincaid {

	//206.835 - 1.015(totalwords/totalsentences) - 84.6(totalsyllables/totalwords)
	private String myReading;
	
	public FleschKincaid(String choice){
		
	}
	public FleschKincaid(int choice){
		if(choice == 1){
			myReading = "Four score and seven years ago our fathers brought forth on this "
						+ "continent a new nation, conceived in liberty and dedicated to the "
						+ "proposition that all men are created equal. Now we are engaged in "
						+ "a great civil war, testing whether that nation or any nation so "
						+ "conceived and so dedicated can long endure. We are met on a great "
						+ "battlefield of that war. We have come to dedicate a portion of "
						+ "that field as a final resting-place for those who here gave their "
						+ "lives that that nation might live. It is altogether fitting and "
						+ "proper that we should do this. But in a larger sense, we cannot "
						+ "dedicate, we cannot consecrate, we cannot hallow this ground. "
						+ "The brave men, living and dead who struggled here have consecrated "
						+ "it far above our poor power to add or detract. The world will "
						+ "little note nor long remember what we say here, but it can never "
						+ "forget what they did here. It is for us the living rather to be "
						+ "dedicated here to the unfinished work which they who fought here "
						+ "have thus far so nobly advanced. It is rather for us to be here "
						+ "dedicated to the great task remaining before us that from these "
						+ "honored dead we take increased devotion to that cause for which "
						+ "they gave the last full measure of devotion that we here highly "
						+ "resolve that these dead shall not have died in vain, that this "
						+ "nation under God shall have a new birth of freedom, and that "
						+ "government of the people, by the people, for the people shall "
						+ "not perish from the earth." + "|";
		}else if(choice == 2){
			myReading = "Flesch invented an index to check whether a text is easy to read. To compute the index, you need not look at the meaning of the words.";
		}else {
			myReading = "The following index was invented by Flesch as a simple tool to estimate the legibility of a document without linguistic analysis.";
		}
	}
	
	public int findWords(){
		int i = 1;
		int totalWords = 0;
		do{
			if(myReading.charAt(i) == ' '){
				totalWords++;
			}
			i++;
		}while(i != myReading.length());
		return totalWords;
	}
	
	public ArrayList<String> findArrayWords(){
		ArrayList<String> listWords = new ArrayList<String>();
		String temp = "";
		int wordStart = 0;
		for(int i = 0; i < myReading.length(); i++){
				if(myReading.charAt(i) == ' '||myReading.charAt(i) == '|'){
					temp = myReading.substring(wordStart, i);
					if(temp.charAt(temp.length() - 1) == ',' ||  temp.charAt(temp.length() - 1) == '.' || temp.charAt(temp.length() - 1) == '!'){
						temp = removeLastChar(temp);
					}	
					listWords.add(temp);
					wordStart = i + 1;
				}
		}
		return listWords;
	}
	
	public int findSentences(){
		int totalSentences = 0;
		for(int i = 0; i < myReading.length(); i++){
			if(myReading.charAt(i) == '.' || myReading.charAt(i) == '!' || myReading.charAt(i) == '?'){
				totalSentences++;
			}
		}
		return totalSentences;
	}
	
	public int findSyllables(){
		int totalSyllables = 0;
		Word checkWord = new Word();
		ArrayList<String> listWords = new ArrayList<String>();
		listWords = findArrayWords();
		for(int i = 0; i < findArrayWords().size(); i++){
			
			checkWord.setWord(listWords.get(i));
			totalSyllables += checkWord.findSyllables();
		}
		return totalSyllables;
	}
	
	public double findScore(){
		double score = 0;
		score = 206.835 - 1.015 * ((double)findWords()/(double)findSentences()) - 84.6 *((double)findSyllables()/(double)findWords());
		return score;
	}
	
	public String findGrade(){
		String grade = "";
		int score = (int) findScore();
		if(score >= 90){grade = "5th";}
		else if(score >= 80){grade = "6th";}
		else if(score >= 70){grade = "7th";}
		else if(score >= 60){grade = "8th & 9th";}
		else if(score >= 50){grade = "10th to 12th";}
		else if(score >= 30){grade = "College";}
		else if(score < 30){grade = "College Graduate";}
		return grade;
	}
    private static String removeLastChar(String str) {
        return str.substring(0,str.length()-1);
    }
}
