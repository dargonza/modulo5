package bootcamp.modulo5.service;

import java.time.LocalDate;

/**
 * Interfaz que define los servicios relacionados con el horóscopo.
 * Esta interfaz proporciona métodos para obtener información zodiacal.
 */
public interface HoroscopeService {

    /**
     * Obtiene el animal del zodiaco chino basado en la fecha de nacimiento.
     *
     * @param birthDate Fecha de nacimiento para calcular el animal del zodiaco chino
     * @return String que representa el animal del zodiaco chino correspondiente
     */
    String getChineseZodiacAnimal(LocalDate birthDate);
}
