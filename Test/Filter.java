/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.util.ArrayList;
import java.util.List;

public class Filter {

    JsonModel myModelJson;
    

    
   public void maxMinAge(List<JsonModel> myAgeList, ArrayList<JsonModel> myFilter, int min, int max){
        for(int i = 0; i<myAgeList.size(); i++){
            if (myAgeList.get(i).getMeta().getClinical().getAge_approx()>=min && myAgeList.get(i).getMeta().getClinical().getAge_approx()<=max){
                myFilter.add(myAgeList.get(i));

            }
        }
    }
    public void Allresult(ArrayList<JsonModel> myFilter){
        for (int i = 0; i < myFilter.size(); i++) {
            System.out.println(myFilter.get(i).getMeta().toStringClinical());
        }
    }
    public static void showResult(ArrayList<JsonModel> myFilter){
        for(int i = 0; i<myFilter.size(); i++){
            System.out.println(myFilter.get(i).getName());
        }
        myFilter.clear();
    }


    public JsonModel getMyModelJson() {
        return myModelJson;
    }

    public void setMyModelJson(JsonModel myModelJson) {
        this.myModelJson = myModelJson;
    }

   
}