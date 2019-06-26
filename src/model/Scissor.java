package model;

public class Scissor extends GameObject {
	
	private static final Scissor scissorObject = new Scissor();

	private Scissor() {
		super("Scissor", "File:gameImages/ScissorClipArt.png");
	}
	
	public static Scissor getScissorObject() {
		return scissorObject;
	}
	
	@Override
	public int compareTo(GameObject o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean equals(Object o) {
		if(o == null || !(o instanceof Scissor)) {
			return false;
		}
		
		Scissor scissorObj = (Scissor)o;
		
		return scissorObj==this ? true : false;
	}

}
