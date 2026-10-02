String nombre;
String password;
String historial = "\nTransacciones\n";

void main() {
    int opc;
    int balance = 0;

    IO.println("\n===\tAccenture Bank Account\t===");
    IO.println("Crea tu cuenta\n");
    login();

    while(true) {

        opc = Integer.parseInt(IO.readln("\n1. Revisar Saldo\n2. Depositar\n3. Retirar\n4. Historial\n5. Exit\nElija una opcion:\n"));

        if(opc == 5){
            IO.println("Saliendo...");
            break;
        }

        balance = operations(opc,balance);
    }
}

void login(){
    nombre = IO.readln("Ingresa tu nombre: ");
    password = IO.readln("Crea tu contraseña: ");
}

void showInfo(int balance){
    IO.println("===\tAccenture Bank Account\t===");
    IO.println("Cuenta: "+nombre);
    IO.println("Saldo: $"+balance);
}

int operations(int opc, int balance){
    int cantidad;
    int nuevoBalance;

    balance = switch(opc){

        //Revisar balance
        case 1 -> {
            showInfo(balance);
            yield balance;
        }
        //Depositar
        case 2 -> {
            cantidad = Integer.parseInt(IO.readln("Deposite: "));
            if(cantidad > 0){
                nuevoBalance = depositar(cantidad,balance);
            } else{
                IO.println("Monto invalido ");
                nuevoBalance = balance;
            }
            showInfo(nuevoBalance);
            agregarOperacion(nuevoBalance, cantidad, "Deposito");
            yield nuevoBalance;
        }
        //Retirar
        case 3 ->{
            cantidad = Integer.parseInt(IO.readln("Retirar: "));
            if(cantidad < balance && cantidad > 0){ //tiene saldo para retirar y va a retirar mas de 0
                nuevoBalance = retirar(cantidad,balance);
            } else{
                IO.println("Monto invalido");
                nuevoBalance = balance;
            }
            showInfo(nuevoBalance);
            agregarOperacion(nuevoBalance, cantidad, "Retiro");
            yield nuevoBalance;
        }
        //Historial
        case 4->{
            IO.println(historial);
            yield balance;
        }

        default -> {
            IO.println("Opcion Incorrecta\n");
            yield balance;
        }

    };
    return balance;
}

int depositar (int n1, int n2){
    return n1 + n2;
}

int retirar (int n1, int n2){
    return n2-n1;
}

void agregarOperacion(int balance, int cantidad, String operacion ){

    historial = historial + operacion+"\nCantidad: $"+cantidad+" Balance Final: $"+balance+"\n";
}
