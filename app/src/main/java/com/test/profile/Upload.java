package com.test.profile;

public class Upload {

    private int image;
    private String viewCount;
    public Upload(int image, String viewCount) {
        this.image = image;
        this.viewCount = viewCount;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getViewCount() {
        return viewCount;
    }



    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }


}
