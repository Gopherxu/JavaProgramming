class Employee{

    String empName;
    int empID;
    Employee(String empName, int empId){
        this.empName = empName;
        this.empID = empId;
    }
    public static void main(String[] args){
        System.out.println("Its going Good !..");
        Employee emp1 = new Employee("Ram",1);
        Employee emp2 = new Employee("kartik",2);
        System.out.println("1st Employee Name :-"+emp1.empID+" 2nd Employee Name :- "+emp2.empID);

    } 

}