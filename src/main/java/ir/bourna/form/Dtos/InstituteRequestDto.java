package ir.bourna.form.Dtos;

public class InstituteRequestDto {
    private String name;
    private String lastname;
    private String phone;
    private String email;
    private String degree;
    private String workexp;
    private String supportdes;
    private String hourdes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
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