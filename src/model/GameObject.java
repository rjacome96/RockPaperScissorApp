package model;

public abstract class GameObject implements Comparable<GameObject>{
	
	private final String name;
	private final String fileURL;
	
	public abstract boolean equals(Object o);

	public GameObject(String name, String fileURL) {
		this.name = name;
		this.fileURL = fileURL;
	}
	
	public String getName() {
		return name;
	}

	public String getFileURL() {
		return fileURL;
	}

}
