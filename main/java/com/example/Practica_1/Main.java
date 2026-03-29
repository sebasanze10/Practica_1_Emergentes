package com.example.Practica_1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Main{

    @GetMapping("/En_cinco_años")
    public String getFiveYears(){
        return "Me llamo Sebastian Alvaro Anze Colque y en 5 años ya estare titulado de la carrera de Ingeniería de Sistemas, ya con bastante experiencia para crear proyectos que me ayuden a tener trabajos mejores y especializarme en algun area de Sistemas al mismo tiempo";
    }
    @GetMapping("/Peliculas")
    public Object getPeliculas(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String genero,
            @RequestParam(required = false) String orden
    ) {

        List<Peliculas> lista = Arrays.asList(
                new Peliculas("El Rey León",
                        "15 de junio de 1994",
                        Arrays.asList("Animacion", "Aventura", "Drama", "Familiar"),
                        "Dirigida por Roger Allers y Rob Minkoff, es una película animada de Disney que narra la historia de Simba, un joven león que debe enfrentar la traición de su tío Scar y asumir su destino como rey de la Tierra de los Príncipes, aprendiendo sobre el ciclo de la vida y la responsabilidad."),

                new Peliculas("Harry Potter y la Piedra Filosofal",
                        "16 de noviembre de 2001",
                        Arrays.asList("Aventura", "Fantasia", "Familiar"),
                        "Dirigida por Chris Columbus, es la primera entrega de la saga. Narra la historia de Harry Potter, un niño huérfano que descubre en su undécimo cumpleaños que es un mago y es invitado a estudiar en el Colegio Hogwarts de Magia y Hechicería, donde hará amigos y enfrentará al malvado Lord Voldemort."),

                new Peliculas("Los Increíbles",
                        "5 de noviembre de 2004",
                        Arrays.asList("Animacion", "Accion", "Aventura", "Familia"),
                        "Dirigida por Brad Bird, es una película de Pixar que sigue a una familia de superhéroes que viven en el anonimato. Bob Parr (Mr. Increíble) y su familia deben unir fuerzas para salvar al mundo de un nuevo villano mientras lidian con sus problemas familiares."),

                new Peliculas("La Máscara",
                        "29 de julio de 1994",
                        Arrays.asList("Comedia", "Fantasia", "Accion"),
                        "Dirigida por Chuck Russell y protagonizada por Jim Carrey, cuenta la historia de Stanley Ipkiss, un empleado de banco tímido que encuentra una máscara mágica que le otorga poderes para transformarse en un ser verde de personalidad alocada y traviesa."),

                new Peliculas("Alicia en el País de las Maravillas",
                        "4 de marzo de 2010",
                        Arrays.asList("Fantasia", "Aventura", "Familiar"),
                        "Dirigida por Tim Burton, es una adaptación del clásico de Lewis Carroll. Alicia, ahora una joven de 19 años, regresa al País de las Maravillas para descubrir su verdadero destino y ayudar al Sombrerero Loco a derrotar a la Reina Roja."),

                new Peliculas("Superman: El Hombre de Acero",
                        "14 de junio de 2013",
                        Arrays.asList("Accion", "Ciencia Ficcion", "Aventura"),
                        "Dirigida por Zack Snyder, narra los orígenes de Superman, desde su llegada a la Tierra hasta convertirse en el protector de la humanidad. Clark Kent descubre sus poderes y debe enfrentar al general Zod, otro sobreviviente de Krypton."),

                new Peliculas("Super Mario Bros: La Película",
                        "5 de abril de 2023",
                        Arrays.asList("Animacion", "Aventura", "Comedia", "Familiar"),
                        "Dirigida por Aaron Horvath y Michael Jelenic, es una adaptación animada del popular videojuego. Mario y Luigi, dos fontaneros de Brooklyn, son transportados a un mundo mágico donde deben ayudar a la Princesa Peach a derrotar a Bowser."),

                new Peliculas("La Era de Hielo",
                        "15 de marzo de 2002",
                        Arrays.asList("Animacion", "Aventura", "Comedia", "Familiar"),
                        "Dirigida por Chris Wedge, sigue las aventuras de Manny, un mamut gruñón, Sid, un perezoso torpe, y Diego, un tigre dientes de sable, quienes se unen para devolver a un bebé humano a su tribu durante la era de hielo."),

                new Peliculas("Chucky: El Muñeco Diabólico",
                        "9 de noviembre de 1988",
                        Arrays.asList("Terror", "Suspenso", "Sobrenatural"),
                        "Dirigida por Tom Holland, es la primera entrega de la saga Child's Play. Un muñeco Good Guy poseído por el espíritu de un asesino en serie aterroriza a un niño pequeño y su madre en Navidad."),

                new Peliculas("Los Vengadores",
                        "4 de mayo de 2012",
                        Arrays.asList("Accion", "Ciencia Ficcion", "Aventura"),
                        "Dirigida por Joss Whedon, reúne a los superhéroes más poderosos de la Tierra: Iron Man, Capitán América, Thor, Hulk, Viuda Negra y Ojo de Halcón, quienes deben unirse para detener a Loki y su ejército alienígena que amenazan con conquistar el mundo.")

        );

        String nombreFiltro = (nombre != null && nombre.trim().isEmpty()) ? null : nombre;
        String generoFiltro = (genero != null && genero.trim().isEmpty()) ? null : genero;

        List<Peliculas> resultado = lista.stream()

                .filter(p -> nombreFiltro == null ||
                        p.getNombre().toLowerCase().contains(nombreFiltro.toLowerCase()))

                .filter(p -> generoFiltro == null ||
                        p.getGeneros().stream()
                                .anyMatch(g -> g.equalsIgnoreCase(generoFiltro)))

                .collect(Collectors.toList());

        if (resultado.isEmpty()) {
            return "Selecciona otra pelicula";
        }

        return resultado;
    }

}