package ar.edu.untref.aydoo;

public class Program {

    private static int limitSuccession = 0;

    public static void main(String[] args) {

        boolean isRightArgument = new ArgumentValidator().checkArguments(args);
        if (isRightArgument) {
            args = completeArguments(args);
            Fibonacci aFibonacci = createFibonacci(args);

            Boolean isVertical = args[0].matches("-o=[v][a-zA-Z]");
            String successionWithFormat = giveShapeToFibonacci(aFibonacci, args[0]);
            String output = obtainOutput(args, aFibonacci, isVertical, successionWithFormat);
            System.out.println(output);
        } else {
            System.out.println("Opciones no validas.");
        }
    }

    private static String obtainOutput(String[] args, Fibonacci aFibonacci, Boolean isVertical, String successionWithFormat) {
        String output;
        if(writeInFile(args[1])) {
            String nameOfFile = obtainNameFile(args[1]);
            FibonacciWriter fibonacciWriter = new FibonacciWriter();
            String text = obtainTextToShow(args[2], successionWithFormat, aFibonacci, isVertical);
            fibonacciWriter.write(nameOfFile, text);
            output = "fibo<" + limitSuccession + "> guardado en " + nameOfFile;
        } else {
            output = obtainTextToShow(args[1], successionWithFormat, aFibonacci, isVertical);
        }
        return output;
    }

    private static Fibonacci createFibonacci(String[] args) {
        limitSuccession = obtainLimitSuccession(args);
        Boolean isInverted = args[0].matches("-o=[a-zA-Z][i]");
        Fibonacci fibo = new Fibonacci(limitSuccession, isInverted);
        return keepOnlyPairs(fibo, args);
    }

    private static Fibonacci keepOnlyPairs(Fibonacci fibo, String[] args){
        for (int i = 0; i < args.length - 1; i++){
            if (args[i].matches("-n=[p]")){
                fibo.keepOnlyPairs();
            }
        }
        return fibo;
    }

    private static String obtainNameFile(String argument) {
        String[] arrayArgument = argument.split("=");
        return arrayArgument[1];
    }

    private static String giveShapeToFibonacci(Fibonacci aFibonacci, String args) {
        ShapeToFibonacci shapeToFibonacci;
        if (args.matches("-o=[v][a-zA-Z]")){
            shapeToFibonacci = new VerticalFibonacci();
        }else if (args.matches("-o=[p][a-zA-Z]")){
            shapeToFibonacci = new ProgressiveFibonacci();
        }else{
            shapeToFibonacci = new HorizontalFibonacci();
        }
        return shapeToFibonacci.giveShape(aFibonacci.getSuccession());
    }

    private static String obtainTextToShow(String argument, String successionWithShape, Fibonacci aFibonacci, Boolean isVertical) {
        StringBuffer stringBuffer = new StringBuffer();
        if(isModeSummation(argument)) {
            stringBuffer.append("fibo<" + limitSuccession + ">s: ");
            if(isVertical) {
                stringBuffer.append("\n");
            }
            stringBuffer.append(aFibonacci.sumSuccession());
        } else {
            stringBuffer.append("fibo<" + limitSuccession + ">:");
            stringBuffer.append(successionWithShape);
        }
        return stringBuffer.toString();
    }

    private static int obtainLimitSuccession(String[] args) {
        return Integer.valueOf(args[args.length - 1]);
    }

    private static Boolean writeInFile(String arg) {
        return arg.contains("-f");
    }

    private static Boolean isModeSummation(String arg) {
        return arg.contains("-m=s");
    }

    private static String[] completeArguments(String[] args) {
        String[] arguments = args;
        if (arguments.length == 1) {
            arguments = new String[]{"-o=hd", args[0]};
        }
        return arguments;
    }
}