import java.util.HashMap;

public class Department {
    private String depCode;
    private String depName;
    private Double depTotalSalary=0.00;
    private HashMap<String,Employee> empMap;

    public void setDepcode(String depCode){
        this.depCode = depCode;
    }
    public void setDepName(String depName){
        this.depName = depName;
    }
    public void setDepTotalSalary(Double depTotalSalary){
        this.depTotalSalary += depTotalSalary;
    }
    public void setEmpMap(HashMap<String,Employee> empMap){
        this.empMap= empMap;
    }

    public String getDepCode(){
        return depCode;
    }
    public String getDepName(){
        return depName;
    }
    public Double getDepTotalSalary(){
        return depTotalSalary;
    }
    public HashMap<String,Employee> getEmpMap(){
        return empMap;
    }
    
    
}
