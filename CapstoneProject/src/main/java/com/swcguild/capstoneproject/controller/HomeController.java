package com.swcguild.capstoneproject.controller;

import com.swcguild.capstoneproject.dao.interfaces.AssetInterface;
import com.swcguild.capstoneproject.dao.interfaces.EventInterface;
import com.swcguild.capstoneproject.dao.interfaces.ReportInterface;
import com.swcguild.capstoneproject.dao.interfaces.UserInterface;
import com.swcguild.capstoneproject.model.Asset;
import com.swcguild.capstoneproject.model.AssetType;
import com.swcguild.capstoneproject.model.Category;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/"})
public class HomeController {

    private AssetInterface assetDao;
    private EventInterface eventDao;
    private UserInterface userDao;
    private ReportInterface reportDao;

    @Inject
    public HomeController(AssetInterface assetDao, EventInterface eventDao, UserInterface userDao) {
        this.assetDao = assetDao;
        this.eventDao = eventDao;
        this.userDao = userDao;
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

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(value = {"/assets"}, method = RequestMethod.GET)
    public String displayBrowseAssets(Model model, HttpServletRequest request) {
        Set<Category> categories = assetDao.getAllCategories();
        Set<AssetType> types = new HashSet<>();
        Set<Asset> assets = new HashSet<>();
        
        Category selectedCat = null;
        AssetType selectedType = null;
        
        String catName = request.getParameter("searchByCategory");
        String typeName = request.getParameter("searchByCategory");

        //find desired category, if selected, and get asset types for category
        for (Category cat : categories) {
            if (cat.getCategoryName().equalsIgnoreCase(catName)) {
                selectedCat = cat;
                types.addAll(assetDao.getAssetTypeByCategory(cat));
            }
        }

        //get all asset types if no category selected
        if (selectedCat == null || catName == null || catName.equalsIgnoreCase("All")) {
            for (Category cat : categories) {
                types.addAll(assetDao.getAssetTypeByCategory(cat));
            }
        }

        if (typeName != null) {
            //find desired asset type, if selected, and get assets for asset type
            for (AssetType type: types) {
                if (type.getName().equalsIgnoreCase(typeName)) {
                    selectedType = type;
                    assets.addAll(assetDao.getAllAssetsByAssetType(selectedType));
                }
            }

            //get all assets if no asset type selected
            if (catName.equalsIgnoreCase("All") || selectedCat == null) {
                assets.addAll(assetDao.getAllAssets());
            }
            
            //if searching by asset type, supply requested set of assets
            model.addAttribute("assets", assets);
        }
        else{
            //if searching by category, supply requested set of asset types
            model.addAttribute("types", types);
        }

        
        return "browseAssets";
    }

    @RequestMapping(value = {"/addAsset"}, method = RequestMethod.GET)
    public String displayAddAsset(Model model) {
        model.addAttribute("categories", assetDao.getAllCategories());
        model.addAttribute("assetTypes", assetDao.getAllAssetTypes());
        
        model.addAttribute("newAsset", new Asset());
        
        return "addAsset";
    }

    @RequestMapping(value = {"/manage_assets"}, method = RequestMethod.GET)
    public String displayManageAssets(Model model) {
        return "manageAssets";
    }

    @RequestMapping(value = {"/submitNewAsset"}, method = RequestMethod.POST)
    public String submitNewAsset(@ModelAttribute("newAsset") Asset newAsset, Model model, HttpServletRequest request) {
        int typeId;
        
//        Asset newAsset = new Asset();
//        Set<Category> categories = assetDao.getAllCategories();
//        Set<AssetType> types;
//        Category selectedCat = null;
//        AssetType typeSelected = null;
//
//        String name = request.getParameter("name");
//        String catDescription = request.getParameter("category");
//        String type = request.getParameter("assetType");
//        String status = request.getParameter("status");
//        String serial = request.getParameter("serialNum");
//        String imagePath = request.getParameter(""); //not sure how to handle image file. Will investigate.
//        String damage = request.getParameter("damage");
//        String note = request.getParameter("assetNote");
//
//        int serialNum;
//
//        try {
//            serialNum = Integer.parseInt(serial);
//        } catch (NumberFormatException e) {
//            return "redirect:addAsset";
//        }
//
//        for (Category c : categories) {
//            if (c.getCategoryName().equalsIgnoreCase(catDescription)) {
//                selectedCat = c;
//            }
//        }
//        if (selectedCat == null) {
//            selectedCat = new Category();
//            selectedCat.setCategoryName(catDescription);
//            assetDao.addCategory(selectedCat);
//        }
//
//        types = assetDao.getAssetTypeByCategory(selectedCat);
//        for (AssetType t : types) {
//            if (t.getName().equalsIgnoreCase(type) || t.getName().equalsIgnoreCase(name)) {
//                typeSelected = t;
//            }
//        }
//        if (typeSelected == null) {
//            typeSelected = new AssetType();
//            typeSelected.setCategory(selectedCat);
//            typeSelected.setName(name);
//            typeSelected.setImagePath(imagePath);
//            assetDao.addAssetType(typeSelected);
//        }
//
//        newAsset.setAssetType(typeSelected);
//        newAsset.setDamageStatus(damage);
//        newAsset.setInStock(status.equalsIgnoreCase("available"));
//        newAsset.setSerialNumber(serialNum);
        
        try{
            typeId = Integer.parseInt(request.getParameter("typeId"));
        }
        catch(NumberFormatException e){
            return "addAsset";
        }
        
        newAsset.setAssetType(assetDao.getAssetTypeById(typeId));
        assetDao.addAsset(newAsset);
        
        //assetDao.addNoteToAsset(newAsset.getAssetId(), note, damage);
        
        return "redirect:manage_assets";
    }
}
