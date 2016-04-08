import java.util.Scanner;
import java.util.ArrayList;

public class Driver {
	public static void main(String [] args){
	double isRunning = 1; 
	do{
		
		Scanner reader = new Scanner(System.in);
		ArrayList<String> test = new ArrayList<String>();
		System.out.println('\n' + "READABILITY");
		System.out.println("SELECT READING" + '\n');
		int choice = reader.nextInt();
		FleschKincaid readingFS = new FleschKincaid(choice);
		AutomatedReadabilityIndex readingARI = new AutomatedReadabilityIndex(choice);
		System.out.println('\n' + "FLESCHKINCAID");
		System.out.println("SCORE: " + readingFS.findScore());
		System.out.println("SENTENCES: " + readingFS.findSentences());
		System.out.println("SYLLABLES: " + readingFS.findSyllables());
		System.out.println("WORDS: " + readingFS.findWords());
		System.out.println("GRADE: " + readingFS.findGrade());
		System.out.println('\n' + "AutomatedReadabilityIndex");
		System.out.println("SCORE: " + readingARI.findScore());
		System.out.println("SENTENCES: " + readingARI.findSentences());
		System.out.println("CHARACTERS: " + readingARI.findCharacters());
		System.out.println("WORDS: " + readingARI.findWords());
		System.out.println("GRADE: " + readingARI.findGrade());
		System.out.print('\n' + "RUN AGAIN?");
		isRunning = reader.nextDouble();
	}while(isRunning == 1);
	}
}
