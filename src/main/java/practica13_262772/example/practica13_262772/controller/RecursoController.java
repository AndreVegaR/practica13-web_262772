package practica13_262772.example.practica13_262772.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practica13_262772.example.practica13_262772.model.Recurso;
import practica13_262772.example.practica13_262772.service.RecursoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recursos")
public class RecursoController {

    @Autowired
    private RecursoService recursoService;

    /**
     * Consulta todos los recursos
     * @return lista con todos los recursos
     */
    @GetMapping
    public List<Recurso> consultarRecursos() {
        return recursoService.consultarRecursos();
    }

    /**
     * Consulta un recurso por ID
     *
     * @param id
     *
     * @return el recurso
     */
    @GetMapping("/{id}")
    public Optional<Recurso> consultarRecurso(@PathVariable Long id) { // <-- Faltaba @PathVariable
        return recursoService.consultarRecurso(id);
    }

    /**
     * Crea un nuevo recurso
     *
     * @param recurso en JSON
     *
     * @return el recurso creado
     */
    @PostMapping
    public Recurso crearRecurso(@RequestBody Recurso recurso) {
        return recursoService.crearRecurso(recurso);
    }

    /**
     * Actualiza un recurso parcialmente
     *
     * @param id
     * @param recurso
     *
     * @return el recurso actualizado
     */
    @PatchMapping("/{id}")
    public Optional<Recurso> actualizarRecursoParcialmente(@PathVariable Long id, @RequestBody Recurso recurso) {
        return recursoService.actualizarRecursoParcialmente(id, recurso);
    }

    /**
     * Actualiza un recurso
     *
     * @param id
     * @param recurso
     *
     * @return
     */
    @PutMapping("/{id}")
    public Recurso actualizarRecurso(@PathVariable Long id, @RequestBody Recurso recurso) {
        return recursoService.actualizarRecurso(id, recurso);
    }

    /**
     * Elimina un recurso por ID
     */
    @DeleteMapping("/{id}")
    public void eliminarRecurso(@PathVariable Long id) {
        recursoService.eliminarRecurso(id);
    }
}