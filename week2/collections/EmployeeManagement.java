import java.util.LinkedList;

public class Employee{
    private int id;
    private String name;
    private String dpto;
    private double salary;

    public Employee(int id, String name, String dpto, double salary){
        this.id = id;
        this.name = name;
        this.dpto = dpto;
        this.salary = salary;
    }

    public int getId(){
        return id;
    }

    public double getSalary(){
        return salary;
    }

}


LinkedList<Employee> employeeList = new LinkedList<>();

void main() {
    int opc;
    while (true){
        opc = Integer.parseInt(IO.readln("\n1. Agregar\n2. Borrar \n3. Buscar Empleado\n4. Buscar Empleado por Dpto\n5. Calcular Salario\n6. Exit\nElija una opcion:\n"));
        if(opc == 6){
            IO.println("Saliendo...");
            break;
        }
        employeeManagement(opc);
    }
}

void employeeManagement(int opc){

    switch (opc){
        case 1:
            addEmployee();
            break;
        case 2:
            removeEmployee();
            break;
        case 3:
            findEmployee();
            break;
        case 4:
            findByDepartment();
            break;
        case 5:
            calculateAverageSalary();
            break;
    }
}


void addEmployee(){
    int id;
    String name;
    String dpto;
    double salary;

    id = Integer.parseInt(IO.readln("ID: "));
    name = IO.readln("Nombre: ");
    dpto = IO.readln("Departamento: ");
    salary = Double.parseDouble(IO.readln("Salario: "));

    employeeList.add(new Employee(id,name,dpto, salary));
}

void removeEmployee(){
    int id;
    id = Integer.parseInt(IO.readln("ID a borrar: "));

    employeeList.removeIf(emp -> emp.getId() == id);
}

void findEmployee(){
    int id;
    id = Integer.parseInt(IO.readln("ID del empleado a buscar: "));

    for (Employee emp: employeeList){
        if (emp.id == id){
            IO.println("Empleado\n"+"ID: "+emp.id+"\nNombre: "+emp.name+"\nDepartamento: "+emp.dpto);
            break;
        }
    }
}

void findByDepartment(){
    String dpto;
    dpto = IO.readln("Departamento de los empleados a buscar: ");

    for (Employee emp: employeeList){
        if (dpto.equals(emp.dpto)){
            IO.println("Empleado\n"+"ID: "+emp.id+"\nNombre: "+emp.name+"\nDepartamento: "+emp.dpto);
        }
    }
}

void calculateAverageSalary() {
    if (employeeList.isEmpty()) {
        IO.println("No hay empleados registrados.");
        return;
    }

    double totalSalary = 0;

    for (Employee emp : employeeList) {
        totalSalary += emp.getSalary();
    }

    double average = totalSalary / employeeList.size();

    IO.println("El promedio de los salarios es: " + average);
}