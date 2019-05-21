/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.util.ArrayList;

public class Note {

    Reviewed reviewed;
    ArrayList<Object> tags = new ArrayList<Object>();

    private class Reviewed {
        private boolean accepted;
        private String time;
        private String userId;

        public boolean isAccepted() {
            return accepted;
        }

        public void setAccepted(boolean accepted) {
            this.accepted = accepted;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }

    public Reviewed getReviewed() {
        return reviewed;
    }

    public void setReviewed(Reviewed reviewed) {
        this.reviewed = reviewed;
    }

    public ArrayList<Object> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Object> tags) {
        this.tags = tags;
    }
}