package fr.lernejo.umlgrapher;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command()
public class Launcher implements Runnable{
    @Option(names = {"-c", "--classes"}, required = true ,description = "define class")
    private final Class<?>[] theClass = null;
    @Option(names = {"-g", "--graph-type"}, required = false ,description = "Select type graph type")
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
