package co.edu.uptc.models;


import co.edu.uptc.dynamic.SimpleList;
import co.edu.uptc.interfaces.VehicleManagerInterface;
import co.edu.uptc.model.MySort;
import co.edu.uptc.pogos.Table;
import co.edu.uptc.pogos.Vehicle;
import co.edu.uptc.utilities.JsonReader;
import co.edu.uptc.utilities.sorters.*;
import lombok.Getter;

@Getter
public class VehicleManagerModel implements VehicleManagerInterface.Model {
    private VehicleManagerInterface.Presenter presenter;
    private SimpleList<Vehicle> vehicles;

    public VehicleManagerModel() {
        vehicles= new SimpleList<>();
        loadData();
        //litar();
        sort();
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
    public SimpleList litar(){
        SimpleList<String> states = new SimpleList<String>();
        SimpleList<Table> tables = new SimpleList<Table>();
        Table aux;
        for (Vehicle vehicle : vehicles) {

            if(!states.contains(vehicle.getState())){
                aux = new Table(vehicle.getState(), 1);
                states.add(vehicle.getState());
                tables.add(aux);
            }else{
                int auxi=0;
       
                while (!vehicle.getState().equals(states.get(auxi))) {
                    
                   auxi++;
                }
                add(tables.get(auxi));
            }
        }
        System.out.println("finañ");
        return tables;

    }
    private Table add(Table t){
        t.setCan(t.getCan()+1);
        return t;
    }
    private void sort(){
        SimpleList sp= this.litar();
        ComparadorStados c = new ComparadorStados();
        c.compare(sp, c);
        MySort.sort(sp, c);

    }
    

}
