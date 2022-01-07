//package com.xiaoergekeji.devops.scheduler.executor;
//
//import com.xiaoergekeji.devops.scheduler.bean.enums.ExecutorTypeEnum;
//import org.quartz.Job;
//
///**
// * @program: xeg-cloud
// * @description:
// * @author: ArchieDing
// * @create: 2021-05-20 22:03
// **/
//public enum ExecutorMappingEnum {
//    HTTP(ExecutorTypeEnum.HTTP.getValue(), HttpExecutorJob.class),
//    TOPIC(ExecutorTypeEnum.TOPIC.getValue(), TopicExecutorJob.class),
//    ;
//    private String type;
//    private Class<? extends Job> clazz;
//
//    ExecutorMappingEnum(String type, Class<? extends Job> clazz) {
//        this.type = type;
//        this.clazz = clazz;
//    }
//
//    public static String getType(Class<? extends Job> clazz) {
//        for (ExecutorMappingEnum value : ExecutorMappingEnum.values()) {
//            if (value.clazz.equals(clazz)) {
//                return value.type;
//            }
//        }
//        return HTTP.type;
//    }
//
//    public static Class<? extends Job> getClazz(String type) {
//        for (ExecutorMappingEnum value : ExecutorMappingEnum.values()) {
//            if (value.type.equals(type)) {
//                return value.clazz;
//            }
//        }
//        return HTTP.clazz;
//    }
//}
