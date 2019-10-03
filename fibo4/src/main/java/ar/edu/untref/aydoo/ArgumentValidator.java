package ar.edu.untref.aydoo;

public class ArgumentValidator {

    private final static String[] validArguments = new String[]{"-o=[vhp][di]", "-m=[ls]", "-n=[p]", "-f=[^\\s]+"};

    public Boolean checkArguments(String[] arguments) {
        boolean legalArguments = true;

        if (arguments.length > 1){
            for (int i = 0; i < arguments.length - 1; i++) {
                legalArguments = false;
                for (String validArgument : validArguments) {
                    if (arguments[i].matches(validArgument)) {
                        legalArguments = true;
                    }
                }
            }
        }
        // El ultimo parámetro debe ser el número de la secuencia de fibonacci
        try{
            Integer.parseInt(arguments[arguments.length - 1]);
        }catch (Exception e){
            legalArguments = false;
        }

        return legalArguments;
    }

}