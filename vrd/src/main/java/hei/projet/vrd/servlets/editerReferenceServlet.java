package hei.projet.vrd.servlets;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import hei.projet.vrd.entities.Chantier;
import hei.projet.vrd.services.SiteService;

@WebServlet("/adm-realisations")
@MultipartConfig
public class editerReferenceServlet extends AbstractGenericServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setCharacterEncoding("UTF-8");
		
		TemplateEngine templateEngine =this.createTemplateEngine(req);
		
		WebContext context = new WebContext(req, resp, req.getServletContext());
		context.setVariable("references", SiteService.getInstance().listChantier());
		templateEngine.process("editer-reference", context, resp.getWriter());
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String titre = req.getParameter("titre");
		String ville = req.getParameter("ville");
		Integer cp = Integer.parseInt(req.getParameter("cp"));
		String mo = req.getParameter("mo");
		String client = req.getParameter("client");
		String mission = req.getParameter("mission");
		
		Part photo = req.getPart("photo");
		
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				  "cloud_name", "hmx9ewx7x",
				  "api_key", "824237185367422",
				  "api_secret", "3GlEAEHv-BPAzMifVPbWUF6qUQk"));
		
		
		File toUpload = new File(photo.getSubmittedFileName());
		
		//Map uploadResult = cloudinary.uploader().upload(toUpload, ObjectUtils.emptyMap());
		
	    //System.out.println("File getPart: " + photo);
		
		//System.out.println("File name : "+toUpload);
		
		
		
		//Files.copy(picture.getInputStream(), picturePath);
		
		Map result = cloudinary.uploader().upload(new BufferedInputStream(new FileInputStream(toUpload)), ObjectUtils.emptyMap());
			
				
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
		String date = format1.format(cal.getTime());
		
		Chantier newChantier = new Chantier(
				null,
				ville,
				cp,
				date,
				mo,
				client,
				titre,
				mission
				);
		
		SiteService.getInstance().addChantier(newChantier, req.getPart("photo"));
		resp.setCharacterEncoding("UTF8");
		resp.sendRedirect("adm-addmsg");
		
	}

}
