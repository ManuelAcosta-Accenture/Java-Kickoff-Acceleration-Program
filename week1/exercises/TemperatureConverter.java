void main() {
    TemperatureConverter(39, "Celsius");
    TemperatureConverter(39, "Fahrenheit");
}

void TemperatureConverter(double temp, String option) {

    if (option.equalsIgnoreCase("Celsius")) {
            temp = (temp - 32) * (5 / 9.0);

            String temperature = String.format("%.2f", temp);
            IO.println("Temperature to Celsius: "+temperature + "C");
    }
    else if (option.equalsIgnoreCase("Fahrenheit")) {
        temp = temp * (9.0 / 5) + 32;
        String temperature = String.format("%.2f", temp);
        IO.println("Temperature to Fahrenheit: "+temperature + "F");
    }

}



