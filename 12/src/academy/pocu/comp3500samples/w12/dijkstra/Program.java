package academy.pocu.comp3500samples.w12.dijkstra;

import java.util.HashMap;
import java.util.LinkedList;

public class Program {
    public static void main(String[] args) {
        HashMap<String, Node> nodes = createNodes();

        HashMap<String, String> previous = new HashMap<>();

        HashMap<String, Integer> minDists = Dijkstra.run(nodes, "Home", previous);

        int schoolDist = minDists.get("School");
        System.out.println(schoolDist);

        int bankDist = minDists.get("Bank");
        System.out.println(bankDist);

        int libDists = minDists.get("Library");
        System.out.println(libDists);

        LinkedList<String> path = new LinkedList<>();

        String name = "School";
        while (name != null) {
            path.addFirst(name);
            name = previous.get(name);
        }

        String pathString = String.join(" -> ",
                path);

        System.out.println(pathString);
    }

    private static HashMap<String, Node> createNodes() {
        Node home = new Node("Home");
        Node policeStation = new Node("Police Station");
        Node school = new Node("School");
        Node park = new Node("Park");
        Node bank = new Node("Bank");
        Node library = new Node("Library");

        home.addRoad(policeStation, 2);
        policeStation.addRoad(home, 2);

        home.addRoad(park, 3);
        park.addRoad(home, 3);

        policeStation.addRoad(bank, 1);
        bank.addRoad(policeStation, 1);

        policeStation.addRoad(school, 6);
        school.addRoad(policeStation, 6);

        bank.addRoad(library, 2);
        library.addRoad(bank, 2);

        bank.addRoad(park, 2);
        park.addRoad(bank, 2);

        school.addRoad(library, 1);
        library.addRoad(school, 1);

        HashMap<String, Node> nodes = new HashMap<>();

        nodes.put(home.getName(), home);
        nodes.put(policeStation.getName(), policeStation);
        nodes.put(school.getName(), school);
        nodes.put(park.getName(), park);
        nodes.put(bank.getName(), bank);
        nodes.put(library.getName(), library);

        return nodes;
    }
}
