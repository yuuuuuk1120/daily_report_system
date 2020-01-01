package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "attendanceManagements")
@NamedQueries({
        @NamedQuery(name = "getMyAllworks", query = "SELECT a FROM AttendanceManagement AS a WHERE a.employee=:employee ORDER BY a.id DESC")
})

@Entity
public class AttendanceManagement {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "day_time", nullable = false)
    private Timestamp day_time;

    @Column(name = "start_from", nullable = false)
    private Timestamp start_from;

    @Column(name = "finish_at", nullable = false)
    private Timestamp finish_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Timestamp getDay_time() {
        return day_time;
    }

    public void setDay_time(Timestamp day_time) {
        this.day_time = day_time;
    }

    public Timestamp getStart_from() {
        return start_from;
    }

    public void setStart_from(Timestamp start_from) {
        this.start_from = start_from;
    }

    public Timestamp getFinish_at() {
        return finish_at;
    }

    public void setFinish_at(Timestamp finish_at) {
        this.finish_at = finish_at;
    }

}
