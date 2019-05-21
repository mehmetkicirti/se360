/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

public class Dataset {
    private float _accessLevel;
    private String _id;
    private String description;
    private String license;
    private String name;
    private String updated;

    public float get_accessLevel() {
        return _accessLevel;
    }

    public void set_accessLevel(float _accessLevel) {
        this._accessLevel = _accessLevel;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }
       public String toStringDataSet() {
        return "Description : " + getDescription() +
                "\nLicense : " + getLicense() +
                "\nName :  " + getName()+
                "\nUpdated Date : " + getUpdated() +
                "\nİd : " + get_id()+
                "\nAccess Level : "+get_accessLevel();

    }
}
