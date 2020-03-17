import java.util.List;
import java.util.Scanner;

public class CompanyManagement {
    public static void main(String[] args) {
        //create interface instant
        employeeDAO dao = EmployeeDAOImpl.getInstance();

        //Get all Employee
        displayAllEmployee(dao);
        //add new Employee
        //addNewEmployee(dao);
        //find Employee by ID
        //findEmployeeByID(dao);
        //update Employee by ID
        //updateEmployeeByID(dao);
        //delete Employee by ID
        deleteEmployeeByID(dao);


    }//main

    private static void deleteEmployeeByID(employeeDAO dao) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Delete employee with iD: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        dao.deleteEmp(id);

    }

    private static void updateEmployeeByID(employeeDAO dao) {
        Employee emp = findEmployeeByID2(dao);
        Scanner sc = new Scanner(System.in);
        System.out.print("Update new salary for employee iD"+emp.getEmpID()+":");
        double ns = Double.parseDouble(sc.nextLine().trim());
        //update salary
        emp.setSalary(ns);
        dao.updateEmp(emp);
        System.out.print("Update employee with ID: "+emp.getEmpID());

    }

    private static Employee findEmployeeByID2(employeeDAO dao) {  //ใช้กับฟังชั่นอัปเดต
        Scanner sc =new Scanner(System.in);
        System.out.println("Update an employee ID:");
        int id =Integer.parseInt(sc.nextLine().trim());
        Employee emp = dao.findEmp(id);
        System.out.println(emp.toString());
        return emp;
    }

    private static void findEmployeeByID(employeeDAO dao) {  //ค้นหาเพื่อแสดงข้อมูล
        Scanner sc =new Scanner(System.in);
        System.out.println("Update new salary for employee ID:");
        int id =Integer.parseInt(sc.nextLine().trim());
        Employee emp = dao.findEmp(id);
        System.out.println(emp.toString());
    }

    private static void addNewEmployee(employeeDAO dao) {
        Scanner sc = new Scanner(System.in);
        //input data
        System.out.print("Enter employee id:");
        int id = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Enter employee name:");
        String name = sc.nextLine().trim();
        System.out.print("Enter employee position:");
        String position = sc.nextLine().trim();
        System.out.print("Enter employee salary:");
        double salary = Double.parseDouble(sc.nextLine().trim());
        //insert data to database
        Employee newEmp = new Employee(id, name, position, salary);
        dao.addEmp(newEmp);

    }

    private static void displayAllEmployee(employeeDAO dao) {
        List<Employee> myEmp =dao.getAllEmp();
        for (Employee emp:myEmp) {
            System.out.println(emp.toString());
        }
    }
}//class
