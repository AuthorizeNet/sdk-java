package net.authorize.util;

public class SensitiveTag {
	
	public String tagName;
	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getReplacement() {
		return replacement;
	}

	public void setReplacement(String replacement) {
		this.replacement = replacement;
	}

	public boolean isDisableMask() {
		return disableMask;
	}

	public void setDisableMask(boolean disableMask) {
		this.disableMask = disableMask;
	}

	public String pattern;
	public String replacement;
	public boolean disableMask;
	
	public SensitiveTag(String tagName, String pattern, String replacement, boolean disableMask) {
		
		this.tagName = tagName;
		this.pattern = pattern;
		this.replacement = replacement;
		this.disableMask = disableMask;
	}
}

