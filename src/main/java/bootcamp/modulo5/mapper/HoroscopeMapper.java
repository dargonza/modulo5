package bootcamp.modulo5.mapper;

import bootcamp.modulo5.model.Horoscope;
import bootcamp.modulo5.dto.HoroscopeResponseDTO;

import java.time.format.DateTimeFormatter;

public class HoroscopeMapper {


    // Convierte una entidad Horoscope a un HoroscopeResponseDto
    public static HoroscopeResponseDTO toDto(Horoscope horoscope) {
        return new HoroscopeResponseDTO(
                horoscope.getAnimal(),
                horoscope.getStartDate(),
                horoscope.getEndDate()
        );
    }
}
