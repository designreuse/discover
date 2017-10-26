package com.ada.quartz.data.entity;

import com.ada.data.entity.AbstractEntity;

import javax.persistence.*;

/**
 * 任务记录
 */

@Entity
@Table(name = "task_record")
public class CronTaskRecord extends AbstractEntity {


    /**
     * 那个任务
     */
    @ManyToOne(fetch = FetchType.LAZY)
    private CronTask task;

    /**
     * 开销时间
     */
    private Long expensesTime;

    /**
     * 备注
     */
    @Column(length = 20)
    private String note;

    public CronTask getTask() {
        return task;
    }

    public void setTask(CronTask task) {
        this.task = task;
    }

    public Long getExpensesTime() {
        return expensesTime;
    }

    public void setExpensesTime(Long expensesTime) {
        this.expensesTime = expensesTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
