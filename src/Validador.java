public class Validador {

    public static boolean validarCPF(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) return false;

        String limpo = sanitize(cpf);

        if (!temTamanhoValido(limpo)) return false;
        if (isSequencia(limpo)) return false;

        int dv1 = calculaDV(limpo.substring(0, 9), 10);
        int dv2 = calculaDV(limpo.substring(0, 9) + dv1, 11);

        return digito(limpo, 9) == dv1 && digito(limpo, 10) == dv2;
    }

    //classes privadas para garantir o comportamento e que ninguem mude-as

    /*remove tudo que não for dígito*/
    private static String sanitize(String cpf) {
        return cpf.trim().replaceAll("\\D", "");
    }

    /*exige exatamente 11 dígitos*/
    private static boolean temTamanhoValido(String s) {
        return s.matches("\\d{11}");
    }

    /*verdadeiro se todos os caracteres são iguais (ex.: "00000000000")*/
    private static boolean isSequencia(String s) {
        return s.chars().distinct().count() == 1;
    }

    /* calcula DV com peso decrescente a partir de pesoInicial
     regra 11-resto (>=10 vira 0) */
    private static int calculaDV(String base, int pesoInicial) {
        int soma = 0;
        for (int i = 0; i < base.length(); i++) {
            int dig = base.charAt(i) - '0';
            soma += dig * (pesoInicial - i);
        }
        int resto = soma % 11;
        int dv = 11 - resto;
        return (dv >= 10) ? 0 : dv;
    }

    /* converte o caractere numérico da posição para inteiro (0–9) */
    private static int digito(String s, int pos) {
        return s.charAt(pos) - '0';
    }

}

