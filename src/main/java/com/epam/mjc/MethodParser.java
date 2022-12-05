package com.epam.mjc;


import java.util.StringTokenizer;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {
        MethodSignature result = new MethodSignature("");
        int indexArg = signatureString.indexOf('(');
        String argumentsAtChars = signatureString.substring(indexArg+1, signatureString.length()-1);
        String withoutArguments = signatureString.substring(0,indexArg);
        String[] wA = withoutArguments.split(" ");
        if (wA.length>2){
            result.setMethodName(wA[2]);
            result.setAccessModifier(wA[0]);
            result.setReturnType(wA[1]);
        }
        else {
            result.setMethodName(wA[1]);
            result.setReturnType(wA[0]);
            result.setAccessModifier(null);
        }
        StringTokenizer argumentsInString = new StringTokenizer(argumentsAtChars, ", ");
        int i = 0;
        while (argumentsInString.hasMoreTokens()){
            result.getArguments().add(i, new MethodSignature.Argument(argumentsInString.nextToken(), argumentsInString.nextToken()));
            i++;
        }
        return result;
    }
}
