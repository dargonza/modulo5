package bootcamp.modulo5.model;

import java.time.LocalDate;

/**
 * Clase que representa un horóscopo del zodiaco chino
 * Contiene información sobre el animal, y el período de fechas correspondiente
 */
public class Horoscope {

    // Atributos de la clase
    private int id;                // Identificador único del horóscopo
    private String animal;         // Animal del horóscopo chino
    private LocalDate startDate;   // Fecha de inicio del período
    private LocalDate endDate;     // Fecha de fin del período

    /**
     * Constructor por defecto
     * Inicializa un objeto Horoscope sin parámetros
     */
    public Horoscope() {
    }

    /**
     * Constructor con todos los parámetros
     * @param id Identificador único del horóscopo
     * @param animal Animal del horóscopo chino
     * @param startDate Fecha de inicio del período
     * @param endDate Fecha de fin del período
     */
    public Horoscope(int id, String animal, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.animal = animal;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Métodos getters y setters
    /**
     * Obtiene el ID del horóscopo
     * @return Identificador único del horóscopo
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del horóscopo
     * @param id Nuevo identificador único a establecer
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el animal del horóscopo
     * @return Nombre del animal del horóscopo chino
     */
    public String getAnimal() {
        return animal;
    }

    /**
     * Establece el animal del horóscopo
     * @param animal Nuevo nombre del animal a establecer
     */
    public void setAnimal(String animal) {
        this.animal = animal;
    }

    /**
     * Obtiene la fecha de inicio del período
     * @return Fecha que marca el inicio del período del horóscopo
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Establece la fecha de inicio del período
     * @param startDate Nueva fecha de inicio a establecer
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * Obtiene la fecha de fin del período
     * @return Fecha que marca el fin del período del horóscopo
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Establece la fecha de fin del período
     * @param endDate Nueva fecha de fin a establecer
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /**
     * Genera una representación en formato String del objeto Horoscope
     * @return Cadena que contiene todos los atributos del horóscopo formateados
     */
    @Override
    public String toString() {
        return "Horoscope{" +
                "id=" + id +
                ", animal='" + animal + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}