public class Validador {

    public static boolean validarCPF(String cpf) {

        if (cpf == null || cpf.trim().isEmpty()) return false;

        String limpo = cpf.trim().replaceAll("[.-]", "");

        if (!limpo.matches("\\d{11}")) return false;

        if (limpo.chars().distinct().count() == 1) return false;

        int dv1 = calculaDV(limpo.substring(0, 9), 10);
        int dv2 = calculaDV(limpo.substring(0, 9) + dv1, 11);

        return (limpo.charAt(9)  - '0') == dv1 && (limpo.charAt(10) - '0') == dv2;
    }

    private static int calculaDV(String base, int pesoInicial) {
        int soma = 0;
        for (int i = 0; i < base.length(); i++) {
            int digito = base.charAt(i) - '0';
            soma += digito * (pesoInicial - i);
        }
        int resto = soma % 11;
        int dv = 11 - resto;
        if (dv >= 10) dv = 0; // regra do CPF
        return dv;
    }

}

