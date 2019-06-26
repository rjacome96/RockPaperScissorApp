package model;

public abstract class GameObject implements Comparable<GameObject>{
	
	private String name;
	private String fileURL;
	
	public abstract boolean equals(Object o);

	public String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	public String getFileURL() {
		return fileURL;
	}

	protected void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}

}
