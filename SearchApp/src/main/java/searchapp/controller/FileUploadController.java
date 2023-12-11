/**
 * 
 */
package searchapp.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * @author Junaid Khan
 *
 */

@Controller
public class FileUploadController {

	@RequestMapping("/fileform")
	public String showFileMethod() {

		System.out.println("controller is called method invoke index:::");
		return "fileform";
	}

	
	@RequestMapping(value="/uploadimage", method = RequestMethod.POST)
	public String fileUpload(@RequestParam("profile") CommonsMultipartFile file
			,HttpSession session
			,Model model) {
		System.out.println(file.getSize()+" "
		+file.getContentType()+" "+file.getName()+" "+file.getFileItem()+" ");
		//etc...
		
		byte[] data=file.getBytes();
		//we have to save it on server...
		String path=session.getServletContext().getRealPath("/")
				+"WEB-INF"+
				File.separator+
				"resources"+
				File.separator+
				"images"
				+File.separator
				+file.getOriginalFilename();
		System.out.println(path+"  ---");
		//now write data
		FileOutputStream fileOutputStream;
		
			try {
				fileOutputStream = new FileOutputStream(path);
				fileOutputStream.write(data);
				fileOutputStream.close();
				
				model.addAttribute("filename",file.getOriginalFilename());
				model.addAttribute("msg","upload successfull...");
				
				System.out.println("Done.....");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("error1.....");
				model.addAttribute("msg","uploading error...");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("error2.....");
				model.addAttribute("msg","uploading error...");
			}
		
		System.out.println("FileUpload controller is called method invoke index:::");
		return "successfile";
	}
	
}
