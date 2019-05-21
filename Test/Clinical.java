/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

public class Clinical {
    private int age_approx;
    private String anatom_site_general;
    private String benign_malignant;
    private String diagnosis;
    private String diagnosis_confirm_type = null;
    private boolean melanocytic;
    private String sex;

    public int getAge_approx() {
        return age_approx;
    }

    public void setAge_approx(int age_approx) {
        this.age_approx = age_approx;
    }

    public String getAnatom_site_general() {
        return anatom_site_general;
    }

    public void setAnatom_site_general(String anatom_site_general) {
        this.anatom_site_general = anatom_site_general;
    }

    public String getBenign_malignant() {
        return benign_malignant;
    }

    public void setBenign_malignant(String benign_malignant) {
        this.benign_malignant = benign_malignant;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getDiagnosis_confirm_type() {
        return diagnosis_confirm_type;
    }

    public void setDiagnosis_confirm_type(String diagnosis_confirm_type) {
        this.diagnosis_confirm_type = diagnosis_confirm_type;
    }

    public boolean isMelanocytic() {
        return melanocytic;
    }

    public void setMelanocytic(boolean melanocytic) {
        this.melanocytic = melanocytic;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


}