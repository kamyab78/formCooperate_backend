package ir.bourna.form.Dtos;

public class ProjectRequestDto {
    private String title;
    private String description;
    private String activitydomain;
    private int partnerid;
    private boolean disabled;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActivitydomain() {
        return activitydomain;
    }

    public void setActivitydomain(String activitydomain) {
        this.activitydomain = activitydomain;
    }

    public int getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(int partnerid) {
        this.partnerid = partnerid;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }
}
