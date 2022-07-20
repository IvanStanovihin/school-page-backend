package ru.inrtu.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.inrtu.backend.enums.ActivityProgress;

import javax.persistence.*;

/**
 * Класс для таблицы в которой хранятся записи о всх когда-либо проводимых активностях.
 */
@Entity
@Data
@NoArgsConstructor
public class ActivityHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "schoolchild_id", nullable = false)
    private Schoolchild schoolchild;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "study_activity_id", nullable = false)
    private StudyActivity activity;

    private ActivityProgress historyRecordType;
    private String recordCreateDate;

    public ActivityHistory(Schoolchild schoolchild, StudyActivity activity,
                           ActivityProgress historyRecordType, String recordCreateDate) {
        this.schoolchild = schoolchild;
        this.activity = activity;
        this.historyRecordType = historyRecordType;
        this.recordCreateDate = recordCreateDate;
    }
}
