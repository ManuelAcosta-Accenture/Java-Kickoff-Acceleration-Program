void main() {
    String n;

    while(true) {
        n = IO.readln("Ingrese su numero: ");
        if(n.equals("exit")){
            IO.println("\nbyeee");
            break;
        }
        analyze(Integer.parseInt(n));
    };
}

void analyze(int num){
    boolean isPrime;

    isPrime = num > 1;
    for (int i = 2;i <= Math.sqrt(num) && isPrime; i++){
        isPrime = num % i != 0;
    }

    IO.println(num % 2 == 0 ? "Even" : "Odd");
    IO.println(num >= 0 ? "Positive" : "Negative");
    IO.println(isPrime ? "Prime": "Not Prime");

}