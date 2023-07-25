package upload;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {
	// 업로드폼 화면 리턴
	@GetMapping("fileupload")
	public String uploadForm() {
		return "upload/uploadform";
	}

	// 업로드 처리 결과 화면 리턴
	@PostMapping("fileupload")
	public ModelAndView uploadResult(UploadDTO dto) throws Exception {
		MultipartFile file[] = { dto.getFile1(), dto.getFile2() };
		String savePath = "D:/kdt_file/upload/";
		String randId[] = UUID.randomUUID().toString().split("-");
		String fileName[] = new String[2];

		for (int f = 0; f < file.length; f++) {
			if (!file[f].isEmpty()) {
				String originalName[] = file[f].getOriginalFilename().split("\\.");
				fileName[f] = savePath + originalName[0] + "(" + randId[f] + ")." + originalName[originalName.length - 1];
				file[f].transferTo(new java.io.File(fileName[f]));
			}
		}

		ModelAndView mv = new ModelAndView();
		mv.addObject("uploadresult", fileName[0] + "<br>" + fileName[1] + "<br>파일에 저장했습니다.");
		mv.setViewName("upload/uploadresult");
		return mv;
	}
}