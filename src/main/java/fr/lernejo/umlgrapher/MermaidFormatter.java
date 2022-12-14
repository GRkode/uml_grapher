package fr.lernejo.umlgrapher;

import java.lang.reflect.Modifier;
import java.util.Set;

public class MermaidFormatter {
    private final Set<UmlType> types;

    public MermaidFormatter(Set<UmlType> types) { this.types = types; }

    public String words(){
        String chaine = "classDiagram\n";
        for(UmlType atype: types){
            chaine +="class " + atype.getClassName();
            if(Modifier.isInterface(atype.getaClasse().getModifiers())){
                chaine += " {\n    <<interface>>\n}";
            }
            chaine += "\n";
        }
        return chaine;
    }
}
