package guru.springframework.sfgpetclinic.Model;

public class Speciality extends  BaseEntity{
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
