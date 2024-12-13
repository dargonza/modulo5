package bootcamp.modulo5.model;

import java.time.LocalDate;

/**
 * Clase que representa un usuario en el sistema.
 */
public class User {
    /** ID único del usuario */
    private int id;
    /** Nombre completo del usuario */
    private String name;
    /** Nombre de usuario para el login */
    private String username;
    /** Correo electrónico del usuario */
    private String email;
    /** Fecha de nacimiento del usuario */
    private LocalDate birthDate;
    /** Contraseña del usuario */
    private String password;
    /** Animal favorito del usuario */
    private String animal;

    /**
     * Constructor por defecto
     */
    public User() {
    }

    /**
     * Constructor con todos los campos
     * @param id ID único del usuario
     * @param name Nombre completo del usuario
     * @param username Nombre de usuario para el login
     * @param email Correo electrónico del usuario
     * @param birthDate Fecha de nacimiento del usuario
     * @param password Contraseña del usuario
     * @param animal Animal favorito del usuario
     */
    public User(int id, String name, String username, String email, LocalDate birthDate, String password, String animal) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.birthDate = birthDate;
        this.password = password;
        this.animal = animal;
    }

    // Getters and Setters
    /**
     * Obtiene el ID del usuario
     * @return ID del usuario
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del usuario
     * @param id ID a establecer
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del usuario
     * @return Nombre del usuario
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del usuario
     * @param name Nombre a establecer
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene el nombre de usuario
     * @return Nombre de usuario
     */
    public String getUsername() {
        return username;
    }

    /**
     * Establece el nombre de usuario
     * @param username Nombre de usuario a establecer
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtiene el email del usuario
     * @return Email del usuario
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el email del usuario
     * @param email Email a establecer
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la fecha de nacimiento del usuario
     * @return Fecha de nacimiento del usuario
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Establece la fecha de nacimiento del usuario
     * @param birthDate Fecha de nacimiento a establecer
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Obtiene la contraseña del usuario
     * @return Contraseña del usuario
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del usuario
     * @param password Contraseña a establecer
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Obtiene el animal favorito del usuario
     * @return Animal favorito del usuario
     */
    public String getAnimal() {
        return animal;
    }

    /**
     * Establece el animal favorito del usuario
     * @param animal Animal favorito a establecer
     */
    public void setAnimal(String animal) {
        this.animal = animal;
    }

    /**
     * Devuelve una representación en cadena del objeto User
     * @return Cadena que representa el objeto User con todos sus atributos
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", password='" + password + '\'' +
                ", animal='" + animal + '\'' +
                '}';
    }
}