package bootcamp.modulo5.dto;

/**
 * Clase que representa un DTO para el zodiaco chino
 * Contiene información básica de una persona y su animal del zodiaco chino
 */
public class ChineseZodiacDTO {
    // Atributos de la clase
    private String name;        // Nombre de la persona
    private String username;    // Nombre de usuario
    private String animal;      // Animal del zodiaco chino

    /**
     * Constructor por defecto
     */
    public ChineseZodiacDTO() {
    }

    /**
     * Constructor con parámetros
     * @param name Nombre de la persona
     * @param username Nombre de usuario
     * @param animal Animal del zodiaco chino
     */
    public ChineseZodiacDTO(String name, String username, String animal) {
        this.name = name;
        this.username = username;
        this.animal = animal;
    }

    /**
     * Obtiene el nombre de la persona
     * @return nombre de la persona
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre de la persona
     * @param name nuevo nombre
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
     * Obtiene el animal del zodiaco chino
     * @return animal del zodiaco
     */
    public String getAnimal() {
        return animal;
    }

    /**
     * Establece el animal del zodiaco chino
     * @param animal nuevo animal del zodiaco
     */
    public void setAnimal(String animal) {
        this.animal = animal;
    }

    /**
     * Método que convierte el objeto a String
     * @return representación en String del objeto
     */
    @Override
    public String toString() {
        return "ChineseZodiacDTO{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", animal='" + animal + '\'' +
                '}';
    }
}