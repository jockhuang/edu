package cn.chineseall.book.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.Group;
import org.apache.solr.client.solrj.response.GroupCommand;
import org.apache.solr.client.solrj.response.GroupResponse;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("indexController")
@RequestMapping("/")
public class IndexController extends BaseController {

	private static final String SOLR_SERVER = "http://master.chineseall.cn:8080/solr/collection1";
	
	@RequestMapping("searchBook")
	public ModelAndView searchBook(String keyWords,Integer currentPage,Integer pageSize,HttpServletRequest request){	
		currentPage = (currentPage==null||currentPage==0)?1:currentPage;
		pageSize = (pageSize==null||pageSize==0)?10:pageSize;
		Integer start = (currentPage-1) * pageSize;
		Integer rows = pageSize;
		keyWords = (keyWords==null||keyWords.equals(""))?"*":keyWords;
		SolrServer solrServer = new HttpSolrServer(SOLR_SERVER);
		SolrQuery query = new SolrQuery();
		query.setStart(start);
		query.setRows(rows);
		if(keyWords.equals("*")){
			query.setQuery("*:*");
		}else{
			query.setQuery("name:"+keyWords+" OR content:"+keyWords);
		}
		query.addHighlightField("name");
		query.addHighlightField("intro");
		query.setHighlightSimplePre("<font color=\"red\">");
		query.setHighlightSimplePost("</font>");
		
		ModelAndView mav = new ModelAndView("/search");
		try {
			QueryResponse rsp = solrServer.query(query);
			SolrDocumentList docs = rsp.getResults();
			Map<String,Map<String,List<String>>> map = rsp.getHighlighting();		
			for (SolrDocument doc : docs) {
				String id = (String) doc.getFieldValue("id");
				if(map.get(id).get("name") != null){  
				  String temp = map.get(id).get("name").get(0);
				  doc.setField("name", temp);
				}  
				if(map.get(id).get("intro") != null){  
					  String temp = map.get(id).get("intro").get(0);  
					  doc.setField("intro", temp);
				}   
			}
			Integer totalPages = Double.valueOf(Math.ceil(docs.getNumFound()*1.0/pageSize)).intValue();
			mav.getModelMap().put("docNums", docs.getNumFound());
			mav.getModelMap().put("totalPages", totalPages);
			mav.getModelMap().put("currentPage", currentPage);
			mav.getModelMap().put("pageSize", pageSize);
			mav.getModelMap().put("docs", docs);
			if(keyWords.equals("*")){
				mav.getModelMap().put("keyWords", "");
			}else{
				mav.getModelMap().put("keyWords", keyWords);
			}
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		return mav;
	}
}
