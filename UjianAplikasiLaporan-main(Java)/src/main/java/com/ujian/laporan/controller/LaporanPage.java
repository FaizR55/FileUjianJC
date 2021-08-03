package com.ujian.laporan.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ujian.laporan.utility.FileUtility;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import com.ujian.laporan.entity.Laporan;
import com.ujian.laporan.service.ModelLaporan;

@Controller
public class LaporanPage {
	
	@Autowired
	ModelLaporan modelLaporan;
	
	@GetMapping("/dashboard")
	public String viewDashboardLaporan(Model model) {
		
		model.addAttribute("totalLaporan", modelLaporan.getAllLaporan().size());
		model.addAttribute("ditanggapi", modelLaporan.getAllLaporan().size());
		model.addAttribute("proses", modelLaporan.getAllLaporan().size());
		model.addAttribute("active",1);
		
		return "dashboard";
	}
	
	
	@GetMapping("/laporan/view")
	public String viewIndexLaporan(Model model) {
		
		model.addAttribute("listLaporan",modelLaporan.getAllLaporan());
		model.addAttribute("active",3);
		model.addAttribute("test","Test Aja");
		return "view_laporan";
	}
	
	@GetMapping("/laporan/add")
	public String viewAddLaporan(Model model) {
		
		// buat penampung data mahasiswa di halaman htmlnya
		model.addAttribute("laporan",new Laporan());
		model.addAttribute("active",2);
		
		return "add_laporan";
	}
	
	@PostMapping("/laporan/vieew")
	public String addLaporan(@RequestParam(value = "file") MultipartFile file, @ModelAttribute Laporan laporan,
			Model model) throws IOException {
		{
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());

			String uploadDir = "user-photos/";

			FileUtility.saveFile(uploadDir, fileName, file);

			laporan.setFoto("/" + uploadDir + fileName);
			this.modelLaporan.addLaporan(laporan);
			model.addAttribute("active", 2);

			return "redirect:/dashboard";
		}
	}
	
	@GetMapping("/laporan/update/{id}")
	public String viewUpdateLaporan(@PathVariable String id, Model model) {
		
		Laporan laporan = modelLaporan.getLaporanById(id);
		// buat penampung data mahasiswa di halaman htmlnya
		model.addAttribute("laporan",laporan);
		
		return "add_laporan";
	}
	
	@GetMapping("/laporan/delete/{id}")
	public String deleteLaporan(@PathVariable String id, Model model) {
		
		this.modelLaporan.deleteLaporan(id);
		model.addAttribute("listLaporan",modelLaporan.getAllLaporan());
		
		
		return "redirect:/laporan/view";
	}
	
	@GetMapping("/laporan/approve/{id}")
	public String approveLaporan(@PathVariable String id, Model model) {
		
		Laporan updateStatus = modelLaporan.getLaporanById(id);
		updateStatus.setStatus("Approve");
		modelLaporan.save(updateStatus);
		
		return "redirect:/laporan/view";
	}
	
	@GetMapping("/laporan/reject/{id}")
	public String rejectLaporan(@PathVariable String id, Model model) {
		
		Laporan updateStatus = modelLaporan.getLaporanById(id);
		updateStatus.setStatus("Reject");
		modelLaporan.save(updateStatus);
		
		return "redirect:/laporan/view";
	}
	
	@GetMapping("/laporan/reset/{id}")
	public String resetLaporan(@PathVariable String id, Model model) {
		
		Laporan updateStatus = modelLaporan.getLaporanById(id);
		updateStatus.setStatus("Pending");
		modelLaporan.save(updateStatus);
		
		return "redirect:/laporan/view";
	}
	
	@GetMapping("/laporan/report/pdf")
	public String exportPDF() {
		try {
		File file = ResourceUtils.getFile("classpath:laporan.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		
		List<Laporan> lstLaporan = modelLaporan.getAllLaporan();
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lstLaporan);
        
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy","FaizR");
        
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        String path = "D:\\laporan.pdf";
        JasperExportManager.exportReportToPdfFile(jasperPrint,path);
        
       
		
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return "redirect:/laporan/view";
	}

}
