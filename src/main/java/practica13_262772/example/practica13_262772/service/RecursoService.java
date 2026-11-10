package practica13_262772.example.practica13_262772.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practica13_262772.example.practica13_262772.model.Recurso;
import practica13_262772.example.practica13_262772.repository.RecursoRepository;
import java.util.List;
import java.util.Optional;

@Service
public class RecursoService {
    @Autowired
    private RecursoRepository recursoRepository;

    /**
     * Consulta todos los recursos
     *
     * @return la lista de los recursos
     */
    public List<Recurso> consultarRecursos() {
        return recursoRepository.findAll();
    }

    /**
     * Consulta un recurso por su ID
     *
     * @param id
     *
     * @return el recurso
     */
    public Optional<Recurso> consultarRecurso(Long id) {
        return recursoRepository.findById(id);
    }

    /**
     * Crea un recurso y lo guarda
     *
     * @param recurso
     */
    public Recurso crearRecurso (Recurso recurso) {
        return recursoRepository.save(recurso);
    }

    /**
     * Actualiza parcialmente un recurso parcialmente
     *
     * @param id
     * @param recurso
     * @return
     */
    public Optional<Recurso> actualizarRecursoParcialmente(Long id, Recurso recurso) {
        return recursoRepository.findById(id).map(existente -> {
            if (recurso.getTitulo() != null) existente.setTitulo(recurso.getTitulo());
            if (recurso.getUrl() != null) existente.setUrl(recurso.getUrl());
            if (recurso.getTipo() != null) existente.setTipo(recurso.getTipo());
            if (recurso.getCategoria() != null) existente.setCategoria(recurso.getCategoria());
            return recursoRepository.save(existente);
        });
    }

    /**
     * Actualiza un recurso en su totalidad
     *
     * @param id
     * @param recurso
     *
     * @return el recurso actualizado
     */
    public Recurso actualizarRecurso(Long id, Recurso recurso) {
        recurso.setId(id);
        return recursoRepository.save(recurso);
    }

    /**
     * Elimina un recurso por ID
     *
     * @param id
     */
    public void eliminarRecurso(Long id) {
        recursoRepository.deleteById(id);
    }
}