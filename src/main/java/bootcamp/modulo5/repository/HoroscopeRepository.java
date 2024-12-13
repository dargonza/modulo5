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
     *
     * @return Una lista que contiene todos los objetos Horoscope disponibles
     */
    List<Horoscope> findAll();
}