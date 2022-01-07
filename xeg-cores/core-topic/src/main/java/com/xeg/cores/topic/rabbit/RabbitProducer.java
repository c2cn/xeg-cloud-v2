package com.xeg.cores.topic.rabbit;

import com.xeg.cores.base.im.message.PushEmployerMsgDTO;
import com.xeg.cores.base.im.message.PushLiveMsgDTO;
import com.xeg.cores.base.im.message.PushWorkerMsgDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 消息生产者
 *
 * @author ningpeng
 */
@Slf4j
@Component
@EnableBinding({RabbitOutput.class})
public class RabbitProducer {

    @Resource
    RabbitOutput rabbitOutput;

    /**
     * 发送socketMessage
     *
     * @param msg
     */
    public void sendSocketMessage(Object msg) {
        boolean send = rabbitOutput.sendSocketMessage().send(MessageBuilder.withPayload(msg).build());
        log.info("socketMessage-->" + send);
    }

    /**
     * 雇主支付倒计时剩余2分钟
     *
     * @param msg       orderNo
     * @param delayTime
     * @return
     */
    public boolean sendEmployerPayEndTimeLast2Minute(Object msg, long delayTime) {
        return rabbitOutput.sendEmployerPayEndTimeLast2Minute().send(MessageBuilder.withPayload(msg).setHeader("x-delay", delayTime).build());
    }

    /**
     * 雇主支付倒计时
     *
     * @param msg       orderNo
     * @param delayTime
     * @return
     */
    public boolean sendEmployerPayEndTime(Object msg, long delayTime) {
        return rabbitOutput.sendEmployerPayEndTime().send(MessageBuilder.withPayload(msg).setHeader("x-delay", delayTime).build());
    }

    /**
     * 雇工支付倒计时
     *
     * @param msg       orderNo
     * @param delayTime
     * @return
     */
    public boolean sendWorkerPayEndTime(Object msg, long delayTime) {
        return rabbitOutput.sendWorkerPayEndTime().send(MessageBuilder.withPayload(msg).setHeader("x-delay", delayTime).build());
    }

    /**
     * 生成二维码
     *
     * @param msg
     */
    public void makeInvitationQr(Object msg) {
        boolean send = rabbitOutput.makeInvitationQr().send(MessageBuilder.withPayload(msg).build());
        log.info("发送MQ：生成二维码-->" + send);
    }

    /**
     * 券活动
     *
     * @param msg
     */
    public void sendCouponActivity(Object msg) {
        boolean send = rabbitOutput.sendCouponActivity().send(MessageBuilder.withPayload(msg).build());
        log.info("发送券活动-->" + send);
    }

    /**
     * 测试
     *
     * @param msg
     */
    public void sendMessageTest(Object msg) {
        rabbitOutput.sendMessageTest().send(MessageBuilder.withPayload(msg).build());
    }

    /**
     * 招工倒计时最后2分钟
     *
     * @param msg       orderNo
     * @param delayTime
     * @return
     */
    public boolean sendRecruitCountdownEndLast2Minute(Object msg, long delayTime) {
        return rabbitOutput.sendRecruitCountdownEndLast2Minute().send(MessageBuilder.withPayload(msg).setHeader("x-delay", delayTime).build());
    }

    /**
     * 招工倒计时
     *
     * @param msg       orderNo
     * @param delayTime
     * @return
     */
    public boolean sendRecruitCountdownEnd(Object msg, long delayTime) {
        return rabbitOutput.sendRecruitCountdownEnd().send(MessageBuilder.withPayload(msg).setHeader("x-delay", delayTime).build());
    }

    /**
     * 报价倒计时
     *
     * @param msg       orderNo
     * @param delayTime
     * @return
     */
    public boolean sendOfferEndTime(Object msg, long delayTime) {
        return rabbitOutput.sendOfferEndTime().send(MessageBuilder.withPayload(msg).setHeader("x-delay", delayTime).build());
    }

    /**
     * 开工前2小时提醒
     *
     * @param msg       orderBatch
     * @param delayTime
     * @return
     */
    public boolean sendStart2HoursAgoRemind(Object msg, long delayTime) {
        return rabbitOutput.sendStart2HoursAgoRemind().send(MessageBuilder.withPayload(msg).setHeader("x-delay", delayTime).build());
    }

    /**
     * 到达开工时间提醒1次可申请完工
     *
     * @param msg       orderBatch
     * @param delayTime
     * @return
     */
    public boolean sendStartOrderRemind(Object msg, long delayTime) {
        return rabbitOutput.sendStartOrderRemind().send(MessageBuilder.withPayload(msg).setHeader("x-delay", delayTime).build());
    }

    /**
     * 完单分润
     *
     * @param msg
     */
    public boolean finishOrderToProfit(String msg) {
        log.info("发送MQ：完单分润-->" + msg);
        boolean send = rabbitOutput.finishOrderToProfit().send(MessageBuilder.withPayload(msg).build());
        return send;
    }

    /**
     * 增加代理邀请记录
     *
     * @param msg
     * @return
     */
    public boolean addAgentInvitationUser(String msg) {
        boolean send = rabbitOutput.addAgentInvitationUser().send(MessageBuilder.withPayload(msg).build());
        log.info("发送MQ：增加代理邀请记录-->" + send);
        return send;
    }

    /**
     * 雇主上麦倒计时
     *
     * @param msg
     * @param delayTime
     * @return
     */
    public boolean sendEmployerUpWheatEndTime(Object msg, long delayTime) {
        return rabbitOutput.sendEmployerUpWheatEndTime().send(MessageBuilder.withPayload(msg).setHeader("x-delay", delayTime).build());
    }

    /**
     * 雇工上麦倒计时
     *
     * @param msg
     * @param delayTime
     * @return
     */
    public boolean sendWorkerUpWheatEndTime(Object msg, long delayTime) {
        return rabbitOutput.sendWorkerUpWheatEndTime().send(MessageBuilder.withPayload(msg).setHeader("x-delay", delayTime).build());
    }

    /**
     * 雇工下麦倒计时
     *
     * @param msg
     * @param delayTime
     * @return
     */
    public boolean sendWorkerDownWheatEndTime(Object msg, long delayTime) {
        return rabbitOutput.sendWorkerDownWheatEndTime().send(MessageBuilder.withPayload(msg).setHeader("x-delay", delayTime).build());
    }

    /**
     * 给雇工推送消息
     *
     * @param msg
     * @return
     */
    public boolean pushWorkerMsg(PushWorkerMsgDTO msg) {
        boolean send = rabbitOutput.pushWorkerMsg().send(MessageBuilder.withPayload(msg).build());
        log.info("发送MQ：给雇工推送消息-->" + send);
        return send;
    }

    /**
     * 给雇主推送消息
     *
     * @param msg
     * @return
     */
    public boolean pushEmployerMsg(PushEmployerMsgDTO msg) {
        boolean send = rabbitOutput.pushEmployerMsg().send(MessageBuilder.withPayload(msg).build());
        log.info("发送MQ：给雇主推送消息-->" + send);
        return send;
    }

    /**
     * 推送直播间消息
     *
     * @param msg
     * @return
     */
    public boolean pushLiveRoomMsg(PushLiveMsgDTO msg) {
        boolean send = rabbitOutput.pushLiveRoomMsg().send(MessageBuilder.withPayload(msg).build());
        log.info("发送MQ：推送直播间消息-->" + send);
        return send;
    }

    /**
     * 延时解除禁言
     * @param msg
     */
    public void removeMute(String msg, long delayTime) {
        log.info("发送MQ：延时解除禁言-->" + msg);
        rabbitOutput.removeMute().send(MessageBuilder.withPayload(msg).setHeader("x-delay", delayTime).build());
    }

    /**
     * 延时解除黑名单
     * @param msg
     * @param delayTime
     */
    public void removeRoomBlacklist(String msg, long delayTime) {
        log.info("发送MQ：延时解除黑名单-->" + msg);
        rabbitOutput.removeRoomBlacklist().send(MessageBuilder.withPayload(msg).setHeader("x-delay", delayTime).build());

    }
}
