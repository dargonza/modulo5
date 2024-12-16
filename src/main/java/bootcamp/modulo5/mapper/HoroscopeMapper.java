package bootcamp.modulo5.mapper;

import bootcamp.modulo5.model.Horoscope;
import bootcamp.modulo5.dto.HoroscopeResponseDTO;

/**
 * Clase que maneja el mapeo entre entidades Horoscope y DTOs
 */
public class HoroscopeMapper {

    /**
     * Convierte una entidad Horoscope a un objeto HoroscopeResponseDTO
     *
     * @param horoscope Entidad Horoscope que se va a convertir
     * @return HoroscopeResponseDTO con los datos mapeados
     */
    public static HoroscopeResponseDTO toDto(Horoscope horoscope) {
        // Creación y retorno del DTO con los datos del horóscopo
        return new HoroscopeResponseDTO(
                horoscope.getAnimal(),      // Obtiene el animal del horóscopo
                horoscope.getStartDate(),   // Obtiene la fecha de inicio
                horoscope.getEndDate()      // Obtiene la fecha de fin
        );
    }
}
