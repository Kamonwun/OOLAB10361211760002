import java.util.List;

public interface employeeDAO {

    public List<Eamployee> getAllEmp();
    public void addEmp (Eamployee newEpm);
    public void updateEmp (Eamployee empioyee);
    public void deleteEmp(int id);
    public Eamployee findEmp (int id);


    }

