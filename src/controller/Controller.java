package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.View;

public class Controller implements ActionListener {
    private View v;
    public Controller(View v){
        this.v = v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("Save")){
            this.v.save();
            return;
        }
        if (src.equals("Clear")){
            this.v.clear();
            return;
        }
        if (src.equals("Read file")){
            this.v.read();
            return;
        }
    }
}
