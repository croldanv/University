package cam.java.data;

public class PartTimeTeacher extends Teacher {

    private float activeHoursPerWeek;

    public PartTimeTeacher(String name, float baseSalary, float activeHoursPerWeek) {
        super(name, baseSalary);
        this.activeHoursPerWeek = activeHoursPerWeek;
    }

    public float getActiveHoursPerWeek() {
        return activeHoursPerWeek;
    }

    public void setActiveHoursPerWeek(float activeHoursPerWeek) {
        this.activeHoursPerWeek = activeHoursPerWeek;
    }

    public String toString(){
        return ("Name: " + getName() +"\n" +
                "Id: " + getId() + "\n" +
                "Teacher contract: Part Time" + "\n" +
                "Active hours per week: " + getActiveHoursPerWeek() + "\n" +
                "Week Salary: " + "$" + calculateSalary() + "\n" +
                "------------------------------");
    }

    @Override
    public float calculateSalary(){
            return getBaseSalary()* ((1/4F)/48F) * this.activeHoursPerWeek;
        }
    }

