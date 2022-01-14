package pl.pjwstk.s19916.tau.app;


public class StringManipulator {

    private StringHolder stringToHold ;

    public String addSpaceAtEnd(String text){
        return text + " ";
    }

    public String addSpaceAtBeggining(String text){
        return " " + text;
    }

    public String addInternalVarToTheEnd(String text){
        return text + " " + stringToHold.getStringThatWeHold();
    }

}