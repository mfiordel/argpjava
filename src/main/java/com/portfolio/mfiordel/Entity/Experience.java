package com.portfolio.mfiordel.Entity;

//import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1 , max = 250,message = "No cumple con la longitud")
    private String name_school;
    
    @NotNull
    private boolean is_actually;
    
    //SimpleDateFormat formatter = new SimpleDateFormat("EE MMM d y H:m:s ZZZ");     
    private Date initial_date;
    
    private Date end_date;
    
    @Size(min=1, max = 200, message = "Excede la longitud")
    private String description; 
    
    private String url_img;
    
    private String style;
    //@ManyToOne()
    //@JoinColumn(name = "person_id")
    //private Long person_id;
    //private Long person_id;

    public Experience() {
    }
    
    
}
