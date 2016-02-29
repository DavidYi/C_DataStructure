package exceptions.classFiles;

public class Rectangle {
	private int length;
	private int width;
	
	public Rectangle (int length, int width)
	{
		this.length = length;
		this.width = width;
	}
	
	public int getArea ()
	{
		return length * width;
	}

	public int getPerimeter ()
	{
		return 2 * (length + width);
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		if (length < 0)
			throw new IllegalArgumentException("Length must be greater than 0.");

		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		if (width < 0)
			throw new IllegalArgumentException("Width must be greater than 0.");
		this.width = width;
	}
	

}
