package bootcamp.modulo5.dto;

import java.time.LocalDate;

/**
 * Clase que representa la respuesta del horóscopo chino
 * Contiene información sobre el animal del horóscopo y sus fechas correspondientes
 */
public class HoroscopeResponseDTO {
    // Atributos de la clase
    private String animal;        // Nombre del animal del horóscopo
    private LocalDate startDate;  // Fecha de inicio del período
    private LocalDate endDate;    // Fecha de fin del período

    /**
     * Constructor por defecto
     */
    public HoroscopeResponseDTO() {
    }

    /**
     * Constructor con parámetros
     * @param animal Nombre del animal del horóscopo
     * @param startDate Fecha de inicio del período
     * @param endDate Fecha de fin del período
     */
    public HoroscopeResponseDTO(String animal, LocalDate startDate, LocalDate endDate) {
        this.animal = animal;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // Métodos getter y setter

    /**
     * Obtiene el nombre del animal del horóscopo
     * @return String con el nombre del animal
     */
    public String getAnimal() {
        return animal;
    }

    /**
     * Establece el nombre del animal del horóscopo
     * @param animal Nombre del animal a establecer
     */
    public void setAnimal(String animal) {
        this.animal = animal;
    }

    /**
     * Obtiene la fecha de inicio del período
     * @return LocalDate con la fecha de inicio
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Establece la fecha de inicio del período
     * @param startDate Fecha de inicio a establecer
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * Obtiene la fecha de fin del período
     * @return LocalDate con la fecha de fin
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Establece la fecha de fin del período
     * @param endDate Fecha de fin a establecer
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /**
     * Método que genera una representación en cadena del objeto
     * @return String con la representación del objeto
     */
    @Override
    public String toString() {
        return "HoroscopeResponseDTO{" +
                "animal='" + animal + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
