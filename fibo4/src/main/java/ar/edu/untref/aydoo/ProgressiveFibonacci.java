package ar.edu.untref.aydoo;

import java.util.ArrayList;
import java.util.List;

public class ProgressiveFibonacci implements ShapeToFibonacci {

    @Override
    public String giveShape(List<Integer> succession) {
        StringBuilder out = new StringBuilder();
        List<Integer> successionCopy = new ArrayList<>(succession);

        int counter = 0;
        while(counter < successionCopy.size()){
            out.append("\n");
            for (int i = 0; i <= counter; i++){
                out.append(successionCopy.get(i)).append(" ");
            }
            counter++;
        }

        return out.toString();
    }
}
