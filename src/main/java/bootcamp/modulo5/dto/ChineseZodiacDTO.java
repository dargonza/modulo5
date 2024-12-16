package bootcamp.modulo5.dto;

public class ChineseZodiacDTO {
    private String name;
    private String username;
    private String animal;

    public ChineseZodiacDTO() {
    }

    public ChineseZodiacDTO(String name, String username, String animal) {
        this.name = name;
        this.username = username;
        this.animal = animal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "ChineseZodiacDTO{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", animal='" + animal + '\'' +
                '}';
    }
}