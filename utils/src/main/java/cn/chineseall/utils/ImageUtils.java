package cn.chineseall.utils;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

public class ImageUtils {
    /**
     * 返回头像URL的方法
     * 
     * @param userId 会员ID
     * @return
     */
    public static String getUserImgUrl(Long userId) {
        String md5 = MD5.getMD5(userId.toString());
        String userImg = String.format("/user/%s/%s/%s/%s.jpg", md5.substring(0, 2), md5.substring(2, 4),
                md5.substring(4, 6), md5);
        return userImg;
    }

    /**
     * 返回书籍封面URL
     * 
     * @param bookId 书ID
     * @return
     */
    public static String getBookImgUrl(Long bookId) {
        return String.format("/book/%d/%d/%s.jpg", (bookId % 997), (bookId % 991), EncodeUtil.encode(bookId + ""));
    }

    /**
     * 返回机构树Logo的URL
     * 
     * @param orgtreeId 机构树ID
     * @return
     */
    public static String getOrgLogoUrl(Long orgtreeId) {
        return String.format("/org/%d/%d/logo_%s.jpg", (orgtreeId % 997), (orgtreeId % 101), EncodeUtil.encode(orgtreeId + ""));
    }

    /**
     * 返回机构树Banner的URL
     * 
     * @param orgtreeId 机构树ID
     * @return
     */
    public static String getOrgBannerUrl(Long orgtreeId) {
        return String.format("/org/%d/%d/banner_%s.jpg", (orgtreeId % 997), (orgtreeId % 101), EncodeUtil.encode(orgtreeId + ""));
    }
    
    /**
     * 返回读书小组Logo的URL
     * 
     * @param groupId 读书小组logo
     * @return
     */
    public static String getReadGroupLogoUrl(Long groupId) {
    	String md5 = MD5.getMD5(groupId.toString());
        String readgroupImg = String.format("/readgroup/%s/%s/%s/%s.jpg", md5.substring(0, 2), md5.substring(2, 4),
                md5.substring(4, 6), md5);
        return readgroupImg;
    }

    public static void main(String[] args) {
        System.out.println(getUserImgUrl(new Long(324859)));
        System.out.println(getBookImgUrl(new Long(324859)));
        System.out.println(getOrgLogoUrl(new Long(324859)));
        System.out.println(getOrgBannerUrl(new Long(324859)));
    }
    
    public static BufferedImage cut(BufferedImage image , int xIndex , int yIndex , int width , int height){
		BufferedImage newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for(int x = 0 ; x < width ; x ++){
			for(int y = 0 ; y < height ; y++){
				newImage.setRGB(x, y, image.getRGB(x + xIndex, y + yIndex));
			}
		}
		return newImage;
	}
	
	public static BufferedImage scale(
			BufferedImage src, 
			int scale, 
			boolean flag) {
		int width = src.getWidth(); // 得到源图宽
		int height = src.getHeight(); // 得到源图长
		if (flag) {
			// 放大
			width = width * scale;
			height = height * scale;
		} else {
			// 缩小
			width = width / scale;
			height = height / scale;
		}
		Image image = src.getScaledInstance(
				width, height, Image.SCALE_DEFAULT);
		BufferedImage tag = new BufferedImage(
				width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = tag.getGraphics();
		g.drawImage(image, 0, 0, null); // 绘制缩小后的图
		g.dispose();
//		ImageIO.write(
//				tag, "JPEG", new File(result));// 输出到文件流
		return tag;
	}
	
	/** 
	 * 缩放图像
	 * @param srcImageFile 源图像文件地址
	 * @param result       缩放后的图像地址
	 * @param scale        缩放比例
	 * @param flag         缩放选择:true 放大; false 缩小;
	 * @throws IOException 
	 */
	public static BufferedImage scale(
			String srcImageFile, 
			int scale, 
			boolean flag) throws IOException {
		return scale(ImageIO.read(
				new File(srcImageFile)) , scale , flag);
	}
	
	
	public static BufferedImage scale(InputStream in , int destWidth , int destHeight) throws IOException{
		return scale(ImageIO.read(in) , destWidth , destHeight);
	}
	
	public static BufferedImage scale(File srcImageFile , int destWidth , int destHeight) throws IOException{
		return scale(ImageIO.read(
				srcImageFile) , destWidth , destHeight);
	}
	
	public static BufferedImage scale(BufferedImage src , int destWidth , int destHeight) throws IOException{
		Image image = src.getScaledInstance(
				destWidth, destHeight, Image.SCALE_DEFAULT);
		BufferedImage tag = new BufferedImage(
				destWidth, destHeight, BufferedImage.TYPE_INT_RGB);
		Graphics g = tag.getGraphics();
		g.drawImage(image, 0, 0, null); // 绘制缩小后的图
		g.dispose();
//		ImageIO.write(
//				tag, "JPEG", result);// 输出到文件流
		return tag;
	}
	
	public static BufferedImage scale(
			String srcImageFile, 
			int destWidth,
			int destHeight) throws IOException {
		return scale(new File(srcImageFile) , destWidth , destHeight);
	}
	
	public static BufferedImage scale(
			String srcImageFile,
			int destWidth) throws IOException {
		BufferedImage src = 
			ImageIO.read(
					new File(srcImageFile)); // 读入文件
		int width = src.getWidth(); // 得到源图宽
		int height = src.getHeight(); // 得到源图长
		double scale = (double)destWidth / (double)width;
		int destHeight = (int)(height * scale);
		
		Image image = src.getScaledInstance(
				destWidth, destHeight, Image.SCALE_DEFAULT);
		BufferedImage tag = new BufferedImage(
				destWidth, destHeight, BufferedImage.TYPE_INT_RGB);
		Graphics g = tag.getGraphics();
		g.drawImage(image, 0, 0, null); // 绘制缩小后的图
		g.dispose();
//		ImageIO.write(
//				tag, "JPEG", new File(result));// 输出到文件流
		return tag;
	}
	
	public static byte[] scaleToPNG(
			String srcImageFile,
			int destWidth,
			int destHeight) {
		try {
			BufferedImage src = 
				ImageIO.read(
						new File(srcImageFile)); // 读入文件
			//int width = src.getWidth(); // 得到源图宽
			//int height = src.getHeight(); // 得到源图长
			//double scale = (double)destWidth / (double)width;
			//int destHeight = src.getHeight();
			
			Image image = src.getScaledInstance(
					destWidth, destHeight, Image.SCALE_DEFAULT);
			BufferedImage tag = new BufferedImage(
					destWidth, destHeight, BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			g.drawImage(image, 0, 0, null); // 绘制缩小后的图
			g.dispose();
			
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ImageIO.write(
					tag, "PNG", out);// 输出到文件流
			return out.toByteArray();
		} catch(IOException e) {
			e.printStackTrace();
			return new byte[0];
		}
	}
	
	public static byte[] scaleToJPG(
			String srcImageFile,
			int destWidth,
			int destHeight) {
		try {
			BufferedImage src = 
				ImageIO.read(
						new File(srcImageFile)); // 读入文件
			//int width = src.getWidth(); // 得到源图宽
			//int height = src.getHeight(); // 得到源图长
			//double scale = (double)destWidth / (double)width;
			//int destHeight = src.getHeight();
			
			Image image = src.getScaledInstance(
					destWidth, destHeight, Image.SCALE_DEFAULT);
			BufferedImage tag = new BufferedImage(
					destWidth, destHeight, BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			g.drawImage(image, 0, 0, null); // 绘制缩小后的图
			g.dispose();
			
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ImageIO.write(
					tag, "JPG", out);// 输出到文件流
			return out.toByteArray();
		} catch(IOException e) {
			e.printStackTrace();
			return new byte[0];
		}
	}
	
	public static byte[] scaleToPNG(
			String srcImageFile,
			int destWidth) {
		try {
			BufferedImage src = 
				ImageIO.read(
						new File(srcImageFile)); // 读入文件
			//int width = src.getWidth(); // 得到源图宽
			//int height = src.getHeight(); // 得到源图长
			//double scale = (double)destWidth / (double)width;
			int destHeight = src.getHeight();
			
			Image image = src.getScaledInstance(
					destWidth, destHeight, Image.SCALE_DEFAULT);
			BufferedImage tag = new BufferedImage(
					destWidth, destHeight, BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			g.drawImage(image, 0, 0, null); // 绘制缩小后的图
			g.dispose();
			
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ImageIO.write(
					tag, "PNG", out);// 输出到文件流
			return out.toByteArray();
		} catch(IOException e) {
			e.printStackTrace();
			return new byte[0];
		}
	}
	
	public static byte[] scaleToPNG(
			byte[] input,
			int destWidth) {
		try {
			ByteArrayInputStream in = new ByteArrayInputStream(input);
			BufferedImage src = 
				ImageIO.read(in); // 读入文件
			//int width = src.getWidth(); // 得到源图宽
			//int height = src.getHeight(); // 得到源图长
			//double scale = (double)destWidth / (double)width;
			int destHeight = src.getHeight();
			
			Image image = src.getScaledInstance(
					destWidth, destHeight, Image.SCALE_DEFAULT);
			BufferedImage tag = new BufferedImage(
					destWidth, destHeight, BufferedImage.TYPE_INT_RGB);
			Graphics g = tag.getGraphics();
			g.drawImage(image, 0, 0, null); // 绘制缩小后的图
			g.dispose();
			
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ImageIO.write(
					tag, "PNG", out);// 输出到文件流
			return out.toByteArray();
		} catch(IOException e) {
			e.printStackTrace();
			return new byte[0];
		}
	}

	/** *//**
	 * 图像切割
	 * @param srcImageFile 源图像地址
	 * @param destDir      切片目标文件夹
	 * @param destWidth    目标切片宽度
	 * @param destHeight   目标切片高度
	 */
	public static void cut(
			String srcImageFile, 
			String destDir, 
			int destWidth, 
			int destHeight) {
		try {
			Image img;
			ImageFilter cropFilter;
			// 读取源图像
			BufferedImage bi = ImageIO.read(
					new File(srcImageFile));
			int srcHeight = bi.getHeight(); // 源图宽度
			int srcWidth = bi.getWidth(); // 源图高度
			//System.out.println("srcWidth:" + srcWidth );
			//System.out.println("srcHeight:" + srcHeight );
			if (srcWidth >= destWidth 
					&& srcHeight > destHeight) {
				Image image = bi.getScaledInstance(
						srcWidth, 
						srcHeight, 
						Image.SCALE_DEFAULT);
				//destWidth = 200; // 切片宽度
				//destHeight = 150; // 切片高度
				int cols = 0; // 切片横向数量
				int rows = 0; // 切片纵向数量
				// 计算切片的横向和纵向数量
				if (srcWidth % destWidth == 0) {
					cols = srcWidth / destWidth;
				} else {
					cols = (int) Math.floor(srcWidth / destWidth) + 1;
				}
				if (srcHeight % destHeight == 0) {
					rows = srcHeight / destHeight;
				} else {
					rows = (int) Math.floor(srcHeight / destHeight) + 1;
				}
				// 循环建立切片
				// 改进的想法:是否可用多线程加快切割速度
				for (int i = 0; i < rows; i++) {
					for (int j = 0; j < cols; j++) {
						// 四个参数分别为图像起点坐标和宽高
						// 即: CropImageFilter(int x,int y,int width,int height)
						cropFilter = new CropImageFilter(
								j * destWidth, 
								i * destHeight, 
								destWidth, 
								destHeight);
						img = Toolkit.getDefaultToolkit().createImage(
								new FilteredImageSource(
										image.getSource(), 
										cropFilter));
						BufferedImage tag = new BufferedImage(
								destWidth, 
								destHeight, 
								BufferedImage.TYPE_INT_RGB);
						Graphics g = tag.getGraphics();
						g.drawImage(img, 0, 0, null); // 绘制缩小后的图
						g.dispose();
						// 输出为文件
						/*
						ImageIO.write(tag, 
								"PNG", 
								new File(
										descDir 
										+ "pre_map_" 
										+ i 
										+ "_" 
										+ j 
										+ ".png"));
						*/
						ImageIO.write(tag, 
								"PNG", 
								new File(
										destDir
										+ getFileName(srcImageFile)
										+ "_"
										+ i
										+ "_"
										+ j
										+ ".png"));
										
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** *//**
	 * 图像类型转换 GIF->JPG GIF->PNG PNG->JPG PNG->GIF(X)
	 */
	public static void convert(
			String source, 
			String result) {
		try {
			File f = new File(source);
			f.canRead();
			f.canWrite();
			BufferedImage src = ImageIO.read(f);
			ImageIO.write(src, "JPG", new File(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void convertToPNG(
			String source, 
			String result) {
		try {
			File f = new File(source);
			f.canRead();
			f.canWrite();
			BufferedImage src = ImageIO.read(f);
			ImageIO.write(src, "PNG", new File(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** *//**
	 * 彩色转为黑白
	 * @param source
	 * @param result
	 */
	public static void gray(
			String source, 
			String result) {
		try {
			BufferedImage src = ImageIO.read(new File(source));
			ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
			ColorConvertOp op = new ColorConvertOp(cs, null);
			src = op.filter(src, null);
			ImageIO.write(src, "JPEG", new File(result));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getFileName(String path) {
		String s1 = path.substring(
				path.lastIndexOf(
						System.getProperty("file.separator")) + 1);
		if(s1.equals(path)) {
			s1 = path.substring(
					path.lastIndexOf("/") + 1);
		}
		s1 = s1.substring(0, s1.lastIndexOf("."));
		return s1;
	}
	
	public static String getFileFormat(String path) {
		String s1 = path.substring(
				path.lastIndexOf(
						System.getProperty("file.separator")) + 1);
		if(s1.equals(path)) {
			s1 = path.substring(
					path.lastIndexOf("/") + 1);
		}
		s1 = s1.substring(s1.lastIndexOf(".") + 1);
		return s1;
	}
	
	public static String getFileFullName(String path) {
		String s1 = path.substring(
				path.lastIndexOf(
						System.getProperty("file.separator")) + 1);
		if(s1.equals(path)) {
			s1 = path.substring(
					path.lastIndexOf("/") + 1);
		}
		return s1;
	}

	public static void write(BufferedImage image , File file) throws IOException{
		ImageIO.write(image, "JPEG", file);
	}
	
	public static void write(BufferedImage image , String fileName) throws IOException{
		write(image, new File(fileName));
	}
	
	public static void write(BufferedImage image , OutputStream out) throws IOException{
		ImageIO.write(image, "JPEG", out);
	}
}
