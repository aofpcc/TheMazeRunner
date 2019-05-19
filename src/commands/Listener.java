/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.util.*;

/**
 *
 * @author aofpcc
 */
public class Listener {
    private List<AbstractCommand> commands;
    private Scanner scan;
    private game.Game game;
    private boolean isEnd;
    
    public Listener(game.Game game) {
        commands = new ArrayList<AbstractCommand>();
        this.game = game;
        
        commands.add(new Go(this));
        commands.add(new CommandList(this));
        scan = new Scanner(System.in);
    }

    public void listen() {
        while(true) {
            if(isEnd) return;
            System.out.print(getShell());
            String str = scan.nextLine();
            str = str.trim();
            if(str.equals("")) continue;
            String[] all = str.split("\\s+");

            
//            Arrays.asList(all).stream().forEach(System.out::println);
            if(!AbstractCommand.hasCommand(all[0])) {
                System.out.println("Unavailable Commands");
                continue;
            }
            
            Command x = commands.stream().filter( c -> c.getName().equals(all[0])).findFirst().get();
            List<String> args = new ArrayList<>(Arrays.asList(all));
            
            args.remove(0);
            x.execute(args);
        }
    }
    
    public String getShell() {
        game.Room r = game.getCurrentRoom();
        return r.getName() + " > ";
    }
    
    public void endGame() {
        isEnd = true;
    } 
    
    public game.Game getGame() {
        return game;
    }
}
