import java.util.List;

public class CompanyManagemete {
    public static void main(String []args){
        //
        employeeDAO dao = EmployeeDAOlmpl.getInstance();

        //
        displayAllEmployee(dao);
    }

    private static void displayAllEmployee(employeeDAO dao) {
        List<Eamployee> myEmp = dao.getAllEmp();
        for (Eamployee emp:myEmp);
            System.out.println(myEmp.toString());
    }
}
