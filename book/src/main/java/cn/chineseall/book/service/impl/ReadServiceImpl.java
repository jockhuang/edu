/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Lv15
 */
package cn.chineseall.book.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.service.ReadService;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.JsonUtil;

/**
 * 
 * @author Lv15
 */
@Service("readService")
public class ReadServiceImpl implements ReadService {

	@Override
	public String getTxtContent(String tokenKey, String tokenContent)
			throws Exception {
		StringBuilder content = new StringBuilder();
		URLConnection conn = new URL(ClientURL.RESOURCES_PREFIX
				+ "/read.action?m=" + tokenKey + "&c=" + tokenContent)
				.openConnection();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				conn.getInputStream(), "UTF-8"));
		String line = null;
		while ((line = reader.readLine()) != null) {
			content.append(line);
		}
		return content.toString();
	}

	@Override
	public JSONArray getDirectory(Long bookId, Integer type) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bookId", bookId);
		params.put("mode", type);
		String json = ClientUtil.getStringClient(
				ClientURL.GET_READ_DIRECTORY_TOKEN, params);
		JSONObject token = JSONObject.fromObject(json).getJSONObject("token");
		if (token != null) {
			StringBuilder content = new StringBuilder();
			URLConnection conn = new URL(ClientURL.RESOURCES_PREFIX
					+ "/read/directory.action?m=" + token.getString("key")
					+ "&c=" + token.getString("content")).openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "UTF-8"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				content.append(line);
			}
			return JSONArray.fromObject(content.toString());
		} else {
			return new JSONArray();
		}
	}

}
