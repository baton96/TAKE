package com.mycompany.PrimeFaces;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

@Named(value = "indexBean")
@RequestScoped
public class IndexBean {

    private int a = 0, b = 0;
    private Date date = new Date();
    private List<Student> students;
    private LineChartModel model;

    public IndexBean() {
        students = new ArrayList<>();
        students.add(new Student("Bartosz", "Pauleiwcz", 5));
        students.add(new Student("Jan", "Kowalski", 4.5));
        students.add(new Student("Jan", "Nowak", 4));
        students.add(new Student("Jan", "Dzban", 3.5));
        students.add(new Student("John", "Doe", 3));
        students.add(new Student("Jane", "Doe", 2.5));

        model = new LineChartModel();
        LineChartSeries sin = new LineChartSeries();
        sin.setLabel("Sin");
        LineChartSeries cos = new LineChartSeries();
        cos.setLabel("Cos");

        for (int i = 0; i < 361; i += 10) {
            double radians = Math.toRadians(i);
            sin.set(i, Math.sin(radians));
            cos.set(i, Math.cos(radians));
        }
        model.addSeries(sin);
        model.addSeries(cos);
    }

    public LineChartModel getModel() {
        return model;
    }

    /**
     * @return the students
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @return the a
     */
    public int getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(int a) {
        this.a = a;
    }

    /**
     * @return the b
     */
    public int getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(int b) {
        this.b = b;
    }

    public int sum() {
        return a + b;
    }

    public void showGrowl() {
        String msg = String.format("%d + %d = %d", a, b, a + b);
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sum", msg));
    }

}
