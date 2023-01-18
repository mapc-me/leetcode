package dfs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        dfs(rooms, 0, visited);

        return visited.size() == rooms.size();

    }

    void dfs(List<List<Integer>> rooms, int room, Set<Integer> visited) {
        if (visited.contains(room)) {
            return;
        }
        visited.add(room);

        for (Integer connectedRoom : rooms.get(room)) {
            dfs(rooms, connectedRoom, visited);
        }
    }
}
