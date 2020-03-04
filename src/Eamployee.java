public class Eamployee {
    //
    private int empID;
    private String name;
    private String positon;
    private double salay;

    @Override
    public String toString() {
        return "Eamployee{" +
                "empID=" + empID +
                ", name='" + name + '\'' +
                ", positon='" + positon + '\'' +
                ", salay=" + salay +
                '}';
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPositon() {
        return positon;
    }

    public void setPositon(String positon) {
        this.positon = positon;
    }

    public double getSalay() {
        return salay;
    }

    public void setSalay(double salay) {
        this.salay = salay;
    }

    public Eamployee(int empID, String name, String positon, Double salay) {
        this.empID = empID;
        this.name = name;
        this.positon = positon;
        this.salay = salay;
    }
}
