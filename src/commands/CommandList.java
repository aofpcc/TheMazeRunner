/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author aofpcc
 */
public class CommandList extends AbstractCommand {
    
    public CommandList(Listener listener) {
        super("list");
        super.listener = listener;
    }
    
    public void execute(List<String> args) {
        game.Room r = listener.getGame().getCurrentRoom();
        StringBuilder sb = new StringBuilder();
        Arrays.asList(r.exitDoors()).stream().forEach(s -> sb.append(s + " "));
        System.out.println("Available Exit: " + sb);
    }
}
