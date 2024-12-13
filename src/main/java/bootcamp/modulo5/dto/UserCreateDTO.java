package bootcamp.modulo5.dto;

public class UserCreateDTO {
    private String name;
    private String username;
    private String email;
    private String password;
    private String birthDate;

    public UserCreateDTO() {
    }

    public UserCreateDTO(String name, String username, String email, String password, String birthDate) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
