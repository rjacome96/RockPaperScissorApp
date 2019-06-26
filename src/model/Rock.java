package model;

public class Rock extends GameObject {
	
	private static final Rock rockObject = new Rock();
	
	private Rock() {
		super("Rock", "File:gameImages/RockClipArt.png");
	}
	
	public static Rock getRockObject() {
		return rockObject;
	}

	@Override
	public int compareTo(GameObject o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean equals(Object o) {
		if(o == null || !(o instanceof Rock)) {
			return false;
		}
		
		Rock rockObj = (Rock)o;
		
		return rockObj==this ? true : false;
		
	}

}
