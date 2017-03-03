/**
 * 
 */
package cn.chineseall.model.audio.vo;

import cn.chineseall.model.BaseEntity;
import cn.chineseall.model.audio.AudioBookInfo;
import cn.chineseall.model.audio.AudioInfo;
import cn.chineseall.model.audio.AudioReadLog;

/**
 * @author Lv15
 * 
 */
public class AudioReadLogDetail extends BaseEntity {

	private AudioReadLog log;

	private AudioInfo info;

	private AudioBookInfo bookInfo;

	public AudioReadLog getLog() {
		return log;
	}

	public void setLog(AudioReadLog log) {
		this.log = log;
	}

	public AudioInfo getInfo() {
		return info;
	}

	public void setInfo(AudioInfo info) {
		this.info = info;
	}

	public AudioBookInfo getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(AudioBookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}

	@Override
	public String getKeyword() {
		return null;
	}

}
