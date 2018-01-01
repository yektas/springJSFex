package com.yektas.managedbean;


import org.primefaces.event.map.PointSelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.Map;

@ManagedBean(name = "user")
@RequestScoped
public class UserMB {

    private MapModel simpleModel;
    private String latitude;
    private String longitude;
    private String title;


    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public void setSimpleModel(MapModel simpleModel) {
        this.simpleModel = simpleModel;
    }


    @PostConstruct
    public void init(){
        simpleModel = new DefaultMapModel();
    }
    /**
     * @user sercan
     * @date 12/12/2018
     * @version 1.0
     * This method check the fiels from ui.
     */
    public void findUserLocation(){
        Map<String, String> coordinates = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        LatLng coord1 = new LatLng(
                Double.valueOf(coordinates.get("latitude")),
                Double.valueOf(coordinates.get("longitude")));

        setLatitude(coordinates.get("latitude"));
        setLongitude(coordinates.get("longitude"));
        simpleModel.addOverlay(new Marker(coord1, "M1"));
    }

    public void addMarker() {
        LatLng coordinates = new LatLng(Double.valueOf(latitude), Double.valueOf(latitude));
        Marker marker = new Marker(coordinates, title);
        simpleModel.addOverlay(marker);
    }
}
