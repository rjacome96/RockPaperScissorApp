package model;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Scissor extends GameObject {
	
	private static Scissor scissorObject = new Scissor();
	
	private static final List<GameObject> winsAgainst = Arrays.asList(Paper.getPaperObject());
	private static final List<GameObject> losesAgainst = Arrays.asList(Rock.getRockObject());

	private Scissor() {
		super("Scissor", "File:gameImages/ScissorClipArt.png");
	}
	
	public static Scissor getScissorObject() {
		return scissorObject;
	}
	
	@Override
	public int compareTo(GameObject o) {
		// check if it is a draw
		if(o.equals(this)) {
			return 0;
		}
				
		Iterator<GameObject> iter = winsAgainst.iterator();
		// check if Scissor wins against this object
		while(iter.hasNext()) {
			if(o.equals(iter.next())) {
				return 1;
			}
		}
		
		iter = losesAgainst.iterator();
		// check if Scissor loses to this object
		while(iter.hasNext()) {
			if(o.equals(iter.next())) {
				return -1;
			}
		}
		
		throw new IllegalArgumentException(getName() + " was not found to either draw, win, or lose against " + o.getName());
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
