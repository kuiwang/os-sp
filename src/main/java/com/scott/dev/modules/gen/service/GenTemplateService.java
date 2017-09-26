/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.scott.dev.modules.gen.service;

import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scott.dev.common.persistence.Page;
import com.scott.dev.common.service.BaseService;
import com.scott.dev.modules.gen.dao.GenTemplateDao;
import com.scott.dev.modules.gen.entity.GenTemplate;

/**
 * 代码模板Service
 * 
 * @author ThinkGem
 * @version 2013-10-15
 */
@Service
@Transactional(readOnly = true)
public class GenTemplateService extends BaseService {

    @Autowired
    private GenTemplateDao genTemplateDao;

    @Transactional(readOnly = false)
    public void delete(GenTemplate genTemplate) {
        genTemplateDao.delete(genTemplate);
    }

    public Page<GenTemplate> find(Page<GenTemplate> page, GenTemplate genTemplate) {
        genTemplate.setPage(page);
        page.setList(genTemplateDao.findList(genTemplate));
        return page;
    }

    public GenTemplate get(String id) {
        return genTemplateDao.get(id);
    }

    @Transactional(readOnly = false)
    public void save(GenTemplate genTemplate) {
        if (genTemplate.getContent() != null) {
            genTemplate.setContent(StringEscapeUtils.unescapeHtml4(genTemplate.getContent()));
        }
        if (org.apache.commons.lang3.StringUtils.isBlank(genTemplate.getId())) {
            genTemplate.preInsert();
            genTemplateDao.insert(genTemplate);
        } else {
            genTemplate.preUpdate();
            genTemplateDao.update(genTemplate);
        }
    }

}
