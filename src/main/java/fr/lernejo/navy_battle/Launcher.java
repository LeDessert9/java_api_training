package fr.lernejo.navy_battle;

public class Launcher {
    public static void main(String[] args) throws Exception {
        final int port = Integer.parseInt(args[0]);
        var serv = new Serveur(port);
        if (args.length > 1){
            new Request().postRequest(port, args[1]);
	}
    }
}
