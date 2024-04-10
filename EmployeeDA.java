import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class EmployeeDA {
    private Employee employee; 
    public Employee getEmployee(){
      return employee;
    }
    EmployeeDA(String empNo){
       try{
            this.employee = new Employee();
            Scanner employeeFile = new Scanner(new FileReader("emp.csv"));
            employeeFile.hasNext();
            while (employeeFile.hasNext()) {
              String empLine = new String(); 
              empLine=employeeFile.nextLine();

              String[] empArr = new String[3];
              empArr = empLine.split(",");
              if(empArr[0].equals(empNo)){
                employee.setEmpNo(empArr[0].trim());
                employee.setLastName(empArr[1].trim());
                employee.setFirstName(empArr[2].trim());
              }
            }
       }catch(FileNotFoundException e){
         throw new RuntimeException(e);
       } 
    }
    
}
