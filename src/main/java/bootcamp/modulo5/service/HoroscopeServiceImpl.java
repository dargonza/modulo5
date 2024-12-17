package bootcamp.modulo5.service;

import bootcamp.modulo5.model.Horoscope;
import bootcamp.modulo5.repository.HoroscopeRepository;
import bootcamp.modulo5.repository.HoroscopeRepositoryImpl;

import java.time.LocalDate;
import java.util.List;

/**
 * Implementación del servicio para el manejo del horóscopo chino.
 * Esta clase proporciona métodos para determinar el animal del zodíaco chino
 * basado en una fecha de nacimiento.
 */
public class HoroscopeServiceImpl implements HoroscopeService {

    // Repositorio para acceder a los datos del horóscopo
    private final HoroscopeRepository horoscopeRepository;

    /**
     * Constructor que inicializa el repositorio del horóscopo.
     */
    public HoroscopeServiceImpl() {
        this.horoscopeRepository = new HoroscopeRepositoryImpl();
    }

    /**
     * Obtiene el animal del zodíaco chino correspondiente a una fecha de nacimiento.
     * @param birthDate Fecha de nacimiento para calcular el signo
     * @return String con el nombre del animal del zodíaco chino, o null si no se encuentra
     */
    @Override
    public String getChineseZodiacAnimal(LocalDate birthDate) {
        // Obtener todos los signos del zodíaco chino
        List<Horoscope> chineseZodiacSigns = horoscopeRepository.findAll();
        Horoscope matchedZodiacSign = null;

        // Buscar el signo zodiacal que corresponde a la fecha de nacimiento
        for (Horoscope zodiacSign : chineseZodiacSigns) {
            // Verificar si la fecha está dentro del rango del signo
            if (birthDate.isAfter(zodiacSign.getStartDate()) && birthDate.isBefore(zodiacSign.getEndDate())) {
                matchedZodiacSign = zodiacSign;
                break;
            }
            // Verificar si la fecha coincide exactamente con los límites del rango
            else if (birthDate.isEqual(zodiacSign.getStartDate()) || birthDate.isEqual(zodiacSign.getEndDate())) {
                matchedZodiacSign = zodiacSign;
                break;
            }
        }

        // Retornar el animal correspondiente o null si no se encontró coincidencia
        return matchedZodiacSign != null ? matchedZodiacSign.getAnimal() : null;
    }
}
