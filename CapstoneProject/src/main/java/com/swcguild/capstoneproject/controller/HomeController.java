package com.swcguild.capstoneproject.controller;

import com.swcguild.capstoneproject.dao.interfaces.AssetInterface;
import com.swcguild.capstoneproject.dao.interfaces.EventInterface;
import com.swcguild.capstoneproject.dao.interfaces.NoteInterface;
import com.swcguild.capstoneproject.dao.interfaces.ReportInterface;
import com.swcguild.capstoneproject.dao.interfaces.UserInterface;
import com.swcguild.capstoneproject.model.Asset;
import com.swcguild.capstoneproject.model.AssetType;
import com.swcguild.capstoneproject.model.Category;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/"})
public class HomeController {
    private AssetInterface assetDao;
    private EventInterface eventDao;
    private UserInterface userDao;
    private NoteInterface noteDao;
    private ReportInterface reportDao;
    
    @Inject
    public HomeController(AssetInterface assetDao, EventInterface eventDao, UserInterface userDao, NoteInterface noteDao) {
        this.assetDao = assetDao;
        this.eventDao = eventDao;
        this.userDao = userDao;
        this.noteDao = noteDao;
    }
//    
//    @Inject
//    public HomeController(AssetInterface assetDao, EventInterface eventDao, UserInterface userDao, NoteInterface noteDao, ReportInterface reportDao) {
//        this.assetDao = assetDao;
//        this.eventDao = eventDao;
//        this.userDao = userDao;
//        this.noteDao = noteDao;
//        this.reportDao = reportDao;
//    }
//    
    @RequestMapping(value={"/", "/home"}, method=RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(value={"/assets"}, method=RequestMethod.GET)
    public String displayBrowseAssets(Model model, HttpServletRequest request){
        Set<Category> categories = assetDao.getAllCategories();
        Set<AssetType> types = new HashSet<>();
        
        for(Category cat: categories){
            types.addAll(assetDao.getAssetTypeByCategory(cat));
        }
        model.addAttribute("types", types);
        return "browseAssets";
    }
    
    @RequestMapping(value={"/addAsset"}, method = RequestMethod.GET)
    public String displayAddAsset(Model model){
        return "addAsset";
    }
    
    @RequestMapping(value={"/manage_assets"}, method = RequestMethod.GET)
    public String displayManageAssets(Model model){
        return "manageAssets";
    }
    
    @RequestMapping(value={"/submitNewAsset"}, method = RequestMethod.POST)
    public String submitNewAsset(Model model, HttpServletRequest request){
        Asset asset = new Asset();
        Set<Category> categories = assetDao.getAllCategories();
        Set<AssetType> types;
        Category selectedCat = null;
        AssetType typeSelected = null;
        
        String name = request.getParameter("name");
        String catDescription = request.getParameter("category");
        String type = request.getParameter("assetType");
        String status = request.getParameter("status");
        String serial = request.getParameter("serialNum");
        String imagePath = request.getParameter(""); //not sure how to handle image file. Will investigate.
        String damage = request.getParameter("damage");
        String note = request.getParameter("assetNote");
        
        int serialNum;
        
        try{
            serialNum = Integer.parseInt(serial);
        }
        catch(NumberFormatException e){
            return "redirect:addAsset";
        }
        
        for(Category c: categories){
            if(c.getCategoryName().equalsIgnoreCase(catDescription)){
                selectedCat = c;
            }
        }
        if(selectedCat == null){
            selectedCat = new Category();
            selectedCat.setCategoryName(catDescription);
            assetDao.addCategory(selectedCat);
        }
        
        types = assetDao.getAssetTypeByCategory(selectedCat);
        for(AssetType t: types){
            if(t.getName().equalsIgnoreCase(type) || t.getName().equalsIgnoreCase(name)){
                typeSelected = t;
            }
        }
        if(typeSelected == null){
            typeSelected = new AssetType();
            typeSelected.setCategory(selectedCat);
            typeSelected.setName(name);
            typeSelected.setImagePath(imagePath);
            assetDao.addAssetType(typeSelected);
        }
        
        asset.setAssetType(typeSelected);
        asset.setDamageStatus(damage);
        asset.setInStock(status.equalsIgnoreCase("available"));
        asset.setSerialNumber(serialNum);
        
        assetDao.addAsset(asset);
        
        noteDao.addNoteToAsset(asset.getAssetId(), note, damage);
        
        return "redirect:manage_assets";
    }
}
