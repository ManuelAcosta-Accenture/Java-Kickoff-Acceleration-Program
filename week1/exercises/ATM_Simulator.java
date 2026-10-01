void main() {
    int opc;
    int balance = 0;

    while(true) {
        IO.println("\n//\tATM\t //");
        opc = Integer.parseInt(IO.readln("\n1. Revisar Balance\n2. Depositar\n3. Retirar\n4. Exit\nElija una opcion: "));

        if(opc == 4){
            IO.println("Saliendo...");
            break;
        }

        balance = atm(opc,balance);
    }
}

int atm(int opc, int balance){
    int cantidad;
    int nuevoBalance;

    balance = switch(opc){

        //Revisar balance
        case 1 -> {
            IO.println("Saldo: "+balance);
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
            yield nuevoBalance;
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