package net.authorize.sim.button;

public class TextButton extends Button {

	private String name = "submit_button";
	private String value = "Submit";
	private String cssClass = null;

	private TextButton() {
		this.buttonType = ButtonType.TEXT;
	}

	public static TextButton createButton(String name, String value) {
		TextButton button = new TextButton();
		button.name = name;
		button.value = value;

		return button;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the cssClass
	 */
	public String getCssClass() {
		return cssClass;
	}

	/**
	 * @param cssClass the cssClass to set
	 */
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

}
