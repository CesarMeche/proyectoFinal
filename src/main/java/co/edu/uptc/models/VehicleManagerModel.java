package co.edu.uptc.models;


import co.edu.uptc.dynamic.SimpleList;
import co.edu.uptc.interfaces.VehicleManagerInterface;
import co.edu.uptc.pogos.Vehicle;
import co.edu.uptc.utilities.JsonReader;
import lombok.Getter;

@Getter
public class VehicleManagerModel implements VehicleManagerInterface.Model {
    private VehicleManagerInterface.Presenter presenter;
    private SimpleList<Vehicle> vehicles;

    public VehicleManagerModel() {
        vehicles= new SimpleList<>();
        loadData();
    }

    @Override
    public void setPresenter(VehicleManagerInterface.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void loadData() {
        JsonReader jr= new JsonReader("https://data.wa.gov/api/views/f6w7-q2d2/rows.json");
       
        vehicles= jr.read();
    }
    public void sort(){
        
    }
    

}
