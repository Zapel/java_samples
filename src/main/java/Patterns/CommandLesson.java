package Patterns;

import java.util.ArrayList;
import java.util.List;

public class CommandLesson {
    public static void main(String[] args) {
        Receiver receiver = new Receiver ();
        receiver.addCommand ( new MouseClick () );
        receiver.addCommand ( new MousePrees () );
        receiver.RunCommand ();
    }
}

interface Command {
    void execute();
    void revert();
}

class MouseClick implements Command {
    @Override
    public void execute() {
        System.out.println ("click mouse");
    }

    @Override
    public void revert() {
        System.out.println ("revert");
    }
}

class MousePrees implements Command {
    @Override
    public void execute() {
        System.out.println ("click mouse pressed");
    }

    @Override
    public void revert() {
        System.out.println ("revert");
    }
}

class Receiver {
    List<Command> commands = new ArrayList<> (  );

    void addCommand(Command command) {
        commands.add ( command );
    }

    void RunCommand() {
        try {
            for (Command command : commands) {
                command.execute ();
            }
        } catch (Exception e) {
            for (Command command : commands) {
                command.revert ();
            }
        }
    }
}