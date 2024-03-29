package model;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Rock extends GameObject {
	
	private static Rock rockObject = new Rock();
	
	private static final List<GameObject> winsAgainst = Arrays.asList(Scissor.getScissorObject());
	private static final List<GameObject> losesAgainst = Arrays.asList(Paper.getPaperObject());
	
	private Rock() {
		super("Rock", "File:gameImages/RockClipArt.png");
	}
	
	public static Rock getRockObject() {
		return rockObject;
	}

	@Override
	public int compareTo(GameObject o) {
		// check if it is a draw
		if(o.equals(this)) {
			return 0;
		}
		
		Iterator<GameObject> iter = winsAgainst.iterator();
		// check if Rock wins against this object
		while(iter.hasNext()) {
			if(o.equals(iter.next())) {
				return 1;
			}
		}
		
		iter = losesAgainst.iterator();
		// check if Rock loses to this object
		while(iter.hasNext()) {
			if(o.equals(iter.next())) {
				return -1;
			}
		}
		
		throw new IllegalArgumentException(getName() + " was not found to either draw, win, or lose against " + o.getName());
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
