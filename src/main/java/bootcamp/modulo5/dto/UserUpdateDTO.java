package bootcamp.modulo5.dto;

import java.time.LocalDate;

/**
 * Clase DTO (Data Transfer Object) para la actualización de usuarios
 * Esta clase se utiliza para transferir datos de usuario entre capas de la aplicación
 */
public class UserUpdateDTO {
    // Atributos principales del usuario
    private int id;
    private String name;
    private String username;
    private String email;
    private String password;
    private LocalDate birthDate;

    /**
     * Constructor por defecto
     */
    public UserUpdateDTO() {
    }

    /**
     * Constructor con todos los parámetros
     * @param id Identificador único del usuario
     * @param name Nombre completo del usuario
     * @param username Nombre de usuario para el sistema
     * @param email Correo electrónico del usuario
     * @param password Contraseña del usuario
     * @param birthDate Fecha de nacimiento del usuario
     */
    public UserUpdateDTO(int id, String name, String username, String email, String password, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
    }

    // Métodos getter y setter para cada atributo

    /**
     * Obtiene el ID del usuario
     * @return id del usuario
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del usuario
     * @param id nuevo id a establecer
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
     * @param name nuevo nombre a establecer
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
     * @param username nuevo nombre de usuario a establecer
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
     * @param email nuevo email a establecer
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
     * @param birthDate nueva fecha de nacimiento a establecer
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Obtiene la contraseña del usuario
     * @return contraseña del usuario
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del usuario
     * @param password nueva contraseña a establecer
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Método para convertir el objeto a String
     * @return representación en String del objeto UserUpdateDTO
     */
    @Override
    public String toString() {
        return "UserUpdateDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}