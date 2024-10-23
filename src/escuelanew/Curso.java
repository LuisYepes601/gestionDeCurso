package escuelanew;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import javax.sound.sampled.*;
import javax.swing.JOptionPane;

public class Curso {

    private List<Estudiante> listas;
    private List<Profesor> Profesores;
    private String name;

    public Curso(String name) {
        this.name = name;
        this.listas = new ArrayList<>();
        this.Profesores = new ArrayList<>();

    }

    public Curso() {
    }

    public List<Estudiante> getLista() {
        return listas;
    }

    public void setLista(List<Estudiante> lista) {
        this.listas = lista;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Profesor> getProfesores() {
        return Profesores;
    }

    public void setProfesores(List<Profesor> Profesores) {
        this.Profesores = Profesores;

    }

    public String validarDatosEntrada(String campo, String regex, String mensajeError) {
        String dato;
        do {
            dato = JOptionPane.showInputDialog(campo);

            if (dato == null) {
                return null;
            }

            if (!dato.matches(regex)) {
                JOptionPane.showMessageDialog(null, mensajeError);

            }

        } while (!dato.matches(regex));

        return dato;
    }

    public int validarDatos(String campo, String mensajeError) {

        boolean valido = true;

        int diaParse = 0;

        while (valido) {

            try {
                String dia = JOptionPane.showInputDialog(campo);
                if (dia == null) {
                    break;
                }
                diaParse = Integer.parseInt(dia);
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, mensajeError);
            }

        }
        
        return diaParse;

    }

    public void addCurso(ArrayList<Curso> cursos) {
        String name = validarDatosEntrada("Nombre", "[a-zA-Z _-]{4,9}", "Error el nombre del curso no cumple con el minimo de caracteres.");
        if (name == null) {
            return;
        }
        Curso cursoActual = new Curso(name);
        cursos.add(cursoActual);
        JOptionPane.showMessageDialog(null, "Curso " + name + " agregado con éxito");
        //System.out.println("Curso " + name + " agregado con éxito.");
        cursoActual.addProfesor();
        // System.out.println("Quieres agregar estudiantes a este curso? (si/no)");
        String resp = JOptionPane.showInputDialog("¿Quieres agregar estudiantes a este curso? (si/no)");
        if (resp == null) {
            return;
        }
        while (resp.toLowerCase().equalsIgnoreCase("si")) {
            cursoActual.addEstudiantes();
            // System.out.println("Quieres agregar estudiantes a este curso? (si/no)");
            resp = JOptionPane.showInputDialog("¿Quieres agregar estudiantes a este curso? (si/no)");
            if (resp == null) {
                return;
            }

        }
        //System.out.println("\n----------------------------------------------\n");
        JOptionPane.showMessageDialog(null, "\n----------------------------------------------\n" + " Datos de los estudiante ingresados" + cursoActual.mostrarEstudiantes());
        //System.out.println("Datos de los estudiante ingresados");

    }

    public void addEstudiantes() {
        String dni;
        String nombre;
        int cont = 1;
        int diaParse;
        //System.out.println("INGRESA LOS DATOS DE EL ESTUDIANTE ");

        JOptionPane.showMessageDialog(null, "INGRESA LOS DATOS DE EL ESTUDIANTE");

        dni = validarDatosEntrada("DNI", "^\\d{1,10}$", "DNI no valido. Ingresa solo números");

        if (dni == null) {
            return;
        }

        nombre = validarDatosEntrada("Nombre", "^^[A-Za-zÀ-ÿ\\s\\W]{1,15}$", "Nombre no válido necesitas igresar minimo un caracter. No se Admiten números ni simbolos");

        if (nombre == null) {
            return;
        }

        String apellido = validarDatosEntrada("Apellido", "^[A-Za-zÀ-ÿ\\s\\W]{1,15}$", "Apellido no válido necesitas igresar minimo un caracter. No se Admiten números ni simbolos");

        if (apellido == null) {
            return;
        }

        JOptionPane.showMessageDialog(null, "FECHA DE NACIMIENTO");

        diaParse = validarDatos("Dia", "Introduzca un valor númerico.");

        int mes = validarDatos("Mes", "Introduzca un valor númerico.");
        int anio = validarDatos("Año", "Introduzca un valor númerico.");
        listas.add(new Estudiante(dni, nombre, apellido, diaParse, mes, anio));

    }

    public void addProfesor() {
        boolean dniValido = false;
        int cont = 1;
        double dninew = 0;
        String nombre = null;

        JOptionPane.showMessageDialog(null, "INGRESA LOS DATOS DE EL PROFESOR");
        //System.out.println("DNI: ");
        //System.out.println("INGRESA LOS DATOS DE EL PROFESOR ");
        do {
            String dni = JOptionPane.showInputDialog("DNI");
            if (dni == null) {
                return;
            }
            dninew = 0;
            try {
                dninew = Double.parseDouble(dni);
                dniValido = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El DNI es invalido debe de ser números. Ingreselo nuevamente");
            }
        } while (!dniValido);

        nombre = JOptionPane.showInputDialog("Nombre");
        if (nombre == null) {
            return;
        }

        while (!nombre.matches("[a-zA-Z _-]{4,9}")) {
            nombre = JOptionPane.showInputDialog("Nombre invalido. Minimo 5 caracteres");
            if (nombre == null) {
                return;
            }
        }

        Profesor profersorActual = new Profesor(dninew, nombre);
        Profesores.add(profersorActual);
    }

    public String mostrarProfesor() {
        StringBuilder sb = new StringBuilder();
        for (Profesor elem : Profesores) {
            sb.append("Nombre del profesor : ").append(elem.getName()).append("\n");
        }
        return sb.toString();
    }

    public String mostrarEstudiantes() {
        int cont = 0;
        StringBuilder mensaje = new StringBuilder(); // Usar StringBuilder para concatenar
        for (Estudiante elem : listas) {
            mensaje.append("\nDatos del estudiante ").append(cont + 1).append("\n")
                    .append("DNI: ").append(elem.getDNI()).append("\n")
                    .append("Nombre: ").append(elem.getName()).append("\n")
                    .append("Apellido: ").append(elem.getApellido()).append("\n")
                    .append("Fecha de nacimiento:\n")
                    .append("Día: ").append(elem.getDia()).append("\n")
                    .append("Mes: ").append(elem.getMes()).append("\n")
                    .append("Año: ").append(elem.getAnio()).append("\n\n"); // Añadir un espacio entre estudiantes
            cont++;
        }

        if (cont == 0) {
            mensaje.append("No hay estudiantes registrados en este curso.");
        }

        return mensaje.toString(); // Convertir StringBuilder a String

    }

    public void eliminarCurso(ArrayList<Curso> lista) {
        boolean encontrado = false;
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay cursos disponibles para eliminar.");

        } else {
            ListIterator<Curso> iterator = lista.listIterator();

            boolean cond = true;

            while (cond) {
                String name = JOptionPane.showInputDialog("Ingresa el nombre del curso").toLowerCase();
                if (name == null) {
                    return;
                }

                if (name.matches("^[a-zA-Z ]+$")) {
                    cond = false;
                } else {
                    JOptionPane.showMessageDialog(null, "No se aceptan datos númericos ni espacios vacios.");
                }
            }

            while (iterator.hasNext()) {
                Curso siguiente = iterator.next();
                if (name.equals(siguiente.getName())) {
                    encontrado = true;
                    iterator.remove();
                    JOptionPane.showMessageDialog(null, "Curso eliminado con éxito");
                }

            }

            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "Curso no encontrado");
            }
        }

    }

    public void mostrarCurso(ArrayList<Curso> lista) {
        if (!lista.isEmpty()) {
            int i = 0;
            StringBuilder sb = new StringBuilder();
            sb.append("Resumen de los cursos\n");

            for (Curso elem : lista) {
                sb.append("Nombre del curso " + (i + 1) + ":\n").append(elem.getName()).append("\n");
                i++;
            }
            JOptionPane.showMessageDialog(null, sb.toString());
            boolean valido = false;
            StringBuilder sb2 = new StringBuilder();

            sb2.append("Menu")
                    .append("\n1.Mas información de los cursos")
                    .append("\n0.Salir");
            do {
                try {
                    String opc = JOptionPane.showInputDialog(null, sb2.toString());
                    if (opc== null){
                        return;
                    }
                    int opcion = Integer.parseInt(opc);
                    if (opcion == 1) {
                        valido = true;
                        StringBuilder sb3 = new StringBuilder();
                        for (Curso elem : lista) {

                            sb3.append("Nombre del curso: " + elem.getName()).append("\n").append(elem.mostrarProfesor()).append("\n").append(elem.mostrarEstudiantes()).append("\n");

                        }
                        JOptionPane.showMessageDialog(null, sb3.toString());
                    } else if (opcion == 0) {
                        JOptionPane.showMessageDialog(null, "Gracias por visitarnos.");
                        valido = true;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Ingrese un valor númerico. No dejar campos vacios.");
                }
            } while (!valido);

            //JOptionPane.showMessageDialog(null, sb);
        } else {

            JOptionPane.showMessageDialog(null, "Lista vacia. No hay cursos a mostrar. Lo invitamos a agregar nuevos cursos");
        }

    }

    public static void reproducirSonido(String archivoSonido) {
        try {
            File archivo = new File(archivoSonido);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivo);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();  // Reproduce el sonido
        } catch (Exception e) {
            System.err.println("Error al reproducir el sonido: " + e.getMessage());
        }
    }

    public void buscarCurso(ArrayList<Curso> lista) {
        String nameCurso;
        if (!lista.isEmpty()) {
            do {
                nameCurso = JOptionPane.showInputDialog("Ingresa el nombre del curso a buscar");
                if (nameCurso == null) {
                    return;
                }

                if (!nameCurso.matches("^[a-zA-Z ]+$")) {
                    JOptionPane.showMessageDialog(null, "No se aceptan datos númericos ni espacios vacios.");
                }
                if (nameCurso == null) {
                    return;
                }
            } while (!nameCurso.matches("^[a-zA-Z ]+$"));

            boolean encontrado = false;
            for (Curso elem : lista) {
                if (elem.getName().equals(nameCurso)) {
                    encontrado = true;
                    JOptionPane.showMessageDialog(null, "El curso " + elem.getName() + " se encuentra");
                }
            }

            if (!encontrado) {

                JOptionPane.showMessageDialog(null, "El curso " + nameCurso + " no se encuentra");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Lista vacia no se pueden buscar cursos. Te initamos a agregar nuevos cursos.");

        }
    }

    public void eliminarAlumnos(ArrayList<Curso> lista) {
        //Scanner in = new Scanner(System.in);
        if (!lista.isEmpty()) {
            // JOptionPane.showMessageDialog(null, "Gestión para eliminar alumnos");
            String name = JOptionPane.showInputDialog("Ingresa el nombre del curso");
            boolean encontrado = false;
            ListIterator<Curso> iterator = lista.listIterator();

            while (iterator.hasNext()) {
                Curso c = iterator.next();
                if (c.getName().equals(name)) {
                    ListIterator<Estudiante> iterator2 = c.getLista().listIterator();
                    if (!c.getLista().isEmpty()) {
                        name = JOptionPane.showInputDialog("Ingresa el nombre del estudiante");
                        while (iterator2.hasNext()) {
                            Estudiante e = iterator2.next();
                            if (e.getName().equals(name)) {
                                encontrado = true;
                                JOptionPane.showMessageDialog(null, "Estudiante " + e.getName() + " ha sido eliminado con exito");

                                iterator2.remove();
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay estudiantes en este curso.");

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "El curso no se encuentra. Ingrese uno valido.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Lista vacia. No se pueden eliminar alumnos. LO INVITAMOS A AGREGAR NUEVOS CURSOS");
        }

    }

    public void buscarAlumno(ArrayList<Curso> lista) {

        boolean encontrado = false;

        if (!lista.isEmpty()) {
            String name = JOptionPane.showInputDialog("Ingresa el nombre del curso");
            ListIterator<Curso> iterador3 = lista.listIterator();

            while (iterador3.hasNext()) {
                Curso x = iterador3.next();
                if (x.getName().equals(name)) {

                    ListIterator<Estudiante> iterador4 = x.getLista().listIterator();
                    if (!x.getLista().isEmpty()) {
                        String nameEstudiante = JOptionPane.showInputDialog("Ingresa el nombre del estudiante");

                        while (iterador4.hasNext()) {
                            Estudiante e = iterador4.next();
                            if (e.getName().equals(nameEstudiante)) {
                                encontrado = true;
                            }
                        }
                        if (encontrado) {
                            JOptionPane.showMessageDialog(null, "El estudiante se encuentra en el curso");
                        } else {

                            JOptionPane.showMessageDialog(null, "El estudiante no se encuentra en el curso");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No hay estudiantes en este curso.");

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "El curso no se encuentra. Ingrese uno valido.");
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Lista vaica. No se pueden buscar estudiantes. Lo invitamos a agregar nuevos cursos");
        }

    }

    public void addEstudiantesCurso(ArrayList<Curso> lista) {
        if (!lista.isEmpty()) {
            String nombreCurso = JOptionPane.showInputDialog("Ingrese el nombre del curso");

            for (Curso elem : lista) {
                if (elem.getName().equalsIgnoreCase(nombreCurso)) {
                    elem.addEstudiantes();
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "El curso no se encuentra. Ingrese uno valido.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Lista vacia. No se pueden agregar estudiantes. Lo invitamos a agregar nuevos cursos.");
        }

    }

    public void buscarCursosProfesor(ArrayList<Curso> listaCursos) {

        if (!listaCursos.isEmpty()) {
            String nameProfesor = JOptionPane.showInputDialog("Ingrese el nombre del profesor").toLowerCase();

            boolean profesorEncontrado = false;

            // Recorremos la lista de cursos
            for (Curso curso : listaCursos) {
                for (Profesor profesor : curso.getProfesores()) {
                    if (profesor.getName().equalsIgnoreCase(nameProfesor)) {
                        profesorEncontrado = true;
                        JOptionPane.showMessageDialog(null, "El profesor " + profesor.getName() + " enseña el curso: " + curso.getName());

                    }
                }
            }

            if (!profesorEncontrado) {
                JOptionPane.showMessageDialog(null, "No se encontraron cursos para el profesor " + nameProfesor);

            }
        } else {
            JOptionPane.showMessageDialog(null, "Lista vacia. No se pueden buscar profesores. Lo invitamos a agregar nuevos cursos");
        }
    }

}
