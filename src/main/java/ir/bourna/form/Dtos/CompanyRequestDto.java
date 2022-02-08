package ir.bourna.form.Dtos;

public class CompanyRequestDto {
    private String name;
    private String phone;
    private String email;
    private String workexp;
    private String supportdes;
    private String hourdes;

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