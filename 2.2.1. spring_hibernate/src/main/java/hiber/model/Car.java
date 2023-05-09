package hiber.model;
import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "series")
    private int series;
    @Column(name = "model")
    private String model;

    public Car() {
    }

    public Car(int series, String model) {
        this.series = series;
        this.model = model;
    }

    public void setModel(String model){
        this.model=model;
    }
    public void setSeries (int series) {
        this.series = series;
    }
    public String getModel(){
        return model;
    }
    public int getSeries() {
        return series;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\nseries = " + series +
                "\nmodel = " + model;
    }
}
