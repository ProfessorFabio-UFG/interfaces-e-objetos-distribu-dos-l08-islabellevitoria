@Override
public String toUpperCase(String input) {
    return input.toUpperCase();
}

@Override
public double media(double[] numeros) {
    double soma = 0;
    for (double num : numeros) {
        soma += num;
    }
    return numeros.length == 0 ? 0 : soma / numeros.length;
}
