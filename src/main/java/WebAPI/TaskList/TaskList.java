package WebAPI.TaskList;

import WebAPI.Task.Task;
import WebAPI.TerrariumProfile.TerrariumProfile;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity (name =  "TaskList")
@Table(name = "taskList")
public class TaskList {

    @OneToMany(mappedBy = "taskList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Task> tasks = new HashSet<>();


    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "taskList_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )

    @Column(name = "taskListId", updatable = false)
    private Long taskListId;
    @ManyToOne
    @JoinColumn(name = "profileId")
    private TerrariumProfile terrariumProfile;

    public TaskList(Long taskListId, TerrariumProfile terrariumProfile) {
        this.taskListId = taskListId;
        this.terrariumProfile = terrariumProfile;
    }



    public TaskList(){}

    public Long getTaskListId() {
        return taskListId;
    }

    public void setTaskListId(Long taskListId) {
        this.taskListId = taskListId;
    }

  public TerrariumProfile getTerrariumProfile() {
      return terrariumProfile;}

  public void setTerrariumProfile(TerrariumProfile terrariumProfile) {this.terrariumProfile = terrariumProfile;
    }
}
