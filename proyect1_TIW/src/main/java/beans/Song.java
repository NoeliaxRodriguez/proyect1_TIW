package beans;

public class Song implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Song(String songName, int duration, String artist, int score) {
		super();
		this.songName = songName;
		this.duration = duration;
		this.artist = artist;
		this.score = score;
	}

	String songName;
	int duration;
	String artist;
	int score;

	public Song() {

	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
