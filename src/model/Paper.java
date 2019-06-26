package model;

public class Paper extends GameObject {
	
	private static final Paper paperObject = new Paper();
	
	private Paper() {
		super("Paper", "File:gameImages/PaperClipArt.png");
	}
	
	public static Paper getPaperObject() {
		return paperObject;
	}

	@Override
	public int compareTo(GameObject o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean equals(Object o) {
		if(o == null || !(o instanceof Paper)) {
			return false;
		}
		
		Paper paperObj = (Paper)o;
		
		return paperObj==this ? true : false;
	}

}
