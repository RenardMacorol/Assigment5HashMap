import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.text.DecimalFormat;

public class DepartmentDA {
   
   DepartmentDA(){
        try{
            Scanner departmentFile = new Scanner(new FileReader("dep.csv"));
            departmentFile.nextLine();

            while(departmentFile.hasNext()){
                String departmentLine = new String();
                departmentLine = departmentFile.nextLine();

                String[] depArr = new String[3];
                depArr = departmentLine.split(",");
                
                Department department = new Department();
                department.setDepcode(depArr[0].trim());
                department.setDepName(depArr[1].trim());
                readDepEmp(department);
                printDepartment(department);
            }
            
        }catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }

    }
   
   public void readDepEmp(Department department){
        try{
            Scanner depEmpFile = new Scanner(new FileReader("deptemp.csv"));
            depEmpFile.nextLine();
            Integer key =0; 
            HashMap<String, Employee> employeeMap= new HashMap<>();
            while(depEmpFile.hasNext()){
                String depEmpline = new String();
                depEmpline = depEmpFile.nextLine();
                String[] depEmpArr = new String[3];
                depEmpArr = depEmpline.split(",");
                EmployeeDA employee = new EmployeeDA(depEmpArr[1].trim());
                if(department.getDepCode().equals(depEmpArr[0].trim())){
                    employee.getEmployee().setSalary(Double.parseDouble(depEmpArr[2]));
                    employeeMap.put(employee.getEmployee().getEmpNo()+key,employee.getEmployee());
                    key++;
                }
            }
            for(Map.Entry<String, Employee> entryMap : employeeMap.entrySet()){
                department.setDepTotalSalary(entryMap.getValue().getSalary());
            }
            department.setEmpMap(employeeMap);
        }catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }

   }
   public void printDepartment(Department department){
        DecimalFormat df = new DecimalFormat("#,###.00");
        System.out.println("Department Code: "+ department.getDepCode());
        System.out.println("Department Name: "+ department.getDepName());
        System.out.println("Department total Salary: "+ df.format(department.getDepTotalSalary()));
        System.out.println("------------Details----------------");
        System.out.println("EmpNo \t\tEmployeeName \t\tSalary");
        for(Map.Entry<String,Employee> entryMap : department.getEmpMap().entrySet()){
            System.out.printf("%s \t%-20s %20s\n",entryMap.getKey(),entryMap.getValue().getLastName()+","+entryMap.getValue().getFirstName(), df.format(entryMap.getValue().getSalary()));
        }
        System.out.println();

    
   } 
}
