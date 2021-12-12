package com.jef.designpattern.action.status.impl;

import com.jef.designpattern.action.status.ActivityResult;
import com.jef.designpattern.action.status.ActivityService;
import com.jef.designpattern.action.status.ActivityState;
import com.jef.designpattern.action.status.ActivityStatus;


/**
 * 活动状态；待审核
 */
public class CheckState extends ActivityState {

    public ActivityResult arraignment(String activityId, Enum<ActivityStatus> currentStatus) {
        return new ActivityResult("0001", "待审核状态不可重复提审");
    }

    public ActivityResult checkPass(String activityId, Enum<ActivityStatus> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, ActivityStatus.PASS);
        return new ActivityResult("0000", "活动审核通过完成");
    }

    public ActivityResult checkRefuse(String activityId, Enum<ActivityStatus> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, ActivityStatus.REFUSE);
        return new ActivityResult("0000", "活动审核拒绝完成");
    }

    @Override
    public ActivityResult checkRevoke(String activityId, Enum<ActivityStatus> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, ActivityStatus.EDITING);
        return new ActivityResult("0000", "活动审核撤销回到编辑中");
    }

    public ActivityResult close(String activityId, Enum<ActivityStatus> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, ActivityStatus.CLOSE);
        return new ActivityResult("0000", "活动审核关闭完成");
    }

    public ActivityResult open(String activityId, Enum<ActivityStatus> currentStatus) {
        return new ActivityResult("0001", "非关闭活动不可开启");
    }

    public ActivityResult doing(String activityId, Enum<ActivityStatus> currentStatus) {
        return new ActivityResult("0001", "待审核活动不可执行活动中变更");
    }

}
