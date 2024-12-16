package bootcamp.modulo5.dto;

import java.time.LocalDate;

/**
 * Clase DTO (Data Transfer Object) para la creación de usuarios.
 * Esta clase se utiliza para transferir datos de usuario entre diferentes capas de la aplicación.
 */
public class UserCreateDTO {
    // Atributos básicos del usuario
    private String name;        // Nombre completo del usuario
    private String username;    // Nombre de usuario para el sistema
    private String email;       // Correo electrónico del usuario
    private String password;    // Contraseña del usuario
    private LocalDate birthDate;// Fecha de nacimiento del usuario
    private String animal;      // Animal favorito del usuario (información adicional)

    /**
     * Constructor por defecto
     */
    public UserCreateDTO() {
    }

    /**
     * Constructor con todos los campos
     * @param name Nombre completo del usuario
     * @param username Nombre de usuario para el sistema
     * @param email Correo electrónico del usuario
     * @param password Contraseña del usuario
     * @param birthDate Fecha de nacimiento del usuario
     * @param animal Animal favorito del usuario
     */
    public UserCreateDTO(String name, String username, String email, String password, LocalDate birthDate, String animal) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.animal = animal;
    }

    // Métodos getter y setter para cada atributo
    /**
     * Obtiene el nombre del usuario
     * @return nombre del usuario
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del usuario
     * @param name nombre a establecer
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene el nombre de usuario
     * @return nombre de usuario
     */
    public String getUsername() {
        return username;
    }

    /**
     * Establece el nombre de usuario
     * @param username nombre de usuario a establecer
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtiene el correo electrónico
     * @return correo electrónico
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico
     * @param email correo electrónico a establecer
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la contraseña
     * @return contraseña del usuario
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña
     * @param password contraseña a establecer
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Obtiene la fecha de nacimiento
     * @return fecha de nacimiento
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Establece la fecha de nacimiento
     * @param birthDate fecha de nacimiento a establecer
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Obtiene el animal favorito
     * @return animal favorito
     */
    public String getAnimal() {
        return animal;
    }

    /**
     * Establece el animal favorito
     * @param animal animal favorito a establecer
     */
    public void setAnimal(String animal) {
        this.animal = animal;
    }

    /**
     * Método toString para representación en cadena del objeto
     * @return representación en cadena del objeto UserCreateDTO
     */
    @Override
    public String toString() {
        return "UserCreateDTO{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", birthDate=" + birthDate +
                ", animal='" + animal + '\'' +
                '}';
    }
}
