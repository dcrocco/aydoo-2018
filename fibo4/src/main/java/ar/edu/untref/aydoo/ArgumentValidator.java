package ar.edu.untref.aydoo;

public class ArgumentValidator {

    private final static String[] validArguments = new String[]{"-o=[vhp][di]", "-m=[ls]", "-n=[p]", "-f=[^\\s]+"};

    public Boolean checkArguments(String[] arguments) {
        boolean legal_arguments = true;

        if (arguments.length > 1){
            for (int i = 0; i < arguments.length - 1; i++) {
                legal_arguments = false;
                for (String validArgument : validArguments) {
                    if (arguments[i].matches(validArgument)) {
                        legal_arguments = true;
                    }
                }
            }
        }
        // El ultimo parámetro debe ser el número de la secuencia de fibonacci
        try{
            Integer.parseInt(arguments[arguments.length - 1]);
        }catch (Exception e){
            legal_arguments = false;
        }

        return legal_arguments;
    }

}