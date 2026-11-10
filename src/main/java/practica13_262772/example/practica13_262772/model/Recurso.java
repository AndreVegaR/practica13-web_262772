package practica13_262772.example.practica13_262772.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recurso {
    private Long id;
    private String titulo;
    private String url;
    private String tipo;
    private String categoria;
}