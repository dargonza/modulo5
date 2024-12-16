package bootcamp.modulo5.service;

import bootcamp.modulo5.model.Horoscope;
import bootcamp.modulo5.repository.HoroscopeRepository;
import bootcamp.modulo5.repository.HoroscopeRepositoryImpl;

import java.time.LocalDate;
import java.util.List;

public class HoroscopeServiceImpl implements HoroscopeService {

    private final HoroscopeRepository horoscopeRepository;

    public HoroscopeServiceImpl() {
        this.horoscopeRepository = new HoroscopeRepositoryImpl();
    }

    @Override
    public String getChineseZodiacAnimal(LocalDate birthDate) {

        List<Horoscope> chineseZodiacSigns = horoscopeRepository.findAll();
        Horoscope matchedZodiacSign = null;


        for (Horoscope zodiacSign : chineseZodiacSigns) {
            if (birthDate.isAfter(zodiacSign.getStartDate()) && birthDate.isBefore(zodiacSign.getEndDate())) {
                matchedZodiacSign = zodiacSign;
                break;
            } else if (birthDate.isEqual(zodiacSign.getStartDate()) || birthDate.isEqual(zodiacSign.getEndDate())) {
                matchedZodiacSign = zodiacSign;
                break;
            }
        }

        if (matchedZodiacSign == null) {
            return null;
        }

        return matchedZodiacSign.getAnimal();
    }
}
