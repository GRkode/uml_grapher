package fr.lernejo.umlgrapher;

import java.util.Set;

public class MermaidLink {
    private final String ChildClass;
    private final String ParentClass;
    private final String theliason;

    public MermaidLink(Class ParentClass,Class ChildClass,String theliason){
        this.ChildClass = ChildClass.getSimpleName();
        this.ParentClass = ParentClass.getSimpleName();
        this.theliason = theliason;
    }

    public String getChildClass(){
        return this.ChildClass;
    }

    public String getParentClass(){
        return this.ParentClass;
    }
    public String getLink(){
        return this.theliason;
    }
}
