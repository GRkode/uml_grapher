package fr.lernejo.umlgrapher;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UmlGraph {
    private Class<?>[] iClass;
    private final Set<UmlType> types = new TreeSet<>(Comparator
        .<UmlType, String>comparing(t->t.getClassName())
        .thenComparing(t->t.getPackageName()));

    private final Set<MermaidLink> linkers = new TreeSet<>(Comparator
        .<MermaidLink, String>comparing(t->t.getChildClass())
        .thenComparing(t->t.getParentClass()));

    public UmlGraph(Class<?>... classe){
        this.iClass = classe;
    }

    public String as (GraphType graphType){
        List<Class> tabClass = null;
        for (Class nClass : iClass) {
            switch (graphType) {
                case Mermaid:
                    tabClass = new InternalGraphRepresentation(nClass).whatIsYourRelation();
                    for (Class i : tabClass) {
                        types.add(new UmlType(i));
                    }
                break;
            }
        }
        String relationclass = new UmlRelation(types).allRelation(linkers, types);
        String returnvalue = new MermaidFormatter(types).words();
        return returnvalue + relationclass;
    }
}
