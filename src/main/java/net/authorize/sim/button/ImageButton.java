package net.authorize.sim.button;

public class ImageButton extends Button {

	private String src;
	private int height;
	private int width;
	private int border = 0;
	private String alt = "";

	private ImageButton() {
		this.buttonType = ButtonType.IMAGE;
	}

	public static ImageButton createButton(String src, int width, int height, int border, String alt) {
		ImageButton button = new ImageButton();
		button.src = src;
		button.width = width;
		button.height = height;
		button.border = border;
		button.alt = alt;

		return button;
	}

	/**
	 * @return the src
	 */
	public String getSrc() {
		return src;
	}

	/**
	 * @param src the src to set
	 */
	public void setSrc(String src) {
		this.src = src;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the border
	 */
	public int getBorder() {
		return border;
	}

	/**
	 * @param border the border to set
	 */
	public void setBorder(int border) {
		this.border = border;
	}

	/**
	 * @return the alt
	 */
	public String getAlt() {
		return alt;
	}

	/**
	 * @param alt the alt to set
	 */
	public void setAlt(String alt) {
		this.alt = alt;
	}

}
