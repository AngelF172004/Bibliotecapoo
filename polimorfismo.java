// En la clase abstracta RecursoBibliografico:
public abstract void mostrarDetalle();

// En la clase Libro:
@Override
public void mostrarDetalle() {
    System.out.println("Libro: " + titulo + " | Autor: " + autor + " | ISBN: " + codigo + " | Prestado: " + prestado);
}

// En la clase Revista:
@Override
public void mostrarDetalle() {
    System.out.println("Revista: " + titulo + " | ISSN: " + codigo + " | Año: " + anioPublicacion + " | Ejemplares: " + ejemplares);
}

// Ejemplo de uso polimórfico (en BibliotecaApp):
for (RecursoBibliografico r : recursos) {
    r.mostrarDetalle(); // Se ejecuta la versión específica según el tipo real (Libro/Revista)
}