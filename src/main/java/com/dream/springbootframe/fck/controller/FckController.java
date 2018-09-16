package com.dream.springbootframe.fck.controller;

import com.dream.springbootframe.fck.entity.Fck;
import com.dream.springbootframe.fck.service.FckService;
import org.apache.commons.io.FileUtils;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;


/**
 * 
 * @author Dream
 * 2018年2月5日
 *
 *FCKeditor富文本上传文件
 *
 *	要把上传图片的路径在/com.dream.springbootframe/src/main/resources/static/ckeditor/config.js文件内配置
 *		config.filebrowserUploadUrl="/imgUpdate/upfile"
 */
@Controller
@RequestMapping("/fck")
public class FckController {

	@Autowired
	private FckService fckService;

	/**
	 * 
	 * @return 跳转页面
	 * 已写入WebMvcPage
	@see com.dream.springbootframe.config.WebMvcPage
	@RequestMapping("/page")
	public String fckpage() {
		return "fck";
	}
	 */

	/**
	 * 上传图片
	 * @return
	 */
	@RequestMapping(value="/upload_img")
	public void uploadFile(@RequestParam("upload") MultipartFile multipartFile,HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		String CKEditorFuncNum = request.getParameter("CKEditorFuncNum");
		String filename = multipartFile.getOriginalFilename();
		//得到文件上传的服务器路径	后面拼接static加跳转页面的@RequestMapping("/imgUpdate")内的路径
		//这个上传到项目内
		String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static\\fck\\";

		//上传到tomcat的临时文件路径
		//String path = request.getSession().getServletContext().getRealPath("") + "\\fck\\";
		
		//解决文件同名问题
		filename = UUID.randomUUID().toString().replace("-", "")+filename.substring(filename.lastIndexOf("."));
		
		//定义服务器的新文件
		File newFile = new File(path+filename);
		File f = null;
		try {
		    f=File.createTempFile("tmp", null);
		    multipartFile.transferTo(f);
		  //真正上传
		    FileUtils.copyFile(f, newFile);
		    f.deleteOnExit();        
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		PrintWriter out;
		String s = "<script type=\"text/javascript\">window.parent.CKEDITOR.tools.callFunction("+CKEditorFuncNum+", '"+filename+"');</script>";
		try {
			out = response.getWriter();
			out.print(s);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 增
	 * @param
	 */
	@RequestMapping("/add")
	public String add(Fck fck) {
		fckService.add(fck);
		return "redirect:/fck/page";
	}

	/**
	 * 获取全部id
	 * @return
	 */
	@RequestMapping("get_all_id")
	@ResponseBody
	public List<String> getAllid() {
		return fckService.getAllId();
	}

	/**
	 * 根据id获取数据
	 * @param id
	 * @return
	 */
	@RequestMapping("get_one")
	@ResponseBody
	public Fck getOne(String id) {
		return fckService.getFckbyId(id);
	}

	/**
	 * 测试富文本导出word
	 */
	@RequestMapping("/export")
	public void exportWord( HttpServletRequest request, HttpServletResponse response, String id) throws Exception {
		try {
			Fck fck = fckService.getFckbyId(id);
			//word内容
			String content="<html><meta charset=\"utf-8\" /><body>";
			content += fck.getText();
			content += "</body></html>";
			//获取绝对路径 这里要与文件存储的路径一样
			String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/fck/";
			path = path.substring(1);
			//替换里面的所有图片路径
			content = content.replaceAll("<img alt=\"\" src=\"", "<img alt=\"\" src=\"" + path);

			byte b[] = content.getBytes("utf-8");  //这里是必须要设置编码的，不然导出中文就会乱码。
			ByteArrayInputStream bais = new ByteArrayInputStream(b);//将字节数组包装到流中

			//* 关键地方
			//* 生成word格式
			POIFSFileSystem poifs = new POIFSFileSystem();
			DirectoryEntry directory = poifs.getRoot();
			DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);

			//设置文件名
			String fileName = fck.getId();
			//处理文件名乱码
			String userAgent = request.getHeader("User-Agent");
			// 针对IE或者以IE为内核的浏览器：
			if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
				fileName = java.net.URLEncoder.encode(fileName, "UTF-8");
			} else {
				// 非IE浏览器的处理：
				fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			}

			//输出文件
			request.setCharacterEncoding("utf-8");
			response.setContentType("application/msword");//导出word格式
			response.addHeader("Content-Disposition", "attachment;filename=" + fileName + ".doc");
			OutputStream ostream = response.getOutputStream();
			poifs.writeFilesystem(ostream);
			bais.close();
			ostream.close();
		}catch(Exception e){
			System.err.println(e);
		}
	}
}
