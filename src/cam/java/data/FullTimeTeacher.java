package cam.java.data;

public class FullTimeTeacher extends Teacher {

    private int yearsOfExperience;

    public FullTimeTeacher(String name, float baseSalary, int yearsOfExperience) {
        super(name, baseSalary);
        this.yearsOfExperience = yearsOfExperience;

    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String toString(){
        return("Name: " + getName() +"\n" +
                "Id: " + getId() + "\n" +
                "Teacher contract: Full Time" + "\n" +
                "Salary: " + "$" + calculateSalary() + "\n"+
                "----------------------------------");
    }

    @Override
    public float calculateSalary() {
        return this.getBaseSalary()* 1.10F;
    }
}