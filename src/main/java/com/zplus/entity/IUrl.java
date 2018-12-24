package com.zplus.entity;

import com.zplus.service.AsyncService;
import com.zplus.service.impl.AsyncServiceImpl;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Entity
public class IUrl implements Serializable
{
    private static final long serialVersionUID = -4858750994663212830L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;
    private String request;
    
    private Map<String,Object> urlMap=new HashMap<>();

    public Map<String, Object> getUrlMap()
    {
        return urlMap;
    }

    public void setUrlMap(Map<String, Object> urlMap)
    {
        this.urlMap = urlMap;
    }

    private static final AsyncService asyncService=new AsyncServiceImpl();

    public IUrl() {}
    
    public IUrl(String url)
    {
        this.url=url;
    }

    public String doHttpGet(String url)
    {
        return asyncService.httpGetRequest(url);
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }
    
    public void setRequest(String request)
    {
        this.request=request;
    }
    
    public String getRequest()
    {
        return request;
    }
}