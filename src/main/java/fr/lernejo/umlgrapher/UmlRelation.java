package fr.lernejo.umlgrapher;

import java.util.Set;
import java.util.List;

public class UmlRelation {
    private final Set<UmlType> theTree;

    public UmlRelation(Set<UmlType> theTree) {
        this.theTree = theTree;
    }

    public Set<MermaidLink> theRelation(Set<MermaidLink> linkers){
        String relation ="";
        for(UmlType i : theTree){
            Class[] j = i.getaClasse().getInterfaces();
            for(Class k : j){
                if(i.getaClasse().getSuperclass()==null){
                    relation = k.getSimpleName()+" <|-- " + i.getaClasse().getSimpleName() + " : extends";
                }
                else{
                    relation = k.getSimpleName()+" <|.. " + i.getaClasse().getSimpleName() + " : implements";
                }
                relation +="\n";
                linkers.add(new MermaidLink(k,i.getaClasse(),relation));
            }
        }
        return linkers;
    }

    public String allRelation(Set<MermaidLink> linkers, Set<UmlType> types){
        String relationString="";
        linkers = new UmlRelation(types).theRelation(linkers);
        for (MermaidLink i : linkers) {
            relationString += i.getLink();
        }
        return relationString;
    }
}
