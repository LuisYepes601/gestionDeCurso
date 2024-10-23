/**package escuelanew;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;



public class PrincipalGUI extends JFrame {

    private ArrayList<Curso> cursos = new ArrayList<>();

    public PrincipalGUI() {
        setTitle("Sistema de Gestión de Cursos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());


        JPanel header = new JPanel();
        this.getContentPane().add(header);
        header.setBackground(Color.LIGHT_GRAY);
        header.setLayout(new BorderLayout());

        JLabel headerTitle = new JLabel("Sistema de gestión de cursos",JLabel.CENTER);
        headerTitle.setFont(new Font("SansSerif", Font.BOLD, 28));
        headerTitle.setForeground(Color.black);
        header.add(headerTitle, BorderLayout.CENTER);
        add(header, BorderLayout.NORTH);

        

        JPanel contenido = new JPanel();
        contenido.setLayout(new GridLayout(2,1));
        contenido.setBackground(Color.CYAN);
        add(contenido, BorderLayout.CENTER);
 

        JPanel cursoPanel = new JPanel();
        cursoPanel.setLayout(new GridLayout(4, 1, 10, 10));
        cursoPanel.setBackground(Color.WHITE);

        JLabel cursoLabel = new JLabel("Gestión de Cursos", JLabel.CENTER);
        cursoLabel.setFont(new Font("Arial", Font.BOLD, 20));
        Border borde = BorderFactory.createLineBorder(Color.black);
        cursoLabel.setBorder(borde);
        cursoPanel.add(cursoLabel);
      

        JButton crearCursButton = new JButton("Crear Curso");
        crearCursButton.setFont(new Font("Arial", Font.PLAIN, 16));
        crearCursButton.setBackground(new Color(0, 153, 255));
        crearCursButton.setForeground(Color.WHITE);


        JButton eliminarCursoButton = new JButton("Eliminar Curso");
        eliminarCursoButton.setFont(new Font("Arial", Font.PLAIN, 16));
        eliminarCursoButton.setBackground(new Color(255, 102, 102));
        eliminarCursoButton.setForeground(Color.WHITE);

        JButton mostrarCursoButton = new JButton("Mostrar Curso");
        mostrarCursoButton.setFont(new Font("Arial", Font.PLAIN, 16));
        
        JButton buscarCursosButton = new JButton("Buscar Curso");
        buscarCursosButton.setFont(new Font("Arial", Font.PLAIN, 16));

        cursoPanel.add(crearCursButton);
        cursoPanel.add(eliminarCursoButton);
        cursoPanel.add(mostrarCursoButton);
        cursoPanel.add(buscarCursosButton);

        contenido.add(cursoPanel);

        JPanel alumnoPanel = new JPanel();
        alumnoPanel.setLayout(new GridLayout(4, 1, 10, 10));
        alumnoPanel.setBackground(Color.WHITE);

        JLabel alumnoLabel = new JLabel("Gestión de Alumnos", JLabel.CENTER);
        alumnoLabel.setFont(new Font("Arial", Font.BOLD, 20));
        alumnoPanel.add(alumnoLabel);

        JButton agregarAlumnoButton = new JButton("Agregar Alumno");
        agregarAlumnoButton.setFont(new Font("Arial", Font.PLAIN, 16));
        agregarAlumnoButton.setBackground(new Color(0, 204, 102));
        agregarAlumnoButton.setForeground(Color.WHITE);

        JButton eliminarAlumnosButton = new JButton("Eliminar Alumno");
        eliminarAlumnosButton.setFont(new Font("Arial", Font.PLAIN, 16));
        eliminarAlumnosButton.setBackground(new Color(255, 102, 102));
        eliminarAlumnosButton.setForeground(Color.WHITE);

        JButton buscarAlumnoButton = new JButton("Buscar Alumno");
        buscarAlumnoButton.setFont(new Font("Arial", Font.PLAIN, 16));

        JButton buscarCursoProfesorButton = new JButton("Buscar Cursos por Profesor");
        buscarCursoProfesorButton.setFont(new Font("Arial", Font.PLAIN, 16));

        alumnoPanel.add(agregarAlumnoButton);
        alumnoPanel.add(eliminarAlumnosButton);
        alumnoPanel.add(buscarAlumnoButton);
        alumnoPanel.add(buscarCursoProfesorButton);


        contenido.add(alumnoPanel);

        JPanel salirPanel = new JPanel();
        salirPanel.setLayout(new BorderLayout());
        salirPanel.setBackground(Color.LIGHT_GRAY);
        JButton salirButton = new JButton("Salir");
        salirButton.setFont(new Font("Arial", Font.PLAIN, 16));
        salirButton.setBackground(new Color(255, 51, 51));
        salirButton.setForeground(Color.WHITE);
        salirPanel.add(salirButton, BorderLayout.CENTER);
        add(salirPanel, BorderLayout.SOUTH);

        crearCursButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Curso cursoActual = new Curso(getName());
                cursoActual.addCurso(cursos);

            }
        });

        eliminarCursoButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                Curso cursoActual = new Curso(getName());
                cursoActual.eliminarCurso(cursos);
            }

        });

        mostrarCursoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Curso cursoActual = new Curso(getName());
                cursoActual.mostrarCurso(cursos);
            }

        });
        buscarCursosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Curso cursoActual = new Curso(getName());
                cursoActual.buscarCurso(cursos);
            }

        });

       eliminarAlumnosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Curso cursoActual = new Curso(getName());
                cursoActual.eliminarAlumnos(cursos);
            }

        });

        buscarAlumnoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Curso cursoActual = new Curso(getName());
                cursoActual.buscarAlumno(cursos);

            }
        });

        agregarAlumnoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Curso cursoActual = new Curso(getName());
                cursoActual.addEstudiantesCurso(cursos);
            }
            
        });

        buscarCursoProfesorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Curso cursoActual = new Curso(getName());
                cursoActual.buscarCursosProfesor(cursos);
            }
            
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        });
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PrincipalGUI().setVisible(true);
            }
        });

        /*  Curso cursoActual = new Curso(null);
        Scanner in = new Scanner(System.in);
        String resp, respuesta;
        ArrayList<Curso> cursos = new ArrayList<>();
        int opc = 0;
        do {

            System.out.println("1.Crear curso");
            System.out.println("2.Eliminar curso");
            System.out.println("3.Mostrar cursos");
            System.out.println("4.Buscar curso");
            System.out.println("5.Eiminar alumnos");
            System.out.println("6.Buscar alumnos");
            System.out.println("7.Agregar alumnos");
            System.out.println("8. Buscar cusrsos de los profesores");
            System.out.println("0.Salir");
            System.out.println("Ingresa una opción");
            opc = in.nextInt();
            in.nextLine();
            switch (opc) {
                case 1:
                    cursoActual.addCurso(cursos);
                    break;
                case 2:
                    if (!cursos.isEmpty()) {
                        cursoActual.eliminarCurso(cursos);
                    } else {
                        System.out.println("\n--------------------------------------");
                        System.out.println("Lista vacia. Agrega cursos. Intentalo nuevamente");
                        System.out.println("--------------------------------------\n");
                    }

                    break;
                case 3:
                    if (!cursos.isEmpty()) {
                        cursoActual.mostrarCurso(cursos);
                        System.out.println("Menú");
                        System.out.println("1.Mostrar informacion de los cursos");
                        System.out.println("0. Salir");
                        System.out.println("Ingresa una opción");
                        opc = in.nextInt();
                        switch (opc) {
                            case 1:

                                System.out.println("\n-------------------------------------------------");
                                System.out.println("Resumen de cursos");

                                for (Curso elem : cursos) {
                                    System.out.println("-----------------------------");
                                    System.out.println(elem.getName());
                                    System.out.println("nombre del profesor");
                                    elem.mostrarProfesor();
                                    System.out.println("-----------------------------\n");
                                    elem.mostrarEstudiantes();
                                }
                                break;
                            case 0:
                                break;
                            default:
                                break;
                        }
                    } else {
                        System.out.println("\n---------------------------------------------------");
                        System.out.println("Lista vacia. Agrega cursos. Intentalo nuevamente");
                        System.out.println("---------------------------------------------------\n");
                    }

                    break;
                case 4:
                    if (!cursos.isEmpty()) {
                        cursoActual.buscarCurso(cursos);
                    } else {
                        System.out.println("\n---------------------------------------------------");
                        System.out.println("Lista vacia. Agrega cursos. Intentalo nuevamente");
                        System.out.println("---------------------------------------------------\n");
                    }

                    break;
                case 5:
                    if (!cursos.isEmpty()) {
                        cursoActual.eliminarAlumnos(cursos);
                    } else {
                        System.out.println("\n---------------------------------------------------");
                        System.out.println("Lista vacia. Agrega cursos para poder eliminar estudiantes.");
                        System.out.println("Intentalo nuevamente");
                        System.out.println("---------------------------------------------------\n");
                    }

                    break;
                case 6:
                    if (!cursos.isEmpty()) {
                        cursoActual.buscarAlumno(cursos);
                    } else {
                        System.out.println("\n---------------------------------------------------");
                        System.out.println("Lista vacia. Agrega cursos para poder buscar estudiantes.");
                        System.out.println("Intentalo nuevamente");
                        System.out.println("---------------------------------------------------\n");
                    }

                    break;
                case 7:
                    cursoActual.addEstudiantesCurso(cursos);
                    break;
                case 8:
                    if (!cursos.isEmpty()) {
                        cursoActual.buscarCursosProfesor(cursos);
                    } else {

                        System.out.println("\n---------------------------------------------------");
                        System.out.println("Lista vacia. Agrega cursos. Intentalo nuevamente");
                        System.out.println("---------------------------------------------------\n");
                    }

                    break;
                case 0:
                    break;
                default:
                    throw new AssertionError();
            }

            
        } while (opc != 0);
    }
}*/
