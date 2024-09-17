package co.edu.uptc.presenters;

import co.edu.uptc.interfaces.VehicleManagerInterface;
import lombok.Getter;
@Getter
public class Presenter implements VehicleManagerInterface.Presenter{
    private VehicleManagerInterface.View view;
    private VehicleManagerInterface.Model model;

    @Override
    public void setView(VehicleManagerInterface.View view) {
       this.view = view;
    }

    @Override
    public void setModel(VehicleManagerInterface.Model model) {
        this.model = model;
    }

    @Override
    public void loadData() {
        model.loadData();
    }
    
}
