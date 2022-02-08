package ir.bourna.form.Entities;

import javax.persistence.*;

@Entity
@Table(name = "companyentity")
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "partnerid")
    private int partnerid;

    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "workexp")
    private String workexp;
    @Column(name = "supportdes")
    private String supportdes;
    @Column(name = "hourdes")
    private String hourdes;

    public int getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(int partnerid) {
        this.partnerid = partnerid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWorkexp() {
        return workexp;
    }

    public void setWorkexp(String workexp) {
        this.workexp = workexp;
    }

    public String getSupportdes() {
        return supportdes;
    }

    public void setSupportdes(String supportdes) {
        this.supportdes = supportdes;
    }

    public String getHourdes() {
        return hourdes;
    }

    public void setHourdes(String hourdes) {
        this.hourdes = hourdes;
    }
}
