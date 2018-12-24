package com.zplus.service.impl;

import com.zplus.dao.IUrlDao;
import com.zplus.entity.IUrl;
import com.zplus.service.IUrlService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class IUrlServiceImpl implements IUrlService
{
    @Resource
    private IUrlDao iUrlDao;

    private Map<String,String> map=new HashMap<>();
    
    private java.util.List<String> list=new ArrayList<>();
    
    @Override
    public IUrl save(IUrl iUrl)
    {
        iUrlDao.save(iUrl);
        return iUrl;
    }
    
    public Map<String, Object> update(IUrl iUrl)
    {
        iUrlDao.saveAndFlush(iUrl);
        return iUrl.getUrlMap();
    }

    
}