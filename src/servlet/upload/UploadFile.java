package servlet.upload;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadFile
 */
@WebServlet(description = "文件上传", urlPatterns = { "/upload" })
public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String uploadPath = "E:\\upload";
	private String tempPath = "E:\\upload\\temp";
	private File tempFilePath;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.getWriter().println("请使用POST方式上传");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 设置缓冲区大小
		factory.setSizeThreshold(1024 * 4);
		// 设置缓冲区目录
		factory.setRepository(tempFilePath);
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 设置最大文件100MB
		upload.setSizeMax(1024 * 1024 * 100);
		try {
			List<FileItem> items = upload.parseRequest(request);
			Iterator<FileItem> iterator = items.iterator();
			System.out.println("文件开始上传");
			while (iterator.hasNext()) {
				FileItem item = iterator.next();
				String fileName = item.getName();
				if (fileName != null) {
					File fullFile = new File(item.getName());
					File savedFile = new File(uploadPath, fullFile.getName());
					item.write(savedFile);
					System.out.println(fileName + "\n文件上传成功");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("文件上传失败" + e.getMessage());
		}
	}

	@Override
	public void init() throws ServletException {
		File uploadFile = new File(uploadPath);
		if (!uploadFile.exists()) {
			uploadFile.mkdirs();
		}
		File tempPathFile = new File(tempPath);
		if (!tempPathFile.exists()) {
			tempPathFile.mkdirs();
		}
	}

}
