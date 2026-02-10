package mcon364.las.touro.edu;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        //4.
        System.out.println(getGreeting("USERNAME"));
        System.out.println(getGreeting("NO_SUCH_VAR"));

        var data = List.of(
                List.of(5, 10, 15),
                List.of(20, 0, 25),
                List.of(30, 35, 40),
                List.of(45, 99, 50),
                List.of(55, 60, 65)
        );
        int result = processValues(data);
        System.out.println("Processed Rows " + result);

    }

    //2.
    public static String getGreeting(String envVarName) {
        var vars = getUserName(envVarName);
        var name = vars.orElse("Guest");
        var sb = new StringBuilder();

        sb.append("Hello, ").append(name).append("!");
        //sb.append("Hello, ");
        //sb.append(name);
        //sb.append("!");

        return sb.toString();
    }

    //1.
    public static Optional<String> getUserName(String envVarName) {
        return Optional.ofNullable(System.getenv(envVarName));

    }

    //3.
    public static int processValues(List<List<Integer>> data) {
        int processedRows = 0;

        outerLoop:
        for (List<Integer> row : data) {
            for (Integer value : row) {
                if (value == 0) {
                    continue outerLoop;
                }
                if (value == 99) {
                    break outerLoop;
                }
            }
            processedRows++;
        }
        return processedRows;
    }
}
