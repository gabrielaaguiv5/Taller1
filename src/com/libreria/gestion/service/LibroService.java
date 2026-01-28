package com.libreria.gestion.service;

import com.libreria.gestion.model.Libro;
import java.util.ArrayList;

public class LibroService {

    private ArrayList<Libro> libros = new ArrayList<>();

    public void agregarLibro(Libro libro) {


        if (buscarPorIsbn(libro.getIsbn()) != null) {
            System.out.println("Ya existe un libro con ese ISBN.");
            return;
        }

        libros.add(libro);
        System.out.println("Libro agregado correctamente.");
    }

    public void eliminarPorIsbn(int isbn) {
        for(int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getIsbn() == isbn) {
                libros.remove(i);
                System.out.println("Libro eliminado correctamente.");
                return;
            }
        }
        System.out.println("No se encontró un libro con ese ISBN.");

    }

    public void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }
        for (Libro libro : libros) {
            System.out.println(libro.mostrarInfo());
        }
    }

    public Libro buscarPorIsbn(int isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn() == isbn) {
                return libro;
            }
        }
        return null;
    }

    public void buscarPorTituloOAutor(String criterio) {
        boolean encontrado = false;
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(criterio) ||
                libro.getAutor().equalsIgnoreCase(criterio)) {
                libro.mostrarInfo();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron libros.");
        }
    }
}
