package bootcamp.modulo5.dto;

import java.time.LocalDate;

/**
 * Clase DTO (Data Transfer Object) para la respuesta de usuarios
 * Esta clase se utiliza para transferir datos de usuario entre diferentes capas de la aplicación
 */
public class UserResponseDTO {
    // Atributos de la clase
    private int id;                 // Identificador único del usuario
    private String name;            // Nombre completo del usuario
    private String username;        // Nombre de usuario para el sistema
    private String email;           // Correo electrónico del usuario
    private LocalDate birthDate;    // Fecha de nacimiento del usuario
    private String animal;          // Animal favorito del usuario

    /**
     * Constructor por defecto
     */
    public UserResponseDTO() {
    }

    /**
     * Constructor con todos los parámetros
     * @param id Identificador único del usuario
     * @param name Nombre completo del usuario
     * @param username Nombre de usuario para el sistema
     * @param birthDate Fecha de nacimiento del usuario
     * @param email Correo electrónico del usuario
     * @param animal Animal favorito del usuario
     */
    public UserResponseDTO(int id, String name, String username, LocalDate birthDate, String email, String animal) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.birthDate = birthDate;
        this.email = email;
        this.animal = animal;
    }

    // Métodos getter y setter
    /**
     * Obtiene el ID del usuario
     * @return id del usuario
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del usuario
     * @param id nuevo id del usuario
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del usuario
     * @return nombre del usuario
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del usuario
     * @param name nuevo nombre del usuario
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
     * @param username nuevo nombre de usuario
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtiene el email del usuario
     * @return email del usuario
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el email del usuario
     * @param email nuevo email del usuario
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la fecha de nacimiento del usuario
     * @return fecha de nacimiento del usuario
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Establece la fecha de nacimiento del usuario
     * @param birthDate nueva fecha de nacimiento del usuario
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Obtiene el animal favorito del usuario
     * @return animal favorito del usuario
     */
    public String getAnimal() {
        return animal;
    }

    /**
     * Establece el animal favorito del usuario
     * @param animal nuevo animal favorito del usuario
     */
    public void setAnimal(String animal) {
        this.animal = animal;
    }

    /**
     * Método que convierte el objeto a String
     * @return representación en String del objeto UserResponseDTO
     */
    @Override
    public String toString() {
        return "UserResponseDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", animal='" + animal + '\'' +
                '}';
    }
}