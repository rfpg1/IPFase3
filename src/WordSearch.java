import java.util.concurrent.TimeUnit;

public class WordSearch {
	private Puzzle puzzle;
	private int meanTime;
	private int wordPoints;
	private int durationInSeconds;
	private int howManyFoundWords;
	private String[] foundWords;
	private int score;
	private boolean isFinished;
	private long timeStart;
	private long timeSinceLastWord;

	public WordSearch(Puzzle puzzle, int durationInSeconds) {
		this.durationInSeconds = durationInSeconds;
		this.puzzle = puzzle;
		howManyFoundWords = 0;
		foundWords = new String[puzzle.numberHiddenWords()];
		score = 0;
		isFinished = false;
		timeStart = System.currentTimeMillis();
		timeSinceLastWord = System.currentTimeMillis();
		wordPoints = this.puzzle.rows() * this.puzzle.columns() / 10;
		meanTime = duration() / this.puzzle.numberHiddenWords();
	}	

	public int duration() {
		return durationInSeconds;
	}

	public Puzzle puzzle() {
		return puzzle;
	}
	
	public boolean play(Move move) {
		if(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - timeStart) > durationInSeconds) {
			isFinished = true;
			return false;
		}
		String word = puzzle.getWord(move);
		if(word != null && notFound(word)) {
			foundWords[howManyFoundWords] = word;
			howManyFoundWords++;
		}
		if(howManyFoundWords == foundWords.length) {
			isFinished = true;
			return true; //?
		}
		if(timeSinceLastWord >= meanTime) {
			score += wordPoints;
		} else {
			score += (1+ meanTime - timeSinceLastWord) * wordPoints;
		}
		timeSinceLastWord = System.currentTimeMillis();

		return true; //?

	}
 

	private boolean notFound(String word) {
		for (int i = 0; i < howManyFoundWords; i++) {
			if(foundWords[i].equals(word)) {
				return false;
			}
		}
		return true;
	}

	public int howManyFoundWords() {
		return howManyFoundWords;
	}
	
	public String[] foundWords(){
		String[] foundWords = new String[howManyFoundWords];
		for(int i = 0; i < howManyFoundWords; i++ ){
			foundWords[i] = this.foundWords[i];
		}

		return foundWords;
	}

	public int score() {
		return score;
	}

	public boolean isFinished() {
		return isFinished;
	}

	@Override
	public String toString() {
		return "PUZZLE";
	}

}
 
/*
public class WordSearch{

	private Puzzle puzzle;
	private int durationInSeconds;
	private int howManyFoundWords;
	private String[] foundWords;
	private int score;
	private boolean isFinished;
	private long timeStart;
	private long timeSinceLastWord;
	private int wordPoints;
	private int meanTime;

	
	public WordSearch(Puzzle puzzle, int durationInSeconds ){
		this.puzzle = puzzle;
		this.durationInSeconds = durationInSeconds;
		howManyFoundWords = 0;
		foundWords = new String[puzzle.numberHiddenWords()];
		score = 0;
		isFinished = false;
		timeStart = System.currentTimeMillis();
		timeSinceLastWord = System.currentTimeMillis();
		wordPoints = this.puzzle.rows() * this.puzzle.columns() / 10;
		meanTime = duration() / this.puzzle.numberHiddenWords();
	}

	public Puzzle puzzle(){
		return puzzle;
	}

	public int duration(){
		return durationInSeconds;
	}

	public int howManyFoundWords(){
		return howManyFoundWords;
	}

	public String[] foundWords(){
		String[] foundWords = new String[howManyFoundWords];
		for(int i = 0; i < howManyFoundWords; i++ ){
			foundWords[i] = this.foundWords[i];
		}

		return foundWords;
	}

	
	public int score(){
		return score;
	}

	
	public boolean isFinished(){
		return isFinished;
	}

	public boolean play(Move move){

		boolean playable = true;

		if(  System.currentTimeMillis() / 1000 - timeStart / 1000 > durationInSeconds ){
			isFinished = true;
			playable = false;
		} else if ( howManyFoundWords == puzzle.numberHiddenWords() ){
			isFinished = true;
			playable = false;
		} else {
			if ( puzzle.getWord(move) != null ){
				foundWords[howManyFoundWords] = puzzle.getWord(move);
				for(int i = 0; i < foundWords.length; i++ ){
					if ( i != howManyFoundWords){
						if ( foundWords[howManyFoundWords] == foundWords[i] ){
							playable = false;
							foundWords[howManyFoundWords] = null;
						}
					}
				}
				
				if(playable == true){
					howManyFoundWords++;
					if ( howManyFoundWords == puzzle.numberHiddenWords() ){
						isFinished = true;
						playable = false;
					} 
					if( timeSinceLastWord >= meanTime  ){
						score += wordPoints;
					} else {
						score += (1 + meanTime - timeSinceLastWord ) * wordPoints;
					}
					timeSinceLastWord = System.currentTimeMillis() - timeSinceLastWord;
				}
			} else {
				playable = false;
			}

		}

		return playable;

	}
	

}
*/
