package ir.bourna.form.Entities;

import javax.persistence.*;

@Entity
@Table(name = "projectentity")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "activitydomain")
    private String activitydomain;

    @Column(name = "disabled")
    private boolean disabled;

    @Column(name = "partnerid")
    private int partnerid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public int getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(int partnerid) {
        this.partnerid = partnerid;
    }
}
