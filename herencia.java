abstract class RecursoBibliografico {
    protected String titulo;
    protected String codigo;

    public RecursoBibliografico(String titulo, String codigo) {
        this.titulo = titulo;
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCodigo() {
        return codigo;
    }

    public abstract void mostrarDetalle();
}

class Libro extends RecursoBibliografico {
    private String autor;
    private boolean prestado;

    public Libro(String titulo, String autor, String isbn) {
        super(titulo, isbn);
        this.autor = autor;
        this.prestado = false;
    }

    // ... (métodos específicos de Libro)
}

class Revista extends RecursoBibliografico {
    private int anioPublicacion;
    private int ejemplares;

    public Revista(String titulo, String issn, int anioPublicacion, int ejemplares) {
        super(titulo, issn);
        this.anioPublicacion = anioPublicacion;
        this.ejemplares = ejemplares;
    }

    // ... (métodos específicos de Revista)
}
}
