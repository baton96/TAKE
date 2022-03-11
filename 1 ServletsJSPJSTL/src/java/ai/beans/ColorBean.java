package ai.beans;

public class ColorBean {

    private String foregroundColor;
    private String backgroundColor;
    private String showMembers;

    public ColorBean() {
    }

    /**
     * @return the foregroundColor
     */
    public String getForegroundColor() {
        return foregroundColor;
    }

    /**
     * @param foregroundColor the foregroundColor to set
     */
    public void setForegroundColor(String foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    /**
     * @return the backgroundColor
     */
    public String getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * @param backgroundColor the backgroundColor to set
     */
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * @return the showMembers
     */
    public String getShowMembers() {
        return showMembers;
    }

    /**
     * @param showMembers the showMembers to set
     */
    public void setShowMembers(String showMembers) {
        this.showMembers = showMembers;
    }
}
