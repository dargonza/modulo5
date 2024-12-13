package bootcamp.modulo5.dto;

public class UserResponseDTO {
    private int id;
    private String name;
    private String username;
    private String email;
    private String birthDate;
    private String animal;

    public UserResponseDTO() {
    }


    public UserResponseDTO(int id, String name, String username, String birthDate, String email, String animal) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.birthDate = birthDate;
        this.email = email;
        this.animal = animal;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }
}