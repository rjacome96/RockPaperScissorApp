package model;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Paper extends GameObject {
	
	private static final Paper paperObject = new Paper();
	private final List<GameObject> winsAgainst = Arrays.asList(Rock.getRockObject());
	private final List<GameObject> losesAgainst = Arrays.asList(Scissor.getScissorObject());
	
	private Paper() {
		super("Paper", "File:gameImages/PaperClipArt.png");
	}
	
	public static Paper getPaperObject() {
		return paperObject;
	}

	@Override
	public int compareTo(GameObject o) {
		// check if it is a draw
		if(o.equals(this)) {
			return 0;
		}
		
		Iterator<GameObject> iter = winsAgainst.iterator();
		// check if Paper wins against this object
		while(iter.hasNext()) {
			if(o.equals(iter.next())) {
				return 1;
			}
		}
		
		iter = losesAgainst.iterator();
		// check if Paper loses to this object
		while(iter.hasNext()) {
			if(o.equals(iter.next())) {
				return 0;
			}
		}
		
		throw new IllegalArgumentException("Game Object was not found to either draw, win, or lose against " + getName());
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
