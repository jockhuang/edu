/**
 * ChineseAll Inc.
 * Copyright (c) 2013 All Rights Reserved.
 * @author Lv15
 */
package cn.chineseall.book.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.chineseall.book.constant.ClientURL;
import cn.chineseall.book.service.UserService;
import cn.chineseall.model.user.User;
import cn.chineseall.model.user.UserStudy;
import cn.chineseall.model.user.vo.UserInfo;
import cn.chineseall.model.user.vo.UserReadingDetail;
import cn.chineseall.utils.ClientUtil;
import cn.chineseall.utils.ImageUtils;
import cn.chineseall.utils.JsonUtil;

/**
 * 
 * @author Lv15
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource(type = org.apache.commons.configuration.PropertiesConfiguration.class)
	private PropertiesConfiguration fileUploadConfig;

	@Override
	public boolean haveConcernUserId(Long userId , Long concernUserId) throws Exception{
		List<Long> listUserId = new ArrayList<Long>();
		listUserId.add(concernUserId);
		return mapHaveConcernUserId(userId, listUserId).size() > 0;
	}
	
	@Override
	public Map<String, Long> mapHaveConcernUserId(Long userId,
			Collection<Long> listUserId) throws Exception {
		Map<String, Long> mapUserId = new HashMap<String, Long>();
		if (userId == null || listUserId == null || listUserId.size() == 0) {
			return mapUserId;
		}
		HashMap<Object, Object> params = new HashMap<Object, Object>();
		params.put("userId", userId);
		params.put("concernUserIds", listUserId);
		String json = ClientUtil.getStringClient(
				ClientURL.LIST_HAVE_CONCERN_USER_ID, params);

		listUserId = JsonUtil.jsonToList(json, "list", Long.class);
		if (listUserId == null || listUserId.size() == 0) {
			return mapUserId;
		}
		for (Long id : listUserId) {
			mapUserId.put(id.toString(), id);
		}
		return mapUserId;
	}

	@Override
	public Map<String, Object> getUserIndexPageData(Long userId)
			throws Exception {

		if (userId == null) {
			return null;
		}

		Map<String, Object> data = new HashMap<String, Object>();

		HashMap<Object, Object> params = new HashMap<Object, Object>();

		/**
		 * 获取我关注的书友
		 */
		params.put("userId", userId);
		params.put("pageSize", 9);
		String json = ClientUtil.getStringClient(
				ClientURL.LIST_ME_CONCERN_USER, params);
		data.put("listMeConcernUser",
				JsonUtil.jsonToList(json, "list", UserInfo.class));

		/**
		 * 获取关注我的书友
		 */
		params.put("userId", userId);
		params.put("pageSize", 9);
		json = ClientUtil.getStringClient(ClientURL.LIST_CONCERN_ME_USER,
				params);
		data.put("listConcernMeUser",
				JsonUtil.jsonToList(json, "list", UserInfo.class));

		/**
		 * 获取访问我书房的书友
		 */
		params.put("userId", userId);
		params.put("pageSize", 9);
		json = ClientUtil.getStringClient(ClientURL.LIST_VISIT_ME_USER, params);
		data.put("listVisitMyUser",
				JsonUtil.jsonToList(json, "list", UserInfo.class));
		data.put("visitMyUserCount", JsonUtil.getLong(json, "count"));

		/**
		 * 获取我最后阅读的图书
		 */
		params.put("userId", userId);
		params.put("orgTreeId", 1);
		params.put("pageSize", 1);
		json = ClientUtil.getStringClient(ClientURL.LIST_USER_READING_DETAIL,
				params);
		List<UserReadingDetail> lastReadingBook = JsonUtil.jsonToList(json,
				"list", UserReadingDetail.class);
		if (lastReadingBook != null && lastReadingBook.size() > 0) {
			data.put("lastReadingBook", lastReadingBook.get(0));
		}
		return data;
	}

	@Override
	public String settingHeadImg(Long userId, String headImg, Integer width,
			Integer height, Integer x1, Integer y1, Integer x2, Integer y2) {

		if (userId == null) {
			return "登录后进行操作";
		}

		FileOutputStream out = null;
		InputStream in = null;
		try {

			HttpURLConnection conn = (HttpURLConnection) new URL(headImg)
					.openConnection();

			conn.setConnectTimeout(4 * 1000);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept",
					"image/gif, image/jpeg, image/pjpeg, image/pjpeg, image/png");
			conn.setRequestProperty("Accept-Language", "zh-CN");
			conn.setRequestProperty("Charset", "UTF-8");

			if (headImg.lastIndexOf(".") == -1) {
				return "上传头像文件格式不符合要求";
			}

			String iconFileType = headImg.substring(headImg.lastIndexOf("."))
					.toLowerCase();
			if (iconFileType.indexOf("?") > -1) {
				iconFileType = iconFileType.substring(0,
						iconFileType.indexOf("?"));
			}

			if (conn.getContentLength() > (1024 * 1000)) {
				return "上传头像文件大小不能超过1M";
			} else if (iconFileType.equals(".png")
					|| iconFileType.equals(".jpg")
					|| iconFileType.equals(".jpeg")
					|| iconFileType.equals(".gif")) {

				BufferedImage image = ImageIO
						.read((in = conn.getInputStream()));

				if (width != null
						&& height != null
						&& (image.getWidth() != width || image.getHeight() != height)
						&& x1 != null && y1 != null) {
					image = ImageUtils.scale(
							ImageUtils.cut(image, x1, y1, width, height), 200,
							200);
				}

				String baseDir = fileUploadConfig
						.getString("image_upload_base_dir");
				if (baseDir.lastIndexOf("/") == baseDir.length()
						|| baseDir.lastIndexOf("\\") == baseDir.length()) {
					baseDir = baseDir.substring(0, baseDir.length() - 1);
				}

				StringBuilder url = new StringBuilder(baseDir)
						.append(ImageUtils.getUserImgUrl(userId));

				File file = new File(url.toString());
				file.getParentFile().mkdirs();

				out = new FileOutputStream(file);

				ImageIO.write(image, "JPEG",
						ImageIO.createImageOutputStream(out));
			} else {
				return "上传头像文件格式不符合要求";
			}
		} catch (Exception e) {
			logger.error("头像数据传输中断，请稍后重试", e);
			return "头像数据传输中断，请稍后重试";
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e) {
					logger.error("关闭上传头像输入流失败", e);
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
					logger.error("关闭上传头像输出流失败", e);
				}
			}
		}

		return null;
	}

	@Override
	public String saveCacheHeadImg(Long userId, MultipartFile uploadIcon)
			throws Exception {

		if (userId == null) {
			throw new Exception("登录后在进行操作");
		}

		if (uploadIcon == null) {
			throw new Exception("请选择上传头像图片");
		}

		String iconFileType = uploadIcon.getOriginalFilename()
				.substring(uploadIcon.getOriginalFilename().lastIndexOf("."))
				.toLowerCase();

		if (uploadIcon.getSize() > (1024L * 1000L)) {
			throw new Exception("上传头像文件大小不能超过1M");
		} else if (".jpg".equals(iconFileType) || ".jpeg".equals(iconFileType)
				|| ".gif".equals(iconFileType) || ".png".equals(iconFileType)) {
			FileOutputStream out = null;
			try {

				BufferedImage image = ImageIO.read(uploadIcon.getInputStream());

				int sWidth = 200;
				int sHeight = 200;

				double sx = (double) sWidth / image.getWidth();
				double sy = (double) sHeight / image.getHeight();
				if (sx < sy) {
					sx = sy;
					sWidth = (int) (sx * image.getWidth());
				} else {
					sy = sx;
					sHeight = (int) (sy * image.getHeight());
				}

				image = ImageUtils.scale(uploadIcon.getInputStream(), sWidth,
						sHeight);

				String baseDir = fileUploadConfig
						.getString("image_upload_base_dir");
				if (baseDir.lastIndexOf("/") == baseDir.length()
						|| baseDir.lastIndexOf("\\") == baseDir.length()) {
					baseDir = baseDir.substring(0, baseDir.length() - 1);
				}

				StringBuilder url = new StringBuilder(baseDir).append("/cache")
						.append(ImageUtils.getUserImgUrl(userId));

				File file = new File(url.toString());
				file.getParentFile().mkdirs();

				out = new FileOutputStream(file);

				ImageIO.write(image, "JPEG",
						ImageIO.createImageOutputStream(out));
				return url.toString().replaceAll(baseDir, "");
			} catch (Exception e) {
				logger.error("读取上传头像失败", e);
				throw new Exception("读取上传头像失败");
			} finally {
				if (out != null) {
					try {
						out.close();
					} catch (Exception e) {
						logger.error("关闭上传头像输出流失败", e);
						throw new Exception("上传头像文件大小不能超过1M");
					}
				}
			}
		} else {
			throw new Exception("上传头像文件格式不符合要求");
		}
	}

	@Override
	public User getUser(Long userId) throws Exception {
        if (userId != null) {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("userId", userId);
            String returnStr = ClientUtil.getStringClient(ClientURL.GET_USER, params);
            List<User> user = JsonUtil.jsonToList(returnStr, "list", User.class);
            return user.size() > 0 ? user.get(0) : null;
        }
        return null;
    }
	
	@Override
	public UserInfo getUserInfo(Long userId) throws Exception {
        if (userId != null) {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("userId", userId);
            String returnStr = ClientUtil.getStringClient(ClientURL.GET_USER_INFO, params);
            List<UserInfo> userInfo = JsonUtil.jsonToList(returnStr, "list", UserInfo.class);
            return userInfo.size() > 0 ? userInfo.get(0) : null;
        }
        return null;
    }
	
	@Override
	public List<UserInfo> listUserInfo(List<Long> userIds) throws Exception {
        if (userIds != null) {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("userIds", userIds);
            String returnStr = ClientUtil.getStringClient(ClientURL.GET_USER_INFO, params);
            return JsonUtil.jsonToList(returnStr, "list", UserInfo.class);
        }
        return new ArrayList<UserInfo>();
    }
	
	@Override
	public Integer getNotReadLetterCount(Long userId) throws Exception {
        /**
         * 获取我未读书信数
         */
        HashMap<Object, Object> params = new HashMap<Object, Object>();
        params.put("userId", userId);
        String json = ClientUtil.getStringClient(ClientURL.GET_NOT_READ_LETTER_COUNT, params);
        return JsonUtil.getInt(json, "count");
    }

	@Override
	public UserStudy getUserStudy(Long userId) throws Exception {
        HashMap<Object, Object> params = new HashMap<Object, Object>();
        params.put("userId", userId);
        String json = ClientUtil.getStringClient(ClientURL.GET_USER_STUDY, params);
        return JsonUtil.jsonToObject(json, "userStudy", UserStudy.class);
    }
	
	public static void main(String[] args) throws Exception {
	}

	private static Logger logger = LoggerFactory
			.getLogger(UserServiceImpl.class);

	// @Override
	// public String settingHeadImg(Long userId, Integer width, Integer height,
	// Integer x1, Integer y1, Integer x2, Integer y2,
	// MultipartFile uploadIcon, String headImg) {
	//
	// if (userId == null) {
	// return "登录后进行操作";
	// }
	// if (headImg != null && (headImg = headImg.trim()) == null) {
	//
	// } else if (uploadIcon != null) {
	// String iconFileType = uploadIcon
	// .getOriginalFilename()
	// .substring(
	// uploadIcon.getOriginalFilename().lastIndexOf("."))
	// .toLowerCase();
	// if (uploadIcon.getSize() > (1024L * 1000L)) {
	// return "上传头像文件大小不能超过1M";
	// } else if (".jpg".equals(iconFileType)
	// || ".jpeg".equals(iconFileType)
	// || ".gif".equals(iconFileType)
	// || ".png".equals(iconFileType)) {
	// FileOutputStream out = null;
	// try {
	//
	// BufferedImage image = ImageIO.read(uploadIcon
	// .getInputStream());
	//
	// int sWidth = 200;
	// int sHeight = 200;
	//
	// double sx = (double) sWidth / image.getWidth();
	// double sy = (double) sHeight / image.getHeight();
	// if (sx < sy) {
	// sx = sy;
	// sWidth = (int) (sx * image.getWidth());
	// } else {
	// sy = sx;
	// sHeight = (int) (sy * image.getHeight());
	// }
	//
	// image = ImageUtils.scale(uploadIcon.getInputStream(),
	// sWidth, sHeight);
	//
	// if (width != null && height != null
	// && (sWidth != width || sHeight != height)
	// && x1 != null && y1 != null) {
	// image = ImageUtils.scale(
	// ImageUtils.cut(image, x1, y1, width, height),
	// 200, 200);
	// }
	//
	// StringBuilder url = new StringBuilder(
	// ClientURL.UPLOAD_IMG_SYNCHRONOUS_ROOT_DIR)
	// .append(ImageUtils.getUserImgUrl(userId));
	//
	// File file = new File(url.toString());
	// file.getParentFile().mkdirs();
	//
	// out = new FileOutputStream(file);
	//
	// ImageIO.write(image, "JPEG",
	// ImageIO.createImageOutputStream(out));
	//
	// // if(".jpg".equals(iconFileType) ||
	// // ".jpeg".equals(iconFileType)){
	// // ImageIO.write(image, "JPEG",
	// // ImageIO.createImageOutputStream(baos));
	// // }else if(".gif".equals(iconFileType)){
	// // ImageIO.write(image, "GIF",
	// // ImageIO.createImageOutputStream(baos));
	// // }else if(".png".equals(iconFileType)){
	// // ImageIO.write(image, "PNG",
	// // ImageIO.createImageOutputStream(baos));
	// // }
	//
	// } catch (Exception e) {
	// return "读取上传头像失败";
	// } finally {
	// if (out != null) {
	// try {
	// out.close();
	// } catch (Exception e) {
	// logger.error("关闭上传头像输出流失败", e);
	// }
	// }
	// }
	// } else {
	// return "上传头像文件格式不符合要求";
	// }
	// }
	// return null;
	// }

	// @Override
	// public Integer getNotReadLetterCount(Long userId) throws Exception {
	// /**
	// * 获取我未读书信数
	// */
	// HashMap<Object, Object> params = new HashMap<Object, Object>();
	// params.put("userId", userId);
	// String json =
	// ClientUtil.getStringClient(ClientURL.GET_NOT_READ_LETTER_COUNT, params);
	// return JsonUtil.getInt(json, "count");
	// }
	//
	// @Override
	// public UserStudy getUserStudy(Long userId) throws Exception {
	// HashMap<Object, Object> params = new HashMap<Object, Object>();
	// params.put("userId", userId);
	// String json = ClientUtil.getStringClient(ClientURL.GET_USER_STUDY,
	// params);
	// return JsonUtil.jsonToObject(json, "userStudy", UserStudy.class);
	// }

}
