/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.util.List;

/**
 *
 * @author aofpcc
 */
public class Go extends AbstractCommand{

    public Go(Listener listener) {
        super("go");
        super.listener = listener;
    }
    
    public void execute(List<String> args) {
        if(args.size() == 0) {
            System.out.println("Go Where?");
            return;
        }
        String direction = args.get(0);
        game.Room room = listener.getGame().getCurrentRoom();
        game.Room nextRoom = room.get(direction);
        if(nextRoom == null) {
            System.out.println("No door opened in that direction");
        }else {
            listener.getGame().setCurrentRoom(nextRoom);
            if(nextRoom.getName().equals("Exit!!!!!")) {
                System.out.println("Congatulation ! Well done.!");
                listener.endGame();
            }
        }
    }
}
