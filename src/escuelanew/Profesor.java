package escuelanew;

import java.util.ArrayList;

public class Profesor {

    private double id;
    private String name;
    private ArrayList<Curso> cursos;

    public Profesor(double id, String name) {
        this.id = id;
        this.name = name;
        this.cursos = new ArrayList<>();
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   
    

}
