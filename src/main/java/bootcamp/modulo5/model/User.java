package bootcamp.modulo5.model;

import java.time.LocalDate;

/**
 * Clase que representa un usuario en el sistema.
 * Esta clase contiene toda la información personal y credenciales de un usuario.
 */
public class User {
    // Atributos principales del usuario
    private int id;                 // Identificador único
    private String name;            // Nombre completo
    private String username;        // Nombre de usuario para login
    private String email;           // Correo electrónico
    private LocalDate birthDate;    // Fecha de nacimiento
    private String password;        // Contraseña
    private String animal;          // Animal favorito

    /**
     * Constructor por defecto.
     * Inicializa un nuevo usuario sin datos.
     */
    public User() {
    }

    /**
     * Constructor completo que inicializa todos los atributos del usuario.
     *
     * @param id Identificador único del usuario
     * @param name Nombre completo del usuario
     * @param username Nombre de usuario para el sistema
     * @param email Dirección de correo electrónico
     * @param birthDate Fecha de nacimiento
     * @param password Contraseña de acceso
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

    // Métodos de acceso (Getters y Setters)

    /**
     * Obtiene el identificador único del usuario.
     * @return Identificador del usuario
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único del usuario.
     * @param id Nuevo identificador a asignar
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre completo del usuario.
     * @return Nombre completo del usuario
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre completo del usuario.
     * @param name Nuevo nombre a asignar
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene el nombre de usuario del sistema.
     * @return Nombre de usuario para login
     */
    public String getUsername() {
        return username;
    }

    /**
     * Establece el nombre de usuario del sistema.
     * @param username Nuevo nombre de usuario a asignar
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     * @return Dirección de correo electrónico
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del usuario.
     * @param email Nueva dirección de correo a asignar
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la fecha de nacimiento del usuario.
     * @return Fecha de nacimiento
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Establece la fecha de nacimiento del usuario.
     * @param birthDate Nueva fecha de nacimiento a asignar
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Obtiene la contraseña del usuario.
     * @return Contraseña actual del usuario
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del usuario.
     * @param password Nueva contraseña a asignar
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Obtiene el animal favorito del usuario.
     * @return Animal favorito del usuario
     */
    public String getAnimal() {
        return animal;
    }

    /**
     * Establece el animal favorito del usuario.
     * @param animal Nuevo animal favorito a asignar
     */
    public void setAnimal(String animal) {
        this.animal = animal;
    }

    /**
     * Genera una representación en formato String de todos los datos del usuario.
     * Este método es útil para depuración y registro.
     *
     * @return Cadena con todos los atributos del usuario
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