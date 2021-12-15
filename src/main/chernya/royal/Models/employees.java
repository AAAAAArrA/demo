package royal.Models;

public class employees {
    private int empl_id;
    private String empl_name;
    private int empl_age;
    private String empl_position;

    public int getEmpl_id() {
        return empl_id;
    }

    public void setEmpl_id(int empl_id) {
        this.empl_id = empl_id;
    }

    public String getEmpl_name() {
        return empl_name;
    }

    public void setEmpl_name(String empl_name) {
        this.empl_name = empl_name;
    }

    public int getEmpl_age() {
        return empl_age;
    }

    public void setEmpl_age(int empl_age) {
        this.empl_age = empl_age;
    }

    public String getEmpl_position() {
        return empl_position;
    }

    public void setEmpl_position(String empl_position) {
        this.empl_position = empl_position;
    }

    public employees(int empl_id, String empl_name, int empl_age, String empl_position) {
        this.empl_id = empl_id;
        this.empl_name = empl_name;
        this.empl_age = empl_age;
        this.empl_position = empl_position;
    }
    public employees(){

    }
}
