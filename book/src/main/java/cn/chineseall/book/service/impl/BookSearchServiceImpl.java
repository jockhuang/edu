package cn.chineseall.book.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.FacetField.Count;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.stereotype.Service;

import cn.chineseall.book.model.GroupItem;
import cn.chineseall.book.model.QueryField;
import cn.chineseall.book.model.SearchBook;
import cn.chineseall.book.model.SearchVo;
import cn.chineseall.book.service.SearchService;

@Service("bookSearchService")
public class BookSearchServiceImpl extends BaseSearchService implements SearchService {
    private Lock lock = new ReentrantLock();// 锁对象

    @Override
    Lock getLock() {
        if(lock==null)
            lock = new ReentrantLock();
        return this.lock;
    }

    String getServerUrl() {
        return "http://solr.chineseall.cn/book";
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    Map transferResult(Map map, QueryResponse qrsp) {
        SolrDocumentList docs = qrsp.getResults();
        map.put("total", docs.getNumFound());
        List<SearchBook> books = qrsp.getBeans(SearchBook.class);
        
        Map<String,Map<String,List<String>>> hl=qrsp.getHighlighting();
        for(SearchBook sb:books){
            Map<String,List<String>> dmap = hl.get(String.valueOf(sb.getId()));
            if(dmap!=null){
                if(null!=dmap.get("name"))
                    sb.setName(dmap.get("name").get(0));
                if(null!=dmap.get("intro"))
                    sb.setIntro(dmap.get("intro").get(0));
                
            }
                
        }
        map.put("result", books);
        return map;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    Map transferGroup(Map map, QueryResponse qrsp) {
        List<Count> valuelist = qrsp.getFacetField(getFieldName(SearchBook.class, "parentcategory")).getValues();
        Map<String, String> cmap = new HashMap<String, String>();
        List<GroupItem> list = new ArrayList<GroupItem>();
        for (int i = 0; i < valuelist.size(); i++) {
            String[] kv = valuelist.get(i).getName().split("\\|");
            cmap.put(kv[1], kv[0]);
            GroupItem g = new GroupItem(kv[1], kv[0], valuelist.get(i).getCount());
            list.add(g);
        }
        map.put("category0", list);

        valuelist = qrsp.getFacetField(getFieldName(SearchBook.class, "category")).getValues();

        HashMap<String, List<GroupItem>> categorymap = new HashMap<String, List<GroupItem>>();
        for (int i = 0; i < valuelist.size(); i++) {
            String[] kv = valuelist.get(i).getName().split("\\|");
            String key = kv[1].substring(0, 1);
            cmap.put(kv[1], kv[0]);
            list = categorymap.get(key);
            if (list == null)
                list = new ArrayList<GroupItem>();
            GroupItem g = new GroupItem(kv[1], kv[0], valuelist.get(i).getCount());
            list.add(g);
            categorymap.put(key, list);
        }

        map.put("category1", categorymap);
        map.put("categorymap", cmap);

        Map<String, String> umap = new HashMap<String, String>();
        valuelist = qrsp.getFacetField(getFieldName(SearchBook.class, "customcatName0")).getValues();

        list = new ArrayList<GroupItem>();
        for (int i = 0; i < valuelist.size(); i++) {
            String[] kv = valuelist.get(i).getName().split("\\|");
            umap.put(kv[1], kv[0]);
            GroupItem g = new GroupItem(kv[1], kv[0], valuelist.get(i).getCount());
            list.add(g);
        }
        map.put("customcat0", list);

        valuelist = qrsp.getFacetField(getFieldName(SearchBook.class, "customcatName1")).getValues();

        HashMap<String, List<GroupItem>> categorymap1 = new HashMap<String, List<GroupItem>>();
        for (int i = 0; i < valuelist.size(); i++) {
            String[] kv = valuelist.get(i).getName().split("\\|");
            String key = kv[1].substring(0, 2);
            umap.put(kv[1], kv[0]);
            list = categorymap1.get(key);
            if (list == null)
                list = new ArrayList<GroupItem>();
            GroupItem g = new GroupItem(kv[1], kv[0], valuelist.get(i).getCount());
            list.add(g);
            categorymap1.put(key, list);
        }

        map.put("customcat1", categorymap1);
        map.put("custommap", umap);
        
        valuelist = qrsp.getFacetField(getFieldName(SearchBook.class, "tag")).getValues();

        list = new ArrayList<GroupItem>();
        for (int i = 0; i < valuelist.size(); i++) {
            GroupItem g = new GroupItem(valuelist.get(i).getName(), valuelist.get(i).getName(), valuelist.get(i).getCount());
            list.add(g);
        }
        map.put("tag", list);
        return map;
    }

    @Override
    void buildQuery(SolrQuery query, SearchVo s) {
        // query.addSortField("id", SolrQuery.ORDER.desc);
        if (s.getC0() != null && s.getC0().length() > 0)
            query.addFilterQuery("categoryId_0:" + s.getC0());
        if (s.getC1() != null && s.getC1().length() > 0)
            query.addFilterQuery("categoryId_1:" + s.getC1());
        if (s.getU0() != null && s.getU0().length() > 0)
            query.addFilterQuery("customcatId_0:" + s.getU0());
        if (s.getU1() != null && s.getU1().length() > 0)
            query.addFilterQuery("customcatId_1:" + s.getU1());
        if (s.getLetter() != null && s.getLetter().length() > 0)
            query.addFilterQuery("firstLetter:" + s.getLetter().toUpperCase());
        if (s.getOrg() > 0)
            query.addFilterQuery("org:" + s.getOrg());
        query.addSortField("id", SolrQuery.ORDER.desc);
        query.setHighlight(true);
        // 设置高亮区域
        query.addHighlightField( "intro");
        query.addHighlightField("name");
        // 设置高亮区域前缀
        query.setHighlightSimplePre("<i>");
        // 设置高亮区域后缀
        query.setHighlightSimplePost("</i>");
    }

    @Override
    void queryGroup(SolrQuery query, SearchVo s) {
        // 设置分组
        query.setFacet(true);
        query.setFacetLimit(999);
        query.addFacetField(getFieldName(SearchBook.class, "parentcategory"));
        query.addFacetField(getFieldName(SearchBook.class, "category"));
        query.addFacetField(getFieldName(SearchBook.class, "customcatName0"));
        query.addFacetField(getFieldName(SearchBook.class, "customcatName1"));
        query.addFacetField(getFieldName(SearchBook.class, "tag"));
        if (s.getOrg() > 0)
            query.addFilterQuery("org:" + s.getOrg());

        
    }

    @Override
    String varietyQuery(SearchVo s, String queryStr) {
        if (s.getQueryfield() > 0) {
            queryStr = QueryField.getTitle(s.getQueryfield()) + ":(" + queryStr + ") ";
        } else {
            queryStr = "name:(" + queryStr + ") OR author:(" + queryStr + ") OR publisher:(" + queryStr
                    + ") OR content:(" + queryStr + ") OR intro:(" + queryStr + ") ";
        }
        return queryStr;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        BookSearchServiceImpl search = new BookSearchServiceImpl();
        SearchVo s = new SearchVo();

        s.setWord("出版");
        //s.setOrg(1);
        s.setQueryfield(QueryField.ALL.getIndex());
        s.getPageUtil().setCurrentPage(1);
        s.getPageUtil().setPageSize(10);
        // s.setLetter("a");
        s = search.search(s);
        System.out.println("total:" + s.getTotal());
        List<SearchBook> books = (List<SearchBook>) s.getResult();
        System.out.println(books.size());
        for (SearchBook book : books) {
            System.out.print(book.getId() + "    " + book.getName() + "    " + book.getAuthor() + "   "+book.getPublisher());
            if(book.getTag()!=null)
            for(String t:book.getTag()){
                System.out.print(t+" ");
                
            }
            System.out.println();
        }

        List<GroupItem> l = (List<GroupItem>) s.getCustomcat0();
        for (GroupItem c : l) {
            if (c.getCount() > 0) {
                System.out.println("big:" + c.getId() + " " + c.getName() + ":" + c.getCount());
                List<GroupItem> gs = s.getCustomcat1().get(c.getId());
                if (gs != null)
                    for (GroupItem g : gs) {
                        if (g.getCount() > 0)
                            System.out.println(g.getId() + " " + g.getName() + ":" + g.getCount());
                    }
                System.out.println("=======================");
            }

        }
        // System.out.println("=======================");
        // l = (List<Count>) s.getCategory1();
        // for (Count c : l) {
        // if (c.getCount() > 0)
        // System.out.println(c.getName() + ":" + c.getCount());
        // }

    }

}
