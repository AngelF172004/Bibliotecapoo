public class BibliotecaApp {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        List<RecursoBibliografico> recursos = new ArrayList<>();
        
        // Creación de recursos (libros y revistas)
        recursos.add(new Libro("El Quijote", "Miguel de Cervantes", "978-8491050275"));
        recursos.add(new Libro("Cien Años de Soledad", "Gabriel García Márquez", "978-0307474728"));
        recursos.add(new Revista("National Geographic", "0027-9358", 2024, 3));
        // ... (otros recursos)

        Usuario usuario = new Usuario("Usuario1");
        int opcion;
        
        // Menú interactivo
        do {
            System.out.println("\n--- Biblioteca ---");
            System.out.println("1. Listar recursos");
            System.out.println("2. Prestar recurso");
            System.out.println("3. Devolver recurso");
            System.out.println("4. Mostrar prestados");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1: // Listar recursos
                    System.out.println("\n");
                    for (int i = 0; i < recursos.size(); i++) {
                        System.out.print((i + 1) + ". ");
                        recursos.get(i).mostrarDetalle(); // Polimorfismo aquí
                    }
                    break;
                case 2: // Prestar recurso
                    System.out.print("\nNúmero de recurso a prestar: ");
                    int numPrestamo = entrada.nextInt() - 1;
                    if (numPrestamo >= 0 && numPrestamo < recursos.size()) {
                        usuario.PrestarRecurso(recursos.get(numPrestamo));
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;
                case 3: // Devolver recurso
                    System.out.print("\nNúmero de recurso a devolver: ");
                    int numDevolucion = entrada.nextInt() - 1;
                    if (numDevolucion >= 0 && numDevolucion < recursos.size()) {
                        usuario.DevolverRecurso(recursos.get(numDevolucion));
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;
                case 4: // Mostrar préstamos del usuario
                    usuario.MostrarPrestados();
                    break;
                case 5: // Salir
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
        entrada.close();
    }
}
