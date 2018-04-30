package ar.edu.untref.aydoo;

public class PrinterWithDirection extends Printer {

    private char direction;

    PrinterWithDirection(char direction){
        this.direction = direction;
    }

    @Override
    public String print(String text_to_print) {
        // Invertimos el texto, dejando las primeras palabras al final y viceversa
        if (this.direction == 'i'){
            StringBuilder new_text = new StringBuilder();
            String[] splitted_string = text_to_print.split(" ");
            for (int i = splitted_string.length - 1; i > 0; i--){
                new_text.append(" ").append(splitted_string[i]);
            }
            text_to_print = new_text.toString();
        }

        return text_to_print;
    }
}
