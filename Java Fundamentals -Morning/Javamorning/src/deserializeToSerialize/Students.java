/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deserializeToSerialize;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "students")
public class Students implements Serializable {

    private List<Student> students;
    public Students(){}
    public Students(List<Student> students){
        this.students = students;
    }

    @XmlElement(name="student")
    public List<Student> getStudents() { return this.students; }
    public void setStudents(List<Student> students) { this.students = students; }
}
