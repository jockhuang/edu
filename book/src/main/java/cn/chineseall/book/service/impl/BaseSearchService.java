package cn.chineseall.book.service.impl;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;

import cn.chineseall.book.model.SearchVo;

public abstract class BaseSearchService {

    abstract String getServerUrl();

    abstract Lock getLock();

    private HttpSolrServer server = null;

    public BaseSearchService() {
        if (server == null) {
            getLock().lock();
            try {
                server = new HttpSolrServer(getServerUrl());
                server.setSoTimeout(10000); // socket read timeout
                server.setConnectionTimeout(10000);
                server.setDefaultMaxConnectionsPerHost(1000);
                server.setMaxTotalConnections(500);
                server.setFollowRedirects(false); // defaults to false
                server.setAllowCompression(false);
            } finally {
                getLock().unlock();
            }
        }
    }

    @SuppressWarnings("rawtypes")
    public SearchVo search(SearchVo s) {
        Map map = new HashMap();
        SolrQuery query = new SolrQuery();
        query.setQuery(formatQueryString(s));
        query.setStart((s.getPageUtil().getCurrentPage() - 1) * s.getPageUtil().getPageSize());
        query.setRows(s.getPageUtil().getPageSize());
        // query.addSortField("id", SolrQuery.ORDER.desc);

        try {
            QueryResponse qrsp;
            queryGroup(query, s);
            qrsp = server.query(query);
            transferGroup(map, qrsp);
            query = new SolrQuery();
            query.setQuery(formatQueryString(s));
            query.setStart((s.getPageUtil().getCurrentPage() - 1) * s.getPageUtil().getPageSize());
            query.setRows(s.getPageUtil().getPageSize());
            buildQuery(query, s);
            qrsp = server.query(query);
            transferResult(map, qrsp);
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
        try {
            BeanUtils.populate(s, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    abstract void queryGroup(SolrQuery query, SearchVo s);

    abstract void buildQuery(SolrQuery query, SearchVo s);

    @SuppressWarnings("rawtypes")
    abstract Map transferResult(Map map, QueryResponse qrsp);

    @SuppressWarnings("rawtypes")
    abstract Map transferGroup(Map map, QueryResponse qrsp);

    @SuppressWarnings("rawtypes")
    protected String getFieldName(Class clazz, String field) {
        try {
            Field f = clazz.getDeclaredField(field);
            return f.getAnnotation(org.apache.solr.client.solrj.beans.Field.class).value();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    protected String formatQueryString(SearchVo s) {
        String queryStr = "";
        String keyword = s.getWord();
        if (keyword != null && !"".equals(keyword)) {
            keyword = keyword.trim().replaceAll("　", " ");
            Pattern p = Pattern.compile(" {2,}");// 去除多余空格
            Matcher m = p.matcher(keyword);
            keyword = m.replaceAll(" ");
            String[] words = keyword.split(" ");
            if (words.length > 1) {
                for (int i = 0; i < words.length - 1; i++) {
                    queryStr = queryStr + words[i] + " AND ";
                }
                queryStr = queryStr + words[words.length - 1];
            } else {
                queryStr = keyword;
            }
            queryStr = varietyQuery(s, queryStr);
        } else
            queryStr = "*:*";

        return queryStr;
    }

    abstract String varietyQuery(SearchVo s, String queryStr);
}
