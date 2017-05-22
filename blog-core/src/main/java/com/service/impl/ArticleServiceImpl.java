package com.service.impl;

import com.dao.ArticleDao;
import com.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by nuomifan on 2017/5/22.
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class ArticleServiceImpl implements ArticleService{


	@Autowired
	public ArticleDao articleDao;


}
