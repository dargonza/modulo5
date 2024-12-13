package bootcamp.modulo5.model;

import java.time.LocalDate;
 /**
 * Clase que representa un horóscopo con su animal y fechas correspondientes
 */
public class Horoscope {
    /** Identificador único del horóscopo */
    private int id;
    /** Animal del horóscopo */
    private String animal;
    /** Fecha de inicio del período del horóscopo */
    private LocalDate startDate;
    /** Fecha de fin del período del horóscopo */
    private LocalDate endDate;

    /**
     * Constructor por defecto
     */
    public Horoscope() {
    }

    /**
     * Constructor con todos los parámetros
     * @param id Identificador único del horóscopo
     * @param animal Animal del horóscopo
     * @param startDate Fecha de inicio del período
     * @param endDate Fecha de fin del período
     */
    public Horoscope(int id, String animal, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.animal = animal;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Getters and Setters
    /**
     * Obtiene el ID del horóscopo
     * @return id del horóscopo
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del horóscopo
     * @param id nuevo id a establecer
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el animal del horóscopo
     * @return animal del horóscopo
     */
    public String getAnimal() {
        return animal;
    }

    /**
     * Establece el animal del horóscopo
     * @param animal nuevo animal a establecer
     */
    public void setAnimal(String animal) {
        this.animal = animal;
    }

    /**
     * Obtiene la fecha de inicio del período
     * @return fecha de inicio
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Establece la fecha de inicio del período
     * @param startDate nueva fecha de inicio
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * Obtiene la fecha de fin del período
     * @return fecha de fin
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Establece la fecha de fin del período
     * @param endDate nueva fecha de fin
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /**
      * Devuelve una representación en cadena del objeto Horoscope
      * @return cadena que representa el objeto con sus atributos
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
