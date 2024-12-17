package bootcamp.modulo5.repository;

import bootcamp.modulo5.model.Horoscope;
import java.util.List;

/**
 * Repositorio que maneja las operaciones de acceso a datos para los horóscopos.
 * Esta interfaz define los métodos necesarios para interactuar con el almacenamiento
 * de datos de horóscopos en la aplicación.
 */
public interface HoroscopeRepository {

    /**
     * Recupera todos los horóscopos almacenados en el repositorio.
     * Este método se encarga de obtener la lista completa de horóscopos
     * disponibles en la base de datos o el sistema de almacenamiento.
     *
     * @return Una lista que contiene todos los objetos Horoscope disponibles
     * @throws RuntimeException si ocurre un error durante la recuperación de datos
     */
    List<Horoscope> findAll();
}