package cn.anei.pethospital.vo;

import cn.anei.pethospital.entity1.Reply;
import lombok.Data;

import java.util.Date;

/**
 * @Author: ANei
 * @Date: 上午9:25 18/2/8
 * @Description:
 */
@Data
public class ReplyVO {
    private String replyId;
    private String content;
    private Date updateTime;
    private String fromName;
    private String email;
    private String toName;
    private Boolean replyStatus;

    public ReplyVO(Reply reply) {
        this.replyId = reply.getReplyId();
        this.content = reply.getReplyContent();
        this.updateTime = reply.getReplyTime();
        this.fromName = reply.getFromName();
        this.email = reply.getFromEmail();
        this.toName = reply.getToName();
    }
}
