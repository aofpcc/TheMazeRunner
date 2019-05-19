/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aofpcc
 */
public abstract class AbstractCommand implements Command {
    private static List<String> commandLists = new ArrayList<>();
    protected static Listener listener;
    
    private String name;
    
    public AbstractCommand(String name) {
        this.name = name;
        commandLists.add(name);
    }
    
    public static boolean hasCommand(String s) {
        return commandLists.stream().anyMatch(str -> str.trim().equals(s));
    }
    
    public String getName() {
        return name;
    }
    
}
