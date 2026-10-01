int max = 100;
int min = 1;

void main() {
    String respuesta;
    int numeroGenerado;
    numeroGenerado = generateNumber();

    while(true){
        IO.println("Escribe exit para salir");

        respuesta = IO.readln("\nAdivine el numero entero del 1 al 100: ");
        if(respuesta.equals("exit")){
            IO.println("\nbyeee");
            break;
        } else if (Integer.parseInt(respuesta) < numeroGenerado){
            IO.println("No! es mayor\n");
        } else if (Integer.parseInt(respuesta) > numeroGenerado) {
            IO.println("No! es menor\n");
        } else{
          IO.println("Correcto! el numero era "+numeroGenerado);
          IO.println("Juega de nuevo :D\n");
          numeroGenerado = generateNumber();
        }
    }
}

int generateNumber(){
    // (int) (Math.random() * (max - min + 1)) + min
    return (int)(Math.random() * (max - min+1)) + min;
}