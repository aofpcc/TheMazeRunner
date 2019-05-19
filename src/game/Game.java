/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import commands.AbstractCommand;
/**
 *
 * @author aofpcc
 */
public class Game {
    
    private Room[][] rooms;
    private Room currentRoom;
    private Room exitRoom;
    
    public Game() {
        createGame();
        commands.Listener l = new commands.Listener(this);
        l.listen();
    }
    
    private void createGame() {
        
        Room.setAvailableExit(new String[]{ "top", "right", "bottom", "left"});
        rooms = new Room[6][6];
        
        for(int i = 0; i < 6; ++i) {
            for(int j = 0; j < 6; ++j) {
                rooms[i][j] = new Room("[" + i + ", " + j + "]");
            }
        }
        
        currentRoom = rooms[0][0];
        exitRoom = new Room("Exit!!!!!");
        
        rooms[0][0].setExits(null, null, rooms[0][1], null);
        rooms[0][1].setExits(null, rooms[0][2], rooms[1][1], null);
        rooms[0][2].setExits(null, rooms[0][3], null, rooms[0][1]);
        rooms[0][3].setExits(null, rooms[0][4], rooms[1][3], rooms[0][2]);
        rooms[0][4].setExits(null, rooms[0][5], null, rooms[0][3]);
        rooms[0][5].setExits(null, null, rooms[1][5], rooms[0][4]);
        
        rooms[1][0].setExits(rooms[0][0], rooms[1][1], null, null);
        rooms[1][1].setExits(rooms[0][1], null, rooms[2][1], rooms[1][0]);
        rooms[1][2].setExits(null, null, rooms[2][2], null);
        rooms[1][3].setExits(rooms[0][3], null, null, null);
        rooms[1][4].setExits(null, null, rooms[2][4], null);
        rooms[1][5].setExits(rooms[0][5], null, rooms[2][5], null);
        
        rooms[2][0].setExits(null, null, rooms[3][0], null);
        rooms[2][1].setExits(rooms[1][1], null, rooms[3][1], null);
        rooms[2][2].setExits(rooms[1][2], null, rooms[3][2], null);
        rooms[2][3].setExits(null, rooms[2][4], rooms[3][3], null);
        rooms[2][4].setExits(rooms[1][4], rooms[2][5], null, rooms[2][3]);
        rooms[2][5].setExits(rooms[1][5], null, null, rooms[2][4]);
        
        rooms[3][0].setExits(rooms[2][0], rooms[3][1], null, null);
        rooms[3][1].setExits(rooms[2][1], null, rooms[4][1], rooms[3][0]);
        rooms[3][2].setExits(rooms[2][2], rooms[3][3], null, null);
        rooms[3][3].setExits(rooms[2][3], null, rooms[4][3], rooms[3][2]);
        rooms[3][4].setExits(null, rooms[3][5], rooms[4][4], null);
        rooms[3][5].setExits(null, null, rooms[4][5], rooms[3][4]);
        
        rooms[4][0].setExits(null, rooms[4][1], rooms[5][0], null);
        rooms[4][1].setExits(rooms[3][1], rooms[4][2], null, rooms[4][0]);
        rooms[4][2].setExits(null, rooms[4][3], rooms[5][2], rooms[4][1]);
        rooms[4][3].setExits(rooms[3][3], null, rooms[5][3], rooms[4][2]);
        rooms[4][4].setExits(rooms[3][4], null, rooms[5][4], null);
        rooms[4][5].setExits(rooms[3][5], null, rooms[5][5], null);
        
        rooms[5][0].setExits(rooms[4][0], null, null, null);
        rooms[5][1].setExits(null, rooms[5][2], null, null);
        rooms[5][2].setExits(rooms[4][2], null, null, rooms[5][1]);
        rooms[5][3].setExits(rooms[4][3], rooms[5][4], null, null);
        rooms[5][4].setExits(rooms[4][4], null, null, rooms[5][3]);
        rooms[5][5].setExits(rooms[4][5], exitRoom, null, null);
        
    }
    
    public Room getCurrentRoom() {
        return currentRoom;
    }
    
    public void setCurrentRoom(Room r) {
        currentRoom = r;
    }
    
}
