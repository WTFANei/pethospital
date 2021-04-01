package cn.anei.pethospital.vo;

import cn.anei.pethospital.entity1.Comment;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author: ANei
 * @Date: 上午9:23 18/2/8
 * @Description:
 */
@Data
public class CommentVO {

    private String commentId;

    private String fromName;

    private String email;

    private String content;

    private Date updateTime;

    private Boolean commentStatus;

    private List<ReplyVO> replys;

    private  Integer count;

    private String articleTitle;

    public CommentVO(Comment comment, List<ReplyVO> replys) {
        this.commentId = comment.getCommentId();
        this.fromName = comment.getCommenterName();
        this.email = comment.getCommenterEmail();
        this.content = comment.getCommentContent();
        this.updateTime = comment.getCommentTime();
        this.replys = replys;
    }
    public CommentVO(Comment comment, Integer count, String articleTitle) {

        this.commentId = comment.getCommentId();
        this.fromName = comment.getCommenterName();
        this.email = comment.getCommenterEmail();
        this.content = comment.getCommentContent();
        this.updateTime = comment.getCommentTime();
        this.count = count;
        this.articleTitle = articleTitle;
    }
}
