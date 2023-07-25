package upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class DownloadController {
	@RequestMapping("/filedownloadlist")
	public ModelAndView downloadlist() {
		File f = new File("d:/kdt_file/upload/");
		String fileArr[] = f.list();
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("fileArr", fileArr);
		mv.setViewName("upload/downloadlist");
		return mv;
	}
	@RequestMapping("/filedownloadresult")
	public void downloadresule(String filename, HttpServletResponse response) throws Exception {
		File f = new File("d:/kdt_file/upload/" + filename);
		response.setContentType("application/download");
		response.setContentLength((int)(f.length()));
		response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
		
		OutputStream out = response.getOutputStream();
		FileInputStream fin = new FileInputStream(f);
		FileCopyUtils.copy(fin, out);
		fin.close();
		out.close();
	}
}