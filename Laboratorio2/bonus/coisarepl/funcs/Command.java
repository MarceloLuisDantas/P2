package coisarepl.funcs;

public class Command {
    public final String comando;
    public final String[] argumentos;

    Command(String comando, String[] argumentos) {
        this.comando = comando;
        this.argumentos = argumentos;
    }

    private Boolean checkSintax() { return true; };
    public void execute() {};
    public void help() {};
}
