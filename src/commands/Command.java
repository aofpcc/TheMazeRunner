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
public interface Command {
    public String getName();
    public void execute(List<String> args);
}
