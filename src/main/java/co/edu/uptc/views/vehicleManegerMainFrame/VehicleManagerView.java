package co.edu.uptc.views.vehicleManegerMainFrame;

import java.awt.LayoutManager;

import javax.swing.JFrame;

import co.edu.uptc.interfaces.VehicleManagerInterface;
import co.edu.uptc.interfaces.VehicleManagerInterface.Presenter;
import lombok.Getter;
import java.awt.BorderLayout;
import java.awt.CardLayout;

@Getter
public class VehicleManagerView extends JFrame implements VehicleManagerInterface.View{
    private VehicleManagerInterface.Presenter presenter;
    private VehicleManagerHeader vehicleManagerHeader;
    private VehicleManagerBody vehicleManagerBody;
    private VehicleManagerAside vehicleManagerAside;
    private CardLayout bodyCardLayout;
    private CardLayout asideCardLayout;

    public VehicleManagerView(){
        this.initFrame();
        this.createVehicleManagerHeader();
        this.createVehicleManagerBody();
        this.createVehicleManagerAside();
    }

    @Override
    public void begin() {
       this.setVisible(true);
    }

    private void initFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Administrador de vehiculos electronicos");
        this.setLayout((LayoutManager) new BorderLayout());
        this.setSize(900,600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    private void createVehicleManagerHeader(){
        vehicleManagerHeader = new VehicleManagerHeader(this);
        this.add(vehicleManagerHeader,BorderLayout.NORTH);
    }

    private void createVehicleManagerBody(){
        bodyCardLayout = new CardLayout();
        vehicleManagerBody = new VehicleManagerBody(this,bodyCardLayout);
        this.add(vehicleManagerBody);
    }

    private void createVehicleManagerAside(){
        asideCardLayout = new CardLayout();
        vehicleManagerAside = new VehicleManagerAside(this,asideCardLayout);
        this.add(vehicleManagerAside,BorderLayout.WEST);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

}
