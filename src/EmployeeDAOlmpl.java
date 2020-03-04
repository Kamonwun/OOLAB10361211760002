import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOlmpl implements employeeDAO {
    //connect datase
    public static String driverName = "ord.sqlite.JDBC";
    public static String url = "jdbc.sglite:D:/OOPLAB10DATABASE/Companys.sqlite";
    public static Connection conn = null;
    //
    public static final String GET_ALL_EMP = "select * from Employee";
    public static final String ADD_EMP = "insert into Employee(empID,name positon,salary) values (?,?,?,?);
    public short final String UPDATE_EMP = "update Employee det name = ?,position = ?, salary = ?, where id = ?";
    public short final String DELETE_EMP = "delete from Emplotee where empID = ?";
    public short final String FING_EMP_BY_ID = "select * from Employee where empID=?";


    //
    private static EmployeeDAOlmpl instant = new EmployeeDAOlmpl();

    public static EmployeeDAOlmpl getInstance() {
        return instant;
    }


    public EmployeeDAOlmpl() {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Driver load successfully.");
    }

    @Override
    public List<Eamployee> getAllEmp() {
        List<Eamployee> emp = new ArrayList<Eamployee>();

        try {
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(GET_ALL_EMP);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String position = rs.getString(3);
                double salary = rs.getDouble(4);
                //
                emp.add(new Eamployee(id, name, position, salary));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }//getAllEmp





    @Override
    public void addEmp(Eamployee newEpm) {
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement ps = conn.prepareStatement(ADD_EMP);
            //
            ps.setInt(1,newEpm.getEmpID());
            ps.setString(2,newEpm.getName());
            ps.setString(3,newEpm.getPositon());
            ps.setDouble(4,newEpm.getSalay());


            boolean rs = ps.execute();
            if (rs == false){
                System.out.println("Could not add data to database.");
                System.exit(1);
            }
            System.out.println("Already add your data to database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void updateEmp(Eamployee empioyee) {
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement ps = conn.prepareStatement(UPDATE_EMP);
            //
            ps.setString(1,empioyee.getName());
            ps.setString(2,empioyee.getPositon());
            ps.setDouble(3,empioyee.getSalay());
            ps.setInt(4,empioyee.getEmpID());

            int rs = ps.executeUpdate();
            if (rs !=0){
                System.out.println("Data with empID" +empioyee.getEmpID());
            }
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //

    }

    @Override
    public void deleteEmp(int id) {
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement ps = conn.prepareStatement(DELETE_EMP);
            //
            ps.setInt(1,id);
            int rs = ps.executeUpdate();
            if (rs !=0){
                System.out.println("Employee with empID"+"was deleted.");
            }else{
                System.out.println("Could not delete Employee with empID"+id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Eamployee findEmp(int id) {
        try {
            conn = DriverManager.getConnection(url);
            PreparedStatement ps = conn.prepareStatement(FING_EMP_BY_ID);
            //
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery(2,);
            if (rs.next()){
                int empid = rs.getInt(1,);
                String name = rs.getString
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;
    }
}
