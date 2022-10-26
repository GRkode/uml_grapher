package fr.lernejo.umlgrapher;

import java.util.ArrayList;
import java.util.List;

public class InternalGraphRepresentation {
    private final Class aClass;

    public InternalGraphRepresentation(Class aClass) {this.aClass = aClass;}

    public List<Class> recursiveRelation(List<Class> recursiveList, Class... tableClasses){
        for(Class iClass : tableClasses){
            if(!recursiveList.contains(iClass)){
                recursiveList.add(iClass);
                recursiveList = recursiveRelation(recursiveList, iClass.getInterfaces());
            }
        }
        return recursiveList;
    }

    public List<Class> whatIsYourRelation(){
        List<Class> theList = new ArrayList<>();
        theList = recursiveRelation(theList, this.aClass);
        return theList;
    }
}
