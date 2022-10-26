package fr.lernejo.umlgrapher;

public class UmlType {
    private final Class aClasse;
    private final String className;
    private final String packageName;

    public UmlType(Class aClass) {
        this.aClasse = aClass;
        this.className = aClass.getSimpleName();
        this.packageName = aClass.getPackageName();
    }

    public Class getaClasse() { return this.aClasse; }

    public String getClassName(){return this.className;}

    public String getPackageName(){return this.packageName;}
}
