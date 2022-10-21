package fr.lernejo.umlgrapher;

public class UmlGraph {

    public UmlGraph(Class<?>...classes){

    }

    public String as(GraphType graphType){
        if (graphType == GraphType.Mermaid){
            return """
            classDiagram
            class Machin {
                <<interface>>
            }
            """;
        }
        return  "";
    }

}
