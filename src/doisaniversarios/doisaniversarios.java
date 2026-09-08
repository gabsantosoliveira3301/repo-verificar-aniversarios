package doisaniversarios;
import javax.swing.JOptionPane;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;

public class doisaniversarios {
    public static void main(String[] args) {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM");

        try {
            String nome1 = JOptionPane.showInputDialog(null, "Nome do primeiro usuário:", "Usuário 1", JOptionPane.QUESTION_MESSAGE);
            if (nome1 == null) return;
            String textoNiver1 = JOptionPane.showInputDialog(null, "Dia e mês do aniversário de " + nome1 + " (dd/MM):", "Aniversário 1", JOptionPane.QUESTION_MESSAGE);
            if (textoNiver1 == null) return;

            String nome2 = JOptionPane.showInputDialog(null, "Nome do segundo usuário:", "Usuário 2", JOptionPane.QUESTION_MESSAGE);
            if (nome2 == null) return;
            String textoNiver2 = JOptionPane.showInputDialog(null, "Dia e mês do aniversário de " + nome2 + " (dd/MM):", "Aniversário 2", JOptionPane.QUESTION_MESSAGE);
            if (textoNiver2 == null) return;

            MonthDay niver1 = MonthDay.parse(textoNiver1, formatador);
            MonthDay niver2 = MonthDay.parse(textoNiver2, formatador);

            String resultado;

            if (niver1.isBefore(niver2)) {
                resultado = nome1 + " faz aniversário primeiro que " + nome2 + "!";
            } else if (niver1.isAfter(niver2)) {
                resultado = nome2 + " faz aniversário primeiro que " + nome1 + "!";
            } else {
                resultado = "Ambos fazem aniversário no mesmo dia (" + niver1.format(formatador) + ")!";
            }

            JOptionPane.showMessageDialog(null, resultado, "Resultado", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: Digite o aniversário no formato correto (Ex: 25/10).", "Formato Inválido", JOptionPane.ERROR_MESSAGE);
        }
    }
}
