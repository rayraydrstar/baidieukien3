package controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.IDanhMucDAO;
import dao.ISanPhamDAO;
import dao.ImplDanhMucDAO;
import dao.ImplSanPhamDAO;
import entity.DanhMuc;
import entity.SanPham;

@Controller
@RequestMapping("/")
public class ProductController {
	
	private void initParam(Model m) {
		IDanhMucDAO dmDAO = new ImplDanhMucDAO();
		List<DanhMuc> lstDM = dmDAO.selectAllDanhMuc();
		m.addAttribute("lstDM", lstDM);
	}
	
	@RequestMapping("")
	private String index(Model m) {
		ISanPhamDAO spDAO = new ImplSanPhamDAO();
		List<SanPham> lstSanPham = spDAO.selectAll();
		m.addAttribute("lstSanPham", lstSanPham);
		return "index";
	}
	
	@RequestMapping("/detail")
	private String detail(@RequestParam(name = "id", required = true) Integer id, Model m) {
		ISanPhamDAO spDAO = new ImplSanPhamDAO();
		SanPham sp = spDAO.detail(id);
		m.addAttribute("sp", sp);
		return "detail";		
	}
	
	@RequestMapping("/form") 
	private String initForm(Model m) {
		SanPham sp = new SanPham();
		m.addAttribute("sp", sp);
		initParam(m);
		return "form";
	}
	
	@RequestMapping("/insert")
	private String insert(@Valid @ModelAttribute(name = "sp") SanPham sp, BindingResult result, Model m) {
		if(result.hasErrors()) {
			m.addAttribute("msgErr", "Du lieu sai");
		} else { 
			ISanPhamDAO spDAO = new ImplSanPhamDAO();
			boolean isOk = spDAO.insert(sp);
			if(isOk) {
				m.addAttribute("msgOk", "them moi thanh cong");
			} else {
				m.addAttribute("msgOk", "them moi that bai");
			}
		}
		
		m.addAttribute("sp", sp);
		initParam(m);
		return "form";
	}

	@RequestMapping("/update")
	private String update(@RequestParam(name = "id", required = true) Integer id, Model m) {
		ISanPhamDAO spDAO = new ImplSanPhamDAO();
		SanPham p = spDAO.detail(id);
		SanPham sp = new SanPham();
		m.addAttribute("sp", sp);
		m.addAttribute("p", p);
		initForm(m);
		return "update";
	}
	
	@RequestMapping("/update_handler")
	private String updateHandler(@Valid @ModelAttribute(name = "sp") SanPham sp, BindingResult result, Model m) {
		if(result.hasErrors()) {
			m.addAttribute("msgErr", "Du lieu sai");
		} else { 
			ISanPhamDAO spDAO = new ImplSanPhamDAO();
			boolean isOk = spDAO.update(sp);
			if(isOk) {
				m.addAttribute("msgOk", "them moi thanh cong");
			} else {
				m.addAttribute("msgOk", "them moi that bai");
			}
		}
		m.addAttribute("sp", sp);
		return "update";
	}
	
	@RequestMapping("/delete")
	private String delete(@RequestParam(name = "id", required = true) Integer id, Model m) {
		ISanPhamDAO spDAO = new ImplSanPhamDAO();
		spDAO.delete(id);
		return "index";
	}
	
	@RequestMapping(path = "/search", method = RequestMethod.GET )
	private String search(@RequestParam(name = "txtName", required = false) String txtName, 
						  @RequestParam(name = "priceFrom", required = false) Double priceFrom,
						  @RequestParam(name = "priceTo", required = false) Double priceTo,
						  Model m) {
		ISanPhamDAO spDAO = new ImplSanPhamDAO();
		List<SanPham> lstSanPham =  spDAO.search(txtName, priceFrom, priceTo);
		m.addAttribute("lstSanPham", lstSanPham);
		return "index";
	}
	
	@RequestMapping(path = "/sort_by_category")
	private String sortByCategory(@RequestParam(name = "maDanhMuc", required = true) Integer maDanhMuc, Model m) {
		ISanPhamDAO spDAO = new ImplSanPhamDAO();
		List<SanPham> lstSanPham = spDAO.sortByCategory(maDanhMuc);
		m.addAttribute("lstSanPham", lstSanPham);
		return "index";
	}
}
