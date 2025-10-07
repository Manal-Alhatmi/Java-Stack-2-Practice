import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Navigator {

    public List<String> traceBack(List<String> forwardJourney) {
        Stack<String> pathStack = new Stack<>();
        for (String step : forwardJourney) {
            pathStack.push(step);
        }

        List<String> returnJourney = new ArrayList<>();
        while (!pathStack.isEmpty()) {
            String currentStep = pathStack.pop();
            String oppositeStep = getOppositeStep(currentStep);
            returnJourney.add(oppositeStep);
        }
        return returnJourney;
    }

    private String getOppositeStep(String step) {
        if (step.equals("RIGHT")){
            return "LEFT";
        }

        if (step.equals("LEFT")){
            return "RIGHT";
        }

        if (step.startsWith("TAKE EXIT")){
            String exitNumber=step.replaceAll("[^0-9]", " ");
            return "ENTER ROUND ABOUT AT EXIT" + exitNumber;
        }

        return "";
    }
}