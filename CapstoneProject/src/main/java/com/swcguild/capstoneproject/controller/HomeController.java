package com.swcguild.capstoneproject.controller;

import com.swcguild.capstoneproject.dao.interfaces.AssetInterface;
import com.swcguild.capstoneproject.dao.interfaces.EventInterface;
import com.swcguild.capstoneproject.dao.interfaces.ReportInterface;
import com.swcguild.capstoneproject.dao.interfaces.UserInterface;
import com.swcguild.capstoneproject.model.Asset;
import com.swcguild.capstoneproject.model.AssetType;
import com.swcguild.capstoneproject.model.Category;
import com.swcguild.capstoneproject.model.notes.AssetNote;
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

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    //List Pages
    @RequestMapping(value = {"/assets"}, method = RequestMethod.GET)
    public String displayBrowseAssets(Model model, HttpServletRequest request) {
        Set<AssetType> types = getSelectedAssetTypes(request.getParameter("selectCategory"));
        model.addAttribute("categoryList", assetDao.getAllCategories());
        model.addAttribute("assetTypeList", types);

        return "browseAssets";
    }

    @RequestMapping(value = {"/manage_assets"}, method = RequestMethod.GET)
    public String displayManageAssets(Model model, HttpServletRequest request) {
        Set<AssetType> types = getSelectedAssetTypes(request.getParameter("selectCategory"));
        model.addAttribute("categoryList", assetDao.getAllCategories());
        model.addAttribute("assetTypeList", types);
        return "manageAssets";
    }

    @RequestMapping(value = {"/listAssets"}, method = RequestMethod.GET)
    public String displayAssetListingForType(Model model, HttpServletRequest request) {
        int typeId = 0;

        try {
            typeId = Integer.parseInt(request.getParameter("typeId"));
            AssetType typeSelected = assetDao.getAssetTypeById(typeId);

            model.addAttribute("assetList", assetDao.getAllAssetsByAssetType(typeSelected));
        } catch (Exception e) {
            model.addAttribute("assetTypeError", "Oops! Something went wrong when attempting to list assets of the selected type. Please make sure you selected a valid asset type.");
            return "redirect:manage_assets";
        }

        return "assetsByType";
    }
    
    @RequestMapping(value = {"/listAssetNotes"}, method = RequestMethod.GET)
    public String listAssetNotes(Model model, HttpServletRequest request){
        int assetId;
        
        try {
            assetId = Integer.parseInt(request.getParameter("assetId"));
            Asset asset = assetDao.getAssetById(assetId);
            model.addAttribute("asset", asset);
            model.addAttribute("assetNotes", assetDao.getAssetNotes(assetId));
        } catch (Exception e) {
            model.addAttribute("listAssetNotesError", "Oops! Something went wrong when attempting to list notes for the selected asset.");
            return "redirect:manage_assets";
        }

        return "viewAssetNotes";
    }

    //Asset Forms
    @RequestMapping(value = {"/addAsset"}, method = RequestMethod.GET)
    public String displayAddAsset(Model model) {
        model.addAttribute("assetTypes", assetDao.getAllAssetTypes());

        model.addAttribute("newAsset", new Asset());

        return "addAsset";
    }

    @RequestMapping(value = {"/updateAsset"}, method = RequestMethod.GET)
    public String displayEditAsset(Model model, HttpServletRequest request) {
        int assetId = 0;

        try {
            assetId = Integer.parseInt(request.getParameter("assetId"));
            
            model.addAttribute("assetTypes", assetDao.getAllAssetTypes());

            model.addAttribute("asset", assetDao.getAssetById(assetId));

        } catch (Exception e) {
            request.setAttribute("displayUpdateAssetFormError", "Oops! Something went wrong when loading the form. Please try again.");
            //model.addAttribute("displayUpdateAssetFormError", "Oops! Something went wrong when loading the form. Please try again.");
            return "redirect:manage_assets";
        }

        return "editAsset";
    }

    //AssetType Forms
    @RequestMapping(value = {"/addAssetType"}, method = RequestMethod.GET)
    public String displayAddAssetType(Model model) {
        model.addAttribute("categoryList", assetDao.getAllCategories());

        model.addAttribute("newAssetType", new AssetType());

        return "addAssetType";
    }

    @RequestMapping(value = {"/updateAssetType"}, method = RequestMethod.GET)
    public String displayEditAssetType(Model model, HttpServletRequest request) {
        int assetTypeId;

        try {
            assetTypeId = Integer.parseInt(request.getParameter("typeId"));

            model.addAttribute("categoryList", assetDao.getAllCategories());

            model.addAttribute("assetType", assetDao.getAssetTypeById(assetTypeId));
        } catch (Exception e) {
            request.setAttribute("displayUpdateAssetTypeFormError", "Oops! Something went wrong when loading the form. Please try again.");
            return "redirect:manage_assets";
        }

        return "editAssetType";
    }

    //Category Forms
    @RequestMapping(value = {"/updateCategory"}, method = RequestMethod.GET)
    public String displayEditCategory(Model model, HttpServletRequest request) {
        int categoryId;

        try {
            categoryId = Integer.parseInt(request.getParameter("categoryId"));

            model.addAttribute("category", assetDao.getCategoryById(categoryId));
        } catch (NumberFormatException e) {
            request.setAttribute("displayUpdateCategoryFormError", "Oops! Something went wrong when loading the form. Please try again.");
            return "redirect:manage_assets";
        }

        return "editCategory";
    }

    //AssetNote Form
    @RequestMapping(value = {"/assetAddNote"}, method = RequestMethod.GET)
    public String displayAddAssetNote(Model model, HttpServletRequest request) {
        int assetId = 0;
        AssetNote newNote = new AssetNote();
        Asset asset;
        try {
            assetId = Integer.parseInt(request.getParameter("assetId"));
            //request.setAttribute("assetId", assetId);
            newNote.setAssetId(assetId);
            asset=assetDao.getAssetById(assetId);
            model.addAttribute("assetNote", newNote);
            model.addAttribute("asset", asset);
            model.addAttribute("assetNoteList", assetDao.getAssetNotes(assetId));
        }
        catch(Exception e){
            return "redirect:manage_assets";
        }
        
        return "assetAddNote";
    }
    
    //Asset CRUD
    @RequestMapping(value = {"/submitNewAsset"}, method = RequestMethod.POST)
    public String submitNewAsset(@ModelAttribute("newAsset") Asset newAsset, Model model, HttpServletRequest request) {
        int typeId;

        try {
            typeId = Integer.parseInt(request.getParameter("typeId"));
            newAsset.setAssetType(assetDao.getAssetTypeById(typeId));
        } catch (Exception e) {
            request.setAttribute("newAssetSubmissionError", "Oops! Something went wrong when submitting new asset. Please try again.");
            return "redirect:addAsset";
        }

        assetDao.addAsset(newAsset);

        //assetDao.addNoteToAsset(newAsset.getAssetId(), note, damage);
        return "redirect:manage_assets";
    }

    @RequestMapping(value = {"/submitAssetUpdate"}, method = RequestMethod.POST)
    public String submitAssetUpdate(@ModelAttribute("asset") Asset asset, Model model, HttpServletRequest request) {
        try {
            assetDao.editAsset(asset);
        } catch (Exception e) {
            request.setAttribute("assetUpdateSubmissionError", "Oops! Something went wrong when updating asset. Please try again.");
            return "redirect:updateAsset";
        }
        
        return "redirect:manage_assets";
    }

    @RequestMapping(value = {"/removeAsset"}, method = RequestMethod.GET)
    public String deleteAsset(Model model, HttpServletRequest request
    ) {
        int assetId = 0;
        Asset asset;
        try {
            assetId = Integer.parseInt(request.getParameter("assetId"));
            asset = assetDao.getAssetById(assetId);

            assetDao.deleteAsset(asset);
        } catch (Exception e) {
            request.setAttribute("assetDeletionError", "Oops! Something went wrong when attempting to delete asset.");
        }
        return "redirect:manage_assets";
    }

    //AssetType CRUD
    @RequestMapping(value = {"/submitNewAssetType"}, method = RequestMethod.POST)
    public String submitNewAssetType(@ModelAttribute("newAssetType") AssetType newAssetType, Model model, HttpServletRequest request
    ) {
        int categoryId;

        try {
            categoryId = Integer.parseInt(request.getParameter("categoryId"));

            newAssetType.setCategory(assetDao.getCategoryById(categoryId));
            assetDao.addAssetType(newAssetType);
        } catch (Exception e) {
            request.setAttribute("newAssetTypeSubmissionError", "Oops! Something went wrong when submitting new asset type. Please try again.");
            return "redirect:addAssetType";
        }
        return "redirect:manage_assets";
    }

    @RequestMapping(value = {"/submitAssetTypeUpdate"}, method = RequestMethod.POST)
    public String submitAssetTypeUpdate(@ModelAttribute("assetType") AssetType assetType, Model model, HttpServletRequest request
    ) {
        int categoryId = 0;

        try {
            categoryId = Integer.parseInt(request.getParameter("categoryId"));
            assetType.setCategory(assetDao.getCategoryById(categoryId));
            assetDao.editAssetType(assetType);
        } catch (Exception e) {
            request.setAttribute("assetTypeUpdateError", "Oops! Something went wrong when updating asset type. Please try again.");
        }
        return "redirect:manage_assets";
    }

    @RequestMapping(value = {"/removeAssetType"}, method = RequestMethod.GET)
    public String deleteAssetType(Model model, HttpServletRequest request
    ) {
        AssetType assetType;
        int assetTypeId = 0;
        try {
            assetTypeId = Integer.parseInt(request.getParameter("typeId"));

            assetType = assetDao.getAssetTypeById(assetTypeId);

            assetDao.deleteAssetType(assetType);
        } catch (Exception e) {
            request.setAttribute("assetTypeDeletionError", "Oops! Something went wrong when attempting to delete asset type.");
        }
        return "redirect:manage_assets";
    }

    //Category CRUD
    @RequestMapping(value = {"/submitNewCategory"}, method = RequestMethod.POST)
    public String submitNewAssetType(Model model, HttpServletRequest request) {
        Category newCat = new Category();
        try {
            newCat.setCategoryName(request.getParameter("categoryName"));
            assetDao.addCategory(newCat);
        } catch (Exception e) {
            request.setAttribute("newCategorySubmissionError", "Oops! Something went wrong when submitting new category. Please try again.");
        }

        return "redirect:manage_assets";
    }

    @RequestMapping(value = {"/submitCategoryUpdate"}, method = RequestMethod.POST)
    public String submitCategoryUpdate(@ModelAttribute("category") Category category, Model model, HttpServletRequest request
    ) {
        try {
            assetDao.editCategory(category);
        } catch (Exception e) {
            request.setAttribute("categoryUpdateError", "Oops! Something went wrong when updating asset. Please try again.");
        }
        return "redirect:manage_assets";
    }

    @RequestMapping(value = {"/removeCategory"}, method = RequestMethod.GET)
    public String deleteCategory(Model model, HttpServletRequest request
    ) {
        Category category;
        int categoryId = 0;
        try {
            categoryId = Integer.parseInt(request.getParameter("categoryId"));

            category = assetDao.getCategoryById(categoryId);

            assetDao.deleteCategory(category);
        } catch (Exception e) {
             request.setAttribute("categoryDeletionError", "Oops! Something went wrong when attempting to delete asset.");
        }
        return "redirect:manage_assets";
    }
    
    //AssetNoteCRUD
    @RequestMapping(value = {"/submitNewAssetNote"}, method = RequestMethod.POST)
    public String submitNewAssetNote(@ModelAttribute("assetNote") AssetNote newAssetNote, Model model, HttpServletRequest request) {
        int assetId;
        //Asset asset;

        try {
            //assetId = Integer.parseInt(request.getParameter("assetId"));
     
            //asset = assetDao.getAssetById(assetId);
            //newAssetNote.setAssetId(assetId);
            assetDao.addNoteToAsset(newAssetNote.getAssetId(), newAssetNote.getNote(), newAssetNote.getCategory());
        } catch (Exception e) {
            request.setAttribute("newAssetNoteSubmissionError", "Oops! Something went wrong when submitting note. Please try again.");
            return "redirect:assetAddNote";
        }

        return "redirect:manage_assets";
    }

    //Helper Methods
    private Set<AssetType> getSelectedAssetTypes(String categoryName) {
        Set<Category> categories = assetDao.getAllCategories();
        Set<AssetType> types = new HashSet<>();
        Category selectedCat = null;
        //String catName = request.getParameter("searchByCategory");

        //find desired category, if selected, and get asset types for category
        if (categoryName != null) {
            for (Category cat : categories) {
                if (cat.getCategoryName().equalsIgnoreCase(categoryName)) {
                    selectedCat = cat;
                    types.addAll(assetDao.getAssetTypeByCategory(cat));
                }
            }
        }

        //get all asset types if no category selected
        if (selectedCat == null /* || catName == null || catName.equalsIgnoreCase("All")*/) {
            for (Category cat : categories) {
                types.addAll(assetDao.getAssetTypeByCategory(cat));
            }
        }

        return types;
    }
}
