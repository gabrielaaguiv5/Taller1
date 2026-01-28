package com.libreria.gestion.app;

import com.libreria.gestion.model.Libro;
import com.libreria.gestion.service.LibroService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LibroService libroService = new LibroService();
        int opcion;

        do {
            System.out.println("\nMENÚ DE LIBRERÍA");
            System.out.println("1. Agregar libro");
            System.out.println("2. Eliminar libro por ISBN");
            System.out.println("3. Ver todos los libros");
            System.out.println("4. Buscar libro por título o autor");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();

                    System.out.print("ISBN: ");
                    int isbn = scanner.nextInt();
                    scanner.nextLine();

                    Libro libros = new Libro(titulo, autor, isbn);
                    libroService.agregarLibro(libros);
                    break;

                case 2:
                    System.out.print("ISBN a eliminar: ");
                    int isbnEliminar = scanner.nextInt();
                    scanner.nextLine();
                    libroService.eliminarPorIsbn(isbnEliminar);
                    break;

                case 3:
                    libroService.mostrarLibros();
                    break;

                case 4:
                    System.out.print("Título o autor: ");
                    String criterio = scanner.nextLine();
                    libroService.buscarPorTituloOAutor(criterio);
                    break;

                case 5:
                    System.out.println("Hasta Luego...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 5);

        scanner.close();
    }
}
