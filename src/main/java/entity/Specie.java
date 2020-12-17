package entity;

public class Specie {
	private String name;
    private String classification;
    private String designation;
    private String average_height;
    private String skin_colors;
    private String hair_colors;
    private String eye_colors;
    private String average_lifespan;
    
    public String Sname;
    public String Sclassification;
    public String Sdesignation;
    public String Saverage_height;
    public String Sskin_colors;
    public String Shair_colors;
    public String Seye_colors;
    public String Saverage_lifespan;
    
    public void setName(String name) {
        this.name = name;
        Sname=name;
    }
    public String getName() {
    	if (name!=Sname){
    		 return Sname;
    	}
    	else {
    		return name;
    	}
    }
    
    public void setClassification(String classification) {
        this.classification = classification;
        Sclassification = classification;
    }
    public String getClassification() {
        if (classification!=Sclassification){
   		 return Sclassification;
   	}
   	else {
   		return classification;
   	}
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
        Sdesignation = designation;
    }
    public String getDesignation() {        
        if (designation!=Sdesignation){
      		 return Sdesignation;
      	}
      	else {
      		return designation;
      	}
    }
    
    public void setAverage_height(String average_height) {
        this.average_height = average_height;
        Saverage_height=average_height;
    }
    public String getAverage_height() {
        if (average_height!=Saverage_height){
     		 return Saverage_height;
     	}
     	else {
     		return average_height;
     	}
    }
    
    public void setSkin_colors(String skin_colors) {
        this.skin_colors = skin_colors;
        Sskin_colors=skin_colors;
    }
    public String getSkin_colors() {
        if (skin_colors!=Sskin_colors){
    		 return Sskin_colors;
    	}
    	else {
    		return skin_colors;
    	}
    }
    
    public void setHair_colors(String hair_colors) {
        this.hair_colors = hair_colors;
        Shair_colors=hair_colors;
    }
    public String getHair_colors() {
        if (hair_colors!=Shair_colors){
   		 	return Shair_colors;
        }
        else {
        	return hair_colors;
        }
    }
    
    public void setEye_colors(String eye_colors) {
        this.eye_colors = eye_colors;
        Seye_colors=eye_colors;
    }
    public String getEye_colors() {
        if (eye_colors!=Seye_colors){
   		 	return Seye_colors;
        }
        else {
        	return eye_colors;
        }
    }
    
    public void setAverage_lifespan(String average_lifespan) {
        this.average_lifespan = average_lifespan;
        Saverage_lifespan=average_lifespan;
    }
    public String getAverage_lifespan() {
        if (average_lifespan!=Saverage_lifespan){
   		 	return Saverage_lifespan;
        }
        else {
        	return average_lifespan;
        }
    }
    
}
