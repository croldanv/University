package cam.java.data;

public abstract class Teacher {
    private int id;
    private String name;
    private float baseSalary;

    private static int rep_id = 1;

    public Teacher(String name, float baseSalary) {
        this.id = rep_id++;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(float baseSalary) {
        this.baseSalary = baseSalary;
    }

    public abstract float calculateSalary();
}
