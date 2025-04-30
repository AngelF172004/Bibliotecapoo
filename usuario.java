class Usuario {
    private String nombre;
    private List<RecursoBibliografico> recursosPrestados;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.recursosPrestados = new ArrayList<>();
    }

    public void PrestarRecurso(RecursoBibliografico recurso) {
        if (recurso instanceof Libro) {
            Libro libro = (Libro) recurso;
            if (!libro.isPrestado()) {
                libro.setPrestado(true);
                recursosPrestados.add(recurso);
                System.out.println("Préstamo exitoso de libro: " + libro.getTitulo());
            } else {
                System.out.println("El libro no está disponible.");
            }
        } else if (recurso instanceof Revista) {
            Revista revista = (Revista) recurso;
            if (revista.getEjemplares() > 0) {
                revista.setEjemplares(revista.getEjemplares() - 1);
                recursosPrestados.add(recurso);
                System.out.println("Préstamo exitoso de revista: " + revista.getTitulo());
            } else {
                System.out.println("No hay ejemplares disponibles.");
            }
        }
    }

    public void DevolverRecurso(RecursoBibliografico recurso) {
        if (recursosPrestados.remove(recurso)) {
            if (recurso instanceof Libro) {
                ((Libro) recurso).setPrestado(false);
                System.out.println("Devolución exitosa de libro: " + recurso.getTitulo());
            } else if (recurso instanceof Revista) {
                Revista revista = (Revista) recurso;
                revista.setEjemplares(revista.getEjemplares() + 1);
                System.out.println("Devolución exitosa de revista: " + recurso.getTitulo());
            }
        } else {
            System.out.println("Este recurso no está prestado por el usuario.");
        }
    }

    public void MostrarPrestados() {
        // ... (implementación del método)
    }
}
