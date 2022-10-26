package fr.lernejo.umlgrapher;

import picocli.CommandLine;
import picocli.CommandLine.Option;

public class Launcher implements Runnable {
    @Option(names = {"-c", "--classes"}, required = true ,description = "classes used")
    private final Class<?>[] theClass = null;
    @Option(names = {"-g", "--graph-type"}, required = false ,description = "Select type graph")
    private final GraphType graphType = GraphType.Mermaid;

    public void run(){
        UmlGraph graph = new UmlGraph(theClass);
        String output = graph.as(graphType);
        System.out.print(output);
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new Launcher()).execute(args);
        System.exit(exitCode);
    }
}
