/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.scott.dev.modules.cms.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.scott.dev.common.config.Global;
import com.scott.dev.common.persistence.DataEntity;

/**
 * 文章Entity
 * 
 * @author ThinkGem
 * @version 2013-01-15
 */
public class ArticleData extends DataEntity<ArticleData> {

    private static final long serialVersionUID = 1L;

    private String allowComment;// 是否允许评论

    private Article article;

    private String content; // 内容

    private String copyfrom;// 来源

    private String id; // 编号

    private String relation;// 相关文章

    public ArticleData() {
        super();
        this.allowComment = Global.YES;
    }

    public ArticleData(String id) {
        this();
        this.id = id;
    }

    @Length(min = 1, max = 1)
    public String getAllowComment() {
        return allowComment;
    }

    public Article getArticle() {
        return article;
    }

    @NotBlank
    public String getContent() {
        return content;
    }

    @Length(min = 0, max = 255)
    public String getCopyfrom() {
        return copyfrom;
    }

    @Override
    public String getId() {
        return id;
    }

    @Length(min = 0, max = 255)
    public String getRelation() {
        return relation;
    }

    public void setAllowComment(String allowComment) {
        this.allowComment = allowComment;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCopyfrom(String copyfrom) {
        this.copyfrom = copyfrom;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

}
