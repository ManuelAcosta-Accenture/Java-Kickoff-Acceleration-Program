void main() {
    IO.println("Hola :D elige una opcion\n");
    calculadora();
}

void calculadora(){
    int opc;
    double n = 0;
    double res = 0;

    do{
        opc = Integer.parseInt(IO.readln(
                "Resultado: "+res+"\n0. Salir\n1. Sumar\n2. Restar\n3. Multiplicar\n4. Dividir\n5. Residuo\n6. Limpiar\n"));

        res = switch(opc){
          case 0 -> res;

          case 1 -> {
              n = Double.parseDouble(IO.readln(res+" + "));
              yield suma(res,n);
          }
          case 2 -> {
              n = Double.parseDouble(IO.readln(res+" - "));
              yield resta(res,n);
          }
          case 3 ->{
              n = Double.parseDouble(IO.readln(res+" * "));
              yield multiplicar(res,n);
          }
          case 4 ->{
              n = Double.parseDouble(IO.readln(res+" / "));
              yield dividir(res,n);
          }
          case 5->{
              n = Double.parseDouble(IO.readln(res+" % "));
              yield modulo(res,n);
          }
          case 6-> 0;
          default -> {
              IO.println("Opcion Incorrecta\n");
              yield res;
          }

        };
    }while (opc != 0);
}


double suma (double n1, double n2){
    return n1 + n2;
}

double resta (double n1, double n2){
    return n1-n2;
}

double multiplicar(double n1, double n2){
    return n1*n2;
}


double dividir(double n1, double n2){
    if(n2 == 0){
        IO.println("No se puede divir por 0");
        return n1;
    }
    return n1/n2;
}

double modulo(double n1, double n2){
    if(n2 == 0){
        IO.println("No se puede divir por 0");
        return n1;
    }
    return n1%n2;
}