package bootcamp.modulo5.dto;

import java.time.LocalDate;

public class HoroscopeResponseDTO {
    private String animal;
    private LocalDate startDate;
    private LocalDate endDate;

    public HoroscopeResponseDTO() {
    }

    public HoroscopeResponseDTO(String animal, LocalDate startDate, LocalDate endDate) {
        this.animal = animal;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "HoroscopeResponseDTO{" +
                "animal='" + animal + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
