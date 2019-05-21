/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

public class Meta {

    Acquisition acquisition;
    Clinical clinical;
    Unstructured unstructured;
    UnstructuredExif unstructuredExif;
    Acquisition a;

    public class UnstructuredExif {
    }

    public Acquisition getAcquisition() {
        return acquisition;
    }

    public void setAcquisition(Acquisition acquisition) {
        this.acquisition = acquisition;
    }

    public Clinical getClinical() {
        return clinical;
    }

    public void setClinical(Clinical clinical) {
        this.clinical = clinical;
    }

    public Unstructured getUnstructured() {
        return unstructured;
    }

    public void setUnstructured(Unstructured unstructured) {
        this.unstructured = unstructured;
    }

    public UnstructuredExif getUnstructuredExif() {
        return unstructuredExif;
    }

    public void setUnstructuredExif(UnstructuredExif unstructuredExif) {
        this.unstructuredExif = unstructuredExif;
    }

    public String toStringClinical() {
        return "Approximate Age : " + getClinical().getAge_approx() +
                "\nSex : " + getClinical().getSex() +
                "\nAnatom Site General :  " + getClinical().getAnatom_site_general()+
                "\nBenign Maligent : " + getClinical().getBenign_malignant() +
                "\nDiagnosis : " + getClinical().getDiagnosis() +
                "\nDiagnosis Confirm Type : " + getClinical().getDiagnosis_confirm_type() +
                "\nMelanocytic : " + getClinical().isMelanocytic();
    }


}