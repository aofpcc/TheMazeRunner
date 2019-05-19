/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import java.util.*;

/**
 *
 * @author aofpcc
 */
public class Room {
    
    private static List<String> availableExit = new ArrayList<>();;
    
    private Map<String, Room> nextRoom;
    private String name;
    
    public Room(String name) {
        this.name = name;
        nextRoom = new HashMap<>();
    }
    
    public String getName() {
        return name;
    }
    
    public void setExits(Room... rooms) {
        if(rooms.length != availableExit.size()) throw new RuntimeException("Different");
        int c = 0;
        for(Room r: rooms) {
            if(r != null) nextRoom.put(availableExit.get(c++), r);
            else c++;
        }
    }
    
    public void setExits(String key, Room target) {
        if(!availableExit.contains(key)) throw new RuntimeException("Not matched room found");
        nextRoom.put(key, target);
    }
    
    public Room get(String key) {
        return nextRoom.get(key);
    }
    
    public String[] exitDoors() {
        String[] strs = nextRoom.keySet().toArray(new String[nextRoom.size()]);
        return strs;
    }
    
    public static void setAvailableExit(String... keys) {
        availableExit = Arrays.asList(keys);
    }
    
}
