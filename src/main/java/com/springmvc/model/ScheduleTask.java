package com.springmvc.model;

import java.util.TimeZone;

/**
 * Created by PVer on 2017/5/29.
 */
public class ScheduleTask {

    private String id;   //任务id，默认系统时间戳
    private String parentId;      //父级任务id
    private String name = "";      //任务名称
    private String desc;        //任务描述
    private int planExe = 0;      //计划执行次数，默认为0，表示符合条件循环执行
    private String group = "";    //任务组名称
    private String groupDesc = "";   //任务组描述
    private String cron = "";         //任务表达式
    private String cronDesc = "";       //表达式描述
    private TimeZone trigger;        //触发器名称
    private String triggerDesc = "";      //触发器描述
    private int execute = 0;         //任务被执行过多少次
    private Long lastExeTime = 0L;    //最后一次开始执行时间
    private Long lastFinishTime = 0L; //最后一次完成执行时间
    private int state = 1;            //任务状态，0禁用，1启用，2删除


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPlanExe() {
        return planExe;
    }

    public void setPlanExe(int planExe) {
        this.planExe = planExe;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public String getCronDesc() {
        return cronDesc;
    }

    public void setCronDesc(String cronDesc) {
        this.cronDesc = cronDesc;
    }

    public TimeZone getTrigger() {
        return trigger;
    }

    public void setTrigger(TimeZone trigger) {
        this.trigger = trigger;
    }

    public String getTriggerDesc() {
        return triggerDesc;
    }

    public void setTriggerDesc(String triggerDesc) {
        this.triggerDesc = triggerDesc;
    }

    public int getExecute() {
        return execute;
    }

    public void setExecute(int execute) {
        this.execute = execute;
    }

    public Long getLastExeTime() {
        return lastExeTime;
    }

    public void setLastExeTime(Long lastExeTime) {
        this.lastExeTime = lastExeTime;
    }

    public Long getLastFinishTime() {
        return lastFinishTime;
    }

    public void setLastFinishTime(Long lastFinishTime) {
        this.lastFinishTime = lastFinishTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ScheduleTask{" +
                "id='" + id + '\'' +
                ", parentId='" + parentId + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", planExe=" + planExe +
                ", group='" + group + '\'' +
                ", groupDesc='" + groupDesc + '\'' +
                ", cron='" + cron + '\'' +
                ", cronDesc='" + cronDesc + '\'' +
                ", trigger='" + trigger + '\'' +
                ", triggerDesc='" + triggerDesc + '\'' +
                ", execute=" + execute +
                ", lastExeTime=" + lastExeTime +
                ", lastFinishTime=" + lastFinishTime +
                ", state=" + state +
                '}';
    }
}
